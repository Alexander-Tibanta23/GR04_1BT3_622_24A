package org.example.gr04_1bt3_622_24a;

import entity.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/agregarProducto")
public class AgregarProductoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recibir los datos del producto desde un formulario
        String nombre = request.getParameter("nombre");
        double precio = Double.parseDouble(request.getParameter("precio"));
        String marca = request.getParameter("marca");
        String garantia = request.getParameter("garantia");
        int stock = Integer.parseInt(request.getParameter("stock"));

        Producto producto = new Producto(nombre, precio, marca, garantia, stock);
        if (agregarProducto(producto)) {
            request.setAttribute("mensaje", "Producto agregado con éxito: " + nombre);
        } else {
            request.setAttribute("mensaje", "Error: El producto ya existe en el inventario.");
        }

        // Preguntar si quiere agregar otro producto
        request.setAttribute("agregarOtro", true);

        // Redirigir de vuelta al formulario
        request.getRequestDispatcher("/formularioAgregarProducto.jsp").forward(request, response);
    }

    private boolean agregarProducto(Producto producto) {
        String url = "jdbc:mysql://127.0.0.1/tiendaelectrodomesticos?serverTimezone=UTC";
        String user = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO Producto (nombreProducto, precioProducto, marcaProducto, garantiaProducto, cantidadProducto) VALUES (?, ?, ?, ?, ?)")) {

            statement.setString(1, producto.getNombre());
            statement.setDouble(2, producto.getPrecio());
            statement.setString(3, producto.getMarca());
            statement.setString(4, producto.getGarantia());
            statement.setInt(5, producto.getStock());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar el producto a la base de datos", e);
        }
    }
}
