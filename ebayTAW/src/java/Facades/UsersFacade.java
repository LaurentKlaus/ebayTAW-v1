/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Users;
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
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "ebayTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    public Users comprobarUsuario (String email, String pass){
        Query q;
        q = this.getEntityManager().createQuery("select u from Users u where u.email = :email and u.password = :clave");
        q.setParameter("email", email);
        q.setParameter("clave", pass);
        List<Users> lista = q.getResultList();
        if (lista == null || lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Users> getUsuarios(){
        Query q = this.getEntityManager().createQuery("select u from Users");
        
        return q.getResultList();
    }
    
    public List<Users> getUsuarios(String rol, String username, String name, 
            String surname, String gender, String street, String number, 
            String city, String region, String postalCode){
        
        String queryStr = "select u from Users u where";
        HashMap<String, String> queryParams = new HashMap<String, String>(); 
        
        if(rol != null){
            queryStr += " u.rol = :rol";
            queryParams.put("rol", rol);
        }
        
        if(username != null){
            queryStr += " u.username = :username";
            queryParams.put("username", username);
        }
        
        if(name != null){
            queryStr += " u.name = :name";
            queryParams.put("name", name);
        }
        
        if(surname != null){
            queryStr += " u.surname = :surname";
            queryParams.put("surname", surname);
        }
        
        if(gender != null){
            queryStr += " u.gender = :gender";
            queryParams.put("gender", gender);
        }
        
        if(street != null){
            queryStr += " u.street = :street";
            queryParams.put("street", street);
        }
        
        if(number != null){
            queryStr += " u.number = :number";
            queryParams.put("number", number);
        }
        
        if(city != null){
            queryStr += " u.city = :city";
            queryParams.put("city", city);
        }
        
        if(region != null){
            queryStr += " u.region = :region";
            queryParams.put("region", region);
        }
        
        if(postalCode != null){
            queryStr += " u.postalCode = :postalCode";
            queryParams.put("postalCode", postalCode);
        }
        
        Query q = this.getEntityManager().createQuery(queryStr);
        
        for(String key : queryParams.keySet()){
            q.setParameter(key, queryParams.get(key));
        }
        
        return q.getResultList();
    }
}
