/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jairb
 */
@Entity
@Table(name = "categoriaVeiculo")
@XmlRootElement
public class CategoriaVeiculo implements Serializable{
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
    @Column(name = "idCatVeiculo")
    private Integer idCatVeiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descCatVeiculo")
    private String descCatVeiculo;
    @Column(name = "catAtivo")
    private Boolean catAtivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCatVeiculo")
    private Collection<Veiculo> veiculoCollection;

    /**
     * @return the idCatVeiculo
     */
    public Integer getIdCatVeiculo() {
        return idCatVeiculo;
    }

    /**
     * @param idCatVeiculo the idCatVeiculo to set
     */
    public void setIdCatVeiculo(Integer idCatVeiculo) {
        this.idCatVeiculo = idCatVeiculo;
    }

    /**
     * @return the descCatVeiculo
     */
    public String getDescCatVeiculo() {
        return descCatVeiculo;
    }

    /**
     * @param descCatVeiculo the descCatVeiculo to set
     */
    public void setDescCatVeiculo(String descCatVeiculo) {
        this.descCatVeiculo = descCatVeiculo;
    }

    /**
     * @return the catAtivo
     */
    public Boolean getCatAtivo() {
        return catAtivo;
    }

    /**
     * @param catAtivo the catAtivo to set
     */
    public void setCatAtivo(Boolean catAtivo) {
        this.catAtivo = catAtivo;
    }

    @XmlTransient
    public Collection<Veiculo> getVeiculoCollection() {
        return veiculoCollection;
    }

    public void setVeiculoCollection(Collection<Veiculo> veiculoCollection) {
        this.veiculoCollection = veiculoCollection;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoriaVeiculo other = (CategoriaVeiculo) obj;
        return Objects.equals(this.idCatVeiculo, other.idCatVeiculo);
    }
    
    @Override
    public String toString() {
        return idCatVeiculo + " - " + descCatVeiculo;
    }
    
}
