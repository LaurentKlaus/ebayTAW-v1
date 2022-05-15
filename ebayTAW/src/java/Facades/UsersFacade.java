/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import DTO.UserDTO;
import Entity.Users;
import java.util.ArrayList;
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
    
    // Miguel y Cristobal
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
    
    // Cristobal
    public List<Users> getUsuarios(String rol, String username, String email, String name, 
            String surname, String gender, String street, Integer number, 
            String city, String region, Integer postalCode){
        
        String queryStr = "select u from Users u where";
        HashMap<String, Object> queryParams = new HashMap<>(); 
        
        if(rol != null && !rol.isEmpty()){
            queryStr += " u.rol = :rol";
            queryParams.put("rol", rol);
        }
        
        if(username != null && !username.isEmpty()){
            if(queryParams.size() > 0){
                queryStr += " and";
            }
            queryStr += " u.username like :username";
            queryParams.put("username", '%' + username + '%');
        }
        
        if(email != null && !email.isEmpty()){
            if(queryParams.size() > 0){
                queryStr += " and";
            }
            queryStr += " u.email like :email";
            queryParams.put("email", '%' + email + '%');
        }
        
        if(name != null && !name.isEmpty()){
            if(queryParams.size() > 0){
                queryStr += " and";
            }
            queryStr += " u.name like :name";
            queryParams.put("name", '%' + name + '%');
        }
        
        if(surname != null && !surname.isEmpty()){
            if(queryParams.size() > 0){
                queryStr += " and";
            }
            queryStr += " u.surname like :surname";
            queryParams.put("surname", '%' + surname + '%');
        }
        
        if(gender != null && !gender.isEmpty()){
            if(queryParams.size() > 0){
                queryStr += " and";
            }
            queryStr += " u.gender = :gender";
            queryParams.put("gender", gender);
        }
        
        if(street != null && !street.isEmpty()){
            if(queryParams.size() > 0){
                queryStr += " and";
            }
            queryStr += " u.street like :street";
            queryParams.put("street", '%' + street + '%');
        }
        
        if(number != null){
            if(queryParams.size() > 0){
                queryStr += " and";
            }
            queryStr += " u.number = :number";
            queryParams.put("number", number);
        }
        
        if(city != null && !city.isEmpty()){
            if(queryParams.size() > 0){
                queryStr += " and";
            }
            queryStr += " u.city like :city";
            queryParams.put("city", '%' + city + '%');
        }
        
        if(region != null && !region.isEmpty()){
            if(queryParams.size() > 0){
                queryStr += " and";
            }
            queryStr += " u.region like :region";
            queryParams.put("region", '%' + region + '%');
        }
        
        if(postalCode != null){
            if(queryParams.size() > 0){
                queryStr += " and";
            }
            queryStr += " u.postalCode = :postalCode";
            queryParams.put("postalCode", postalCode);
        }
        
        System.out.println("sancho " + queryStr);
        
        Query q = this.getEntityManager().createQuery(queryStr);
        
        for(String key : queryParams.keySet()){
            q.setParameter(key, queryParams.get(key));
        }
       
        return q.getResultList();
    }

    public List<UserDTO> listarUsuariosFiltrado(String nombreUsuario, String orderBy) {
        
        String queryStr = "SELECT u FROM Users u ";
        String where = "WHERE u.name like '%" + nombreUsuario +"%' ";
        String order = "ORDER BY u." + orderBy;
         
        if(nombreUsuario != null && !nombreUsuario.isEmpty())
            queryStr += where;
            
        if(orderBy != null && !orderBy.isEmpty()) 
            queryStr += order;
            
        Query q = this.getEntityManager().createQuery(queryStr);
            
        
        //if(nombreUsuario != null && !nombreUsuario.isEmpty())
        //    q.setParameter("nombreUsuario", nombreUsuario);
        
       // if(orderBy != null && !orderBy.isEmpty()) 
        //    q.setParameter("orderBy", orderBy);
            
            
        List<Users> lista = q.getResultList();
        
        List<UserDTO> resultado = new ArrayList<>();
        for(Users u : lista)
            resultado.add(u.toDTO());
        
        
        return resultado;
        
        
    }
}
