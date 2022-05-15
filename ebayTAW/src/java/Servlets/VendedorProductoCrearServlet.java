/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// MIGUEL JURADO VAZQUEZ

package Servlets;

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
@WebServlet(name = "ProductoCrearVendedorServlet", urlPatterns = {"/ProductoCrearVendedorServlet"})
public class VendedorProductoCrearServlet extends SampleTAWServlet {

    @EJB ProductService ps;
    
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
        response.setContentType("text/html;charset=UTF-8");
        
        if (super.comprobarSession(request, response)){
            String id = request.getParameter("id");
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");
            String categoria = request.getParameter("categoria");
            String $precio = request.getParameter("precioInicial");
            BigDecimal precio = new BigDecimal ($precio);
            String link = request.getParameter("linkFoto");
            String fechaInicio = request.getParameter("fechaInicio");
            String fechaFin = request.getParameter("fechaFin");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fInicio = null;
            Date fFin = null;

            try {
                fInicio = format.parse(fechaInicio);
            } catch (ParseException ex) {
                Logger.getLogger(VendedorProductoCrearServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                fFin = format.parse(fechaFin);
            } catch (ParseException ex) {
                Logger.getLogger(VendedorProductoCrearServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.ps.crearProducto(id, titulo, descripcion, categoria, precio, link, fInicio, fFin);
            
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
