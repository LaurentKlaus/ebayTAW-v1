/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// MIGUEL JURADO VAZQUEZ

package Servlets;

import DTO.CategoriesDTO;
import DTO.ProductsDTO;
import DTO.UserDTO;
import Entity.Users;
import Service.CategoryService;
import Service.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mjura
 */
@WebServlet(name = "ProductosVendedorServlet", urlPatterns = {"/ProductosVendedorServlet"})
public class VendedorProductosServlet extends SampleTAWServlet {

    @EJB ProductService productService;
    @EJB CategoryService cs;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (super.comprobarSession(request, response)){
            UserDTO vendedor = (UserDTO) request.getSession().getAttribute("usuario");
            List<CategoriesDTO> categorias = this.cs.findAll();
            
            // <<< FILTROS
            String titulo = request.getParameter("titulo");
            String $idCategoria = request.getParameter("idCategoria");
            Integer idCategoria = null;
            if ($idCategoria != null && !$idCategoria.isEmpty()){
                idCategoria = Integer.parseInt($idCategoria);
            }
            
            String $precioInicial = request.getParameter("precioInicial");
            BigDecimal precioInicial = null;
            if ($precioInicial != null && !$precioInicial.isEmpty()){
                precioInicial = new BigDecimal($precioInicial);
            }
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String $fechaInicio = request.getParameter("fechaInicio");
            Date fechaInicio = null;
            if ($fechaInicio != null && !$fechaInicio.isEmpty()){
                try {
                    fechaInicio = format.parse($fechaInicio);
                } catch (ParseException ex) {
                    Logger.getLogger(VendedorProductosServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            String $fechaFin = request.getParameter("fechaFin");
            Date fechaFin = null;
            if ($fechaFin != null && !$fechaFin.isEmpty()){
                try {
                    fechaFin = format.parse($fechaFin);
                } catch (ParseException ex) {
                    Logger.getLogger(VendedorProductosServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            String $vendido = request.getParameter("vendido");
            Boolean vendido = null;
            if ($vendido != null && !$vendido.isEmpty()){
                vendido = Boolean.parseBoolean($vendido);
            }
            
            List<ProductsDTO> productos = this.productService.listarProductos(titulo, vendedor, idCategoria, precioInicial, fechaInicio, fechaFin, vendido);
            // FILTROS >>>
            
            
            request.setAttribute("categorias", categorias);
            request.setAttribute("productos", productos);
            request.getRequestDispatcher("/WEB-INF/Vendedor/vendedor_listado_productos.jsp").forward(request, response);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
