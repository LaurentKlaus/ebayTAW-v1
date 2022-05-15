<%-- 
    Document   : administrador_editar_usuario
    Created on : May 12, 2022, 9:01:54 PM
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
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Usuarios</title>

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
            <h1>Editar usuario</h1>

            <%
                UserDTO user = (UserDTO) request.getAttribute("user");
            %>

            <form method="post" action="AdministradorGuardarEditarUsuarioServlet">
                Username: <input type="text" name="username" value="<%=user.getUsername()%>" required><br>
                Email: <input type="text" name="email" value="<%=user.getEmail()%>" required><br>
                Rol: <select name="rol">
                    <option value="Administrador" <%=user.getRol() == "Administrador" ? "selected" : ""%>>Administrador</option>
                    <option value="Vendedor" <%=user.getRol() == "Vendedor" ? "selected" : ""%>>Vendedor</option>
                    <option value="Comprador" <%=user.getRol() == "Comprador" ? "selected" : ""%>>Comprador</option>
                    <option value="Analista" <%=user.getRol() == "Analista" ? "selected" : ""%>>Analista</option>
                    <option value="Marketing" <%=user.getRol() == "Marketing" ? "selected" : ""%>>Marketing</option>
                </select><br>
                Nombre: <input type="text" name="name" value="<%=user.getName() == null?"":user.getName()%>"><br>
                Apellidos: <input type="text" name="surname" value="<%=user.getSurname()==null?"":user.getSurname()%>"><br>
                Genero: <select name="gender">
                    <option value="" <%=user.getGender() == null ? "selected" : ""%>>- - -</option>
                    <option value="Hombre" <%=user.getGender() == "Hombre" ? "selected" : ""%>>Hombre</option>
                    <option value="Mujer" <%=user.getGender() == "Mujer" ? "selected" : ""%>>Mujer</option>
                    <option value="No binario" <%=user.getGender() == "No binario" ? "selected" : ""%>>No binario</option>
                </select><br>
                Numero: <input type="number" name="number" value="<%=user.getNumber()==null?"":user.getNumber()%>"><br>
                Calle: <input type="text" name="street" value="<%=user.getStreet()==null?"":user.getStreet()%>"><br>
                Ciudad: <input type="text" name="city" value="<%=user.getCity()==null?"":user.getCity()%>"><br>
                Region: <input type="text" name="region" value="<%=user.getRegion()==null?"":user.getRegion()%>"><br>
                Codigo postal: <input type="number" name="postalCode" value="<%=user.getPostalCode()==null?"":user.getPostalCode()%>"><br>
                <input type="hidden" name="userId" value="<%=user.getUserID()%>">
                <input type="submit" value="Editar">
            </form>
        </div>
    </body>
</html>
