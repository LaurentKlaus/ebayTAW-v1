<%-- 
    Document   : administrador_usuarios
    Created on : Apr 28, 2022, 10:57:33 AM
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



<html lang="en">
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

        <!-- TABLA PRODUCTOS -->
        <div class="content">
            <h1>Bienvenidx, <%=admin.getUsername()%> </h1>
            
            <form method="post" action="AdministradorCrearUsuarioServlet">
                <input type="submit" value="Crear usuario">
            </form>
            
            <form method="post" action="AdministradorUsuariosServlet">
                Username: <input type="text" name="username" value=""><br>
                Email: <input type="text" name="email" value=""><br>
                Rol: <select name="rol">
                    <option value="">- - -</option>
                    <option value="Administrador">Administrador</option>
                    <option value="Vendedor">Vendedor</option>
                    <option value="Comprador">Comprador</option>
                    <option value="Analista">Analista</option>
                    <option value="Marketing">Marketing</option>
                </select><br>
                Nombre: <input type="text" name="name" value=""><br>
                Apellidos: <input type="text" name="surname" value=""><br>
                Genero: <select name="gender">
                    <option value="">- - -</option>
                    <option value="Hombre">Hombre</option>
                    <option value="Mujer">Mujer</option>
                    <option value="No binario">No binario</option>
                </select><br>
                Numero: <input type="number" name="number" value=""><br>
                Calle: <input type="text" name="street" value=""><br>
                Ciudad: <input type="text" name="city" value=""><br>
                Region: <input type="text" name="region" value=""><br>
                Codigo postal: <input type="number" name="postalCode" value=""><br>
                <input type="submit" value="Filtrar">
            </form>

            <%
                List<UserDTO> usuarios = (List) request.getAttribute("usuarios");
                if (usuarios == null || usuarios.isEmpty()) {
            %>

            <h2>No existen usuarios</h2>

            <%
            } else {
            %>
            <table border="1">
                <tr>
                    <th>Username</th>
                    <th>Email</th>                
                    <th>Rol</th>                                
                    <th>Nombre</th>     
                    <th>Apellidos</th>                     
                    <th>Genero</th>
                    <th>Numero</th>
                    <th>Calle</th>
                    <th>Ciudad</th>
                    <th>Region</th>
                    <th>Codigo Postal</th>
                    <th></th>                                                     
                    <th></th>                                                                     
                </tr>

                <%
                    for (UserDTO user : usuarios) {
                %>

                <tr>
                    <td><%= user.getUsername()%></td>
                    <td><%= user.getEmail()%></td>
                    <td><%= user.getRol()%></td>
                    <td><%= user.getName()%></td>
                    <td><%= user.getSurname()%></td>
                    <td><%= user.getGender()%></td>
                    <td><%= user.getNumber()%></td>
                    <td><%= user.getStreet()%></td>
                    <td><%= user.getCity()%></td>
                    <td><%= user.getRegion()%></td>
                    <td><%= user.getPostalCode()%></td>
                    <td><a href="AdministradorBorrarUsuarioServlet?id=<%= user.getUserID()%>">Borrar</a></td>
                    <td><a href="AdministradorEditarUsuarioServlet?id=<%= user.getUserID()%>">Editar</a></td>
                </tr>

                <%
                    }
                %>

            </table>

            <%
                }
            %>
        </div>
    </body>
</html>
