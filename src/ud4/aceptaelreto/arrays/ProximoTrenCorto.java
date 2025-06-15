package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class ProximoTrenCorto {
    public static void main(String[] args) {
        Scanner entradaUsuario = new Scanner(System.in);

        System.out.println("Bienvenido al programa para calcular la mejor parada del tren.");

        while (true) {
            // Leer la longitud del tren y el tamaño del andén como enteros
            System.out.println("\nIntroduce la longitud del tren y el tamaño del andén (T, E):");
            int longitudTren = entradaUsuario.nextInt();
            int tamañoAnden = entradaUsuario.nextInt();

            // Si encontramos "0 0", terminamos la entrada
            if (longitudTren == 0 && tamañoAnden == 0) {
                System.out.println("Fin de los casos de prueba.");
                break;
            }

            // Crear arreglo para almacenar los pasajeros en cada posición del andén
            int[] pasajerosEnCadaPosicion = new int[tamañoAnden];

            // Leer el número de pasajeros en cada posición del andén
            System.out.println("Introduce el número de pasajeros en cada posición del andén:");
            for (int posicion = 0; posicion < tamañoAnden; posicion++) {
                pasajerosEnCadaPosicion[posicion] = entradaUsuario.nextInt();
            }

            // Mostrar los pasajeros en cada posición
            System.out.print("Pasajeros en cada posición del andén: ");
            for (int i = 0; i < tamañoAnden; i++) {
                System.out.print(pasajerosEnCadaPosicion[i] + " ");
            }
            System.out.println();

            // Inicializar la menor distancia con un valor grande (1,000,000,000)
            int menorDistanciaAcumulada = 1000000000;

            // Calcular la mejor posición del tren en el andén
            for (int posicionInicioTren = 0; posicionInicioTren <= tamañoAnden - longitudTren; posicionInicioTren++) {
                int distanciaTotal = 0;

                for (int ventanaTren = 0; ventanaTren < longitudTren; ventanaTren++) {
                    int pasajerosEnPosicionActual = pasajerosEnCadaPosicion[posicionInicioTren + ventanaTren];

                    // Calcular distancia acumulada con base en la posición central del tren
                    int posicionCentral = posicionInicioTren + longitudTren / 2;
                    int distanciaDesdeCentro = posicionInicioTren + ventanaTren - posicionCentral;
                    if (distanciaDesdeCentro < 0) {
                        distanciaDesdeCentro = -distanciaDesdeCentro;
                    }

                    // Multiplicar cantidad de pasajeros por distancia
                    distanciaTotal += pasajerosEnPosicionActual * distanciaDesdeCentro;
                }

                // Comparar si esta distancia es menor
                if (distanciaTotal < menorDistanciaAcumulada) {
                    menorDistanciaAcumulada = distanciaTotal;
                }

                // Mostrar información sobre la posición evaluada
                System.out.println("Posición inicial del tren: " + (posicionInicioTren + 1));
                System.out.println("Distancia total para esta posición: " + distanciaTotal);
            }

            // Imprimir el resultado para el caso de prueba
            System.out.println("\nLa menor distancia total acumulada es: " + menorDistanciaAcumulada);
        }

        // Cerrar el scanner
        entradaUsuario.close();
    }
}

/*
 * Próximo tren corto
 * Tiempo máximo: 2,000-3,000 s Memoria máxima: 16384 KiB
 * Tren de cercanías entrando en una estación. Imagen CC-BY-2.0 de Ricardo
 * Ricote Rodríguez
 * Aunque el jefe de la estación de Cercanías pone en todos los carteles
 * luminosos y anuncia por megafonía que el próximo tren en llegar a la estación
 * será corto, los pasajeros insisten en distribuirse a lo largo de todo el
 * andén. Cuando llega el tren, son comunes las carreras de aquellos que se han
 * colocado mal y no faltan los tropezones y accidentes. Una vez la maleta de un
 * pasajero voló por los aires ¡y toda su ropa terminó esparcida por las vías!
 * 
 * Salvador D. Pasa Jeros, un conductor de cercanías con buen corazón, quiere
 * parar el tren de modo que se minimice la suma total recorrida por los
 * usuarios mal colocados. Para eso cuenta con las cámaras del andén de la
 * próxima estación, con las que consigue saber cuánta gente hay en cada punto.
 * 
 * Entrada
 * Cada caso de prueba comienza con dos números, 1 ≤ T ≤ E ≤ 200.000 indicando,
 * respectivamente, la longitud del tren y del andén.
 * 
 * A continuación aparecen, en otra línea, E números (entre 1 y 1.000) indicando
 * cuántos pasajeros hay en cada posición.
 * 
 * La entrada termina con dos ceros.
 * 
 * Salida
 * Por cada caso de prueba el programa escribirá la menor longitud total
 * acumulada que tendrán que recorrer los pasajeros en el andén, asumiendo que
 * el tren para en el mejor sitio posible.
 * 
 * Si un pasajero está situado en una zona del andén en la que para el tren, se
 * asume que no deberá desplazarse hasta llegar a una puerta.
 * 
 * Entrada de ejemplo
 * 2 4
 * 1 1 1 1
 * 2 5
 * 1 1 1 1 1
 * 3 6
 * 10 5 0 0 10 10
 * 0 0
 * Salida de ejemplo
 * 
 * 2
 * 4
 * 35
 * 
 */
