package org.example.gr04_1bt3_622_24a;

import entity.Producto;
import entity.Venta;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/procesarVenta")
public class ProcesarVentaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String codigoProducto = request.getParameter("codigoProducto");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));

            HttpSession session = request.getSession();
            Venta venta = (Venta) session.getAttribute("venta");
            if (venta == null) {
                venta = new Venta();
                session.setAttribute("venta", venta);
            }

            // Asumiendo que InventarioService.buscarProductoPorCodigo está bien implementado.
            Producto producto = InventarioService.buscarProductoPorCodigo(codigoProducto);
            if (producto != null && producto.getStock() >= cantidad) {
                venta.agregarProducto(producto, cantidad);
                // Actualización del stock (debe implementarse en el método agregarProducto o aquí)
                // producto.setStock(producto.getStock() - cantidad); // Considera descomentar si se maneja aquí
                request.setAttribute("message", "Producto agregado a la venta.");
            } else {
                request.setAttribute("message", "Producto no encontrado o stock insuficiente.");
            }

            request.getRequestDispatcher("/registrarVenta.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Error en el formato numérico: " + e.getMessage());
            request.getRequestDispatcher("/registrarVenta.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error al procesar la solicitud: " + e.getMessage());
            request.getRequestDispatcher("/registrarVenta.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Venta venta = (Venta) session.getAttribute("venta");
            if (venta != null) {
                double total = venta.calcularTotal();
                venta.setEstadoPago(true);  // Asumimos que el pago fue exitoso
                request.setAttribute("message", "Venta completada exitosamente.");
                session.removeAttribute("venta");  // Limpieza de sesión
            } else {
                request.setAttribute("message", "No hay una venta en proceso.");
            }
            request.getRequestDispatcher("/finalizarVenta.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error finalizando la venta: " + e.getMessage());
            request.getRequestDispatcher("/finalizarVenta.jsp").forward(request, response);
        }
    }
}