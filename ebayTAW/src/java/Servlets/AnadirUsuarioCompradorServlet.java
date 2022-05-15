/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 34637
 */
@WebServlet(name = "AnadirUsuarioCompradorServlet", urlPatterns = {"/AnadirUsuarioCompradorServlet"})
public class AnadirUsuarioCompradorServlet extends HttpServlet {

    @EJB
    private UserService userService;

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
        String nombreUsuario = request.getParameter("nombreUsuario");
        String contrasena = request.getParameter("contrasena");
        String correo = request.getParameter("correo");
        
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String sexo = request.getParameter("sexo");
        
        String calle = request.getParameter("calle");
        String ccNumero = request.getParameter("numero");
        Integer numero = (ccNumero == null || ccNumero.isEmpty()) ? (null) : Integer.parseInt(ccNumero);
        String ciudad = request.getParameter("ciudad");
        String ccCodigoPostal = request.getParameter("codigoPostal");
        Integer codigoPostal = (ccCodigoPostal == null || ccCodigoPostal.isEmpty()) ? (null) : Integer.parseInt(ccCodigoPostal);
        String region = request.getParameter("region");
        
        if (nombreUsuario != null && !nombreUsuario.isEmpty() &&
            contrasena != null && !contrasena.isEmpty() &&
            correo != null && !correo.isEmpty()) {
            this.userService.crearComprador(nombreUsuario, correo, contrasena, nombre, apellidos, sexo, calle, numero, ciudad, codigoPostal, region);
        }
        
        response.sendRedirect("/ebayTAW/");
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
