package bean;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Cliente;

/**
 *
 * @author lhries
 */
@FacesConverter(forClass=Cliente.class)
public class ClienteConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        LocacaoMB bean = context.getApplication().evaluateExpressionGet(context, "#{locacaoMB}", LocacaoMB.class);
        Cliente cliente = bean.buscarClientePorNome(value);
        return cliente;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value!=null)
            return((Cliente)value).getNomeCliente();
        return null;
    }
    
}
