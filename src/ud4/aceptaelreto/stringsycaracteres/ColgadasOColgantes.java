package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class ColgadasOColgantes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de casos de prueba sin parsear
        System.out.println("Introduce el número de casos de prueba:");
        String numCasosStr = scanner.nextLine().trim(); // Leemos la entrada como String
        int numCasos = 0; // Variable para almacenar el número de casos

        // Verificar que la entrada no esté vacía y es un número válido
        if (numCasosStr.length() > 0) {
            numCasos = numCasosStr.length();
        }

        // Iteramos sobre los casos de prueba
        for (int i = 0; i < numCasos; i++) {
            System.out.println("Introduce la palabra (colgadas o colgantes):");
            String palabra = scanner.nextLine().trim().toLowerCase();

            // Comprobamos la palabra
            if (palabra.equals("colgadas")) {
                System.out.println("Bien");
            } else if (palabra.equals("colgantes")) {
                System.out.println("Mal");
            } else {
                System.out.println("Entrada no válida");
            }
        }

        scanner.close();
    }
}

/*
 * ¿Colgadas o colgantes?
 * Una de las casas colgadas de Cuenca (CC0 Public Domain)
 * Una de las atracciones turísticas más conocidas de la ciudad de Cuenca, en
 * España, son las Casas Colgadas. Se las conoce así por tener una parte de
 * ellas en voladizo, sobre la hoz del río Jucar. La ciudad amurallada de Cuenca
 * fue nombrada Patromonio de la Humanidad en 1996 por la Unesco debido a ellas
 * y a su catedral gótica.
 * 
 * Hoy solo se conservan tres, la Casa de las Sirenas y las dos Casas de los
 * Reyes. La fecha de su construcción es motivo de controversia, por lo que se
 * fechan en un amplio periodo, entre los siglos XIII y XV. Este tipo de
 * construcciones fue habitual en la antigua ciudad. En la década de 1920 aún se
 * conservaban 8 casas de este tipo. A lo largo del tiempo han pasado por
 * multitud de restauraciones y de usos.
 * 
 * Aunque muchos turistas las llaman "Casas Colgantes", los conquenses están
 * cansados de repetirles que no son Colgantes sino Colgadas.
 * 
 * Entrada
 * La entrada comienza con un número que indica la cantidad de casos de prueba
 * que deben procesarse.
 * 
 * Cada caso de prueba es una cadena compuesta por la palabra "colgadas" o
 * "colgantes", quizá mezclando mayúsculas y minúsculas.
 * 
 * Salida
 * El programa escribirá Bien si la palabra del caso de prueba es "colgadas" y
 * Mal si la palabra es "colgantes", ignorando el uso de mayúsculas.
 * 
 * Entrada de ejemplo
 * 3
 * colgadas
 * COLGANTES
 * ColgadaS
 * Salida de ejemplo
 * Bien
 * Mal
 * Bien
 */