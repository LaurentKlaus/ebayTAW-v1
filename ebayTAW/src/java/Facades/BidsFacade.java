/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import DTO.BidsDTO;
import Entity.Bids;
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
public class BidsFacade extends AbstractFacade<Bids> {

    @PersistenceContext(unitName = "ebayTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BidsFacade() {
        super(Bids.class);
    }

    public List<Bids> findByUserId(Integer usuarioId) {
        Query q;
        
        q = em.createQuery("SELECT b FROM Bids b WHERE b.userID.userID = :usuarioId");
        q.setParameter("usuarioId", usuarioId);
        
        return q.getResultList();
    }

    public Bids findByProductAndUser(Integer usuarioId, Integer productoId) {
        Query q;
        
        q = em.createQuery("SELECT b FROM Bids b WHERE b.userID.userID = :usuarioId AND b.productID.productID = :productoId");
        q.setParameter("usuarioId", usuarioId);
        q.setParameter("productoId", productoId);

        List<Bids> listaPujas = q.getResultList();
        Bids puja = (listaPujas != null && !listaPujas.isEmpty()) ? listaPujas.get(0) : null;
        
        return puja ;
    }
    
}
