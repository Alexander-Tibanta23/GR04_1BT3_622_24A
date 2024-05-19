package servlets;

import dao.ProductoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entity.Producto;
import util.HibernateUtil;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/agregarProducto")
public class AgregarProductoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        double precio = Double.parseDouble(request.getParameter("precio"));
        String marca = request.getParameter("marca");
        String garantia = request.getParameter("garantia");
        int stock = Integer.parseInt(request.getParameter("stock"));

        // Crear un objeto Producto
        Producto producto = new Producto();
        producto.setNombreProducto(nombre);
        producto.setPrecio(BigDecimal.valueOf(precio));
        producto.setMarca(marca);
        producto.setGarantia(garantia);
        producto.setStock(stock);

        // Guardar el producto en la base de datos
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.guardarProducto(producto);
    }
}
