<%-- 
    Document   : administrador_usuarios
    Created on : Apr 28, 2022, 10:57:33 AM
    Author     : cristobal
--%>

<%@page import="DTO.UserDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    UserDTO admin = (UserDTO)session.getAttribute("usuario");
    if (admin == null){
        response.sendRedirect(request.getContextPath());
    }
%>



<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <style>
            * {
            box-sizing: border-box;
            font-family: Arial, Helvetica, sans-serif;
            }

            body {
                margin: 0;
                font-family: Arial, Helvetica, sans-serif;
            }

            /* Style the content */
            .content {
                background-color: #ddd;
                padding: 10px;
            }
            
            /* Style the footer */
            .footer {
                background-color: #f1f1f1;
                padding: 10px;
            }
        </style>
        
    </head>
    <body>
        <jsp:include page="/WEB-INF/Vendedor/vendedor.jsp" />
        
        <!-- TABLA PRODUCTOS -->
        <div class="content">
            <h1>Bienvenidx, <%=admin.getUsername()%> </h1>
        <form method="post" action="AdministradorProductosServlet">
            Titulo: <input type="text" name="filtroTitulo" value="">
            <input type="submit" value="Filtrar">
        </form>
        
        <% 
            List<UserDTO> usuarios = (List)request.getAttribute("usuarios");
            if ( usuarios == null || usuarios.isEmpty()){
        %>
        
        <h2>No existen usuarios pero si estas tu mirando??</h2>
        
        <% 
            } else {
        %>
        <table border="1">
            <tr>
                <th>Username</th>
                <th>Email</th>                
                <th>Rol</th>                                
                <th>Name</th>     
                <th>Surname</th>                     
                <th>Gender</th>
                <th>Number</th>
                <th>City</th>
                <th>Region</th>
                <th>Region</th>
                <th>Postal Code</th>
                <th></th>                                                     
                <th></th>                                                                     
            </tr>
        
        <% 
            for(UserDTO user:usuarios){
        %>
        
        <tr>
            <td><%= user.getUsername()%></td>
            <td><%= user.getEmail() %></td>
            <td><%= user.getRol()%></td>
            <td><%= user.getName()%></td>
            <td><%= user.getSurname()%></td>
            <td><%= user.getGender() %></td>
            <td><%= user.getStreet()%></td>
            <td><%= user.getNumber()%></td>
            <td><%= user.getCity()%></td>
            <td><%= user.getRegion()%></td>
            <td><%= user.getPostalCode()%></td>
            <td><a href="ProductoBorrarServlet?id=<%= user.getUserID() %>">Borrar</a></td>
            <td><a href="CrearEditarProducto?id=<%= user.getUserID() %>">Editar</a></td>
        </tr>
        
        <% 
            }
        %>
        
        </table>
        
        <% 
            }
        %>
        </div>
    </body>
</html>
