package factorial;

public class Factorial {
    // apartado 2
    /**
     * Calcula el factorial de un número n
     * @param n
     * @return el factorial de n
     * @throws Exception Se lanza una excepción si n<0
     */
    public float factorial(byte n) throws Exception {

        if (n < 0) {

            throw new Exception("Error. El número tiene que ser >=0");

        }

        float resultado = 1;

        for (int i = 2; i <= n; i++) {

            resultado *= i;

        }

        return resultado;

    }
}
