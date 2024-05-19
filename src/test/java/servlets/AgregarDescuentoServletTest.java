package servlets;

import dao.DescuentoDAO;
import entity.Descuento;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(value = MockitoJUnitRunner.class)
public class AgregarDescuentoServletTest {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    RequestDispatcher requestDispatcher;

    private AgregarDescuentoServlet servlet;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        servlet = new AgregarDescuentoServlet();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void pruebaConFallas() throws Exception {
        when(request.getParameter("codigo")).thenReturn(null);
        when(request.getParameter("nombre")).thenReturn("");
        when(request.getParameter("porcentajeDescuento")).thenReturn("10");
        when(request.getParameter("stock")).thenReturn("");

        // Simular respuesta
        when(request.getRequestDispatcher("agregarDescuento.jsp")).thenReturn(requestDispatcher);

        // Ejecutar método doPost del servlet
        servlet.doPost(request, response);

        // Verificar que se envía un mensaje de error
        verify(request).setAttribute("mensaje", "Todos los campos obligatorios deben ser completados.");
        verify(requestDispatcher).forward(request, response);
    }
}