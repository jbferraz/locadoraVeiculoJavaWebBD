package bean;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Veiculo;

/**
 *
 * @author lhries
 */
@FacesConverter(forClass=Veiculo.class)
public class VeiculoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        LocacaoMB bean = context.getApplication().evaluateExpressionGet(context, "#{locacaoMB}", LocacaoMB.class);
        Veiculo veiculo = bean.buscarVeiculoPorPlaca(value);
        return veiculo;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value!=null)
            return((Veiculo)value).getPlaca();
        return null;
    }
    
}
