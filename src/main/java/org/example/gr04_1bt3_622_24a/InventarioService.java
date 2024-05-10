package org.example.gr04_1bt3_622_24a;

import com.google.gson.Gson;
import entity.Producto;
import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.HibernateUtil;

import java.io.IOException;
import java.util.List;

@WebServlet({"/obtenerProductos", "/buscarProducto"})
public class InventarioService extends HttpServlet {

    private static final InventarioService instance = new InventarioService();

    public static InventarioService getInstance() {
        return instance;
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
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Producto> query = session.createQuery("FROM Producto", Producto.class);
            return query.getResultList();
        }
    }

    public List<Producto> buscarProducto(String filtro, String terminoBusqueda) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Producto> query = session.createQuery("FROM Producto p WHERE p." + filtro + " LIKE :terminoBusqueda", Producto.class);
            query.setParameter("terminoBusqueda", "%" + terminoBusqueda + "%");
            return query.getResultList();
        }
    }

}
