package servlets;

import dao.ProductoDAO;
import entity.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AgregarProductoServletTest {

    private AgregarProductoServlet servlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private ProductoDAO productoDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        servlet = new AgregarProductoServlet();
        servlet.setProductoDAO(productoDAO);
    }

    @Test
    public void testAgregarProducto() throws ServletException, IOException {

        System.out.println("testAgregarProducto");
        // Configurar los parámetros del request
        when(request.getParameter("nombre")).thenReturn("Laptop");
        when(request.getParameter("precio")).thenReturn("1200.00");
        when(request.getParameter("marca")).thenReturn("HP");
        when(request.getParameter("garantia")).thenReturn("2 años");
        when(request.getParameter("stock")).thenReturn("10");

        // Ejecutar el método doPost del servlet
        servlet.doPost(request, response);

        // Verificar que el método guardarProducto fue llamado una vez
        ArgumentCaptor<Producto> productoCaptor = ArgumentCaptor.forClass(Producto.class);
        verify(productoDAO, times(1)).guardarProducto(productoCaptor.capture());

        // Verificar los valores del producto capturado

        Producto productoCapturado = productoCaptor.getValue();
        assertEquals("Laptop", productoCapturado.getNombreProducto());
        assertEquals(BigDecimal.valueOf(1200.00), productoCapturado.getPrecio());
        assertEquals("HP", productoCapturado.getMarca());
        assertEquals("2 años", productoCapturado.getGarantia());
        assertEquals(Integer.valueOf(10), productoCapturado.getStock());
        System.out.println("El producto ha sido capturado");
    }
}
