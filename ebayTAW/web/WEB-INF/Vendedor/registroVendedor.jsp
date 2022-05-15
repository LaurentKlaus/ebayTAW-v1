<%-- 
    Document   : registroVendedor
    Created on : 03-may-2022, 16:14:53
    Author     : mjura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Vendedor</title>
        <style>
            * {
            box-sizing: border-box;
            font-family: Arial, Helvetica, sans-serif;
            }

            body {
                margin: 0;
                font-family: Arial, Helvetica, sans-serif;
            }

            /* Style the top navigation bar */
            .topnav {
                overflow: hidden;
                background-color: #333;
            }

            /* Style the topnav links */
            .topnav a {
                float: left;
                display: block;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                
            }

            /* Change color on hover */
            .topnav a:hover {
                background-color: #ddd;
                color: black;
            }

            /* Style the content */
            .content {
                background-color: #ddd;
                padding: 10px;
                
            }
            
            /* Style the footer */
            .footer {
                text-align: center;
                background-color: #f1f1f1;
                padding: 10px;
            }
        </style>
    </head>
    <body>
        
        <div class="topnav">
            <li style="float:right"><a class="active" href="homeRegisterServlet">Home</a></li>
            <li style="float:right"><a class="active" href="homeRegisterServlet">Registrate como vendedor</a></li>
        </div>
        
        
        
        <div class="content">
            <h1>Bienvenido futuro vendedor</h1>
            <p>Los campos * son obligatorios</p>
            <form action="newUserVendedorServlet" method="POST">
                <table border="0">
                    <tbody>
                        <tr>
                            <td>*Nombre de usuario:</td>
                            <td><input type="text" name="nick" value="" /></td>
                        </tr>
                        <tr>
                            <td>*Email:</td>
                            <td><input type="email" name="email" value="" /></td>
                        </tr>
                        <tr>
                            <td>*Contraseña:</td>
                            <td><input type="password" name="pass" value="" /></td>
                        </tr>
                        <tr>
                            <td>Nombre:</td>
                            <td><input type="text" name="nombre" value="" /></td>
                        </tr>
                        <tr>
                            <td>Apellidos:</td>
                            <td><input type="text" name="apellidos" value="" /></td>
                        </tr>
                        <tr>
                            <td>Genero:</td>
                            <td>
                                <input type="radio" name="genero" value="Hombre" />Hombre<br>
                                <input type="radio" name="genero" value="Mujer" />Mujer<br>
                                <input type="radio" name="genero" value="No Binario" />No Binario
                            </td>
                        </tr>
                        <tr>
                            <td>Calle:</td>
                            <td><input type="text" name="calle" value="" /></td>
                        </tr>
                        <tr>
                            <td>Numero:</td>
                            <td><input type="number" name="numero" value="" /></td>
                        </tr>
                        <tr>
                            <td>Ciudad:</td>
                            <td><input type="text" name="ciudad" value="" /></td>
                        </tr>
                        <tr>
                            <td>Codigo Postal:</td>
                            <td><input type="number" name="cPostal" value="" /></td>
                        </tr>
                        <tr>
                            <td>Region:</td>
                            <td><input type="text" name="region" value="" /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Registrarse" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        
        
        <div class="footer">
            <p>Regístrese para formar parte de la comunidad Ebay</p>
        </div>
    </body>
</html>
