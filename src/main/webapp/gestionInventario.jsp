<%@ page import="java.util.List" %>
<%@ page import="org.example.gr04_1bt3_622_24a.InventarioService" %>
<%@ page import="entity.Producto" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestion de Inventario</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>Gestion de Inventario</h1>

<h2>Buscar Producto</h2>
<form id="searchForm">
    <label for="filtro">Filtrar por:</label>
    <select id="filtro" name="filtro">
        <option value="nombreProducto">Nombre</option>
        <option value="precioProducto">Precio</option>
        <option value="marcaProducto">Marca</option>
        <option value="garantiaProducto">Garantía</option>
        <option value="cantidadProducto">Cantidad</option>
    </select>
    <label for="terminoBusqueda">Termino de busqueda:</label>
    <input type="text" id="terminoBusqueda" name="terminoBusqueda">
    <button type="submit">Buscar</button>
</form>

<h2>Inventario Actual</h2>
<form action = "obtenerProductos" method="get">
<table id="tablaProductos">
    <tr>
        <th>Nombre</th>
        <th>Precio</th>
        <th>Marca</th>
        <th>Garantia</th>
        <th>Stock</th>
    </tr>
    <%
        InventarioService inventarioService = InventarioService.getInstance();
        List<Producto> productos = inventarioService.obtenerProductos();

        for (Producto producto : productos) {
    %>
    <tr>
        <td><%= producto.getNombre() %></td>
        <td><%= producto.getPrecio() %></td>
        <td><%= producto.getMarca() %></td>
        <td><%= producto.getGarantia() %></td>
        <td><%= producto.getStock() %></td>
    </tr>
    <% } %>
</table>
</form>

<button onclick="mostrarFormulario()">Agregar Producto</button>

<script>
    function mostrarFormulario() {
        window.open('formularioAgregarProducto.jsp', 'Agregar Producto', 'width=400,height=400');
    }
    document.getElementById('searchForm').addEventListener('submit', function(event) {
        event.preventDefault(); // Evita que se recargue la página al enviar el formulario
        var filtro = document.getElementById('filtro').value;
        var terminoBusqueda = document.getElementById('terminoBusqueda').value;
        var url = 'buscarProducto?filtro=' + filtro + '&terminoBusqueda=' + terminoBusqueda;
        fetch(url)
            .then(response => response.json())
            .then(data => {
                // Limpiar la tabla actual
                var table = document.getElementById('tablaProductos');
                table.innerHTML = '';
                // Agregar los encabezados de columna con estilo en negrita
                var headerRow = table.insertRow();
                var headers = ['Nombre', 'Precio', 'Marca', 'GarantIa', 'Stock'];
                headers.forEach(headerText => {
                    var headerCell = document.createElement('th');
                    headerCell.textContent = headerText;
                    headerCell.style.fontWeight = 'bold'; // Aplica negrita
                    headerRow.appendChild(headerCell);
                });
                // Agregar los nuevos productos a la tabla
                data.forEach(producto => {
                    var row = table.insertRow();
                    row.insertCell(0).textContent = producto.nombre;
                    row.insertCell(1).textContent = producto.precio;
                    row.insertCell(2).textContent = producto.marca;
                    row.insertCell(3).textContent = producto.garantia;
                    row.insertCell(4).textContent = producto.stock;
                });
            });
    });
</script>

</body>
</html>
