/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Bids;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
