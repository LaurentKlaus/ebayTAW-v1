/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// MIGUEL JURADO VAZQUEZ

package Servlets;

import DTO.CategoriesDTO;
import Entity.Categories;
import Entity.Products;
import Facades.ProductsFacade;
import Service.CategoryService;
import Service.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "ProductoGuardarServlet", urlPatterns = {"/ProductoGuardarServlet"})
public class VendedorProductoGuardarServlet extends SampleTAWServlet {

    @EJB ProductService ps;
    @EJB CategoryService cs;
    //private ProductsFacade pf;
    
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
            String id = request.getParameter("id");
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");
            String $categoria = request.getParameter("categoria");
            String precioInicial = request.getParameter("precioInicial");
            BigDecimal pInicial = new BigDecimal(precioInicial);
            String linkFoto = request.getParameter("linkFoto");
            String fechaInicio = request.getParameter("fechaInicio");
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date fInicio = null;
            
            try {
                fInicio = format.parse(fechaInicio);
            } catch (ParseException ex) {
                Logger.getLogger(VendedorProductoGuardarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String fechaFin = request.getParameter("fechaFin");
            Date fFin = null;
            try {
                fFin = format.parse(fechaFin);
            } catch (ParseException ex) {
                Logger.getLogger(VendedorProductoGuardarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            String $vendido = request.getParameter("vendido");
            Boolean vendido = $vendido != null && !$vendido.isEmpty();
            
            this.ps.editarProducto(Integer.parseInt(id), titulo, descripcion, linkFoto, Integer.parseInt($categoria), pInicial, fInicio, fFin, vendido);
            
            response.sendRedirect(request.getContextPath()+"/ProductosVendedorServlet");
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
