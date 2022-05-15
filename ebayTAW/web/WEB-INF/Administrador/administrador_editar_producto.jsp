<%-- 
    Document   : administrador_editar_producto
    Created on : May 12, 2022, 6:28:15 PM
    Author     : cristobal
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DTO.ProductsDTO"%>
<%@page import="java.util.List"%>
<%@page import="DTO.CategoriesDTO"%>
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
        <title>Productos</title>

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
            <h1>Editar producto</h1>

            <%
                ProductsDTO producto = (ProductsDTO) request.getAttribute("producto");
                List<CategoriesDTO> categorias = (List) request.getAttribute("categorias");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            %>

            <form method="post" action="AdministradorGuardarEditarProductoServlet">
                Titulo: <input type="text" name="title" value="<%=producto.getTitle()%>" required><br>
                Descripcion: <input type="text" name="description" value="<%=producto.getDescription()%>" required><br>
                Foto: <input type="text" name="photo" value="<%=producto.getPhoto()%>" required><br>

                Categoria: <select name="categoryId">
                    <%
                        for (CategoriesDTO categoria : categorias) {
                    %>
                    <option value="<%=categoria.getCategoryID()%>" <%=producto.getCategoryID().getCategoryID() == categoria.getCategoryID() ? "selected" : ""%>><%=categoria.getName()%></option>
                    <%
                        }
                    %>
                </select><br>

                Precio inicial: <input type="number" name="initialPrice" step="any" min="0" value="<%=producto.getInitialPrice()%>" required><br>

                Fecha de inicio: <input type="date" name="startDate" value="<%=format.format(producto.getStartDate())%>" required><br>

                Fecha de fin: <input type="date" name="finishDate" value="<%=format.format(producto.getFinishDate())%>" required><br>

                Vendido: <input type="checkbox" name="isSold" <%=producto.getIsSold() ? "checked" : ""%>><br>

                <input type="hidden" name="productId" value="<%=producto.getProductID()%>"><br>
                
                <input type="submit" value="Editar">
            </form>
        </div>
    </body>
</html>
