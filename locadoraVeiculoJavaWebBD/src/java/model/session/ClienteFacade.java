/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Cliente;

/**
 *
 * @author jairb
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "locadoraVeiculoJavaWebBDPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    public Cliente buscarPorNomeCliente(String nomeCliente) {
        String jpql = "select c from Cliente c where c.nomeCliente=:nomeCliente";
        TypedQuery<Cliente> query = em.createQuery(jpql,Cliente.class);
        query.setParameter ("nomeCliente",nomeCliente);
        Cliente c = query.getSingleResult();
        return c;
    }
    
}
