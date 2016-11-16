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
 * @author @felipeBkl
 */
@Entity
@Table(name = "reserva")
@XmlRootElement
public class Reserva implements Serializable {
    private static long serialVersionUID = 1L;
    
    public static long getSerialVersionUID(){
        return serialVersionUID;
    }
     public static void setSerialVersionUID(long aSerialVersionUID){
         serialVersionUID = aSerialVersionUID;
     }
     @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
     @Basic (optional = false)
     @Column (name = "idReserva")
     private Integer idReserva;
     @Column (name = "dataLocacao")
     @Temporal(TemporalType.DATE)
     private Date dataLocacao;
     @Column(name = "dataRetirada")
    @Temporal(TemporalType.DATE)
    private Date dataRetirada;
     @JoinColumn(name="IDCLIENTE_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name="IDVEICULO_idVeiculo", referencedColumnName = "idVeiculo")
    @ManyToOne(optional = false)
    private Veiculo idVeiculo;
    
    public Reserva(){
        
    }
    

    public Integer getIdReserva(){
        return idReserva;
    }
    
    public void setIdReserva(Integer idReserva){
        this.idReserva = idReserva;
    }
    public Date getDataLocacao(){
        return dataLocacao;
    }
    public void setDataLocacao(Date dataLocacao){
        this.dataLocacao = dataLocacao;
    }
    public Date getDataRetirada(){
        return dataRetirada;
    }
    public void setDataRetirada(Date dataRetirada){
        this.dataRetirada = dataRetirada;
    }
    public Cliente getIdCliente(){
        return idCliente;
    }
    public void setIdCliente(Cliente idCliente){
        this.idCliente = idCliente;
    }
    public Veiculo getIdVeiculo(){
        return idVeiculo;
    }
    public void setIdVeiculo(Veiculo idVeiculo){
        this.idVeiculo = idVeiculo;
    }
}
