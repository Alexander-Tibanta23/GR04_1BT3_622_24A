package org.example.gr04_1bt3_622_24a;

import entity.Producto;
import util.HibernateUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

@WebServlet(name = "AgregarProductoServlet", urlPatterns = {"/agregarProducto"})
public class AgregarProductos extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreProducto = request.getParameter("nombreProducto");
        Float precio = Float.parseFloat(request.getParameter("precio"));
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String garantia = request.getParameter("garantia");
        String categoria = request.getParameter("categoria");
        Integer stock = Integer.parseInt(request.getParameter("stock"));

        Producto producto = new Producto();
        producto.setNombreProducto(nombreProducto);
        producto.setPrecio(precio);
        producto.setMarca(marca);
        producto.setModelo(modelo);
        producto.setGarantia(garantia);
        producto.setCategoria(categoria);
        producto.setStock(stock);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(producto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }

        response.sendRedirect("gestionInventario.jsp");  // Redirigir a una página de confirmación
    }
}