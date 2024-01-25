package division;

public class Division {
    // apartado 1 division
    /**
     * Calcula el resultado de dividir dividendo entre divisor
     * @param dividendo
     * @param divisor
     * @return resultado de la división
     * @throws Exception Se lanza una excepción cuando el divisor es cero
     */
    public float calcularDivision(float dividendo, float divisor) throws Exception {

        if (divisor == 0) {

            throw (new Exception("Error. El divisor no puede ser 0."));

        }

        float resultado = dividendo / divisor;

        return resultado;

    }
}
