/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.CategoriesDTO;
import DTO.ProductsDTO;
import DTO.UserDTO;
import Entity.Categories;
import Entity.Products;
import Entity.Users;
import Facades.CategoriesFacade;
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
    
    @EJB ProductsFacade pf;
    @EJB CategoriesFacade cf;
    @EJB UsersFacade uf;
    
    public List<ProductsDTO> listaEntityADTO (List<Products> lista){
        List<ProductsDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Products producto : lista) {
                listaDTO.add(producto.toDTO());
            }
        }
        return listaDTO;
    }

    // Borrar
    public List<ProductsDTO> listarProductos(String filtroTitulo) {
        List<Products> productos = null;
        if (filtroTitulo == null || filtroTitulo.isEmpty()) {
            productos = this.pf.findAll();
        } else {
            productos = this.pf.findAllByTitulo(filtroTitulo);
        }


        return this.listaEntityADTO(productos);
    }

    public void borrarProducto(Integer id) {
        Products producto = this.pf.find(id);
        this.pf.remove(producto);
    }

    public ProductsDTO buscarProducto(Integer id) {
        Products producto = this.pf.find(id);
        return producto.toDTO();
    }
    
    
    // Borrar??
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
    
    
    // Miguel
    public List<ProductsDTO> listarProductos(String title, UserDTO vendedor, Integer categoryId, BigDecimal initialPrice, Date startDate, Date finishDate, Boolean isSold) {
        List<Products> productos;

        if ((title == null || title.isEmpty()) && categoryId == null && initialPrice == null && startDate == null && finishDate == null && isSold == null) {
            productos = this.pf.findAllByUser(vendedor);
        } else {
            productos = this.pf.findAll(title, vendedor.getUserID(), categoryId, initialPrice, startDate, finishDate, isSold);
        }

        return this.listaEntityADTO(productos);
    }

    //Cristobal
    public List<ProductsDTO> listarProductos(String title, Integer userId, Integer categoryId, BigDecimal initialPrice, Date startDate, Date finishDate, Boolean isSold) {
        List<Products> productos;

        if ((title == null || title.isEmpty()) && userId == null && categoryId == null && initialPrice == null && startDate == null && finishDate == null && isSold == null) {
            productos = this.pf.findAll();
        } else {
            productos = this.pf.findAll(title, userId, categoryId, initialPrice, startDate, finishDate, isSold);
        }

        return this.listaEntityADTO(productos);
    }
    
    //Cristobal
    public void editarProducto(Integer productId, String titulo, String descripcion, String linkFoto, Integer categoriaId, BigDecimal pInicial, Date fInicio, Date fFin, Boolean v){
        
        //Busco el producto
        Products producto = this.pf.find(productId);
        Categories cat = this.cf.find(categoriaId);
        
        producto.setTitle(titulo);
        producto.setDescription(descripcion);
        producto.setCategoryID(cat);
        producto.setInitialPrice(pInicial);
        producto.setPhoto(linkFoto);
        producto.setStartDate(fInicio);
        producto.setFinishDate(fFin);
        producto.setIsSold(v);
        
        this.pf.edit(producto);
    }
    
    //Miguel
    public void crearProducto(String id, String titulo, String descripcion, String categoria, BigDecimal precio, String foto, Date finicio, Date ffin){
        Products producto = new Products();
        Categories cat = this.cf.findByNombre(categoria);
        Users usuario = this.uf.find(Integer.parseInt(id));
        List<Products> productosUsuario = this.pf.findAllByUser(usuario.toDTO());
        
        producto.setUserID(usuario);
        producto.setTitle(titulo);
        producto.setDescription(descripcion);
        producto.setCategoryID(cat);
        producto.setInitialPrice(precio);
        producto.setPhoto(foto);
        producto.setStartDate(finicio);
        producto.setFinishDate(ffin);
        producto.setIsSold(Boolean.FALSE);
        
        this.pf.create(producto);
        productosUsuario.add(producto);
        usuario.setProductsList(productosUsuario);
        this.uf.edit(usuario);
    }
    
    //Miguel
    public void setVendido (Integer productoId){
        Products producto = this.pf.find(productoId);
        producto.setIsSold(Boolean.TRUE);
    }
}
