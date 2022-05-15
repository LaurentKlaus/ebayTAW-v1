<%-- 
    Document   : administrador_crear_usuario
    Created on : May 12, 2022, 9:47:10 PM
    Author     : cristobal
--%>

<%@page import="DTO.UserDTO"%>
<%@page import="java.util.List"%>
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
        <div class="content">
            <h1>Crear usuario</h1>

            <form method="post" action="AdministradorGuardarCrearUsuarioServlet">
                Username: <input type="text" name="username" required><br>
                Password: <input type="password" name="password" required><br>
                Email: <input type="email" name="email" required><br>
                Rol: <select name="rol">
                    <option value="Analista">Analista</option>
                    <option value="Marketing">Marketing</option>
                </select><br>
                Nombre: <input type="text" name="name"><br>
                Apellidos: <input type="text" name="surname"><br>
                Genero: <select name="gender">
                    <option value="">- - -</option>
                    <option value="Hombre">Hombre</option>
                    <option value="Mujer">Mujer</option>
                    <option value="No binario">No binario</option>
                </select><br>
                Numero: <input type="number" name="number"><br>
                Calle: <input type="text" name="street"><br>
                Ciudad: <input type="text" name="city"><br>
                Region: <input type="text" name="region"><br>
                Codigo postal: <input type="number" name="postalCode"><br>
                <input type="submit" value="Crear">
            </form>
        </div>
    </body>
</html>
