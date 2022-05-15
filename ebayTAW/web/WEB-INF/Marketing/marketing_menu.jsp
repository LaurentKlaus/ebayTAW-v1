<%-- 
    Document   : marketing_menu
    Created on : 05-may-2022, 10:45:58
    Author     : power
--%>

<%@page import="DTO.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    UserDTO marketing = (UserDTO)session.getAttribute("usuario");
    if (marketing == null){
        response.sendRedirect(request.getContextPath());
    }
%>


<html>
    
    <jsp:include page="/WEB-INF/Marketing/marketing_header.jsp" />
       
      
        <h1>Bienvenido  <%= marketing.getName()%></h1>
    
    <table border="1">

        <caption><h1> Acciones </h1><caption>
                <tr>
                </tr>
                <tr>
                <form action="./MarketingCrearServlet" method="POST">
                    <td><input type="submit" value="Crear lista de usuarios" /></td>
                </form>
                <form action="./MarketingVerListasServlet" method="POST">
                    <td><input type="submit" value="Ver listas de usuarios" /></td>
                </form>
                    <form action="./MarketingMensajesRecibidosServlet" method="POST">
                    <td><input type="submit" value="Ver mensajes recibidos" /></td>
                </form>
                <form action="./MarketingRedactarMensajeServlet" method="POST">
                    <td><input type="submit" value="Crear un nuevo mensaje" /></td>
                </form>
            
                </tr>


                </table>



</html>
