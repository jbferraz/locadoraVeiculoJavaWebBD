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
import model.Veiculo;
import model.Cliente;
import model.Locacao;
import model.session.VeiculoFacade;
import model.session.LocacaoFacade;
import model.session.ClienteFacade;

/**
 *
 * @author jairb
 */
@Named(value = "locacaoMB")
@SessionScoped
public class LocacaoMB implements Serializable{
    private Locacao locacaoSelecionado;
    private Cliente clienteSelecionado;
    @Inject
    private LoginMB loginMB;
    private Veiculo veiculoSelecionado;
    @Inject
    private VeiculoFacade veiculoFacade;
    @Inject
    private ClienteFacade clienteFacade;
    @Inject
    private LocacaoFacade locacaoFacade;

    public LocacaoMB(){
        locacaoSelecionado = new Locacao();
        
    }
    
    /**
     * @return the locacaoSelecionado
     */
    public Locacao getLocacaoSelecionado() {
        return locacaoSelecionado;
    }

    /**
     * @param locacaoSelecionado the locacaoSelecionado to set
     */
    public void setLocacaoSelecionado(Locacao locacaoSelecionado) {
        this.locacaoSelecionado = locacaoSelecionado;
    }

    public List<Locacao> getListaLocacao(){
        return locacaoFacade.findAll();
    }
    
    public List<Veiculo> getListaVeiculo(){
        return veiculoFacade.findAll();
    }
    
    public List<Cliente> getListaCliente(){
        return clienteFacade.findAll();
    }
    
    public List<Veiculo> getListaVeicDisponivel(){
        return veiculoFacade.getListaVeicDisponivel();
    }

    public String novoLocacao(){
        setLocacaoSelecionado(new Locacao());
        return ("/admin/formularioLocacaoCadastro?faces-redirect=true");
    }
    
    public String adicionarLocacao(){
        System.out.println("ID DO CLIENTE: "+this.getClienteSelecionado().getID());
        getLocacaoSelecionado().setIdCliente(getClienteSelecionado());
        getLocacaoSelecionado().setIdVeiculo(getVeiculoSelecionado());
        locacaoFacade.create(getLocacaoSelecionado());
        return (this.novoLocacao());
    }
    
    public String editarLocacao(Locacao l){
        setLocacaoSelecionado(l);
        return ("/admin/formularioLocacaoEdicao?faces-redirect=true");
    }
    
    public String atualizarLocacao(){
        locacaoFacade.edit(getLocacaoSelecionado());
        return ("/admin/listaLocacao?faces-redirect=true");
    }
    
    public void removerLocacao(Locacao l){
        locacaoFacade.remove(l);
    }

    public Cliente buscarClientePorNome(String nome) {
        return clienteFacade.buscarPorNomeCliente(nome);
    }
    
    public Veiculo buscarVeiculoPorPlaca(String placa) {
        return veiculoFacade.buscarPorPlaca(placa);
    }

 

    /**
     * @return the veiculoSelecionado
     */
    public Veiculo getVeiculoSelecionado() {
        return veiculoSelecionado;
    }

    /**
     * @param veiculoSelecionado the veiculoSelecionado to set
     */
    public void setVeiculoSelecionado(Veiculo veiculoSelecionado) {
        this.veiculoSelecionado = veiculoSelecionado;
    }

    /**
     * @return the loginSelecionado
     */
    public Cliente getClienteSelecionado() {
        System.out.println("Logado id> "+loginMB.getClienteLogado().getID());
        clienteSelecionado= loginMB.getClienteLogado();
            return clienteSelecionado;
    }
}
