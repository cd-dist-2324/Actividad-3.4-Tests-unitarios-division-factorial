package busqueda;

public class Busqueda {
     // apartado 3
    /**
     * Recibe un carácter c y una matriz de caracteres v de como máximo 10 elementos ordenados en orden ascendente.
     * La búsqueda es dicotómica, es decir, la  búsqueda se realiza calculando el índice mitad del segmento (en principio todo el array) y comparando c con el elemento almacenado en ese índice; si coincide, la búsqueda finaliza y se encuentra el carácter en la matriz; si c es menor, el siguiente segmento será la primera mitad del actual; si c es mayor, el siguiente segmento será la segunda mitad del actual. Si este proceso termina con un segmento nulo y no se encuentra el carácter, no existe y se devolverá false
     * @param c carácter c
     * @param v  matriz de caracteres v de como máximo 10 elementos ordenados en orden ascendente
     * @return   Devuelve el valor booleano verdadero o falso dependiendo de si el carácter se encuentra en la matriz o no.
     */
    public boolean busca(char c, char[] v) {

        int a, z, m;

        a = 0;

        z = v.length - 1;

        boolean resultado = false;

        while (a <= z && resultado == false) {

            m = (a + z) / 2;

            if (v[m] == c) {

                resultado = true;

            }

            else

            {

                if (v[m] < c) {

                    a = m + 1;

                }

                else {

                    z = m - 1;

                }

            }

        }

        return resultado;

    }

}
