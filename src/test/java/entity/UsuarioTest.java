package entity;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UsuarioTest {

    private Usuario usuario ;
    private String usuarioInput;
    private String contrasenaInput;
    private boolean resultadoEsperado;

    public UsuarioTest(String usuario, String contrasena, boolean resultadoEsperado) {
        this.usuario = new Usuario();
        this.usuarioInput = usuario;
        this.contrasenaInput = contrasena;
        this.resultadoEsperado = resultadoEsperado;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"usuario1", "contrasena1", true},
                {"usuario2", "contrasena2", false},
                {"usuario3", "contrasena3", false}
        });
    }
    @Test
    public void given_iniciarSesion_when_validarCredenciales_then_returnTrue() {
        System.out.println("test 1 con parametros");
        boolean resultado = usuario.iniciarSesion(usuarioInput, contrasenaInput);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void given_verificarCedula_when_is_ecuadorian_then_return_true() {
        System.out.println("test 2");
        Usuario usuario = new Usuario();
        usuario.setNumeroCedula("1717171717");

        boolean result = usuario.verificarCedula();

        assertTrue(result);
    }

}
