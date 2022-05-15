<%-- 
    Document   : administrador_nueva_categoria
    Created on : May 12, 2022, 2:47:01 PM
    Author     : cristobal
--%>

<%@page import="DTO.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    UserDTO admin = (UserDTO) session.getAttribute("usuario");
    if (admin == null) {
        response.sendRedirect(request.getContextPath());
    }
%>

<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Categorias</title>

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
            
            <form method="post" action="AdministradorGuardarEditarCategoriaServlet">
                Nombre: <input type="text" name="nombre" value="<%=request.getAttribute("categoriaNombre")%>" required>
                <input type="hidden" name="categoriaId" value="<%=request.getAttribute("categoriaId")%>">
                <input type="submit" value="Editar">
            </form>
        </div>
    </body>
</html>
