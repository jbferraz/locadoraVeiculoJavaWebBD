/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Reserva;
/**
 *
 * @author @felipeBkl
 */
@Stateless
public class ReservaFacade extends AbstractFacade<Reserva> {
    
    @PersistenceContext(unitName = "locadoraVeiculoJavaWebBDPU")
    private EntityManager em;
    
     @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservaFacade() {
        super(Reserva.class);
    }
    public Reserva buscarPorId(Integer idReserva) {
        String jpql = "select r from Reserva r where r.idReserva=:idReserva";
        TypedQuery<Reserva> query = em.createQuery(jpql,Reserva.class);
        query.setParameter ("idReserva",idReserva);
        Reserva r = query.getSingleResult();
        return r;
    }
    
}
