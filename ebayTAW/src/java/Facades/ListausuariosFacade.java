/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import DTO.ListausuarioDTO;
import Entity.Listausuarios;
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
public class ListausuariosFacade extends AbstractFacade<Listausuarios> {

    @PersistenceContext(unitName = "ebayTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ListausuariosFacade() {
        super(Listausuarios.class);
    }
    
    public int getId(String fname){
       Query q;
        q = this.getEntityManager().createQuery("select p.listID from Listausuarios p WHERE p.username like :fname");
        q.setParameter("fname", '%' + fname + '%');
        return Integer.parseInt(q.getResultList().get(0).toString());

    }

    public List<ListausuarioDTO> todasLasListas() {
        List<Listausuarios> listas =  super.findAll();
        List<ListausuarioDTO> resultado = new ArrayList();
        for(Listausuarios l : listas)
            resultado.add(l.toDTO());
        
        return resultado;
        
    }

    public void borrarLista(Integer listID) {
        Query q;
        q = this.getEntityManager().createQuery("DELETE FROM Listausuarios p WHERE p.listID = :idList");
        q.setParameter("idList", listID);
        q.executeUpdate();
    }
    
}
