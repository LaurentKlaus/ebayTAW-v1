<%-- 
    Document   : marketing_ver_listas
    Created on : 14-may-2022, 14:41:04
    Author     : power
--%>

<%@page import="DTO.ListausuarioDTO"%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VerListas</title>
        
        </head>
    <body>
        
        <jsp:include page="/WEB-INF/Marketing/marketing_header.jsp" />
        
        <h1> Listas de Usuarios </h1>
        
            <table border="1">
        
                <caption><h2> Listas </h2><caption>
        <% 
            List<ListausuarioDTO> listas = (List)request.getAttribute("listas");
        %>
                        
                <tr>                                           
                    <th>Nombre</th>                 
                    <th></th>                                                                                                                          
                </tr>
                <%
                    if (listas != null && !listas.isEmpty())
                    for (ListausuarioDTO l : listas) {
                %>
                
                <tr>
                    <td><%= l.getUsername()%></td>
                    <td><a href="MarketingEditarListaDesdeVerServlet?&idList=<%=l.getListID()%>">Editar</a></td> 
                </tr>
                
                <%
                    }
                %>

</table>
           
    </body>
</html>
