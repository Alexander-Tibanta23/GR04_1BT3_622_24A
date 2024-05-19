<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Inicio de Sesion</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
        }
        .login-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        .login-container h2 {
            margin-bottom: 20px;
            font-size: 24px;
            text-align: center;
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 95%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .login-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #0000FF;
            border: none;
            border-radius: 4px;
            color: white;
            font-size: 16px;
        }
        .login-container input[type="submit"]:hover {
            background-color: #0000FF;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Iniciar Sesion</h2>
    <form action="../java/servlets/InicioSesionServlet" method="POST"> <!-- Cambiado a InicioSesionServlet -->
        <input type="text" name="numeroCedula" id="numeroCedula" placeholder="Numero de Cedula" required> <!-- Cambiado a numeroCedula -->
        <input type="password" name="password" id="password" placeholder="Contrasenia" required> <!-- Cambiado a password -->
        <input type="submit" value="Iniciar Sesion">
    </form>
</div>
</body>
</html>
