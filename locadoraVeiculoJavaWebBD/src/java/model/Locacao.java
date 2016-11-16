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
    
    @NotNull  
    @JoinColumn(name="idCliente", referencedColumnName = "idCliente")
    @ManyToOne
    private Cliente idCliente;
    @NotNull
    @JoinColumn(name="idVeiculo", referencedColumnName = "idVeiculo")
    @ManyToOne
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
