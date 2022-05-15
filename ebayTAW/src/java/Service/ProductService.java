/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.ProductsDTO;
import DTO.UserDTO;
import Entity.Bids;
import Entity.Products;
import Entity.Users;
import Facades.BidsFacade;
import Facades.ProductsFacade;
import Facades.UsersFacade;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author mjura
 */
@Stateless
public class ProductService {

    @EJB
    private BidsFacade bidsFacade;

    @EJB
    private UsersFacade usersFacade;
    
    @EJB ProductsFacade pf;
    
    public List<ProductsDTO> listaEntityADTO (List<Products> lista){
        List<ProductsDTO> listaDTO = null;
        if (lista != null){
            listaDTO = new ArrayList<>();
            for (Products producto:lista){
                listaDTO.add(producto.toDTO());
            }
        }
        return listaDTO;
    }

    public List<ProductsDTO> listarProductos (String filtroTitulo){
        List<Products> productos = null;
        if (filtroTitulo == null || filtroTitulo.isEmpty()){
            productos = this.pf.findAll();
        } else {
            productos = this.pf.findAllByTitulo(filtroTitulo);
        }
        
        return this.listaEntityADTO(productos);
    }    

    public List<ProductsDTO> listarProductos (String filtroTitulo, UserDTO vendedor){
        List<Products> productos = null;
        if (filtroTitulo == null || filtroTitulo.isEmpty()){
            productos = this.pf.findAllByUser(vendedor);
        } else {
            productos = this.pf.findByTitulo(filtroTitulo, vendedor);
        }
        
        return this.listaEntityADTO(productos);
    }
    
    public void borrarProducto(Integer id){
        Products producto = this.pf.find(id);
        this.pf.remove(producto);
    }
    
    
    public ProductsDTO buscarProducto(Integer id){
        Products producto = this.pf.find(id);
        return producto.toDTO();
    }
    
    public Products findProduct(Integer id){
        Products producto = this.pf.find(id);
        return producto;
    }
    
    public void editarProductoBorrarLuego (Integer id, String titulo, String descripcion, BigDecimal precioInicial, String foto, Boolean vendido){
        Products producto = this.pf.find(id);
        
        producto.setTitle(titulo);
        producto.setDescription(descripcion);
        producto.setInitialPrice(precioInicial);
        producto.setPhoto(foto);
        producto.setIsSold(vendido);
        this.pf.edit(producto);
    }
    
    public void editarProducto(Integer id, String titulo, String descripcion, BigDecimal precioInicial, String foto, Date fechaInicio, Date fechaFin, Boolean vendido){
        Products producto = this.pf.find(id);
        
        producto.setTitle(titulo);
        producto.setDescription(descripcion);
        producto.setInitialPrice(precioInicial);
        producto.setPhoto(foto);
        producto.setStartDate(fechaInicio);
        producto.setFinishDate(fechaFin);
        producto.setIsSold(vendido);
        this.pf.edit(producto);
    }

    public List<ProductsDTO> listarProductosPujados(UserDTO usuario, String filtroTituloDescripcion, String [] filtroCategoria) {
        Users comprador = this.usersFacade.find(usuario.getUserID());
        List<ProductsDTO> listaProductosDTO = null;
                
        if (comprador != null) {
            List<Bids> listaPujas = this.bidsFacade.findByUserId(comprador.getUserID());
            
            if (listaPujas != null && !listaPujas.isEmpty()) {
                List<Integer> listaProductosId = new ArrayList<>();
                
                for (Bids puja : listaPujas) {
                    listaProductosId.add(puja.getProductID().getProductID());
                } 
                
                List<Products> listaProductos;
                
                if (filtroTituloDescripcion != null && !filtroTituloDescripcion.isEmpty()) {
                    if (filtroCategoria != null && filtroCategoria.length > 0) {
                        listaProductos = this.pf.findByIdAndTitleDescriptionAndCategory(listaProductosId, filtroTituloDescripcion, filtroCategoria);
                    } else {
                        listaProductos = this.pf.findByIdAndTitleDescription(listaProductosId, filtroTituloDescripcion);
                    }
                } else {
                    if (filtroCategoria != null && filtroCategoria.length > 0) {
                        listaProductos = this.pf.findByIdAndCategory(listaProductosId, filtroCategoria);
                    } else {
                        listaProductos = this.pf.findById(listaProductosId);
                    }
                }
                
                listaProductosDTO = this.listaEntityADTO(listaProductos);
            }
        }
        
        return listaProductosDTO;
    }

    public List<ProductsDTO> listarProductos(String filtroTituloDescripcion, String[] filtroCategoria) {
        List<Products> listaProductos;
                
        if (filtroTituloDescripcion != null && !filtroTituloDescripcion.isEmpty()) {
            if (filtroCategoria != null && filtroCategoria.length > 0) {
                listaProductos = this.pf.findByTitleDescriptionAndCategory(filtroTituloDescripcion, filtroCategoria);
            } else {
                listaProductos = this.pf.findByTitleDescription(filtroTituloDescripcion);
            }
        } else {
            if (filtroCategoria != null && filtroCategoria.length > 0) {
                listaProductos = this.pf.findByCategory(filtroCategoria);
            } else {
                listaProductos = this.pf.findAll();
            }
        }

       return this.listaEntityADTO(listaProductos);
    }
}
