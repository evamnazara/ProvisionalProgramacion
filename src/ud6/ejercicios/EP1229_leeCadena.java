package ud6.ejercicios;

/*
EP1227. Implementa la función LeeCadena(), con el siguiente prototipo: que lee una cadena por teclado y nos la devuelve en una lista con un carácter en cada elemento.

List<Character> leeCadena() */
import java.util.*;

public class EP1229_leeCadena {

    // Función que lee una cadena desde el teclado y la convierte en una lista de
    // caracteres
    public static List<Character> leeCadena() {
        @SuppressWarnings("resource")
        Scanner lector = new Scanner(System.in);

        System.out.print("Introduce una cadena de texto: ");
        String textoIngresado = lector.nextLine(); // Leer línea completa

        List<Character> listaDeCaracteres = new ArrayList<>();

        // Recorrer cada carácter de la cadena y añadirlo a la lista
        for (int posicion = 0; posicion < textoIngresado.length(); posicion++) {
            char caracterActual = textoIngresado.charAt(posicion);
            listaDeCaracteres.add(caracterActual);
        }

        return listaDeCaracteres;
    }

    public static void main(String[] args) {
        List<Character> resultado = leeCadena();
        System.out.println("Lista de caracteres: " + resultado);
    }
}
