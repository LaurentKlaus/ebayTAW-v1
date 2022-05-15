/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import DTO.ProductsDTO;
import DTO.UserDTO;
import Entity.Bids;
import Entity.Products;
import java.util.Arrays;
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
        //q = this.getEntityManager().createQuery("select p from Products p WHERE p.userID.userID = :vendedor");
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

    public List<Products> findById(List<Integer> listaProductosId) {
        Query q;
        
        q = em.createQuery("SELECT p FROM Products p WHERE p.productID IN :listaProductosId");
        q.setParameter("listaProductosId", listaProductosId);
        
        return q.getResultList();
    }

    public List<Products> findByIdAndTitleDescription(List<Integer> listaProductosId, String filtroTituloDescripcion) {
        Query q;
        
        q = em.createQuery("SELECT p FROM Products p WHERE p.productID IN :listaProductosId AND (p.title LIKE :filtroTituloDescripcion OR p.description LIKE :filtroTituloDescripcion)");
        q.setParameter("listaProductosId", listaProductosId);
        q.setParameter("filtroTituloDescripcion", "%" + filtroTituloDescripcion + "%");
        
        return q.getResultList();
    }

    public List<Products> findByIdAndTitleDescriptionAndCategory(List<Integer> listaProductosId, String filtroTituloDescripcion, String[] filtroCategoria) {
        Query q;
        
        q = em.createQuery("SELECT p FROM Products p WHERE p.productID IN :listaProductosId AND (p.title LIKE :filtroTituloDescripcion OR p.description LIKE :filtroTituloDescripcion) AND p.categoryID.name IN :filtroCategoria");
        q.setParameter("listaProductosId", listaProductosId);
        q.setParameter("filtroTituloDescripcion", "%" + filtroTituloDescripcion + "%");
        q.setParameter("filtroCategoria", Arrays.asList(filtroCategoria));
        
        return q.getResultList();
    }

    public List<Products> findByIdAndCategory(List<Integer> listaProductosId, String[] filtroCategoria) {
        Query q;
        
        q = em.createQuery("SELECT p FROM Products p WHERE p.productID IN :listaProductosId AND p.categoryID.name IN :filtroCategoria");
        q.setParameter("listaProductosId", listaProductosId);
        q.setParameter("filtroCategoria", Arrays.asList(filtroCategoria));
        
        return q.getResultList();
    }

    public List<Products> findByTitleDescriptionAndCategory(String filtroTituloDescripcion, String[] filtroCategoria) {
        Query q;
        
        q = em.createQuery("SELECT p FROM Products p WHERE (p.title LIKE :filtroTituloDescripcion OR p.description LIKE :filtroTituloDescripcion) AND p.categoryID.name IN :filtroCategoria");
        q.setParameter("filtroTituloDescripcion", "%" + filtroTituloDescripcion + "%");
        q.setParameter("filtroCategoria", Arrays.asList(filtroCategoria));
        
        return q.getResultList();
    }

    public List<Products> findByTitleDescription(String filtroTituloDescripcion) {
        Query q;
        
        q = em.createQuery("SELECT p FROM Products p WHERE (p.title LIKE :filtroTituloDescripcion OR p.description LIKE :filtroTituloDescripcion)");
        q.setParameter("filtroTituloDescripcion", "%" + filtroTituloDescripcion + "%");
        
        return q.getResultList();
    }

    public List<Products> findByCategory(String[] filtroCategoria) {
        Query q;
        
        q = em.createQuery("SELECT p FROM Products p WHERE p.categoryID.name IN :filtroCategoria");
        q.setParameter("filtroCategoria", Arrays.asList(filtroCategoria));
        
        return q.getResultList();
    }
    
}
