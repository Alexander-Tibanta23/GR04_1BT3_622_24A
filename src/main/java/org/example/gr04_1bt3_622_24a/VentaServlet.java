package org.example.gr04_1bt3_622_24a;

import entity.Venta;
import entity.Cajero;
import util.HibernateUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.time.Instant;

@WebServlet(name = "VentaServlet", urlPatterns = {"/venta"})
public class VentaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cajeroId = Integer.parseInt(request.getParameter("cajeroId"));
        double totalVenta = Double.parseDouble(request.getParameter("totalVenta"));
        boolean estadoPago = Boolean.parseBoolean(request.getParameter("estadoPago"));

        Venta venta = new Venta();
        Cajero cajero = new Cajero();
        cajero.setId(cajeroId);  // Suponiendo que el cajero ya existe en la base de datos
        venta.setIdCajero(cajero);
        venta.setFecha(Instant.now());
        venta.setTotalVenta(totalVenta);
        venta.setEstadoPago(estadoPago);
        //a
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(venta);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }

        response.sendRedirect("ventaCompletada.jsp");  // Redireccionar a una página de confirmación
    }
}
