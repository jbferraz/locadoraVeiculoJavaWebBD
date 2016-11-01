/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jairb
 */
@Entity
@Table(name = "marca")
@XmlRootElement
public class Marca implements Serializable{
    private static long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMarca")
    private Integer idMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeMarca")
    private String nomeMarca;
    @Column(name = "marcaAtiva")
    private Boolean marcaAtiva;

    /**
     * @return the idMarca
     */
    public Integer getIdMarca() {
        return idMarca;
    }

    /**
     * @param idMarca the idMarca to set
     */
    public void setidMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    /**
     * @return the nomeMarca
     */
    public String getNomeMarca() {
        return nomeMarca;
    }

    /**
     * @param nomeMarca the nomeMarca to set
     */
    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    /**
     * @return the marcaAtiva
     */
    public Boolean getMarcaAtiva() {
        return marcaAtiva;
    }

    /**
     * @param marcaAtiva the marcaAtiva to set
     */
    public void setmarcaAtiva(Boolean marcaAtiva) {
        this.marcaAtiva = marcaAtiva;
    }
    
    
    
}
