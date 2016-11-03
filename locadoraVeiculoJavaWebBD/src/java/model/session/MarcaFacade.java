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
import model.Marca;

/**
 *
 * @author jairb
 */
@Stateless
public class MarcaFacade extends AbstractFacade<Marca>{
    @PersistenceContext(unitName = "locadoraVeiculoJavaWebBDPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarcaFacade() {
        super(Marca.class);
    }
    
    public Marca buscarPorNomeMarca(String nome){
        String jpql = "select m from Marca m where m.nomeMarca=:nome";
        TypedQuery<Marca> query = em.createQuery(jpql,Marca.class);
        query.setParameter ("nome",nome);
        Marca m = query.getSingleResult();
        return m;
    }
}
