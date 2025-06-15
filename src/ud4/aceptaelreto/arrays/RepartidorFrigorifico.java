package ud4.aceptaelreto.arrays;

public class RepartidorFrigorifico {

    public static void main(String[] args) {
        // Crear un scanner para leer la entrada
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Bienvenido al programa de Repartidor de Frigoríficos!");
        System.out.println("Este programa encuentra la ubicación óptima para el local del repartidor.");

        while (true) {
            // Leer el número de calles verticales (C), horizontales (F) y el número de
            // frigoríficos (N)
            System.out.println("\nIntroduzca las dimensiones de la ciudad (C, F) y el número de frigoríficos (N):");
            int C = scanner.nextInt();
            int F = scanner.nextInt();
            int N = scanner.nextInt();

            // Si encontramos "0 0 0", terminamos la entrada
            if (C == 0 && F == 0 && N == 0) {
                System.out.println("Fin de la entrada de datos. ¡Gracias por usar el programa!");
                break;
            }

            // Mostrar las dimensiones que el usuario introdujo
            System.out.println("\nLa ciudad tiene " + C + " calles verticales y " + F + " calles horizontales.");
            System.out.println("Hay " + N + " frigoríficos a repartir.");

            // Crear dos arreglos para almacenar las coordenadas de los sitios de reparto
            int[] xCoordinates = new int[N];
            int[] yCoordinates = new int[N];

            // Leer las coordenadas de los sitios de reparto
            System.out.println("Introduzca las coordenadas (x, y) de los sitios de reparto:");
            for (int i = 0; i < N; i++) {
                xCoordinates[i] = scanner.nextInt();
                yCoordinates[i] = scanner.nextInt();
                System.out.println("Reparto " + (i + 1) + ": (" + xCoordinates[i] + ", " + yCoordinates[i] + ")");
            }

            // Ordenamos las coordenadas x y y por separado
            System.out.println("\nOrdenando las coordenadas...");
            java.util.Arrays.sort(xCoordinates);
            java.util.Arrays.sort(yCoordinates);
            System.out.println("Coordenadas x ordenadas: " + java.util.Arrays.toString(xCoordinates));
            System.out.println("Coordenadas y ordenadas: " + java.util.Arrays.toString(yCoordinates));

            // El punto óptimo se encuentra en el valor mediano de x y el mediano de y
            int optimalX = xCoordinates[(N - 1) / 2];
            int optimalY = yCoordinates[(N - 1) / 2];

            // Imprimir la posición óptima del local
            System.out.println("\nLa ubicación óptima para el local del repartidor es:");
            System.out.println("Coordenada óptima: (" + optimalX + ", " + optimalY + ")");
        }

        // Cerrar el scanner
        scanner.close();
    }
}

/*
 * Repartidor de frigoríficos
 * Tiempo máximo: 1,000-4,000 s Memoria máxima: 16384 KiB
 * Ejemplo de repartos
 * Un repartidor de frigoríficos debe decidir en qué cruce de calles situar su
 * local, de modo que la distancia total de todos los trasportes sea mínima. El
 * repartidor trabaja en la ciudad de Novapolis donde todas las calles son en
 * cuadrícula. Las distancias más cortas entre dos puntos se deben por tanto
 * calcular siguiendo las calles y no como la distancia euclídea. La dificultad
 * añadida es que en la furgoneta del repartidor solo cabe un frigorífico por lo
 * que después de cada reparto debe volver al local a cargar el siguiente.
 * 
 * Por poner un ejemplo, en una cuadrícula de 3×3 en el que los lugares de
 * reparto están en las posiciones (1, 1), (1, 3) y (3, 1), la mejor
 * localización para el local del repartidor será el punto (1, 1).
 * 
 * Entrada
 * La entrada está formada por distintos casos de prueba. Cada caso de prueba
 * consiste en varias líneas donde la primera línea son tres números enteros: C,
 * el número de calles en dirección vertical, F, el número de calles en
 * dirección horizontal y N, el número de frigoríficos a repartir. A
 * continuación aparecen N líneas con dos números enteros cada una que indican
 * la posición (x, y) de cada sitio de reparto. Se satisface que 1 ≤ x ≤ C, 1 ≤
 * y ≤ F, 1 ≤ F, C ≤ 10.000 y 1 ≤ N ≤ 50.000. Además, no hay posiciones
 * repetidas.
 * 
 * El final de la entrada se indica con una línea con tres ceros que no se debe
 * procesar.
 * 
 * Salida
 * Para cada caso de prueba, se escribirán en una línea las coordenadas (x, y)
 * de la posición óptima del local del repartidor. En caso de existir varias
 * posiciones óptimas, se escribirán las coordenadas de aquella tal que la suma
 * x+y sea mínima. Si aún así hubiera varias opciones, se debe considerar la
 * posición con menor x.
 * 
 * Entrada de ejemplo
 * 3 3 3
 * 1 1
 * 1 3
 * 3 1
 * 3 3 3
 * 1 2
 * 2 3
 * 3 1
 * 0 0 0
 * Salida de ejemplo
 * 1 1
 * 2 2
 * 
 */
