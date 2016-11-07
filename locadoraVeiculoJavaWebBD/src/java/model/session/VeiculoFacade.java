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
import javax.persistence.TypedQuery;
import model.Veiculo;

/**
 *
 * @author jairb
 */
@Stateless
public class VeiculoFacade extends AbstractFacade<Veiculo> {

    @PersistenceContext(unitName = "locadoraVeiculoJavaWebBDPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VeiculoFacade() {
        super(Veiculo.class);
    }

    public Veiculo buscarPorPlaca(String placa) {
        String jpql = "select v from Veiculo v where v.placa=:placa";
        TypedQuery<Veiculo> query = em.createQuery(jpql,Veiculo.class);
        query.setParameter ("placa",placa);
        Veiculo v = query.getSingleResult();
        return v;
    }
    
    public List<Veiculo> listaVeicDisponivel(Boolean disp) {
        String jpql = "select v from Veiculo v where v.disponivel=:disponivel";
        TypedQuery<Veiculo> query = em.createQuery(jpql,Veiculo.class);
        query.setParameter ("disponivel",disp);
        Veiculo v = query.getSingleResult();
        return (List<Veiculo>) v;
    }
    
    public List<Veiculo> listaVeicDisponivelTeste() {
        String jpql = "select v from Veiculo v where v.disponivel=:disponivel";
        TypedQuery<Veiculo> query = em.createQuery(jpql,Veiculo.class);
        query.setParameter ("disponivel",true);
        Veiculo v = (Veiculo) query.getResultList();
        return (List<Veiculo>) v;
    }
}
