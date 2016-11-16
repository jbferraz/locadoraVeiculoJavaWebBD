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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "veiculo")
@XmlRootElement
public class Veiculo implements Serializable{
    private static long serialVersionUID = 1L;
    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVeiculo")
    private Integer idVeiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private Integer ano;
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cor")
    private String cor;
    @NotNull
    @Column(name = "portas")
    private Integer portas;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "opcionais")
    private String opcionais;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "placa")
    private String placa;
    @NotNull
    @Column(name = "valorLivre")
    private double valorLivre;
    @NotNull
    @Column(name = "valorKm")
    private double valorKm;
    @NotNull
    @Column(name = "disponivel")
    private Boolean disponivel;
    @NotNull
    @Column(name = "veicAtivo")
    private Boolean veicAtivo;
    @JoinColumn(name="IDCATVEICULO_idCatVeiculo", referencedColumnName = "idCatVeiculo")
    @ManyToOne(optional = false)
    private CategoriaVeiculo idCatVeiculo;
    @JoinColumn(name="IDMARCA_idMarca", referencedColumnName = "idMarca")
    @ManyToOne(optional = false)
    private Marca idMarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVeiculo")
    private Collection<Locacao> veiculoCollection;

    public Veiculo() {
    }
    
    @XmlTransient
    public Collection<Locacao> getVeiculoCollection() {
        return veiculoCollection;
    }

    public void setVeiculoCollection(Collection<Locacao> veiculoCollection) {
        this.veiculoCollection = veiculoCollection;
    }
   

    /**
     * @return the idVeiculo
     */
    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    /**
     * @param idVeiculo the idVeiculo to set
     */
    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the ano
     */
    public Integer getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the portas
     */
    public Integer getPortas() {
        return portas;
    }

    /**
     * @param portas the portas to set
     */
    public void setPortas(Integer portas) {
        this.portas = portas;
    }

    /**
     * @return the opcionais
     */
    public String getOpcionais() {
        return opcionais;
    }

    /**
     * @param opcionais the opcionais to set
     */
    public void setOpcionais(String opcionais) {
        this.opcionais = opcionais;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the valorLivre
     */
    public double getValorLivre() {
        return valorLivre;
    }

    /**
     * @param valorLivre the valorLivre to set
     */
    public void setValorLivre(double valorLivre) {
        this.valorLivre = valorLivre;
    }

    /**
     * @return the valorKm
     */
    public double getValorKm() {
        return valorKm;
    }

    /**
     * @param valorKm the valorKm to set
     */
    public void setValorKm(double valorKm) {
        this.valorKm = valorKm;
    }

    /**
     * @return the disponivel
     */
    public Boolean getDisponivel() {
        return disponivel;
    }

    /**
     * @param disponivel the disponivel to set
     */
    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     * @return the veicAtivo
     */
    public Boolean getVeicAtivo() {
        return veicAtivo;
    }

    /**
     * @param veicAtivo the veicAtivo to set
     */
    public void setVeicAtivo(Boolean veicAtivo) {
        this.veicAtivo = veicAtivo;
    }

    /**
     * @return the idCatVeiculo
     */
    public CategoriaVeiculo getIdCatVeiculo() {
        return idCatVeiculo;
    }

    /**
     * @param idCatVeiculo the idCatVeiculo to set
     */
    public void setIdCatVeiculo(CategoriaVeiculo idCatVeiculo) {
        this.idCatVeiculo = idCatVeiculo;
    }

    /**
     * @return the idMarca
     */
    public Marca getIdMarca() {
        return idMarca;
    }

    /**
     * @param idMarca the idMarca to set
     */
    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
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
        final Veiculo other = (Veiculo) obj;
        return Objects.equals(this.idVeiculo, other.idVeiculo);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.idVeiculo);
        return hash;
    }
    @Override
    public String toString() {
        return idVeiculo + modelo + ano + portas + placa;
    }
    
}
