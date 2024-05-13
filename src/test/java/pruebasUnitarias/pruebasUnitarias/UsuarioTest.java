package pruebasUnitarias.pruebasUnitarias;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UsuarioTest {

    private Usuario usuario;
    private String usuarioInput;
    private String contrasenaInput;
    private boolean resultadoEsperado;

    public UsuarioTest(String usuario, String contrasena, boolean resultadoEsperado) {
        this.usuario = new Usuario("usuario1", "contrasena1");
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
    public void iniciarSesion_ValidarCredenciales() {
        System.out.println("test 1 con parametros");
        boolean resultado = usuario.iniciarSesion(usuarioInput, contrasenaInput);
        assertEquals(resultadoEsperado, resultado);
    }
}
