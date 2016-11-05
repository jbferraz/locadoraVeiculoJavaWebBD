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
import model.CategoriaVeiculo;

/**
 *
 * @author jairb
 */
@Stateless
public class CategoriaVeiculoFacade extends AbstractFacade<CategoriaVeiculo>{
    @PersistenceContext(unitName = "locadoraVeiculoJavaWebBDPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaVeiculoFacade() {
        super(CategoriaVeiculo.class);
    }
    
    public CategoriaVeiculo buscarPorDescCatVeiculo(String descCatVeiculo){
        String jpql = "select c from CategoriaVeiculo c where c.descCatVeiculo=:descCatVeiculo";
        TypedQuery<CategoriaVeiculo> query = em.createQuery(jpql,CategoriaVeiculo.class);
        query.setParameter ("descCatVeiculo",descCatVeiculo);
        CategoriaVeiculo c = query.getSingleResult();
        return c;
    }
}
