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
import model.CategoriaVeiculo;
import model.session.CategoriaVeiculoFacade;

/**
 *
 * @author jairb
 */
@Named(value = "categoriaVeiculoMB")
@SessionScoped
public class CategoriaVeiculoMB implements Serializable{
    private CategoriaVeiculo catVeicSelecionado;
    @Inject
    private CategoriaVeiculoFacade categoriaVeiculoFacade;

    public CategoriaVeiculoMB(){
        catVeicSelecionado = new CategoriaVeiculo();
    }
    
    /**
     * @return the catVeicSelecionado
     */
    public CategoriaVeiculo getCatVeicSelecionado() {
        return catVeicSelecionado;
    }

    /**
     * @param catVeicSelecionado the catVeicSelecionado to set
     */
    public void setCatVeicSelecionado(CategoriaVeiculo catVeicSelecionado) {
        this.catVeicSelecionado = catVeicSelecionado;
    }

    public List<CategoriaVeiculo> getListaCatVeiculo(){
        return categoriaVeiculoFacade.findAll();
    }
    
    public String novoCatVeiculo(){
        catVeicSelecionado = new CategoriaVeiculo();
        return ("formularioCatVeicCadastro");
    }
    
    public String adicionarCatVeiculo(){
        catVeicSelecionado.setCatAtivo(Boolean.TRUE);
        categoriaVeiculoFacade.create(catVeicSelecionado);
        return (this.novoCatVeiculo());
    }
    
    public String editarCatVeiculo(CategoriaVeiculo c){
        catVeicSelecionado = c;
        return ("formularioCatVeicEdicao");
    }
    
    public String atualizarCatVeiculo(){
        categoriaVeiculoFacade.edit(catVeicSelecionado);
        return ("listaCatVeiculos");
    }
    
    public void removerCatVeiculo(CategoriaVeiculo cat){
        categoriaVeiculoFacade.remove(cat);
    }
    
    public SelectItem[] getItemsAvailableSelectOne() {
        return beanUtil.getSelectItems(categoriaVeiculoFacade.findAll(), true);
    }
}
