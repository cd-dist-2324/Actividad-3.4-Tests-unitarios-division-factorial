package acronimos;

public class Acronimos {
     // apartado 4
    /**
     * Recibe una cadena de caracteres y devuelve una cadena con el acrónimo correspondiente. 
     * @param cadena de entrada
     * @return El acrónimo está formado por el primer carácter de cada palabra seguido de un punto cuando el carácter es diferente del espacio en blanco.
     */
    public String obtenerAcronimo(String cadena) {

        String resultado = "";

        char caracter;

        int n = cadena.length();

        for (int i = 0; i < n; i++) {

            caracter = cadena.charAt(i);

            if (caracter != ' ') {

                if (i == 0) {

                    resultado = resultado + caracter + '.';

                }

                else {

                    if (cadena.charAt(i - 1) == ' ') {

                        resultado = resultado + caracter + '.';

                    }

                }

            }

        }

        return resultado;

    }
}
