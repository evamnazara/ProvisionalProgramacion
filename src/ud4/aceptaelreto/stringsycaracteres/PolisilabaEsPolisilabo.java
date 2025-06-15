package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class PolisilabaEsPolisilabo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el número de casos
        System.out.println("Introduce el número de casos a procesar:");
        int casos = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer de entrada

        // Procesar cada caso
        for (int i = 0; i < casos; i++) {
            System.out.println("Introduce la frase (X es Y):");
            String frase = sc.nextLine().trim();

            // Verificar si la frase es una tautología
            if (esTautologia(frase)) {
                System.out.println("TAUTOLOGIA");
            } else {
                System.out.println("NO TAUTOLOGIA");
            }
        }

        sc.close(); // Cerrar el scanner después de usarlo
    }

    // Función para verificar si la frase es una tautología
    public static boolean esTautologia(String frase) {
        // Dividir la frase en dos partes usando " es "
        String[] partes = frase.split(" es ");

        // Comprobar si ambas partes son iguales sin considerar mayúsculas y minúsculas
        // Convertimos ambas partes a minúsculas para una comparación insensible al caso
        String parteIzquierda = partes[0].toLowerCase();
        String parteDerecha = partes[1].toLowerCase();

        // Verificar si las dos partes son iguales
        return parteIzquierda.equals(parteDerecha);
    }
}

/*
 * Polisílaba es polisílaba
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Tautología en un reloj de agujas
 * La palabra "polisílaba" es polisílaba ya que tiene más de tres sílabas. Este
 * curioso fenómeno de una palabra describiéndose a sí misma también se da en
 * otros vocablos que describen propiedades de las palabras. Por ejemplo,
 * tenemos que "esdrújula" es esdrújula y que "llana" es llana.
 * 
 * Si vamos a palabras con más de un significado, el mismo esquema de frase
 * aparentemente tautológica podemos tenerlo por ejemplo al afirmar que la
 * naranja es naranja.
 * 
 * Sea como sea, si alguien no sabe el significado de polisílaba o de esdrújula
 * las frases anteriores serán, efectivamente, simples tautologías vacías de
 * contenido.
 * 
 * Entrada
 * La entrada comienza con una línea con un número indicando cuántos casos hay
 * que procesar.
 * 
 * Cada caso tiene una frase con el esquema "X es Y" en la que tanto X como Y
 * son palabras sin espacios con hasta 20 caracteres del alfabeto inglés.
 * 
 * Salida
 * Por cada caso de prueba se escribirá TAUTOLOGIA si la frase es una tautología
 * (sin distinguir entre mayúsculas y minúsculas) y NO TAUTOLOGIA en caso
 * contrario.
 * 
 * Entrada de ejemplo
 * 3
 * Polisilaba es polisilaba
 * NARANJA es naranja
 * Mandarina es naranja
 * Salida de ejemplo
 * TAUTOLOGIA
 * TAUTOLOGIA
 * NO TAUTOLOGIA
 */