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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "cliente")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM cliente c"),
//    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM cliente c WHERE c.idcliente = :idcliente"),
//    @NamedQuery(name = "Cliente.findByNomeCliente", query = "SELECT c FROM cliente c WHERE c.nomeCliente = :nomeCliente"),
//    @NamedQuery(name = "Cliente.findByLogin", query = "SELECT c FROM cliente c WHERE c.login = :login")})
public class Cliente implements Serializable {

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
    @Column(name = "idcliente")
    private Integer idcliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeCliente")
    private String nomeCliente;
    @Size(min = 1, max = 45)
    @Column(name = "CPF")
    private String CPF;
    @Size(min = 1, max = 255)
    @Column(name = "endereco")
    private String endereco;
    @Size(min = 1, max = 45)
    @Column(name = "celular")
    private String celular;
    @Size(min = 1, max = 45)
    @Column(name = "telefone")
    private String telefone;
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Size(max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Size(min = 1, max = 45)
    @Column(name = "login")
    private String login;
    @Size(min = 1, max = 255)
    @Column(name = "senha")
    private String senha;
    @Column(name = "cliAtivo")
    private Boolean cliAtivo;
    @Column(name = "adm")
    private Boolean adm;
    

    public Integer getID() {
        return getIdcliente();
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    /**
     * @return the idcliente
     */
    public Integer getIdcliente() {
        return idcliente;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the cliAtivo
     */
    public Boolean getCliAtivo() {
        return cliAtivo;
    }

    /**
     * @param cliAtivo the cliAtivo to set
     */
    public void setCliAtivo(Boolean cliAtivo) {
        this.cliAtivo = cliAtivo;
    }

    /**
     * @return the adm
     */
    public Boolean getAdm() {
        return adm;
    }

    /**
     * @param adm the adm to set
     */
    public void setAdm(Boolean adm) {
        this.adm = adm;
    }

    @Override
    public String toString() {
        return idcliente + nomeCliente + CPF;
    }
    
     public boolean isAdmin() {
        return adm;
    }
    
     public String getCliAtivoString(){
        if(cliAtivo) return "SIM";
        else return "NAO";
    }
     
    public String getAdminString(){
        if(adm) return "SIM";
        else return "NAO";
    }

    public void setAdmin(boolean admin) {
        this.adm = admin;
    }
    
    public boolean verificaLogin(String login, String senha){
        return(this.login.equals(login) && this.senha.equals(senha));
    }
    
}
