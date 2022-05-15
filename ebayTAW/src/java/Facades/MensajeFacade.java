/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import DTO.UserDTO;
import Entity.Mensaje;
import Entity.Users;
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
public class MensajeFacade extends AbstractFacade<Mensaje> {

    @PersistenceContext(unitName = "ebayTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajeFacade() {
        super(Mensaje.class);
    }

    public List<Mensaje> misMensajes(UserDTO user) {
        
        //Creamos al usuario
        Users usuario = new Users();
        usuario.setCity(user.getCity());
        usuario.setEmail(user.getEmail());
        usuario.setGender(user.getGender());
        usuario.setName(user.getName());
        usuario.setNumber(user.getNumber());
        usuario.setPassword(user.getPassword());
        usuario.setPostalCode(user.getPostalCode());
        usuario.setRegion(user.getRegion());
        usuario.setRol(user.getRol());
        usuario.setStreet(user.getStreet());
        
        usuario.setSurname(user.getSurname());
        usuario.setUsername(user.getUsername());
        usuario.setUserID(user.getUserID());
        ///////////////////////////////////////
        
        Query q;
        q = this.getEntityManager().createQuery("SELECT u from Mensaje u WHERE u.userID = :idUser");
        q.setParameter("idUser", usuario);
        List<Mensaje> mensajes = q.getResultList();

        return mensajes;
        
    }

    public void borrarMensaje(int idMensaje) {
        Query q;
        q = this.getEntityManager().createQuery("DELETE FROM Mensaje p WHERE p.id = :idMensaje");
        q.setParameter("idMensaje", idMensaje);
        q.executeUpdate();
    }

   
}
