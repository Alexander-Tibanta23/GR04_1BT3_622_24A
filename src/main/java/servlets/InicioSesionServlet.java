    package servlets;

    import java.io.IOException;
    import java.util.HashMap;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;

    @WebServlet("/InicioSesion")
    public class InicioSesionServlet extends HttpServlet {
        // Mapa para almacenar usuarios y contraseñas
        private HashMap<String, String> usuarios = new HashMap<>();

        // Método para inicializar usuarios
        @Override
        public void init() throws ServletException {
            // Agregar usuarios y contraseñas al mapa
            usuarios.put("admin", "admin");
            usuarios.put("admin2", "admin2");
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String numeroCedula = request.getParameter("numeroCedula");
            String contrasena = request.getParameter("password");

            // Verifica si las credenciales son válidas
            if (usuarios.containsKey(numeroCedula) && usuarios.get(numeroCedula).equals(contrasena)) {
                // Si las credenciales son válidas, redirige a la página de bienvenida
                response.sendRedirect("inicio.jsp");
            } else {
                // Si las credenciales no son válidas, redirige de vuelta al formulario de inicio de sesión
                response.sendRedirect("index.jsp");
            }
        }

        public void setUsuarios(HashMap<String, String> usuarios) {
        }
    }