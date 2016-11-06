/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Cliente;
import model.session.ClienteFacade;

/**
 *
 * @author jairb
 */
@Named(value = "clienteMB")
@SessionScoped
public class ClienteMB implements Serializable{
    private Cliente clienteSelecionado;
    @Inject
    private ClienteFacade clienteFacade;
    /**
     * Creates a new instance of ClienteMB
     */
    public ClienteMB() {
        clienteSelecionado = new Cliente();
    }
    
    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }
    
    public List<Cliente> getListaCliente(){
        return clienteFacade.findAll();
    }
    public String novoCliente(){
        clienteSelecionado = new Cliente();
        return("/admin/formularioClienteCadastro?faces-redirect=true");
    }
    
    public String adicionarCliente(){
        clienteFacade.create(clienteSelecionado);
        return(this.novoCliente());
    }
    
    public String editarCliente(Cliente c){
        clienteSelecionado = c;
        return("/admin/formularioClienteEdicao?faces-redirect=true");        
    }
    
    public String atualizarCliente(){
        clienteFacade.edit(clienteSelecionado);
        return("/admin/listaClientes?faces-redirect=true");
    }
    
    public void removerCliente(Cliente cliente){
        clienteFacade.remove(cliente);
    }
    
}
