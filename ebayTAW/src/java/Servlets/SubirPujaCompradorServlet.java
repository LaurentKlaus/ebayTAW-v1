/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DTO.BidsDTO;
import DTO.ProductsDTO;
import DTO.UserDTO;
import Entity.Bids;
import Entity.Products;
import Entity.Users;
import Service.BidsService;
import Service.ProductService;
import Service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
@WebServlet(name = "SubirPujaCompradorServlet", urlPatterns = {"/SubirPujaCompradorServlet"})
public class SubirPujaCompradorServlet extends SampleTAWServlet {

    @EJB
    private BidsService bidsService;

    @EJB
    private UserService userService;

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
            UserDTO usuario = (UserDTO) request.getSession().getAttribute("usuario"); 
            String productoId = request.getParameter("productoId");
            String precioPuja = request.getParameter("precioPuja");

            Products producto = this.productService.findProduct(Integer.parseInt(productoId));
            Users comprador = this.userService.findUser(usuario.getUserID());

            if (producto != null && comprador != null) {
                Bids puja = this.bidsService.buscarPuja(comprador.getUserID(), producto.getProductID());
                BigDecimal precio = new BigDecimal(Double.parseDouble(precioPuja));

                if (puja == null) {
                    puja = new Bids();
                    puja.setUserID(comprador);
                    puja.setProductID(producto);
                    puja.setPriceBid(precio);

                    this.bidsService.anadirPuja(puja);
                } else {
                    puja.setPriceBid(precio);

                    this.bidsService.modificarPuja(puja);
                }
            }

            RequestDispatcher rd = request.getRequestDispatcher("ProductosPujadosCompradorServlet");
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
