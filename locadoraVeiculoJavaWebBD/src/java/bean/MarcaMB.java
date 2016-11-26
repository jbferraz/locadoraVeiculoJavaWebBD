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
import model.Marca;
import model.session.MarcaFacade;

/**
 *
 * @author jairb
 */
@Named(value = "marcaMB")
@SessionScoped
public class MarcaMB implements Serializable{
    private Marca marcaSelecionado;
    @Inject
    private MarcaFacade marcaFacade;

    public MarcaMB(){
        marcaSelecionado = new Marca();
    }
    
    /**
     * @return the marcaSelecionado
     */
    public Marca getMarcaSelecionado() {
        return marcaSelecionado;
    }

    /**
     * @param marcaSelecionado the marcaSelecionado to set
     */
    public void setMarcaSelecionado(Marca marcaSelecionado) {
        this.marcaSelecionado = marcaSelecionado;
    }

    public List<Marca> getListaMarca(){
        return marcaFacade.findAll();
    }
    
    public String novoMarca(){
        marcaSelecionado = new Marca();
        return ("formularioMarcaCadastro");
    }
    
    public String adicionarMarca(){
        marcaSelecionado.setmarcaAtiva(Boolean.TRUE);
        marcaFacade.create(marcaSelecionado);
        return (this.novoMarca());
    }
    
    public String editarMarca(Marca m){
        marcaSelecionado = m;
        return ("formularioMarcaEdicao");
    }
    
    public String atualizarMarca(){
        marcaFacade.edit(marcaSelecionado);
        return ("listaMarcas");
    }
    
    public void removerMarca(Marca m){
        marcaFacade.remove(m);
    }
    
    public SelectItem[] getItemsAvailableSelectOne() {
        return beanUtil.getSelectItems(marcaFacade.findAll(), true);
    }
}
