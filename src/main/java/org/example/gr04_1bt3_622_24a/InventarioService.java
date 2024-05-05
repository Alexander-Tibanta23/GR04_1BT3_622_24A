package org.example.gr04_1bt3_622_24a;

import com.google.gson.Gson;
import entity.Producto;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/obtenerProductos", "/buscarProducto"})
public class InventarioService extends HttpServlet {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Error al cargar el controlador JDBC", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filtro = request.getParameter("filtro");
        String terminoBusqueda = request.getParameter("terminoBusqueda");

        List<Producto> productos;

        if (filtro != null && terminoBusqueda != null && !filtro.isEmpty() && !terminoBusqueda.isEmpty()) {
            productos = buscarProducto(filtro, terminoBusqueda);
        } else {
            productos = obtenerProductos();
        }

        // Convertir la lista de productos a JSON
        String json = new Gson().toJson(productos);

        // Enviar la respuesta como JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }


    public List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<>();
        String url = "jdbc:mysql://127.0.0.1/tiendaelectrodomesticos?serverTimezone=UTC";
        String user = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM producto")) {

            while (resultSet.next()) {
                Producto producto = new Producto(
                        resultSet.getString("nombreProducto"),
                        resultSet.getDouble("precioProducto"),
                        resultSet.getString("marcaProducto"),
                        resultSet.getString("garantiaProducto"),
                        resultSet.getInt("cantidadProducto")
                );
                productos.add(producto);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener los productos de la base de datos", e);
        }

        return productos;
    }


    public static List<Producto> buscarProducto(String filtro, String terminoBusqueda) {
        List<Producto> productos = new ArrayList<>();
        String url = "jdbc:mysql://127.0.0.1/tiendaelectrodomesticos?serverTimezone=UTC";
        String user = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM producto WHERE " + filtro + " LIKE ?")) {

            String searchTerm = "%" + terminoBusqueda + "%";
            statement.setString(1, searchTerm);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Producto producto = new Producto(
                        resultSet.getString("nombreProducto"),
                        resultSet.getDouble("precioProducto"),
                        resultSet.getString("marcaProducto"),
                        resultSet.getString("garantiaProducto"),
                        resultSet.getInt("cantidadProducto")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar productos en la base de datos", e);
        }

        return productos;
    }
}
