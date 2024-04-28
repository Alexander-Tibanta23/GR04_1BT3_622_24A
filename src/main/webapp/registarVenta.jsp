<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Venta</title>
</head>
<body>
<h1>Registrar Venta</h1>
<form action="procesarVenta" method="post">
    <label for="codigoProducto">Codigo del Producto:</label>
    <input type="text" id="codigoProducto" name="codigoProducto" required>
    <label for="cantidad">Cantidad:</label>
    <input type="number" id="cantidad" name="cantidad" required>
    <button type="submit">Agregar Producto</button>
</form>

<!-- Aquí se podría agregar una sección para mostrar los productos agregados y el total acumulado -->
<hr>
<form action="finalizarVenta" method="post">
    <button type="submit">Finalizar Venta</button>
</form>
</body>
</html>
