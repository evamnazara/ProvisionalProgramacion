package ud4.utiles;
import java.util.Arrays;
import java.util.Random;


public class ChuletaArrays {
    
    // Generar un array de enteros aleatorios
    public static int[] generarArrayEnteros(int longitud, int min, int max) {
        int[] array = new int[longitud];
        Random rand = new Random();
        for (int i = 0; i < longitud; i++) {
            array[i] = rand.nextInt((max - min) + 1) + min;
        }
        return array;
    }
    
    // Generar un array de Strings aleatorios
    public static String[] generateStringArray(int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = "Str" + i;
        }
        return array;
    }
    
    // Imprimir un array
    public static void imprimirArray(int[] array) {
    }
    
    public static void desordenar(int t[]) {
        Random rnd = new Random();

        for (int i = 0; i < t.length; i++) {
            int nuevaPosicion = rnd.nextInt(t.length);
            
            int auxiliar = t[i];

            t[i] = t[nuevaPosicion];
            t[nuevaPosicion] = auxiliar;

        }
    }
    
    // Buscar un valor en un array ordenado (Binary Search)
    public static int binarySearch(int[] array, int value) {
        return Arrays.binarySearch(array, value);
    }
    
    // Buscar un valor en un array desordenado
    public static int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
    
    // Recorrer un array al derecho
    public static void recorrerArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    // Recorrer un array al revés
    public static void recorrerArrayAlReves(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    // Insertar un valor en un array
    public static int[] insertarValor(int[] array, int value) {
        int[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[array.length] = value;
        return newArray;
    }
    
    // Insertar un valor en un array ordenado
    public static int[] insertarValorOrdenado(int[] array, int value) {
        int[] newArray = insertarValor(array, value);
        Arrays.sort(newArray);
        return newArray;
    }
    
    // Eliminar un elemento de un array ordenado
    public static int[] eliminarValorOrdenado(int[] array, int value) {
        int index = binarySearch(array, value);
        if (index < 0) return array;
        return borrarIndice(array, index);
    }
    
    // Eliminar un elemento de un array desordenado
    public static int[] eliminarValorDesordenado(int[] array, int value) {
        int index = linearSearch(array, value);
        if (index < 0) return array;
        return borrarIndice(array, index);
    }
    
    // 
    private static int[] borrarIndice(int[] array, int index) {
        int[] nuevoArray = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                nuevoArray[j++] = array[i];
            }
        }
        return nuevoArray;
    }

    //contar el numero de veces que aparece un valor 
    public static int contar(int t[], int clave) {
        int contar = 0;

        for (int i = 0; i < t.length; i++)
            if (t[i] == clave)
                contar++;

        return contar;
    } 

    // Comparación de arrays
    public static boolean compararArrays(int[] array1, int[] array2) {
        return Arrays.equals(array1, array2);
    }
    
    // Uso de copyOf y copyOfRange
    public static void metodosCopia(int[] array) {
        int[] copiedArray = Arrays.copyOf(array, array.length);
        int[] rangeCopy = Arrays.copyOfRange(array, 1, array.length);
        System.out.println("Original: " + Arrays.toString(array));
        System.out.println("Copia: " + Arrays.toString(copiedArray));
        System.out.println("Copia de rango: " + Arrays.toString(rangeCopy));
    }
}