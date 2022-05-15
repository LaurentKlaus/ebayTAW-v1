/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DTO.CategoriesDTO;
import DTO.ProductsDTO;
import DTO.UserDTO;
import Entity.Categories;
import Service.CategoriesService;
import Service.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "ProductosEnVentaCompradorServlet", urlPatterns = {"/ProductosEnVentaCompradorServlet"})
public class ProductosEnVentaCompradorServlet extends SampleTAWServlet {

    @EJB
    private CategoriesService categoriesService;

    @EJB
    private ProductService productService;

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
            UserDTO vendedor = (UserDTO) request.getSession().getAttribute("usuario");
            
            String filtroTituloDescripcion = request.getParameter("filtroTituloDescripcion");
            String [] filtroCategoria = request.getParameterValues("filtroCategoria");
            
            List<ProductsDTO> listaProductos = this.productService.listarProductos(filtroTituloDescripcion, filtroCategoria);
            List<CategoriesDTO> listaCategorias = this.categoriesService.listarCategorias();
            
            request.setAttribute("listaProductos", listaProductos);
            request.setAttribute("listaCategorias", listaCategorias);
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Comprador/productosEnVenta.jsp");
            rd.forward(request, response);
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
