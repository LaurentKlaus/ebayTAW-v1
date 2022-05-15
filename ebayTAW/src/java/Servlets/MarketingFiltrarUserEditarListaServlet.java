/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DTO.UserDTO;
import Entity.Listausuarios;
import Entity.Users;
import Service.ListaUsuariosService;
import Service.UserService;
import Service.UsuarioListaService;
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
@WebServlet(name = "MarketingFiltrarUserEditarListaServlet", urlPatterns = {"/MarketingFiltrarUserEditarListaServlet"})
public class MarketingFiltrarUserEditarListaServlet extends HttpServlet {

    @EJB UserService userService;
    @EJB ListaUsuariosService lu;
    @EJB UsuarioListaService uls;
    
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
  
        //Filtro del nombre
        String nombreUsuario = request.getParameter("NombreUsuario");
        //Filtro del ordenarPor
        String orderBy = request.getParameter("OrderBy");
        
        //Tomar id de la lista de usuarios
        Integer idList = Integer.parseInt(request.getParameter("idList"));
        //Traemos la lista
        Listausuarios lista = lu.getLista(idList);
        
        // Todos los usuarios filtrados según NOMBREUSUARIO y ORDERBY
        List<UserDTO> usuarios = this.userService.listarUsuariosFiltrado(nombreUsuario,orderBy);

        //Traemos los usuarios de la Usuariolista
        List<UserDTO> usuarioslista = this.userService.usuariosDTODeUnaLista(idList);
        
        //Quitamos los que estan en la lista
        List<UserDTO> usuariosRestante = new ArrayList();
        usuariosRestante.addAll(usuarios);
        
        for(UserDTO ul : usuarioslista )
            for(UserDTO u : usuarios )
                if(ul.getUserID() == u.getUserID())
                    usuariosRestante.remove(u);
                
        
        //Pasamos los parámetros al JSP
        request.setAttribute("usuarioslista", usuarioslista);
        request.setAttribute("usuarios", usuariosRestante);
        request.setAttribute("fname", lista.getUsername());
        request.setAttribute("id", idList);
        
        //Debug
        request.setAttribute("nombre", nombreUsuario);
        request.setAttribute("order", orderBy);
            
        //Lanzamos el JSP
        request.getRequestDispatcher("WEB-INF/Marketing/marketing_editar_lista.jsp").forward(request, response);
   
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
