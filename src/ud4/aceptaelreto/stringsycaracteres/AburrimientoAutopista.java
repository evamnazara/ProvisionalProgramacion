package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class AburrimientoAutopista {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leemos el número de casos de prueba
        System.out.println("Introduce el número de casos:");
        int numeroDeCasos = scanner.nextInt();
        scanner.nextLine(); // Limpiamos el buffer

        // Procesamos cada caso de prueba
        for (int i = 0; i < numeroDeCasos; i++) {
            System.out.println("Introduce las matrículas para el caso " + (i + 1) + ":");
            String caso = scanner.nextLine();
            String[] matriculas = caso.split(" "); // Corregido el nombre de la variable

            // Procesamos la matrícula de Edu (la primera)
            String matriculaEdu = matriculas[0]; // Corregido el nombre de la variable

            // Inicializamos los contadores
            int cochesAntiguos = 0;
            int cochesModernos = 0;

            // Comparamos las matrículas
            for (int j = 1; j < matriculas.length; j++) { // Corregido el nombre de la variable
                if (matriculas[j].equals("0")) { // Corregido el nombre de la variable
                    break; // Fin del caso, cuando encontramos un "0"
                }

                // Comparamos la matrícula de Edu con la de los demás coches
                if (esMasAntigua(matriculaEdu, matriculas[j])) { // Corregido el nombre de la variable
                    cochesAntiguos++;
                } else if (esMasModerna(matriculaEdu, matriculas[j])) { // Corregido el nombre de la variable
                    cochesModernos++;
                }
            }

            // Imprimimos los resultados para este caso
            System.out.println(cochesAntiguos + " " + cochesModernos);
        }

        scanner.close(); // Cerramos el scanner
    }

    // Función para comparar si una matrícula es más antigua que la de Edu
    public static boolean esMasAntigua(String matriculaEdu, String matricula) {
        // Separamos el número y las letras
        String numeroEdu = matriculaEdu.substring(0, 4);
        String letrasEdu = matriculaEdu.substring(4);
        String numero = matricula.substring(0, 4);
        String letras = matricula.substring(4);

        // Comparamos las letras
        if (letras.compareTo(letrasEdu) < 0) {
            return true;
        } else if (letras.compareTo(letrasEdu) == 0) {
            // Si las letras son iguales, comparamos los números
            return numero.compareTo(numeroEdu) < 0;
        }

        return false; // Si las letras no son menores, no es más antigua
    }

    // Función para comparar si una matrícula es más moderna que la de Edu
    public static boolean esMasModerna(String matriculaEdu, String matricula) {
        // Separamos el número y las letras
        String numeroEdu = matriculaEdu.substring(0, 4);
        String letrasEdu = matriculaEdu.substring(4);
        String numero = matricula.substring(0, 4);
        String letras = matricula.substring(4);

        // Comparamos las letras
        if (letras.compareTo(letrasEdu) > 0) {
            return true;
        } else if (letras.compareTo(letrasEdu) == 0) {
            // Si las letras son iguales, comparamos los números
            return numero.compareTo(numeroEdu) > 0;
        }

        return false; // Si las letras no son mayores, no es más moderna
    }
}

/*
 * Aburrimiento en la autopista
 * 
 * 
 * De los 700 kilómetros que separan su casa de su lugar de vacaciones, la
 * inmensa mayoría son de autopista. Edu Ermo no tiene claro si eso es una
 * bendición o una maldición. Es verdad que las autopistas son cómodas y
 * seguras, pero también son terriblemente aburridas, y Edu tiene que luchar
 * duro contra el sopor. Por más que lo intenta, no consigue que su mujer, Sue
 * Ñosmil, le sustituya al volante. A ella le ocurre exactamente lo mismo y se
 * pasa los 700 kilómetros durmiendo en el sitio del copiloto. Solo la voz del
 * GPS le hace, muy de vez en cuando, algo de compañía.
 * 
 * Para las próximas vacaciones ha ideado una estrategia. Se va a entretener
 * mirando las matrículas de todos los coches con los que se cruce y
 * comparándolas con la del suyo propio para contar cuántos coches son más
 * antiguos y cuántos más nuevos. Quiere matar dos pájaros de un tiro:
 * entretenerse para no dormirse, y tener una prueba de que su coche se está
 * quedando viejo y poder así convencer a Sue de que hay que comprar otro.
 * 
 * Entrada
 * La entrada comienza con una línea que contiene el número de casos de prueba
 * que vendrán a continuación.
 * 
 * Cada caso de prueba consta de una línea con una serie de matrículas. La
 * primera de ellas se corresponde con la matrícula del coche de Edu y el resto
 * con la de los coches que se cruza (se garantiza que Edu no se cruzará consigo
 * mismo). La línea termina con un 0.
 * 
 * El formato de todas las matrículas es igual: comienza con un número con
 * cuatro dígitos (desde el 0000 hasta el 9999) al que siguen 3 letras en
 * mayúsculas que nunca serán vocales, Q ni Ñ.
 * 
 * Salida
 * Para cada caso de prueba se escribirá una línea con dos números separados por
 * un espacio indicando, respectivamente, cuántos coches se han visto más
 * antiguos que el de Edu, y cuántos más modernos. Edu no tiene buena memoria,
 * por lo que si la misma matrícula aparece varias veces en la entrada deberá
 * contarse tantas veces como lo haga.
 * 
 * Recuerda que un coche es más antiguo que otro si las tres letras de su
 * matrícula son menores lexicográficamente o si, en caso de empate, el número
 * es menor.
 * 
 * Entrada de ejemplo
 * 2
 * 5555CPP 5558CPB 5554CPX 0
 * 2019PRG 3030PRG 3030PRG 0
 * Salida de ejemplo
 * 1 1
 * 0 2
 */