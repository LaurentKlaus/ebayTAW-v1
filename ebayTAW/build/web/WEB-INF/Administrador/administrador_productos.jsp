<%-- 
    Document   : administrador_usuarios
    Created on : Apr 28, 2022, 10:57:33 AM
    Author     : cristobal
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DTO.CategoriesDTO"%>
<%@page import="DTO.ProductsDTO"%>
<%@page import="DTO.UserDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    UserDTO admin = (UserDTO) session.getAttribute("usuario");
    if (admin == null) {
        response.sendRedirect(request.getContextPath());
    }
%>



<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Productos</title>

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

        <div class="content">
            <h1>Bienvenidx, <%=admin.getUsername()%> </h1>

            <%
                List<UserDTO> usuarios = (List) request.getAttribute("usuarios");
                List<CategoriesDTO> categorias = (List) request.getAttribute("categorias");
            %>

            <form method="post" action="AdministradorProductosServlet">
                Titulo: <input type="text" name="title" value=""><br>

                Usuario: <select name="userId">
                    <option value="">- - -</option>
                    <%
                        for (UserDTO usuario : usuarios) {
                    %>
                    <option value="<%=usuario.getUserID()%>"><%=usuario.getUsername()%></option>
                    <%
                        }
                    %>
                </select><br>
                
                Categoria: <select name="categoryId">
                    <option value="">- - -</option>
                    <%
                        for (CategoriesDTO categoria : categorias) {
                    %>
                    <option value="<%=categoria.getCategoryID()%>"><%=categoria.getName()%></option>
                    <%
                        }
                    %>
                </select><br>
                
                Precio inicial: <input type="number" name="initialPrice" step="any" min="0"><br>
                
                Fecha de inicio: <input type="date" name="startDate"><br>
                
                Fecha de fin: <input type="date" name="finishDate"><br>
                
                Vendido: <select name="isSold">
                    <option value="">- - -</option>
                    <option value="True">Si</option>
                    <option value="False">No</option>
                </select><br>

                <input type="submit" value="Filtrar">
            </form>

            <%
                List<ProductsDTO> productos = (List) request.getAttribute("productos");
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                if (productos == null || productos.isEmpty()) {
            %>

            <h2>No existen productos</h2>

            <%
            } else {
            %>
            <table border="1">
                <tr>
                    <th>Titutlo</th>
                    <th>Usuario</th>
                    <th>Categoria</th>
                    <th>Descripcion</th>                
                    <th>Precio Inicial</th>                                
                    <th>Link foto</th>     
                    <th>Fecha inicio</th>                     
                    <th>Fecha final</th>
                    <th>Vendido</th>
                    <th></th>                                                     
                    <th></th>                                                                     
                </tr>

                <%
                    for (ProductsDTO producto : productos) {
                %>

                <tr>
                    <td><%= producto.getTitle()%></td>
                    <td><%= producto.getUserID().getUsername()%></td>
                    <td><%= producto.getCategoryID().getName()%></td>
                    <td><%= producto.getDescription()%></td>
                    <td><%= producto.getInitialPrice()%></td>
                    <td><%= producto.getPhoto()%></td>
                    <td><%= format.format(producto.getStartDate())%></td>
                    <td><%= format.format(producto.getFinishDate())%></td>
                    <td><%= producto.getIsSold()%></td>
                    <td><a href="AdministradorBorrarProductoServlet?id=<%= producto.getProductID()%>">Borrar</a></td>
                    <td><a href="AdministradorEditarProductoServlet?id=<%= producto.getProductID()%>">Editar</a></td>
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
