package bean;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Marca;

/**
 *
 * @author lhries
 */
@FacesConverter(forClass=Marca.class)
public class MarcaConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        VeiculoMB bean = context.getApplication().evaluateExpressionGet(context, "#{veiculoMB}", VeiculoMB.class);
        Marca marca = bean.buscarMarcaPorNome(value);
        return marca;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value!=null)
            return((Marca)value).getNomeMarca();
        return null;
    }
    
}
