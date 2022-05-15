/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// MIGUEL JURADO VAZQUEZ

package Servlets;

import DTO.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mjura
 */

public abstract class SampleTAWServlet extends HttpServlet {
    @Override
    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    
    @Override
    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected boolean comprobarSession (HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO usuario = (UserDTO)session.getAttribute("usuario");
        if (usuario == null){
            response.sendRedirect(request.getContextPath());
            return false;
        } else{
            return true;
        }
    }
    
}
