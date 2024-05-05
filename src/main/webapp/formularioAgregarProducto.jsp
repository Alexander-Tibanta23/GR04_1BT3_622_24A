<%@ page import="org.example.gr04_1bt3_622_24a.AgregarProductoServlet" %>
<%@ page import="entity.Producto" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Agregar Producto</title>
</head>
<body>
<h2>Agregar Producto</h2>
<form action="agregarProducto" method="post">
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" required><br>
    <label for="precio">Precio:</label>
    <input type="number" id="precio" name="precio" step="0.01" required><br>
    <label for="marca">Marca:</label>
    <input type="text" id="marca" name="marca" required><br>
    <label for="garantia">Garantía:</label>
    <select id="garantia" name="garantia">
        <option value="1">Si</option>
        <option value="2">No</option>
    </select><br>

    <label for="stock">Stock:</label>
    <input type="number" id="stock" name="stock" required><br>
    <button type="submit">Agregar</button>
</form>

<%-- Mostrar mensaje de confirmación o error --%>
<%
    String mensaje = (String) request.getAttribute("mensaje");
    if (mensaje != null) {
        System.out.println("<p>" + mensaje + "</p>");
    }
%>

</body>
</html>
