/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import DTO.CategoriesDTO;
import DTO.UserDTO;
import Entity.Products;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
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
public class ProductsFacade extends AbstractFacade<Products> {

    @PersistenceContext(unitName = "ebayTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductsFacade() {
        super(Products.class);
    }
    
    public List<Products> findAllByUser (UserDTO vendedor){
        Query q;
        q = this.getEntityManager().createQuery("select p from Products p WHERE p.userID.userID = :vendedor ORDER BY p.userID DESC");
        q.setParameter("vendedor", vendedor.getUserID());
        return q.getResultList();
    }

    public List<Products> findAllByTitulo (String titulo){
        Query q;
        q = this.getEntityManager().createQuery("select p from Products p WHERE p.title like :titulo");
        q.setParameter("titulo", '%' + titulo + '%');
        return q.getResultList();
    }
    
    public List<Products> findByTitulo (String titulo, UserDTO vendedor){
        Query q;
        q = this.getEntityManager().createQuery("select p from Products p WHERE p.userID.userID = :vendedor AND p.title like :titulo");
        q.setParameter("titulo", '%' + titulo + '%');
        q.setParameter("vendedor", vendedor.getUserID());
        return q.getResultList();
    }
    
    //Cristobal
    public List<Products> findAll(String title, Integer userId, Integer categoryId, BigDecimal initialPrice, Date startDate, Date finishDate, Boolean isSold){
        String queryStr = "select p from Products p where";
        HashMap<String, Object> parameters = new HashMap<>();
        
        if(title != null || title.isEmpty()){
            queryStr += " p.title like :title";
            parameters.put("title", '%' + title + '%');
        }
        
        if(userId != null){
            if(parameters.size() > 0){
                queryStr += " and";
            }
            queryStr += " p.userID.userID = :userID";
            parameters.put("userID", userId);
        }
        
        if(categoryId != null){
            if(parameters.size() > 0){
                queryStr += " and";
            }
            queryStr += " p.categoryID.categoryID = :categoryID";
            parameters.put("categoryID", categoryId);
        }
        
        if(initialPrice != null){
            if(parameters.size() > 0){
                queryStr += " and";
            }
            queryStr += " p.initialPrice = :initialPrice";
            parameters.put("initialPrice", initialPrice);
        }
        
        if(startDate != null){
            if(parameters.size() > 0){
                queryStr += " and";
            }
            queryStr += " p.startDate = :startDate";
            parameters.put("startDate", startDate);
        }
        
        if(finishDate != null){
            if(parameters.size() > 0){
                queryStr += " and";
            }
            queryStr += " p.finishDate = :finishDate";
            parameters.put("finishDate", finishDate);
        }
        
        if(isSold != null){
            if(parameters.size() > 0){
                queryStr += " and";
            }
            queryStr += " p.isSold = :isSold";
            parameters.put("isSold", isSold);
        }
        
        Query q = this.getEntityManager().createQuery(queryStr);
        
        for(String k:parameters.keySet()){
            q.setParameter(k, parameters.get(k));
        }
        
        return q.getResultList();
    }
    
}
