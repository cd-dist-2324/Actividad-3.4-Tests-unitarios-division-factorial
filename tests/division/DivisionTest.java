package division;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DivisionTest {

    private static Division app;
    private static int MARGEN_ERROR_ESTRICTO = 0;
    private static double MARGEN_ERROR_ACEPTABLE = 1E-3;

    @BeforeAll
    public static void init() {
        app = new Division();
    }

    @AfterAll
    public static void finish() {
        app = null;
    }

    @Test
    public void testC1() throws Exception {
        float resultado = app.calcularDivision(Float.MIN_VALUE, Float.MIN_VALUE);
        assertEquals(1F, resultado);
    }

    @Test
    public void testC2() throws Exception {
        float resultado = app.calcularDivision(Float.MAX_VALUE, Float.MAX_VALUE);
        assertEquals(1F, resultado);
    }

    @Test
    public void testC3() throws Exception {
        float resultado = app.calcularDivision(Float.MIN_VALUE, Float.MAX_VALUE);
        // Devuelve un número muy próximo a cero
        assertEquals(4.1181E-84, resultado, MARGEN_ERROR_ACEPTABLE);
    }

    @Test
    public void testC4() throws Exception {
        float resultado = app.calcularDivision(Float.MAX_VALUE, Float.MIN_VALUE);
        // Devuelve Infinity porque es un nº fuera de los rangos que puede representar
        // un float
        assertEquals(Float.POSITIVE_INFINITY, resultado, MARGEN_ERROR_ESTRICTO);
    }

    @Test
    public void testC5() throws Exception {
        float resultado = app.calcularDivision(1F, 3F);
        assertEquals(3.3333E-001, resultado, MARGEN_ERROR_ACEPTABLE);
    }

    @Test
    public void testC6() throws Exception {
        float resultado = app.calcularDivision(0F, Float.MIN_VALUE);
        assertEquals(0, resultado, MARGEN_ERROR_ESTRICTO);
    }

    @Test
    public void testC7() {
        Exception exception = assertThrows(Exception.class, () -> app.calcularDivision(5f, 0));
        //Este test fallará porque hay un espacio inicial en el mensaje esperado=> habría que quitar el espacio
        assertEquals(" Error. El divisor no puede ser 0.", exception.getMessage());
    }

    /**
     * Para JUnit 4
     */
    // @Test(expected = Exception.class)
    // public void testC7() throws Exception {
    // app.calcularDivision(Float.MIN_VALUE, 0F);
    // }

}
