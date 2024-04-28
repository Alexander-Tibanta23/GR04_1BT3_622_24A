<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestion de Inventario</title>
</head>
<body>
<h1>Gestion de Inventario</h1>
<form action="agregarProducto" method="post">
    <label for="nombreProducto">Nombre del Producto:</label>
    <input type="text" id="nombreProducto" name="nombreProducto" required>

    <label for="precio">Precio:</label>
    <input type="text" id="precio" name="precio" required>

    <label for="marca">Marca:</label>
    <input type="text" id="marca" name="marca">

    <label for="modelo">Modelo:</label>
    <input type="text" id="modelo" name="modelo">

    <label for="garantia">Garantia:</label>
    <input type="text" id="garantia" name="garantia">

    <label for="categoria">Categoria:</label>
    <input type="text" id="categoria" name="categoria">

    <label for="stock">Stock Inicial:</label>
    <input type="number" id="stock" name="stock" required>

    <button type="submit">Agregar Producto</button>
</form>
</body>
</html>
