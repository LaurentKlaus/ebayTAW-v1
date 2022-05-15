<%-- 
    Document   : administrador_usuarios
    Created on : Apr 28, 2022, 10:57:33 AM
    Author     : cristobal
--%>

<%@page import="DTO.CategoriesDTO"%>
<%@page import="java.util.List"%>
<%@page import="DTO.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    UserDTO admin = (UserDTO) session.getAttribute("usuario");
    if (admin == null) {
        response.sendRedirect(request.getContextPath());
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Categorias</title>

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
        <jsp:include page="/WEB-INF/Administrador/administrador_header.jsp" />

        <!-- TABLA PRODUCTOS -->
        <div class="content">
            <h1>Bienvenidx, <%=admin.getUsername()%> </h1>
            
            <form method="post" action="AdministradorSubirCategoriaServlet">
                <input type="submit" value="Nueva Categoria">
            </form>
            
            <form method="post" action="AdministradorCategoriasServlet">
                Nombre: <input type="text" name="filtroNombre" value="">
                <input type="submit" value="Filtrar">
            </form>

            <%
                List<CategoriesDTO> categorias = (List) request.getAttribute("categorias");
                if (categorias == null || categorias.isEmpty()) {
            %>

            <h2>No existen categorias</h2>

            <%
            } else {
            %>
            <table border="1">
                <tr>
                    <th>Nombre</th>
                    <th></th>                                                     
                    <th></th>                                                                     
                </tr>

                <%
                    for (CategoriesDTO categoria : categorias) {
                %>

                <tr>
                    <td><%= categoria.getName()%></td>
                    <td><a href="AdministradorBorrarCategoriaServlet?id=<%= categoria.getCategoryID()%>">Borrar</a></td>
                    <td><a href="AdministradorEditarCategoriaServlet?id=<%= categoria.getCategoryID()%>">Editar</a></td>
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
