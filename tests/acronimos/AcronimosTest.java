package acronimos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AcronimosTest {

    private static Acronimos app = null;

    @BeforeAll
    public static void init() {
        app = new Acronimos();
    }

    @AfterAll
    public static void finish() {
        app = null;
    }

    @Test
    public void testC1() {
        String cadena = "";

        String result = app.obtenerAcronimo(cadena);
        assertEquals("", result);
    }

    @Test
    public void testC2() {
        String cadena = "a";

        String result = app.obtenerAcronimo(cadena);
        assertEquals("a.", result);
    }

    @Test
    public void testC3() {
        String cadena = " ";

        String result = app.obtenerAcronimo(cadena);
        assertEquals("", result);
    }

    @Test
    public void testC4() {
        // cadena es una tabulación (físicamente tecleamos la tecla TAB que en función
        // de la configuración del IDE se traducirá a X espacios seguidos)
        String cadena = "   ";

        String result = app.obtenerAcronimo(cadena);
        // Una tabulación se interpreta como x espacios seguidos
        assertEquals("", result);
    }

    @Test
    public void testC4bis() {
        // \t es un carácter de control que se utiliza para simbolizar la tabulación
        // (pero no se traduce a X espacios seguidos, es un carácter distinto de un
        // espacio)
        String cadena = "\t";

        String result = app.obtenerAcronimo(cadena);
        assertEquals("\t" + ".", result);
    }

    @Test
    public void testC5() {

        // Gracias a https://stackoverflow.com/a/42289203
        // No me fue posible crear un char[] de Integer.MAX_VALUE debido a
        // java.lang.OutOfMemoryError: Requested array size exceeds VM limit, pero sí de
        // Integer.MAX_VALUE-3:
        char[] array = new char[Integer.MAX_VALUE - 3];
        Arrays.fill(array, 'a');
        String cadena = new String(array);
        System.out.println(cadena.length());
        System.out.println("La longitud de la cadena es: " + cadena.length()); // La longitud de la cadena es:
                                                                               // 2147483644

        String result = app.obtenerAcronimo(cadena);
        assertEquals("a.", result);

    }

    @Test
    public void testC6() {       
        String cadena = "   a";
        String result = app.obtenerAcronimo(cadena);
        assertEquals("a.", result);
    }

    @Test
    public void testC7() {       
        String cadena = "a  ";
        String result = app.obtenerAcronimo(cadena);
        assertEquals("a.", result);
    }

    @Test
    public void testC8() {       
        String cadena = "Organización de Consumidores y Usuarios";
        String result = app.obtenerAcronimo(cadena);
        assertEquals("O.d.C.y.U.", result);
    }

    @Test
    public void testC9() {       
        String cadena = ".Asociación .Central";
        String result = app.obtenerAcronimo(cadena);
        assertEquals("....", result);
    }
}
