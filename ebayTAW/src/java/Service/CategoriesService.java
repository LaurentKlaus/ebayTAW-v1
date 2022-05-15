/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.CategoriesDTO;
import Entity.Categories;
import Facades.CategoriesFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 34637
 */
@Stateless
public class CategoriesService {

    @EJB
    private CategoriesFacade categoriesFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<CategoriesDTO> conversionListaCategoriasDTO(List<Categories> listaCategorias) {
        List<CategoriesDTO> listaCategoriasDTO = null;
        
        if (listaCategorias != null) {
            listaCategoriasDTO = new ArrayList<>();
            for (Categories categoria : listaCategorias) {
                listaCategoriasDTO.add(categoria.toDTO());
            }
        }
        
        return listaCategoriasDTO;
    }
    
    public List<CategoriesDTO> listarCategorias() {
        return this.conversionListaCategoriasDTO(this.categoriesFacade.findAll());
    }
}
