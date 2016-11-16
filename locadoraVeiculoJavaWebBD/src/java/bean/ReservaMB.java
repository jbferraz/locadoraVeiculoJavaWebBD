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
import model.Cliente;
import model.Veiculo;
import model.Reserva;
import model.session.ClienteFacade;
import model.session.VeiculoFacade;
import model.session.ReservaFacade;

/**
 *
 * @author AssisBrasil
 */
@Named(value = "reservaMB")
@SessionScoped
public class ReservaMB implements Serializable {

    private Reserva reservaSelecionado;
    @Inject
    private ReservaFacade reservaFacade;
    @Inject
    private VeiculoFacade veiculoFacade;
    @Inject
    private ClienteFacade clienteFacade;
    /**
     * Creates a new instance of ReservaMB
     */
    public ReservaMB() {
        reservaSelecionado = new Reserva();
    }
    
    public Reserva getReservaSelecionado(){
        return reservaSelecionado;
    }
    
    public void setReservaSelecionado(Reserva reservaSelecionado){
        this.reservaSelecionado = reservaSelecionado;
    }
    
    public List<Reserva> getListaReserva(){
        return reservaFacade.findAll();
    }
    public List<Veiculo> getListaVeiculo(){
        return veiculoFacade.findAll();
    }
    public List<Cliente> getListaCliente(){
        return clienteFacade.findAll();
    }
    public List<Veiculo> getListaVeicDisponivel() {
        return veiculoFacade.getListaVeicDisponivel();
    }
    public String novoReserva(){
        reservaSelecionado = new Reserva();
        return ("/usuario/formularioReservaCadastro?faces-redirect=true");
    }
    public String adicionarReserva(){
        reservaFacade.create(reservaSelecionado);
        return (this.novoReserva());
    }
    public String editarReserva(Reserva r){
        reservaSelecionado = r;
        return ("/usuario/formularioReservaEdicao?faces-redirect=true");
    }
    public String atualizarReserva(){
        reservaFacade.edit(reservaSelecionado);
        return ("/usuario/listaReserva?faces-redirect=true");
    }
    public void removerReserva(Reserva r){
        reservaFacade.remove(r);
    }
    public Veiculo buscarVeiculoPorPlaca(String placa) {
        return veiculoFacade.buscarPorPlaca(placa);
    }
    public Cliente buscarClientePorNome(String nome) {
        return clienteFacade.buscarPorNomeCliente(nome);
    }
}
