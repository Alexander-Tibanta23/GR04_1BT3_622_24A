package org.example.gr04_1bt3_622_24a;

import entity.Cliente;
import entity.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/venta")
public class VentaServlet extends HttpServlet {
    private EntityManagerFactory emf;

    public void init() {
        emf = Persistence.createEntityManagerFactory("your-persistence-unit");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clienteId = request.getParameter("clienteId");
        String productoId = request.getParameter("productoId");

        EntityManager em = emf.createEntityManager();
        Cliente cliente = null;
        Producto producto = null;

        if (clienteId != null && !clienteId.isEmpty()) {
            cliente = em.find(Cliente.class, clienteId);
            request.setAttribute("cliente", cliente);
        }
        if (productoId != null && !productoId.isEmpty()) {
            producto = em.find(Producto.class, productoId);
            request.setAttribute("producto", producto);
        }

        em.close();

        request.getRequestDispatcher("/sales.jsp").forward(request, response);
    }

    public void destroy() {
        emf.close();
    }
}
