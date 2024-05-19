package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InicioSesionServlet")
public class InicioSesionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numeroCedula = request.getParameter("numeroCedula");
        String contrasena = request.getParameter("password"); // Cambiamos el nombre del parámetro a "password"

        System.out.println("numeroCedula" + numeroCedula);
        System.out.println("contras" + contrasena);

        // Verifica si las credenciales son válidas
        if (numeroCedula.equals("admin") && contrasena.equals("admin")) {
            // Si las credenciales son válidas, redirige a la página de bienvenida
            response.sendRedirect("inicio.jsp");
        } else {
            // Si las credenciales no son válidas, redirige de vuelta al formulario de inicio de sesión
            response.sendRedirect("index.jsp");
        }


    }
}
