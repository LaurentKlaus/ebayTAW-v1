<%-- 
    Document   : productos
    Created on : 30-abr-2022, 11:03:51
    Author     : mjura
--%>

<!-- MIGUEL JURADO VAZQUEZ -->

<%@page import="DTO.CategoriesDTO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DTO.ProductsDTO"%>
<%@page import="DTO.UserDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    UserDTO vendedor = (UserDTO)session.getAttribute("usuario");
    if (vendedor == null){
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
    
    <%
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        List<CategoriesDTO> categorias = (List)request.getAttribute("categorias");
        List<ProductsDTO> productos = (List)request.getAttribute("productos");
    %>
    <body>
        <jsp:include page="/WEB-INF/Vendedor/vendedor_header.jsp" />
        
        <!-- TABLA PRODUCTOS -->
        <div class="content">
            <h1>Bienvenidx, <%=vendedor.getUsername()%> </h1>
            
            <!-- FILTROS -->
        <h5>Filtra tus productos:</h5>
        <form method="post" action="ProductosVendedorServlet">
            <table>
                <tbody>
                    <tr>
                        <td>Titulo:</td>
                        <td><input type="text" name="titulo" value=""></td>
                    </tr>
                    <tr>
                        <td>Categoria:</td>
                        <td>
                            <select name="idCategoria">
                                <option value="">?</option>
                                <%for (CategoriesDTO categoria : categorias) {%>
                                    <option value="<%=categoria.getCategoryID()%>"><%=categoria.getName()%></option>
                                <%}%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Precio inicial:</td>
                        <td><input type="number" name="precioInicial" step="any" min="0"></td>
                    </tr>
                    <tr>
                        <td>Fecha de inicio:</td>
                        <td><input type="date" name="fechaInicio"></td>
                    </tr>
                    <tr>
                        <td>Fecha de fin:</td>
                        <td><input type="date" name="fechaFin"></td>
                    </tr>
                    <tr>
                        <td>¿Vendido?</td>
                        <td>
                            <select name="vendido">
                                <option value="">?</option>
                                <option value="True">Si</option>
                                <option value="False">No</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Filtrar"></td>
                    </tr>
                </tbody>
            </table>
        </form>

        <% 
            
            if ( productos == null || productos.isEmpty()){
        %>
        
        <h2>No existen productos</h2>
        
        <% 
            } else {
        %>
        
        <br>
        
        <h4>Sus productos:</h4>
        <table border="2">
            <tr>
                <th>Tituto</th>
                <th>Descripcion</th>
                <th>Categoria</th>                
                <th>Precio Inicial</th>                                
                <th>Link foto</th>     
                <th>Fecha inicio</th>                     
                <th>Fecha final</th>
                <th>Vendido</th>
                <th></th>                                                     
                <th></th>       
                <th></th>
            </tr>
        
        <% 
            for(ProductsDTO producto:productos){
        %>
        
        <tr>
            <td><%= producto.getTitle() %></td>
            <td><%= producto.getDescription() %></td>
            <td><%= producto.getCategoryID().getName() %></td>
            <td><%= producto.getInitialPrice() %> €</td>
            <td><%= producto.getPhoto() %></td>
            <td><%= format.format(producto.getStartDate())%></td>
            <td><%= format.format(producto.getFinishDate())%></td>
            <td><%= producto.getIsSold() %></td>
            <td><a href="ProductoBorrarServlet?id=<%= producto.getProductID() %>">Borrar</a></td>
            <td><a href="CrearEditarProducto?id=<%= producto.getProductID() %>">Editar</a></td>
            <td><% Date date = new Date();
                if (date.after(producto.getFinishDate()) && producto.getIsSold() == false){ %>
                    <a href="VendedorToAdjudicarServlet?id=<%= producto.getProductID()%>">Adjudicar</a></td>
                <%}%></td>
        </tr>
        
        <% 
            }
        %>
        
        </table>
        
        <% 
            }
        %>
        </div>
        <div class="footer">
            <p>© 2022 EbayTAW, Inc</p>
        </div>
    </body>
</html>
