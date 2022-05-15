/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entity.Products;
import Facades.ProductsFacade;
import Service.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
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
public class ProductoGuardarServlet extends SampleTAWServlet {

    @EJB ProductService ps;
    private ProductsFacade pf;
    
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
            String precioInicial = request.getParameter("precioInicial");
            BigDecimal pInicial = new BigDecimal(precioInicial);
            String linkFoto = request.getParameter("linkFoto");
            //String fechaInicio = request.getParameter("fechaInicio");
            //Date fInicio = new Date(fechaInicio);
            //String fechaFin = request.getParameter("fechaFin");
            //Date fFin = new Date(fechaFin);
            String vendido = request.getParameter("vendido");
            
            //this.ps.editarProducto(Integer.parseInt(id), titulo, descripcion, pInicial, linkFoto, fInicio, fFin, Boolean.valueOf(vendido));
            this.ps.editarProductoBorrarLuego(Integer.parseInt(id), titulo, descripcion, pInicial, linkFoto, Boolean.valueOf(vendido));
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
