package u6;

import java.util.*;

public class utiles {
    public static void main(String[] args) {
        // separar valores a partir de un string.
        String texto = "manzana pera plátano kiwi";
        String[] arrayPalabras = texto.split(" ");
        System.out.println("Array:");
        for (String palabra : arrayPalabras) {
            System.out.println(palabra);
        }

        ArrayList<String> listaPalabras = new ArrayList<>(Arrays.asList(arrayPalabras));
        System.out.println("\nArrayList:");
        for (String palabra : listaPalabras) {
            System.out.println(palabra);
        }
        // opcion 2 ArrayList<String> lista = new
        // ArrayList<>(Arrays.asList(texto.split(" ")));

        // CONVERSIONES:

        // 1. De un Array a un ArrayList
        /*
         * con clase Arrays, método asList(). -> no te da un ArrayList en el sentido
         * completo (es una lista fija), para que sea funcional, debes crear una nueva
         * instancia de ArrayList.
         */

        String[] array = { "A", "B", "C" };
        List<String> list = Arrays.asList(array); // Esta lista está respaldada por el array y no es dinámica.
        System.out.println(list); // [A, B, C]

        // Ejemplo 2: Creando un ArrayList desde un Array
        // String[] array = {"A", "B", "C"};
        List<String> arrayListCopiado = new ArrayList<>(Arrays.asList(array)); // Crea una copia totalmente dinámica
        System.out.println(arrayListCopiado); // [A, B, C]

        // de un ArrayList a un Array
        // simplemente puedes usar el método toArray(). Si necesitas especificar el tipo
        // del array, debes pasarlo como argumento.

        List<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        String[] array2 = list2.toArray(new String[0]); // Pasamos el tipo del array como parámetro
        System.out.println(Arrays.toString(array2)); // [A, B, C]

        // 3. LISTA A SET -> uita los duplicados
        /*
         * constructor de HashSet (o cualquier otro tipo de Set) que acepta una
         * colección como argumento. eliminará los duplicados de la lista en el proceso.
         */

        // Ejemplo 1: Usando el constructor de HashSet
        List<String> list3 = Arrays.asList("A", "B", "C", "A");
        Set<String> set = new HashSet<>(list3);
        System.out.println(set); // [A, B, C] (duplicados eliminados)

        // 4. De un Set a un ArrayList //Para convertir un Set en un ArrayList, puedes
        // usar el constructor de ArrayList, que acepta cualquier colección.

        // Ejemplo 1: Usando el constructor de ArrayList
        Set<String> set5 = new HashSet<>(Arrays.asList("A", "B", "C"));
        List<String> list5 = new ArrayList<>(set5);
        System.out.println(list5); // [A, B, C] (el orden puede no ser el mismo, ya que Set no garantiza orden)

        // 5. De un Mapa a una Lista
        // Convertir un Mapa (por ejemplo, un HashMap) en una Lista puede hacerse de
        // varias maneras dependiendo de qué parte del mapa quieras convertir (claves,
        // valores o entradas).

        // Ejemplo 1: De un Mapa a una Lista de claves

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        List<String> keys = new ArrayList<>(map.keySet());
        System.out.println(keys); // [A, B, C]

        // Ejemplo 2: De un Mapa a una Lista de valores
        List<Integer> values = new ArrayList<>(map.values());
        System.out.println(values); // [1, 2, 3]
        // Ejemplo 3: De un Mapa a una Lista de entradas (pares clave-valor)

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        System.out.println(entries); // [A=1, B=2, C=3]
    }
}
