package busqueda;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BusquedaTest {
    private static Busqueda app = null;
    private final int MIN_ARRAY_LENGTH = 1;
    private final int MAX_ARRAY_LENGTH = 10;

    @BeforeAll
    public static void init() {
        app = new Busqueda();
    }

    @AfterAll
    public static void finish() {
        app = null;
    }

    private void validatePreconditions(char[] v) {
        assertNotNull(v, "El array no puede ser null");
        assertTrue(v.length >= MIN_ARRAY_LENGTH && v.length <= MAX_ARRAY_LENGTH,
                "La longitud del array no está comprendida entre " + MIN_ARRAY_LENGTH + " y " + MAX_ARRAY_LENGTH);

        /*
         * Para comprobar la ordenación de los elementos:
         * 1. Creamos una copia del array original v
         * 2. Ordenamos el array original con Arrays.sort que deja ordenado sorted_v
         * 3. Comprobamos que los elementos de v y sorted_v son los mismos
         * 
         */

        char[] sorted_v = v.clone();
        Arrays.sort(sorted_v);
        assertArrayEquals(sorted_v, v,
                "El array v no está ordenado: v " + Arrays.toString(v) + "sorted_v  " + Arrays.toString(sorted_v));
    }

    @Test
    public void testC1() {
        char c = 'a';
        char[] v = new char[0];

        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertFalse(resultado);
    }

    @Test
    public void testC2() {
        char c = 'a';
        char[] v = new char[1];
        v[0] = 'a';

        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertTrue(resultado);
    }

    @Test
    public void testC3() {
        char c = 'a';
        char[] v = new char[1];
        v[0] = 'b';

        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertFalse(resultado);
    }

    @Test
    public void testC4() {
        char c = 'a';
        // char[] v = new char[2];
        // v[0] = 'a';
        // v[1] = 'b';
        char[] v = { 'a', 'b' };
        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertTrue(resultado);
    }

    @Test
    public void testC5() {
        char c = 'c';
        char[] v = { 'b', 'c' };
        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertTrue(resultado);
    }

    @Test
    public void testC6() {
        char c = 'd';
        char[] v = { 'b', 'c' };
        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertFalse(resultado);
    }

    @Test
    public void testC7() {
        char c = '5';
        char[] v = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertTrue(resultado);
    }

    @Test
    public void testC8() {
        char c = 'a';
        char[] v = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertFalse(resultado);
    }

    @Test
    public void testC9() {
        char c = '5';
        char[] v = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertTrue(resultado);
    }

    @Test
    public void testC10() {
        char c = 'a';
        char[] v = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertFalse(resultado);
    }

    @Test
    public void testC11() {
        char c = '8';
        char[] v = { '9', '8', '7', '6', '5', '4', '3', '2', '1', '0' };
        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        // Error en precondiciones
        assertFalse(resultado);
        // con este caso de prueba no se encuentra, pero si hubiese otro tipo de
        // desorden, podría encontrarse
    }

    @Test
    public void testC12() {
        char c = 'a';
        char[] v = { '9', '8', '7', '6', '5', '4', '3', '2', '1', '0' };
        validatePreconditions(v);

        boolean resultado = app.busca(c, v);
        assertFalse(resultado);
        // Error en precondiciones
    }

    @Test
    public void testC13() {
        char c = 'a';
        char[] v = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A' };
        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertFalse(resultado);
        // Error en precondiciones
    }

    @Test
    public void testC14() {
        char c = 'b';
        char[] v = { 'a', 'b', 'c', 'd', 'e' };
        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertTrue(resultado);
        // Error en precondiciones
    }

    @Test
    public void testC15() {
        char c = 'd';
        char[] v = { 'a', 'b', 'c', 'd', 'e' };
        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertTrue(resultado);
        // Error en precondiciones
    }

    @Test
    public void testC16() {
        char c = '5';
        char[] v = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertTrue(resultado);
        // Error en precondiciones
    }

    @Test
    public void testC17() {
        char c = '3';
        char[] v = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertTrue(resultado);
        // Error en precondiciones
    }

    @Test
    public void testC18() {
        char c = '8';
        char[] v = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertTrue(resultado);
        // Error en precondiciones
    }

    @Test
    public void testC19() {
        char c = '4';
        char[] v = { '9', '8', '2', '3', '4', '5', '6', '7', '8', '9' };
        validatePreconditions(v);
        boolean resultado = app.busca(c, v);
        assertTrue(resultado);
        // Error en precondiciones
    }

   

 
}
