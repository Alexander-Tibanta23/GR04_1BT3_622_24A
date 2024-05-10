package org.example.gr04_1bt3_622_24a;

import entity.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.io.IOException;

@WebServlet("/agregarProducto")
public class AgregarProductoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recibir los datos del producto desde un formulario
        String nombre = request.getParameter("nombre");
        double precio = Double.parseDouble(request.getParameter("precio"));
        String marca = request.getParameter("marca");
        String garantia = request.getParameter("garantia");
        int stock = Integer.parseInt(request.getParameter("stock"));

        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setMarca(marca);
        producto.setGarantia(garantia);
        producto.setStock(stock);

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
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(producto);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
