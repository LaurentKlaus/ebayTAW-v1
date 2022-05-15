<%-- 
    Document   : editProducto
    Created on : 01-may-2022, 18:07:20
    Author     : mjura
--%>

<%@page import="DTO.UserDTO"%>
<%@page import="DTO.UserDTO"%>
<%@page import="DTO.ProductsDTO"%>
<%@page import="DTO.ProductsDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    UserDTO vendedor = (UserDTO)session.getAttribute("usuario");
    if (vendedor == null){
        response.sendRedirect(request.getContextPath());
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=vendedor.getUsername()%> page</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/Vendedor/vendedor.jsp" />
        <!-- NUEVO PRODUCTO -->
        <%
            ProductsDTO producto = (ProductsDTO)request.getAttribute("producto");
        %>
        
        <form method="post" action="ProductoGuardarServlet">
            <table border="1">
                <tbody>
                    <tr>
                        <td><label for="">Titulo:</label></td>
                        <td><input type="text" name="titulo" value="<%= producto.getTitle() %>"></td>
                    </tr>
                    <tr>
                        <td><label for="">Descripcion:</label></td>
                        <td><input type="text" name="descripcion" value="<%= producto.getDescription() %>"></td>
                    </tr>
                    <tr>
                        <td><label for="">Precio Inicial:</label></td>
                        <td><input type="text" name="precioInicial" value="<%= producto.getInitialPrice() %>"></td>
                    </tr>
                    <tr>
                        <td><label for="">Link foto:</label></td>
                        <td><input type="text" name="linkFoto" value="<%= producto.getPhoto() %>"></td>
                    </tr>
                    <tr>
                        <td><label for="">Fecha inicio:</label></td>
                        <td><input type="text" name="fechaInicio" value="<%= producto.getStartDate() %>"></td>
                    </tr>
                    <tr>
                        <td><label for="">Fecha fin</label></td>
                        <td><input type="text" name="fechaFin" value="<%= producto.getFinishDate() %>"></td>
                    </tr>
                    <tr>
                        <td><label for="">¿Vendido?</label></td>
                        <%
                            Boolean valor = producto.getIsSold();
                            if (valor){ // True
                        %>
                        <td><input type="radio" name="vendido" value="True" checked/>Vendido</td><br>
                        <td><input type="radio" name="enVenta" value="False" />En venta</td>
                        <%
                            } else {
                        %>
                        <td><input type="radio" name="vendido" value="True"/>Vendido</td><br>
                        <td><input type="radio" name="enVenta" value="False" checked/>En venta<br></td>
                        <%
                          }
                        %>
                        
                        
                        
                        <!--<td><input type="text" name="vendido" value="<%= producto.getIsSold() %>"></td>
                        <td><input type="radio" name="vendido" value="True" />Vendido<br></td>
                        <td><input type="radio" name="enVenta" value="False" />En venta<br></td>-->
                    </tr>
                </tbody>
            </table>
                    <input type="submit" value="Editar" />
        </form>
    </body>
</html>
