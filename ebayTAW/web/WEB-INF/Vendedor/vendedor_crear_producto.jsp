<%-- 
    Document   : createProducto
    Created on : 12-may-2022, 14:51:06
    Author     : mjura
--%>

<!-- MIGUEL JURADO VAZQUEZ -->

<%@page import="DTO.UserDTO"%>
<%@page import="DTO.CategoriesDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    UserDTO vendedor = (UserDTO)session.getAttribute("usuario");
    if (vendedor == null){
        response.sendRedirect(request.getContextPath());
    }
    List<CategoriesDTO> categorias = (List)request.getAttribute("categorias");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Producto</title>
        
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
        <jsp:include page="/WEB-INF/Vendedor/vendedor_header.jsp" />
        
        <div class="content">
            <form method="post" action="ProductoCrearVendedorServlet">
            <h5>Receurda, todos los campos son obligatorios</h5>
            <table>
                <tbody>
                    <tr>
                        <td><label for="">Titulo:</label></td>
                        <td><input required type="text" name="titulo" value=""></td>
                    </tr>
                    <tr>
                        <td><label for="">Descripcion:</label></td>
                        <td><input required type="text" name="descripcion" value=""></td>
                    </tr>
                    <tr>
                        <td><label for="">Categoria:</label></td>
                        <td><select name="categoria">
                                <% for (CategoriesDTO categoria:categorias){%>
                                <option required><%= categoria.getName() %></option>
                                <%}%>
                            </select></td>
                    </tr>
                    <tr>
                        <td><label for="">Precio Inicial:</label></td>
                        <td><input required type="number" step="any" min="0" name="precioInicial" value=""></td>
                    </tr>
                    <tr>
                        <td><label for="">Link foto:</label></td>
                        <td><input required type="text" name="linkFoto" value=""></td>
                    </tr>
                    <tr>
                        <td><label for="">Fecha inicio:</label></td>
                        <td><input required type="date" name="fechaInicio" value=""></td>
                    </tr>
                    <tr>
                        <td><label for="">Fecha fin</label></td>
                        <td><input required type="date" name="fechaFin" value=""></td>
                    </tr>
                </tbody>
            </table>
            <input type="hidden" name="id" value="<%= vendedor.getUserID() %>" />
            <input type="submit" value="Crear" />
            </form>
        </div>
        
        <div class="footer">
            <p>© 2022 EbayTAW, Inc</p>
        </div>
        
    </body>
</html>
