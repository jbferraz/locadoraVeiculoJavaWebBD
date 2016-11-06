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
import model.CategoriaVeiculo;
import model.Marca;
import model.Veiculo;
import model.session.CategoriaVeiculoFacade;
import model.session.VeiculoFacade;
import model.session.MarcaFacade;

/**
 *
 * @author jairb
 */
@Named(value = "veiculoMB")
@SessionScoped
public class VeiculoMB implements Serializable{
    private Veiculo veiculoSelecionado;
    @Inject
    private VeiculoFacade veiculoFacade;
    @Inject
    private MarcaFacade marcaFacade;
    @Inject
    private CategoriaVeiculoFacade catVeicFacade;

    public VeiculoMB(){
        veiculoSelecionado = new Veiculo();
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

    public List<Veiculo> getListaVeiculo(){
        return veiculoFacade.findAll();
    }
    
    public List<Marca> getListaMarca(){
        return marcaFacade.findAll();
    }
    
    public List<CategoriaVeiculo> getListaCatVeiculo(){
        return catVeicFacade.findAll();
    }

    public String novoVeiculo(){
        veiculoSelecionado = new Veiculo();
        return ("/admin/formularioVeiculoCadastro?faces-redirect=true");
    }
    
    public String adicionarVeiculo(){
        veiculoFacade.create(veiculoSelecionado);
        return (this.novoVeiculo());
    }
    
    public String editarVeiculo(Veiculo v){
        veiculoSelecionado = v;
        return ("/admin/formularioVeiculoEdicao?faces-redirect=true");
    }
    
    public String atualizarVeiculo(){
        veiculoFacade.edit(veiculoSelecionado);
        return ("/admin/listaVeiculos?faces-redirect=true");
    }
    
    public void removerVeiculo(Veiculo v){
        veiculoFacade.remove(v);
    }

    public Marca buscarMarcaPorNome(String nome) {
        return marcaFacade.buscarPorNomeMarca(nome);
    }
    
    public CategoriaVeiculo buscarCatVeicPorDesc(String desc) {
        return catVeicFacade.buscarPorDescCatVeiculo(desc);
    }
}
