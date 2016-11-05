package bean;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.CategoriaVeiculo;

/**
 *
 * @author lhries
 */
@FacesConverter(forClass=CategoriaVeiculo.class)
public class CategoriaVeiculoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        VeiculoMB bean = context.getApplication().evaluateExpressionGet(context, "#{veiculoMB}", VeiculoMB.class);
        CategoriaVeiculo categoriaVeiculo = bean.buscarCatVeicPorDesc(value);
        return categoriaVeiculo;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value!=null)
            return((CategoriaVeiculo)value).getDescCatVeiculo();
        return null;
    }
    
}
