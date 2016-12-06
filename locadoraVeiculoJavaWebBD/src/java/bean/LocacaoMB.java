/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bean.util.beanUtil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
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
public class LocacaoMB implements Serializable {

    private Locacao locacaoSelecionado;
    private Cliente clienteSelecionado;
    private Veiculo veiculoSelecionado;
    @Inject
    private LoginMB loginMB;
    @Inject
    private VeiculoFacade veiculoFacade;
    @Inject
    private ClienteFacade clienteFacade;
    @Inject
    private LocacaoFacade locacaoFacade;
   

    public LocacaoMB() {
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

    public List<Locacao> getListaLocacao() {
        return locacaoFacade.findAll();
    }
    public String selecionarVeiculo(Veiculo v){
        veiculoSelecionado = v;
        return (novoLocacao());
    }
    public List<Locacao> getListaLocacaoDisponivel() {
        return locacaoFacade.getListaLocacaoDisponivel();
    }

    public List<Veiculo> getListaVeiculo() {
        return veiculoFacade.findAll();
    }

    public List<Cliente> getListaCliente() {
        return clienteFacade.findAll();
    }

    public List<Veiculo> getListaVeicDisponivel() {
        return veiculoFacade.getListaVeicDisponivel();
    }

    public String novoLocacao() {
        locacaoSelecionado = new Locacao();
        
        return ("formularioLocacaoCadastro");
    }

    public String adicionarLocacao() {
        getLocacaoSelecionado().setIdCliente(getClienteSelecionado());
        
        locacaoSelecionado.setStatus(Boolean.FALSE);
        
        veiculoSelecionado=locacaoSelecionado.getIdVeiculo();
        
        locacaoSelecionado.setKmRetirada(veiculoSelecionado.getHodometro());
        veiculoSelecionado.setDisponivel(Boolean.FALSE);
        veiculoFacade.edit(veiculoSelecionado);
        
        locacaoFacade.create(locacaoSelecionado);
        return (this.novoLocacao());
    }
    
    public String editarLocacao(Locacao l) {
        setLocacaoSelecionado(l);
        return ("formularioLocacaoEdicao");
    }
    
    public String editarDevolucao(Locacao l) {
        setLocacaoSelecionado(l);
        return ("formularioLocacaoEdicao");
    }

    public String devolucao(){
        //somar km e atualizar km atual do veiculo
        veiculoSelecionado=locacaoSelecionado.getIdVeiculo();
        int kmDevolucao = locacaoSelecionado.getKmDevolucao();
        veiculoSelecionado.setHodometro(kmDevolucao);
        veiculoSelecionado.setDisponivel(Boolean.TRUE);
        veiculoFacade.edit(veiculoSelecionado);
        locacaoSelecionado.setStatus(Boolean.TRUE);
        
        locacaoFacade.edit(locacaoSelecionado);
        return ("listaLocacao");
    }
    
    public String atualizarLocacao() {
        locacaoFacade.edit(locacaoSelecionado);
        return ("/admin/listaLocacao?faces-redirect=true");
    }

    public void removerLocacao(Locacao l) {
        locacaoFacade.remove(l);
    }

    public Cliente buscarClientePorNome(String nome) {
        return clienteFacade.buscarPorNomeCliente(nome);
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        return veiculoFacade.buscarPorPlaca(placa);
    }

    
    public SelectItem[] getItemsAvailableSelectOne() {
        return beanUtil.getSelectItems(locacaoFacade.findAll(), true);
    }
    
    /**
     * @return the loginSelecionado
     */
    public Cliente getClienteSelecionado() {
        clienteSelecionado= loginMB.getClienteLogado();
        locacaoSelecionado.setIdCliente(clienteSelecionado);
            return clienteSelecionado;
    }
}
