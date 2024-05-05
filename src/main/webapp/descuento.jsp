<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Descuentos</title>
</head>
<body>
<h1>Descuentos</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Código</th>
        <th>Nombre</th>
        <th>Porcentaje de Descuento</th>
        <th>Stock</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${descuentos}" var="descuento">
        <tr>
            <td>${descuento.idDescuento}</td>
            <td>${descuento.codigo}</td>
            <td>${descuento.nombre}</td>
            <td>${descuento.porcentajeDescuento}%</td>
            <td>${descuento.stock}</td>
            <td>
                <a href="DescuentoServlet?action=edit&id=${descuento.idDescuento}">Editar</a>
                <a href="DescuentoServlet?action=delete&id=${descuento.idDescuento}">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h2>Agregar nuevo descuento</h2>
<form action="descuento" method="POST">
    <input type="hidden" name="action" value="insert">
    <p>Código: <input type="text" name="codigo"></p>
    <p>Nombre: <input type="text" name="nombre"></p>
    <p>Porcentaje de Descuento: <input type="text" name="porcentajeDescuento"></p>
    <p>Stock: <input type="number" name="stock"></p>
    <input type="submit" value="Añadir Descuento">
</form>
</body>
</html>