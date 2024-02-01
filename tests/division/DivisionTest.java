package division;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

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
        // Este test fallará porque hay un espacio inicial en el mensaje esperado=>
        // habría que quitar el espacio
        assertEquals(" Error. El divisor no puede ser 0.", exception.getMessage());
    }

    /**
     * Para JUnit 4
     * 
     * @throws Exception
     */
    // @Test(expected = Exception.class)
    // public void testC7() throws Exception {
    // app.calcularDivision(Float.MIN_VALUE, 0F);
    // }

    /**
     * Utiliza datos de entrada en formato CSV para los parámetros dividindo,
     * divisor y resultado esperado. Esos 3 datos van entrecomillados y separados a
     * su vez por comas.
     * Es posible probar con varios datos de entrada en un solo método de test
     * Las conversiones no son siempre automáticas, pero se pueden personalizar
     * 
     * @param dividendo primer valor de la tríada entrecomillada que será pasado
     *                  como parámetro dividendo
     * @param divisor   segundo valor de la tríada entrecomillada que será pasado
     *                  como parámetro divisor
     * @param expected  tercer valor de la tríada entrecomillada que será pasado
     *                  como parámetro expected
     * @throws Exception en caso de que se que no se cumplan las precondiciones o
     *                   las aserciones
     */

    @ParameterizedTest
    @CsvSource({ "3.40282E+38,   1.40130E-45, +Infinity", "0,  1.40130E-45, 0" })
    public void testC4_C6(Float dividendo, Float divisor, Float expected) throws Exception {
        float resultado = app.calcularDivision(dividendo, divisor);
        assertEquals(expected, resultado, MARGEN_ERROR_ESTRICTO);
    }



    /**
     * Hace lo mismo que el anterior, pero permite especificar un delimitador
     * diferente al por defecto (: en lugar de ,)
     * 
     * @param dividendo primer valor de la tríada entrecomillada que será pasado
     *                  como parámetro dividendo
     * @param divisor   segundo valor de la tríada entrecomillada que será pasado
     *                  como parámetro divisor
     * @param expected  tercer valor de la tríada entrecomillada que será pasado
     *                  como parámetro expected
     * @throws Exception en caso de que se que no se cumplan las precondiciones o
     *                   las aserciones
     */
    @ParameterizedTest
    @CsvSource(value = { "3.40282E+38:   1.40130E-45: +Infinity", "0:  1.40130E-45: 0" }, delimiter = ':')
    public void testC4_C6_delimiter(Float dividendo, Float divisor, Float expected) throws Exception {
        float resultado = app.calcularDivision(dividendo, divisor);
        assertEquals(expected, resultado, MARGEN_ERROR_ESTRICTO);
    }

    /**
     * Hace lo mismo que el anterior, pero leyendo de un fichero en formato CSV. Al ponerle cabeceras y usar   useHeadersInDisplayName = true, muestra en la ejecución el nombre del cabecera para cada argumento. Ya no habría que indicar  numLinesToSkip = 1
     * 
     * @param dividendo primer valor de la tríada entrecomillada que será pasado
     *                  como parámetro dividendo
     * @param divisor   segundo valor de la tríada entrecomillada que será pasado
     *                  como parámetro divisor
     * @param expected  tercer valor de la tríada entrecomillada que será pasado
     *                  como parámetro expected
     * @throws Exception en caso de que se que no se cumplan las precondiciones o
     *                   las aserciones
     */
    @ParameterizedTest
    @CsvFileSource(resources = "input/testC4_C6_fileCSV_input.csv",   useHeadersInDisplayName = true )
    public void testC4_C6_fileCSV(Float dividendo, Float divisor, Float expected) throws Exception {
        float resultado = app.calcularDivision(dividendo, divisor);
        assertEquals(expected, resultado, MARGEN_ERROR_ESTRICTO);
    }

    // Float.MIN_VALUE = 1.40130E-45 e Float.MAX_VALUE = 3.40282E+38.

}
