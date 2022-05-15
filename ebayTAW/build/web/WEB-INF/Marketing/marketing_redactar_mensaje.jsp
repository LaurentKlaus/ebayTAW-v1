<%-- 
    Document   : marketing_redactar_mensaje
    Created on : 14-may-2022, 16:29:08
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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RedactarMensaje</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/Marketing/marketing_header.jsp" />
        
        <h1>Escriba el mensaje</h1>
        
        <form action="MarketingElegirListaMensajeServlet" method="POST">
            <table>
                 <tr><td><textarea name="mensaje" rows="15" cols="100"></textarea></td></tr>
                <tr><td><input type="submit" value="Crear Mensaje"></td></tr> 
            </table>
        </form>
    </body>
</html>
