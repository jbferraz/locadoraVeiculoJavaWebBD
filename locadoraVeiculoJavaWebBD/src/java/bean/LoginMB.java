/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


/**
 *
 * @author AssisBrasil
 */
import java.io.Serializable;
import model.Cliente;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class LoginMB implements Serializable{

    @Inject
    ClienteMB clienteMB;
    private String login, senha;
    private Cliente clienteLogado;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cliente getClienteLogado() {
        return clienteLogado;
    }

    public void setClienteLogado(Cliente clienteLogado) {
        this.clienteLogado = clienteLogado;
    }

    public boolean estaLogado() {
        return (clienteLogado != null);
    }

    public boolean eAdmin() {
        return (this.estaLogado() && this.getClienteLogado().isAdmin());
    }

    public String verificaLogin() {
        //Pega o contexto do JSF - serve agora e depois para mensagem.
        FacesContext contexto = FacesContext.getCurrentInstance();
        //Obtém o usuarioMB criado pelo servidor (nível de aplicação)
        //UsuarioMB usuarioMB = (UsuarioMB) contexto.getExternalContext().getApplicationMap().get("usuarioMB");
        //A partir do usuarioMB do servidor, pegamos a lista de usuários cadastrados no sistema
        List<Cliente> listaCliente = clienteMB.getListaCliente();

        for (Cliente cliente : listaCliente) {
            if (cliente.verificaLogin(login, senha)) {
                clienteLogado = cliente;
                if (cliente.isAdmin()) {
                    return ("/admin/index?faces-redirect=true");
                } else {
                    return ("/usuario/index?faces-redirect=true");
                }
            }
        }
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Login inválido!", "Usuário ou senha estão errados!");
        contexto.addMessage("idMensagem", mensagem);
        return ("/login");
    }

    public String realizaLogout() {
        clienteLogado = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return ("/login?faces-redirect=true");
    }

}

