<%--
  Created by IntelliJ IDEA.
  User: USUARIO
  Date: 5/5/2024
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="entity.Cliente, entity.Producto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ventas</title>
</head>
<body>
<h2>Formulario de Venta</h2>
<form action="venta" method="get">
    Cliente ID: <input type="text" name="clienteId" /><br/>
    Producto ID: <input type="text" name="productoId" /><br/>
    <input type="submit" value="Buscar" />
</form>
<hr/>

<%
    Cliente cliente = (Cliente) request.getAttribute("cliente");
    Producto producto = (Producto) request.getAttribute("producto");
    if (cliente != null) {
%>
<h3>Cliente</h3>
Nombre: <%= cliente.getUsuarios().getNombre() %><br/>
Apellido: <%= cliente.getUsuarios().getApellido() %><br/>
Dirección: <%= cliente.getUsuarios().getDireccion() %><br/>
Correo: <%= cliente.getUsuarios().getCorreo() %><br/>
<% } %>
<%
    if (producto != null) {
%>
<h3>Producto</h3>
Nombre: <%= producto.getNombre() %><br/>
Marca: <%= producto.getMarca() %><br/>
Precio: <%= producto.getPrecio().toString() %><br/>
Garantía: <%= producto.getGarantia() %><br/>
Stock: <%= producto.getStock() %><br/>
<% } %>
</body>
</html>
