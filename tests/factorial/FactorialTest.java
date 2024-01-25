package factorial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class FactorialTest {
   private static Factorial app = null;

    @BeforeAll
    public static void init() {
        app = new Factorial();
    }

    @AfterAll
    public static void finish() {
        app = null;
    }

    @Test
    void testC1() throws Exception {

        byte entrada = 0;
        assertEquals(1F, app.factorial(entrada));

    }

    @Test
    void testC2() throws Exception {

        byte entrada = 1;
        assertEquals(1F, app.factorial(entrada));

    }

    
    @Test
    void testC3() throws Exception {

        byte entrada = 2;
        assertEquals(2F, app.factorial(entrada));

    }

    @Test
    void testC4() throws Exception {

        byte entrada = 3;
        assertEquals(6F, app.factorial(entrada));

    }

    @Test
    void testC5() throws Exception {

        byte entrada = 4;
        assertEquals(24F, app.factorial(entrada));

    }

    @Test
    void testC6() throws Exception {

        byte entrada = Byte.MAX_VALUE;
        assertEquals(Float.POSITIVE_INFINITY, app.factorial(entrada));

    }

     @Test
    public void testC7() {
        byte entrada = -1;
        Exception exception = assertThrows(Exception.class, () -> app.factorial(entrada));
        assertEquals("Error. El número tiene que ser >=0", exception.getMessage());

    }
}
