package Execute;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import servlets.InicioSesionServlet;

public class InicioSesionExecute {
    public static void main(String[] args) throws Exception {
        // Crea una instancia del servidor Jetty
        Server server = new Server(8080);

        // Configura el manejador de servlets
        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(InicioSesionServlet.class, "/InicioSesion");
        server.setHandler(handler);

        // Inicia el servidor
        server.start();
        System.out.println("Servidor iniciado en http://localhost:8080/");

        // Mantiene el servidor en ejecución
        server.join();
    }
}