package ejercicios;

import java.util.*;

public class EP1219_frases {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Leer frase de la consola
        System.out.print("Introduce una frase (solo palabras separadas por espacios): ");
        String frase = scanner.nextLine().toLowerCase(); // Convertimos a minúsculas para uniformidad

        // 2. Separar la frase en palabras y almacenarlas en una lista
        String[] palabrasArray = frase.split("\\s+"); // Separar por uno o más espacios
        List<String> palabras = Arrays.asList(palabrasArray);

        // 3. Contar la frecuencia de cada palabra usando un Map
        Map<String, Integer> contador = new HashMap<>();
        for (String palabra : palabras) {
            contador.put(palabra, contador.getOrDefault(palabra, 0) + 1);
        }

        // 4. Mostrar palabras repetidas
        System.out.println("\nPalabras repetidas:");
        boolean hayRepetidas = false;
        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " (veces: " + entry.getValue() + ")");
                hayRepetidas = true;
            }
        }
        if (!hayRepetidas) {
            System.out.println("Ninguna.");
        }

        // 5. Mostrar palabras no repetidas
        System.out.println("\nPalabras no repetidas:");
        boolean hayNoRepetidas = false;
        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                hayNoRepetidas = true;
            }
        }
        if (!hayNoRepetidas) {
            System.out.println("Ninguna.");
        }

        scanner.close();
    }
}
