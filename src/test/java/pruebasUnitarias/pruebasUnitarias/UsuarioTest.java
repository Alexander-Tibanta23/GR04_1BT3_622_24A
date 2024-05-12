package pruebasUnitarias.pruebasUnitarias;

import org.junit.*;

import static org.junit.Assert.*;

public class UsuarioTest {

    private Usuario usuario;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Antes de todas las pruebas");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Después de todas las pruebas");
    }

    @After
    public void tearDown() {
        System.out.println("Después de cada prueba");
    }

    @Before
    public void setUp() {
        usuario = new Usuario();
        System.out.println("Antes de cada prueba");
    }


    @Test
    public void verificarCedula_when_is_ecuadorias(){
        Usuario usuario = new Usuario();
        assertEquals(true, usuario.verificarCedula());
        System.out.println("test 2");
    }

}