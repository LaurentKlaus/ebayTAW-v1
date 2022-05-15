/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import DTO.UserDTO;
import Entity.Listausuarios;
import Entity.Users;
import Entity.Usuarioslista;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author power
 */
@Stateless
public class UsuarioslistaFacade extends AbstractFacade<Usuarioslista> {

    @PersistenceContext(unitName = "ebayTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioslistaFacade() {
        super(Usuarioslista.class);
    }
    
    
    public List<Users> getUsuariosEnUnaLista(int idList){
       Query q;
        q = this.getEntityManager().createQuery("select distinct p.userID from Usuarioslista p WHERE p.listID.listID = :idList");
        q.setParameter("idList", idList);
        
        return q.getResultList();

    }
    
    public List<UserDTO> getUsuariosDTOEnUnaLista(int idList){
       
        List<Users> usuarios =  getUsuariosEnUnaLista(idList);
        List<UserDTO> resultado = new ArrayList();
        
        for(Users u : usuarios)
           resultado.add(u.toDTO());
        
        return resultado;

    }

    
    public void borrarUsuarioLista(Users usuario, Listausuarios lista) {
        Query q;
        q = this.getEntityManager().createQuery("DELETE FROM Usuarioslista p WHERE p.listID.listID = :idList AND p.userID.userID = :idUser");
        q.setParameter("idList", lista.getListID());
        q.setParameter("idUser", usuario.getUserID());
        q.executeUpdate();
    }

    public void borrarUsuarioLista(int idList) {
        Query q;
        q = this.getEntityManager().createQuery("DELETE FROM Usuarioslista p WHERE p.listID.listID = :idList");
        q.setParameter("idList", idList);
        q.executeUpdate();
    }
    
}
