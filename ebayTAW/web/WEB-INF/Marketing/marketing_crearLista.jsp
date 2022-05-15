<%-- 
    Document   : marketing_crearLista
    Created on : 13-may-2022, 11:28:57
    Author     : power
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<style type='text/css'>

fieldset {
  font-size:15px;
  padding:10px;
  width:220px;
}

</style>



<Title>CrearListaUsuario</Title>
</head>



<body>
    <jsp:include page="/WEB-INF/Marketing/marketing_header.jsp" />
    <h1>Crear una lista de usuarios</h1>


<form action="MarketingEditarListaServlet" method="POST">
<table>
    <tr><td>Nombre de la Lista<input type="text" name="fname" size="50"></td></tr>
    <tr><td><input type="submit" value="Crear lista"></td></tr> 
</table>
</form>
    
    
</body>
    

</html>
