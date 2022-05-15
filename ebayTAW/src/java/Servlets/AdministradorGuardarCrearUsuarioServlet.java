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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cristobal
 */
@WebServlet(name = "AdministradorGuardarCrearUsuarioServlet", urlPatterns = {"/AdministradorGuardarCrearUsuarioServlet"})
public class AdministradorGuardarCrearUsuarioServlet extends SampleTAWServlet {

    @EJB
    UserService userService;

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
        if (super.comprobarSession(request, response)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String rol = request.getParameter("rol");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String gender = request.getParameter("gender");
            String numberStr = request.getParameter("number");
            Integer number = null;
            if (numberStr != null && !numberStr.isEmpty()) {
                number = Integer.parseInt(numberStr);
            }
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String region = request.getParameter("region");
            String postalCodeStr = request.getParameter("postalCode");
            Integer postalCode = null;
            if (postalCodeStr != null && !postalCodeStr.isEmpty()) {
                postalCode = Integer.parseInt(postalCodeStr);
            }

            this.userService.crearUser(rol, username, password, email, name, surname, gender, street, number, city, region, postalCode);
            response.sendRedirect(request.getContextPath() + "/AdministradorUsuariosServlet");
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
