package servlets;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InicioSesionServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    private InicioSesionServlet servlet;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        servlet = new InicioSesionServlet();
        servlet.init();
    }

    @Test
    public void testDoPostCredencialesValidas() throws ServletException, IOException {
        when(request.getParameter("numeroCedula")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("admin");

        servlet.doPost(request, response);

        verify(response).sendRedirect("inicio.jsp");
        System.out.println("Prueba con credenciales válidas: EXITOSA");
    }

    @Test
    public void testDoPostCredencialesInvalidas() throws ServletException, IOException {
        when(request.getParameter("numeroCedula")).thenReturn("usuario");
        when(request.getParameter("password")).thenReturn("contrasena");

        servlet.doPost(request, response);

        verify(response).sendRedirect("index.jsp");
        System.out.println("Prueba con credenciales inválidas: EXITOSA");
    }
}