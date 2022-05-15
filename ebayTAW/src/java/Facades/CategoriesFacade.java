/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Categories;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mjura
 */
@Stateless
public class CategoriesFacade extends AbstractFacade<Categories> {

    @PersistenceContext(unitName = "ebayTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriesFacade() {
        super(Categories.class);
    }
    
    // Miguel
    public List<Categories> findAllByNombre(String nombre){
        Query q = this.getEntityManager().createQuery("select c from Categories c where c.name like :nombre");
        q.setParameter("nombre", '%' + nombre + '%');
        return q.getResultList();
    }
    
    // Miguel
    public Categories findByNombre(String name) {
        Query q;
        q = this.getEntityManager().createQuery("SELECT c FROM Categories c WHERE c.name = :name");
        q.setParameter("name", name);
        
        return (Categories)q.getSingleResult();
    }
}
