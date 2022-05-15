/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DTO.UserDTO;
import Service.ListaUsuariosService;
import Service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author power
 */
@WebServlet(name = "MarketingEditarListaServlet", urlPatterns = {"/MarketingEditarListaServlet"})
public class MarketingEditarListaServlet extends HttpServlet {

    @EJB UserService userService;
    @EJB ListaUsuariosService lu;
    
        
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              
        //ListaUsuariosDTO lista = new ListaUsuarioDTO(request.getParameter("fname"));
        //request.setAttribute("lista", lista.getID());
        
                       // if (super.comprobarSession(request, response)){
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String rol = request.getParameter("rol");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String gender = request.getParameter("gender");
            String numberStr = request.getParameter("number");
            Integer number = null;
            if(numberStr != null && !numberStr.isEmpty()){
                number = Integer.parseInt(numberStr);
            }
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String region = request.getParameter("region");
            String postalCodeStr = request.getParameter("postalCode");
            Integer postalCode = null;
            if(postalCodeStr != null && !postalCodeStr.isEmpty()){
                postalCode = Integer.parseInt(postalCodeStr);
            }
            
            List<UserDTO> usuarios = this.userService.listarUsuarios(rol, username, email, name, surname, gender, street, number, city, region, postalCode);
        
            String fname = request.getParameter("fname");
            request.setAttribute("fname",fname);
        
        
            // Añadimos a la BD la nueva lista
            this.lu.crearLista(fname);
            // Tomamos el id de la lista que acabamos de crear
            int idList = this.lu.getId(fname);
            
            //Creamos al principio los usuarios de la lista vacios
            List<UserDTO> usuarioslista = new ArrayList();
            
        
        request.setAttribute("id", idList);
        request.setAttribute("usuarioslista", usuarioslista);
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/WEB-INF/Marketing/marketing_editar_lista.jsp").forward(request, response);

       // }
        
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
