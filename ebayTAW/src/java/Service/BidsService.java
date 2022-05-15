/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.BidsDTO;
import DTO.UserDTO;
import Entity.Bids;
import Entity.Users;
import Facades.BidsFacade;
import Facades.UsersFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 34637
 */
@Stateless
public class BidsService {

    @EJB
    private UsersFacade usersFacade;

    @EJB
    private BidsFacade bidsFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<BidsDTO> conversionListaPujasDTO(List<Bids> listaPujas) {
        List<BidsDTO> listaPujasDTO = null;
        
        if (listaPujas != null) {
            listaPujasDTO = new ArrayList<>();
            for (Bids puja : listaPujas) {
                listaPujasDTO.add(puja.toDTO());
            }
        }
        
        return listaPujasDTO;
    }
    
    public List<BidsDTO> listarPujasPorUsuario(UserDTO usuario) {
        Users comprador = this.usersFacade.find(usuario.getUserID());
        List<BidsDTO> listaPujasDTO = null;
        
        if (comprador != null) {
            List<Bids> listaPujas = this.bidsFacade.findByUserId(comprador.getUserID());
            listaPujasDTO = this.conversionListaPujasDTO(listaPujas);
        }
        
        return listaPujasDTO;
    }
    
    public Bids buscarPuja(Integer usuarioId, Integer productoId) {
        return this.bidsFacade.findByProductAndUser(usuarioId, productoId);
    }

    public void anadirPuja(Bids puja) {
        this.bidsFacade.create(puja);
    }

    public void modificarPuja(Bids puja) {
       this.bidsFacade.edit(puja);
    }

    public void borrarPuja(Bids puja) {
        this.bidsFacade.remove(puja); 
    }
}
