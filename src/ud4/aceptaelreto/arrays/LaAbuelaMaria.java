package ud4.aceptaelreto.arrays;

public class LaAbuelaMaria {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Leemos el número total de casos de prueba
        System.out.print("Introduce el número de casos de prueba: ");
        int totalCasos = scanner.nextInt();

        // Iteramos por cada caso de prueba
        for (int caso = 1; caso <= totalCasos; caso++) {
            System.out.println("\nCaso de prueba #" + caso + ":");

            // Leemos las alturas de los seis dientes superiores
            System.out.print("Introduce los dientes superiores (6 números separados por espacio): ");
            int[] dientesSuperiores = new int[6];
            for (int i = 0; i < 6; i++) {
                dientesSuperiores[i] = scanner.nextInt();
            }

            // Leemos las alturas de los seis dientes inferiores
            System.out.print("Introduce los dientes inferiores (6 números separados por espacio): ");
            int[] dientesInferiores = new int[6];
            for (int i = 0; i < 6; i++) {
                dientesInferiores[i] = scanner.nextInt();
            }

            // Verificamos si los dientes superiores encajan perfectamente con los
            // inferiores
            boolean encajanPerfectamente = true;
            for (int i = 0; i < 6; i++) {
                // Si los dientes de arriba no coinciden exactamente con los de abajo, no
                // encajan
                if (dientesSuperiores[i] != dientesInferiores[i]) {
                    encajanPerfectamente = false;
                    break;
                }
            }

            // Imprimimos el resultado para este caso de prueba
            if (encajanPerfectamente) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}

/*
 * La abuela María
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Abuela (1949) de Juan Cordero Ruíz
 * Tiene 106 años y tiene el pelo blanco, de nieve. Tiene un vestido negro y, de
 * madera, negros pendientes. Quince hijos parió su duro cuerpo, y trece
 * amamantó del mismo pecho.
 * 
 * Con esta dilatada vida, no es de extrañar que su sonrisa ya no sea lo que
 * era. Aquellos dientes de blanco marfil que se adivinan en su foto de boda se
 * han ido mellando y ahora apenas quedan unos pocos en su sitio que a duras
 * penas la permiten comer algo que no sea líquido.
 * 
 * Todas las mañanas, con el paso tranquilo, se dirige hacia el espejo y junta
 * los pocos dientes que le quedan arriba con los de abajo. Se le endulzan los
 * ojos cuando recuerda su sonrisa de antaño, cómo se juntaban unos con otros
 * formando una preciosa muralla blanca. Ahora, según van mellando, a veces la
 * casualidad hace que encajen perfectamente y que pueda cerrar la sonrisa sin
 * dejar huecos, mientras que otras veces dos de ellos chocan primero y no
 * permiten que todos los de arriba entren en contacto con su pareja de abajo.
 * 
 * Entrada
 * La entrada estará formada por distintos casos de prueba, cada uno
 * representando la configuración de dientes de un día en la vida de la abuela
 * María. El número total de casos aparece en la primera línea de la entrada.
 * 
 * Los casos siguen a continuación, cada uno formado por dos líneas. La primera
 * contiene el alto de los seis dientes superiores responsables de la sonrisa
 * (incisivos y caninos) de izquierda a derecha. De forma equivalente, la
 * segunda línea contiene la información de los seis inferiores. Todos ellos son
 * números enteros entre 0 y 2.000.
 * 
 * Salida
 * Para cada caso de prueba se escribirá SI si los dientes de arriba encajan
 * perfectamente con los de abajo y no quedan huecos entre ninguno de ellos, o
 * NO en caso contrario.
 * 
 * Entrada de ejemplo
 * 2
 * 1 3 1 3 1 3
 * 3 1 3 1 3 1
 * 1 1 1 1 1 1
 * 1 2 1 1 1 1
 * Salida de ejemplo
 * 
 * SI
 * NO
 * 
 */
