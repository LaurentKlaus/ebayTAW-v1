/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.UserDTO;
import Entity.Mensaje;
import Entity.Users;
import Facades.MensajeFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author power
 */
@Stateless
public class MensajeService {
    
    @EJB MensajeFacade mf;

    public void crearMensaje(UserDTO user, String textoMensaje) {
        
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
        usuario.setUserID(user.getUserID());
        usuario.setSurname(user.getSurname());
        usuario.setUsername(user.getUsername());
        ///////////////////////////////////////
        
        Mensaje msj = new Mensaje();
        msj.setUserID(usuario);
        msj.setTexto(textoMensaje);

        mf.create(msj);
     
    }

    public List<Mensaje> misMensajes(UserDTO usuarioSesionActual) {
        return this.mf.misMensajes(usuarioSesionActual);
    }

    public void borrarMensaje(int idMensaje) {
        this.mf.borrarMensaje(idMensaje);
    
    }
    
}
