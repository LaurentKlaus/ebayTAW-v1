/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import javax.ejb.Stateless;
import DTO.*;
import Entity.*;
import javax.ejb.EJB;
import Facades.*;
import java.util.List;

/**
 *
 * @author power
 */
@Stateless
public class ListaUsuariosService {
    
    @EJB ListausuariosFacade luf;

    public void crearLista(String fname) {
        
    Listausuarios lu = new Listausuarios();
    lu.setUsername(fname);
    
    luf.create(lu);
    }
    
    public int getId(String fname){
        return luf.getId(fname);
    }

    public Listausuarios getLista(Integer idList) {
        
    Listausuarios lu = this.luf.find(idList);
    return lu;
    
    }


    public List<ListausuarioDTO> todasLasListas() {
      return luf.todasLasListas();
    }

    public void borrarLista(Integer listID) {
        this.luf.borrarLista(listID);
    }

    
}
