<%-- 
    Document   : registroComprador
    Created on : 07-may-2022, 20:42:10
    Author     : 34637
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de nuevo comprador</title>
        
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
            <li style="float:right"><a class="active" href="/ebayTAW/">Inicio</a></li>
            <li style="float:right"><a class="active" href="homeRegisterServlet">Regístrese como vendedor</a></li>
            <li style="float:right"><a class="active" href="RegistrarCompradorServlet">Regístrese como comprador</a></li>
        </div>
        
        <div class="content">
            <h1>Bienvenido, nuevo comprador</h1>
        
            <form method="POST" action="AnadirUsuarioCompradorServlet">
                <table border="0">
                    <tbody>
                        <tr>
                            <td colspan="4"><b>Cuenta</b></td>
                        </tr>
                        <tr>
                            <td>Nombre de usuario *:</td>
                            <td><input type="text" name="nombreUsuario" value="" required /></td>
                        </tr>
                        <tr>
                            <td>Correo *:</td>
                            <td><input type="text" name="correo" value="" required /></td>
                        </tr>
                        <tr>
                            <td>Contraseña *:</td>
                            <td><input type="password" name="contrasena" value="" required /></td>
                        </tr>
                        <tr>
                            <td colspan="4"><br/><b>Usuario</b></td>
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
                            <td>Sexo:</td>
                            <td><select name="sexo">
                                    <option value="Hombre">Hombre</option>
                                    <option value="Mujer">Mujer</option>
                                    <option value="No Binario" selected="true">Indeterminado</option>
                                </select></td>
                        </tr>
                        <tr>
                            <td colspan="4"><br/><b>Domicilio</b></td>
                        </tr>
                        <tr>
                            <td>Calle:</td>
                            <td><input type="text" name="calle" value="" /></td>
                            <td>Número:</td>
                            <td><input type="number" name="numero" value="" /></td>
                        </tr>
                        <tr>
                            <td>Ciudad:</td>
                            <td><input type="text" name="ciudad" value="" /></td>
                            <td>Código postal:</td>
                            <td><input type="number" name="codigoPostal" value="" /></td>
                        </tr>
                        <tr>
                            <td>Región:</td>
                            <td><input type="text" name="region" value="" /></td>
                        </tr>
                        <tr>
                            <td colspan="4"><br/><input type="submit" value="Registrarse" /></td>
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
