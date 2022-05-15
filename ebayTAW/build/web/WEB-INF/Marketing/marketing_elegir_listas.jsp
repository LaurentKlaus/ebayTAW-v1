<%-- 
    Document   : marketing_elegir_listas
    Created on : 14-may-2022, 16:52:42
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
        <title>ElegirListaMenseja</title>
    </head>
    <body>
        
        <h1>Elija la lista de usuarios a la que enviar el mensaje</h1>
        
        
        <table border="1">
        
                <caption><h2> Listas </h2><caption>
        <% 
            String textoMensaje = request.getAttribute("textoMensaje").toString();
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
                    <td><a href="MarketingEnviarMensajeServlet?&idList=<%=l.getListID()%>&textoMensaje=<%=textoMensaje%>">Enviar</a></td> 
                </tr>
                
                <%
                    }
                %>

</table>
        
        
        
        
        
        
    </body>
    
   
</html>
