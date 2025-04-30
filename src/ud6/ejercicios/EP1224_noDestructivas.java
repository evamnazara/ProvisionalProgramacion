package ejercicios;

import java.util.*;
/*
EP1224. Implementa una función a la que se le pasen dos listas de enteros ordenadas en sentido creciente y nos devuelva una única lista, también ordenada, fusión de las dos anteriores. 
Desarrolla el algoritmo de forma no destructiva, es decir, que las listas utilizadas como parámetros de entrada se mantengan intactas. */

public class EP1224_noDestructivas {

    // Función que fusiona dos listas ordenadas en una nueva lista ordenada
    public static List<Integer> fusionarListas(List<Integer> lista1, List<Integer> lista2) {
        List<Integer> resultado = new ArrayList<>();

        int i = 0, j = 0;

        // Mientras haya elementos en ambas listas
        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) <= lista2.get(j)) {
                resultado.add(lista1.get(i));
                i++;
            } else {
                resultado.add(lista2.get(j));
                j++;
            }
        }

        // Añadir elementos restantes de lista1 si los hay
        while (i < lista1.size()) {
            resultado.add(lista1.get(i));
            i++;
        }

        // Añadir elementos restantes de lista2 si los hay
        while (j < lista2.size()) {
            resultado.add(lista2.get(j));
            j++;
        }

        return resultado;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        List<Integer> listaA = Arrays.asList(1, 3, 5, 7);
        List<Integer> listaB = Arrays.asList(2, 4, 6, 8, 10);

        List<Integer> fusion = fusionarListas(listaA, listaB);

        System.out.println("Lista fusionada: " + fusion);
        System.out.println("Lista original A (intacta): " + listaA);
        System.out.println("Lista original B (intacta): " + listaB);
    }
}
