/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.ListausuarioDTO;
import DTO.UserDTO;
import DTO.UsuarioListaDTO;
import Entity.Listausuarios;
import Entity.Users;
import Entity.Usuarioslista;
import Facades.UsuarioslistaFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author power
 */
@Stateless
public class UsuarioListaService {
    
    @EJB UsuarioslistaFacade usf;

    public void crearUsuarioLista(Users user, Listausuarios lista) {
        
    Usuarioslista ul = new Usuarioslista();
    ul.setListID(lista);
    ul.setUserID(user);
    
    usf.create(ul);
    
    }

    public void borrarUsuarioLista(Users usuario, Listausuarios lista) {
        this.usf.borrarUsuarioLista(usuario,lista);
    }

    public void borrarUsuarioLista(int idList) {
        this.usf.borrarUsuarioLista(idList);
    }

    
}
