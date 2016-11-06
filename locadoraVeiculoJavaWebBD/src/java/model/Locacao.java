/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jairb
 */
@Entity
@Table(name = "locacao")
@XmlRootElement
public class Locacao implements Serializable{
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
    @Column(name = "idLocacao")
    private Integer idLocacao;
    @Column(name = "dataLocacao")
    @Temporal(TemporalType.DATE)
    private Date dataLocacao;
    @Column(name = "dataRetirada")
    @Temporal(TemporalType.DATE)
    private Date dataRetirada;
    @Column(name = "dataDevolucao")
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kmRetirada")
    private Integer kmRetirada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kmDevolucao")
    private Integer kmDevolucao;
    @Column(name = "kmLivre")
    private Boolean kmLivre;
    @Column(name = "status")
    private Boolean status;
    
    @JoinColumn(name="IDCLIENTE_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name="IDVEICULO_idVeiculo", referencedColumnName = "idVeiculo")
    @ManyToOne(optional = false)
    private Veiculo idVeiculo;

    public Locacao() {
    }

    /**
     * @return the idLocacao
     */
    public Integer getIdLocacao() {
        return idLocacao;
    }

    /**
     * @param idLocacao the idLocacao to set
     */
    public void setIdLocacao(Integer idLocacao) {
        this.idLocacao = idLocacao;
    }

    /**
     * @return the dataLocacao
     */
    public Date getDataLocacao() {
        return dataLocacao;
    }

    /**
     * @param dataLocacao the dataLocacao to set
     */
    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    /**
     * @return the dataRetirada
     */
    public Date getDataRetirada() {
        return dataRetirada;
    }

    /**
     * @param dataRetirada the dataRetirada to set
     */
    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    /**
     * @return the dataDevolucao
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @param dataDevolucao the dataDevolucao to set
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * @return the kmRetirada
     */
    public Integer getKmRetirada() {
        return kmRetirada;
    }

    /**
     * @param kmRetirada the kmRetirada to set
     */
    public void setKmRetirada(Integer kmRetirada) {
        this.kmRetirada = kmRetirada;
    }

    /**
     * @return the kmDevolucao
     */
    public Integer getKmDevolucao() {
        return kmDevolucao;
    }

    /**
     * @param kmDevolucao the kmDevolucao to set
     */
    public void setKmDevolucao(Integer kmDevolucao) {
        this.kmDevolucao = kmDevolucao;
    }

    /**
     * @return the kmLivre
     */
    public Boolean getKmLivre() {
        return kmLivre;
    }

    /**
     * @param kmLivre the kmLivre to set
     */
    public void setKmLivre(Boolean kmLivre) {
        this.kmLivre = kmLivre;
    }

    /**
     * @return the status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return the idCliente
     */
    public Cliente getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the idVeiculo
     */
    public Veiculo getIdVeiculo() {
        return idVeiculo;
    }

    /**
     * @param idVeiculo the idVeiculo to set
     */
    public void setIdVeiculo(Veiculo idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    
}
