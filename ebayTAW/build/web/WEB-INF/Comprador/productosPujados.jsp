<%-- 
    Document   : productosComprados
    Created on : 07-may-2022, 20:23:27
    Author     : 34637
--%>

<%@page import="DTO.UserDTO"%>
<%@page import="DTO.CategoriesDTO"%>
<%@page import="DTO.ProductsDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        UserDTO comprador = (UserDTO) session.getAttribute("usuario");
        List<ProductsDTO> listaProductos = (List) request.getAttribute("listaProductos");
        List<CategoriesDTO> listaCategorias = (List) request.getAttribute("listaCategorias");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos pujados</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/Comprador/comprador.jsp" />
        
        <div class="content">
            <h1>Productos pujados</h1>
            <h4>Introduzca cualquier dato relativo al producto, seleccione por categorias o por productos seguidos:</h4>
            <table border="0">
                <tbody> 
                    <form method="GET" action="ProductosPujadosCompradorServlet">
                        <tr>
                       
                            <td>Producto:</td>
                            <td><input type="text" name="filtroTituloDescripcion" value="" /></td>
                            <td><input class="botonazul" type="submit" value="Buscar" /></td>
                        </tr>
                        <tr>
                            <td>Categorias:</td>
                            <td>
                                <select name="filtroCategoria" multiple="true">
                                    <option></option>
                                <%
                                    for (CategoriesDTO categoria : listaCategorias) {
                                %>
                                    <option><%= categoria.getName() %></option>
                                <%
                                    }
                                %>    

                                </select>
                            </td>
                        </tr>
                    </form>
                </tbody>
            </table>

            <br/>
            <br/>
            
            <table class="tabla">
                <thead>
                    <tr>
                        <th>Producto</th>
                        <th>Foto</th>
                        <th>Fechas de inicio/fin</th>
                        <th>Precio de salida</th>
                        <th>Última puja</th>
                        <th>Estado</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (ProductsDTO productoDTO : listaProductos) {
                    %>
                    <tr>
                        <td>
                            <b><%= productoDTO.getTitle() %></b><br/>
                            <%= productoDTO.getDescription() %>
                        </td>
                        <td align="center"><img src="<%= productoDTO.getPhoto() %>" width="120"></td>
                        <td>
                            <%= productoDTO.getStartDateToString() %> <br/>
                        <%
                            if (productoDTO.getIsSold()) {
                        %>
                            <%= productoDTO.getFinishDateToString() %>
                        <%
                            } else {
                        %>
                            -
                        <%
                            }
                        %> 
                        </td>
                        <td align="center"><%= productoDTO.getInitialPrice() %> €</td>
                        <td align="center">
                        <%
                            if (productoDTO.lastBidPrice() != null) {
                        %>
                            <%= productoDTO.lastBidPrice().getPriceBid() %> 
                        <%
                            } else {
                        %>
                            -
                        <%
                            }
                        %> 
                             € </td>
                        <td align="center">
                        <%
                            if (productoDTO.getIsSold()) {
                                if (productoDTO.lastBidPrice().getUserID().getUserID().equals(comprador.getUserID())) {
                        %>
                            <img src="https://cdn-icons-png.flaticon.com/512/1701/1701940.png" width="40"> <br/>
                            <i>Puja ganada</i>
                        <%             
                                } else {
                        %>
                            <img src="https://cdn-icons-png.flaticon.com/512/1701/1701975.png" width="40"> <br/>
                            <i>Puja perdida</i>
                        <%            
                                }
                            } else {
                        %>
                            <img src="https://cdn-icons-png.flaticon.com/512/1701/1701971.png" width="40"> <br/>
                            <i>Subasta abierta</i>
                        <%
                            }
                        %>    
                        </td>
                        <%
                            if (productoDTO.getIsSold()) {
                                if (productoDTO.lastBidPrice().getUserID().getUserID().equals(comprador.getUserID())) {
                        %>
                        <td colspan="2">
                            <i>Producto comprado</i>
                        </td>
                        <%             
                                } else {
                        %>
                        <td colspan="2">
                            <i>Producto no adquirido</i>
                        </td>
                        <%            
                                }
                            } else {
                        %>
                        <td>
                            <form method="GET" action="SubirPujaCompradorServlet">
                                <input type="hidden" name="productoId" value="<%= productoDTO.getProductID() %>" />
                                <input type="number" name="precioPuja" value="" size="9"  step="0.01" /> <br/>
                                <input class="botonverde" type="submit" value="Subir puja" />
                            </form>
                        </td> 
                        <td>
                            <form action="RetirarPujaCompradorServlet">
                                <input type="hidden" name="productoId" value="<%= productoDTO.getProductID() %>" />
                                <br/>
                                <input class="botonrojo" type="submit" value="Retirar puja" />
                            </form>
                        </td> 
                        <%
                            }
                        %>
                        
                    </tr>
                    <%
                            }
                    %>
                </tbody>
            </table>
            
            <br/>
        </div>
        
        <div class="footer">
            <p><b>Id. de sesión:</b> <%= session.getId() %></p>
        </div>
        
    </body>
</html>
