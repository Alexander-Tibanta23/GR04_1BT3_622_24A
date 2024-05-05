package org.example.gr04_1bt3_622_24a;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entity.Descuento;
import util.HibernateUtil;

import static java.lang.Double.parseDouble;

@WebServlet("/descuento")
public class DescuentoServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            switch (action) {
                case "insert":
                    insertDescuento(session, request);
                    break;
                case "update":
                    updateDescuento(session, request);
                    break;
            }
        }
        response.sendRedirect("descuento.jsp");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.isEmpty()) {
            listDescuentos(request, response);
        } else {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                switch (action) {
                    case "delete":
                        deleteDescuento(session, request);
                        response.sendRedirect("descuentos.jsp");
                        break;
                    case "edit":
                        int id = Integer.parseInt(request.getParameter("id"));
                        Descuento descuento = session.get(Descuento.class, id);
                        request.setAttribute("descuento", descuento);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("editarDescuento.jsp");
                        dispatcher.forward(request, response);
                        break;
                }
            }
        }
    }

    private void listDescuentos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Descuento> listaDescuentos = session.createQuery("from Descuento", Descuento.class).getResultList();
            request.setAttribute("descuentos", listaDescuentos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("descuento.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void insertDescuento(Session session, HttpServletRequest request) {
        Transaction tx = session.beginTransaction();
        Descuento descuento = new Descuento();
        descuento.setCodigo(request.getParameter("codigo"));
        descuento.setNombre(request.getParameter("nombre"));
        descuento.setPorcentajeDescuento(BigDecimal.valueOf(parseDouble(request.getParameter("porcentajeDescuento"))));
        descuento.setStock(Integer.parseInt(request.getParameter("stock")));
        session.save(descuento);
        tx.commit();
    }

    public void updateDescuento(Session session, HttpServletRequest request) {
        Transaction tx = session.beginTransaction();
        int id = Integer.parseInt(request.getParameter("idDescuento"));
        Descuento descuento = session.get(Descuento.class, id);
        if (descuento != null) {
            descuento.setCodigo(request.getParameter("codigo"));
            descuento.setNombre(request.getParameter("nombre"));
            descuento.setPorcentajeDescuento(BigDecimal.valueOf(parseDouble(request.getParameter("porcentajeDescuento"))));
            descuento.setStock(Integer.parseInt(request.getParameter("stock")));
            session.update(descuento);
        }
        tx.commit();
    }

    public void deleteDescuento(Session session, HttpServletRequest request) {
        Transaction tx = session.beginTransaction();
        int id = Integer.parseInt(request.getParameter("id"));
        Descuento descuento = session.get(Descuento.class, id);
        if (descuento != null) {
            session.delete(descuento);
        }
        tx.commit();
    }
}