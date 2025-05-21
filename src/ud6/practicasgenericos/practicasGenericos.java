package ud6.practicasgenericos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;

public class practicasGenericos {

    /*
     * Crea un método genérico sinDuplicadosOrdenados() que reciba una colección de
     * elementos de tipo T, y devuelva una nueva colección con los elementos sin
     * duplicados y ordenados alfabéticamente o numéricamente según el orden natural
     * de los elementos.
     * Puedes asumir que T implementa Comparable<T>.
     */
    public static <T> Collection<T> sinDuplicadosOrdenados(Collection<T> coleccion) {
        Set<T> sinRepetidos = new TreeSet<>(coleccion);
        return sinRepetidos;
    }

    // EJERCICIO 2
    /*
     * (2) Método genérico interseccion()
     * Implementa un método genérico interseccion() que reciba dos colecciones de
     * tipo T y devuelva una colección con los elementos comunes a ambas
     * colecciones, sin repetirlos.
     */

    public static <T> Collection<T> interseccion(Collection<T> conjunto1, Collection<T> conjunto2) {
        Set<T> interseccion = new TreeSet<>(conjunto2);
        interseccion.retainAll(conjunto1);
        return interseccion;
    }

    // EJERCICIO 3
    /*
     * Define un método genérico filtrarMenores() similar a filtrarMayores() pero
     * que devuelva los elementos menores o iguales que un valor dado, utilizando un
     * Comparator<T>.
     */

    public static <T> Collection<T> filtrarMenores(Collection<T> coleccion, T valor, Comparator<T> comparador) {
        Collection<T> resultado = new ArrayList<>();

        for (T elemento : coleccion) {
            if (comparador.compare(elemento, valor) >= 0) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    // EJERCICIO 4
    /*
     * Crea un método genérico contarFrecuencias() que reciba una colección de
     * elementos de tipo T y devuelva un Map<T, Integer> donde cada clave sea un
     * elemento de la colección y el valor asociado sea el número de veces que
     * aparece.
     */

    public static <T> Map<T, Integer> contarFrecuencias(Collection<T> coleccion) {
        Map<T, Integer> frecuencias = new HashMap<>();

        for (T elemento : coleccion) {
            frecuencias.put(elemento, frecuencias.getOrDefault(elemento, 0) + 1);
        }
        return frecuencias;
    }

    public static <T> void contarFrecuenciasSinMap(Collection<T> coleccion) {
        List<T> yaProcesados = new ArrayList<>();

        for (T elemento : coleccion) {
            if (!yaProcesados.contains(elemento)) {
                int contador = 0;

                for (T otro : coleccion) {
                    if (elemento.equals(otro)) {
                        contador++;
                    }
                }

                System.out.println(elemento + " aparece " + contador + " veces.");
                yaProcesados.add(elemento); // Para no contar el mismo elemento otra vez
            }
        }
    }

    // solo una vez
    public static <T> List<T> repetidosSinDuplicados(List<T> lista) {
        Map<T, Integer> contador = new HashMap<>();
        List<T> resultado = new ArrayList<>();

        // Contar ocurrencias
        for (T e : lista) {
            contador.put(e, contador.getOrDefault(e, 0) + 1);
        }

        // Añadir solo los elementos con más de una ocurrencia, sin repetirlos
        for (T e : contador.keySet()) {
            if (contador.get(e) > 1) {
                resultado.add(e);
            }
        }

        return resultado;
    }

    // 7: contar únicos
    // Objetivo: Crear un método que devuelva cuántos elementos aparecen solo una
    // vez en una colección.

    public static <T> int contarUnicos(Collection<T> coleccion) {
        Map<T, Integer> contador = new HashMap<>();
        for (T elemento : coleccion) {
            contador.put(elemento, contador.getOrDefault(elemento, 0) + 1);
        }

        int unicos = 0;
        for (int cantidad : contador.values()) {
            if (cantidad == 1)
                unicos++;
        }

        return unicos;
    }

    // EJERCICIO 8: convertirASetOrdenadoDescendente()
    // Objetivo: Convertir una colección a un TreeSet ordenado en orden descendente.
    public static <T> Set<T> convertirASetOrdenadoDescendente(Collection<T> coleccion, Comparator<T> comparador) {
        Set<T> resultado = new TreeSet<>(comparador.reversed());
        resultado.addAll(coleccion);
        return resultado;
    }

    // ✅ EJERCICIO 9: filtrarPorPredicado()
    // Objetivo: Implementar un método que filtre elementos según un Predicate<T>.
    // Es útil para expresar condiciones lógicas.

    public static <T> List<T> filtrarPorPredicado(Collection<T> coleccion, Predicate<T> condicion) {
        List<T> resultado = new ArrayList<>();
        for (T elemento : coleccion) {
            if (condicion.test(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    // ✅ EJERCICIO 10: elementoMasFrecuente()
    // Objetivo: Devolver el elemento que aparece más veces en una colección. Si hay
    // empate, devolver cualquiera.
    public static <T> T elementoMasFrecuente(Collection<T> coleccion) {
        Map<T, Integer> frecuencias = new HashMap<>();

        for (T elemento : coleccion) {
            frecuencias.put(elemento, frecuencias.getOrDefault(elemento, 0) + 1);
        }

        T masFrecuente = null;
        int max = 0;

        for (Map.Entry<T, Integer> entrada : frecuencias.entrySet()) {
            if (entrada.getValue() > max) {
                max = entrada.getValue();
                masFrecuente = entrada.getKey();
            }
        }

        return masFrecuente;
    }

    // ✅ EJERCICIO 11: invertirLista()
    // Objetivo: Devolver una copia invertida de una lista.
    public static <T> List<T> invertirLista(List<T> lista) {
        List<T> resultado = new ArrayList<>(lista);
        Collections.reverse(resultado);
        return resultado;
    }

    // EJERCICIO 12: eliminarNulos()
    // Objetivo: Eliminar los valores null de una colección y devolver una nueva
    // colección limpia.
    public static <T> Collection<T> eliminarNulos(Collection<T> coleccion) {
        List<T> limpia = new ArrayList<>();
        for (T elemento : coleccion) {
            if (elemento != null) {
                limpia.add(elemento);
            }
        }
        return limpia;
    }

    // EJERCICIO 13: contarPorCondicion()
    // Objetivo: Contar cuántos elementos de una colección cumplen un Predicate<T>.
    public static <T> int contarPorCondicion(Collection<T> coleccion, Predicate<T> condicion) {
        int contador = 0;
        for (T elemento : coleccion) {
            if (condicion.test(elemento)) {
                contador++;
            }
        }
        return contador;
    }

    // EJERCICIO 14: eliminarSi()
    // Objetivo: Eliminar todos los elementos que cumplan una condición dada por un
    // Predicate<T> (devuelve una nueva lista sin modificar la original).

    public static <T> List<T> eliminarSi(Collection<T> coleccion, Predicate<T> condicion) {
        List<T> resultado = new ArrayList<>();
        for (T elemento : coleccion) {
            if (!condicion.test(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    // EJERCICIO 15: todosCumplen()
    // Objetivo: Verificar si todos los elementos cumplen una condición.
    public static <T> boolean todosCumplen(Collection<T> coleccion, Predicate<T> condicion) {
        for (T elemento : coleccion) {
            if (!condicion.test(elemento)) {
                return false;
            }
        }
        return true;
    }

    // 16: alguno cumple=
    // si al menos uno de los elementos cumple una condicion
    public static <T> boolean algunoCumple(Collection<T> coleccion, Predicate<T> condicion) {
        for (T elemento : coleccion) {
            if (condicion.test(elemento)) {
                return true;
            }
        }
        return false;
    }
    // EJERCICIO 17: barajarLista()
    // Objetivo: Devolver una copia de la lista, barajada aleatoriamente.

    public static <T> List<T> barajarLista(List<T> lista) {
        List<T> copia = new ArrayList<>(lista);
        Collections.shuffle(copia);
        return copia;
    }

    // EJERCICIO 18: mezclarListasAlternando()
    // Objetivo: Mezclar dos listas intercalando elementos. Si tienen diferente
    // tamaño, se añaden los sobrantes al final.

    public static <T> List<T> mezclarListasAlternando(List<T> l1, List<T> l2) {
        List<T> resultado = new ArrayList<>();
        int max = Math.max(l1.size(), l2.size());

        for (int i = 0; i < max; i++) {
            if (i < l1.size())
                resultado.add(l1.get(i));
            if (i < l2.size())
                resultado.add(l2.get(i));
        }

        return resultado;
    }

    // EJERCICIO 19: extraerAleatorio()
    // Objetivo: Devolver un elemento aleatorio de una colección (sin modificarla).

    public static <T> T extraerAleatorio(Collection<T> coleccion) {
        if (coleccion.isEmpty())
            return null;
        int index = new Random().nextInt(coleccion.size());
        return new ArrayList<>(coleccion).get(index);
    }

    // EJERCICIO 20: rotarLista()
    // Objetivo: Rotar una lista N posiciones a la derecha (puedes usar
    // Collections.rotate()).

    public static <T> List<T> rotarLista(List<T> lista, int posiciones) {
        List<T> copia = new ArrayList<>(lista);
        Collections.rotate(copia, posiciones);
        return copia;
    }

    // EJERCICIO 21: duplicarElementos()
    // Objetivo: Duplicar cada elemento de una lista secuencialmente.

    public static <T> List<T> duplicarElementos(List<T> lista) {
        List<T> resultado = new ArrayList<>();
        for (T e : lista) {
            resultado.add(e);
            resultado.add(e);
        }
        return resultado;
    }

    // EJERCICIO 22: Agrupar elementos por clave
    // Objetivo: Crear un método que reciba una lista de objetos y agrupe por una
    // clave generada mediante una Function<T, K>.
    public static <T, K> Map<K, List<T>> agruparPor(List<T> lista, Function<T, K> clave) {
        Map<K, List<T>> resultado = new HashMap<>();

        for (T e : lista) {
            K key = clave.apply(e);

            // Si la clave no existe, creamos una nueva lista
            if (!resultado.containsKey(key)) {
                resultado.put(key, new ArrayList<>());
            }

            // Añadimos el elemento a la lista correspondiente
            resultado.get(key).add(e);
        }

        return resultado;
    }

    /*
     * EJERCICIO 23: Encontrar el máximo con Comparator<T>
     * Objetivo: Crear un método genérico que devuelva el máximo elemento de una
     * colección, según un comparador.
     */

    public static <T> T maximo(Collection<T> coleccion, Comparator<T> comparador) {
        if (coleccion == null || coleccion.isEmpty()) {
            return null; // o lanza una excepción si lo prefieres
        }

        Iterator<T> it = coleccion.iterator();
        T max = it.next();

        while (it.hasNext()) {
            T actual = it.next();
            if (comparador.compare(actual, max) > 0) {
                max = actual;
            }
        }

        return max;
    }

    /* 23B, mas corto */
    public static <T> T minimo(Collection<T> coleccion, Comparator<T> comparador) {
        if (coleccion == null || coleccion.isEmpty()) {
            return null; // o lanzar IllegalArgumentException si prefieres
        }

        Iterator<T> it = coleccion.iterator();
        T min = it.next();

        while (it.hasNext()) {
            T actual = it.next();
            if (comparador.compare(actual, min) < 0) {
                min = actual;
            }
        }

        return min;
    }

    /*
     * EJERCICIO 24: Contar por categoría (Map<K, Integer>)
     * Objetivo: Contar cuántos elementos hay de cada tipo, agrupando por clave
     * generada con una Function<T, K>.
     */

    public static <T, K> Map<K, Integer> contarPorCategoria(Collection<T> coleccion, Function<T, K> clave) {
        Map<K, Integer> conteo = new HashMap<>();
        for (T e : coleccion) {
            K k = clave.apply(e);
            conteo.put(k, conteo.getOrDefault(k, 0) + 1);
        }
        return conteo;
    }

    /* EJERCICIO 25: Ordenar un mapa por valores (de mayor a menor) */
    public static <K, V extends Comparable<V>> Map<K, V> ordenarPorValorDesc(Map<K, V> mapa) {
        // Convertimos las entradas del mapa en una lista
        List<Map.Entry<K, V>> lista = new ArrayList<>(mapa.entrySet());

        // Ordenamos manualmente por valor descendente
        lista.sort(new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                return e2.getValue().compareTo(e1.getValue()); // Descendente
            }
        });

        // Creamos un nuevo HashMap y lo llenamos en orden (aunque el orden no se
        // mantiene)
        Map<K, V> resultado = new HashMap<>();
        for (Map.Entry<K, V> entrada : lista) {
            resultado.put(entrada.getKey(), entrada.getValue());
        }

        return resultado;
    }

    public static void main(String[] args) {
        // ejercicio 1
        List<String> palabras = Arrays.asList("casa", "perro", "gato", "casa", "perro");
        System.out.println(sinDuplicadosOrdenados(palabras));
        // Salida esperada: [casa, gato, perro]

        // ejercicio 2
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> l2 = Arrays.asList(3, 4, 4, 5, 6);
        System.out.println(interseccion(l1, l2));
        // Salida esperada: [3, 4, 5]

        // ejercicio 3
        Comparator<Double> comp = Comparator.naturalOrder();
        List<Double> numeros = Arrays.asList(4.5, 2.3, 6.7, 1.1);
        System.out.println(filtrarMenores(numeros, 4.0, comp));
        // Salida esperada: [2.3, 1.1]

        // ejercicio 4
        List<Character> letras = Arrays.asList('a', 'b', 'a', 'c', 'b', 'a');
        System.out.println(contarFrecuencias(letras));
        // Salida esperada: {a=3, b=2, c=1}

        // ejercicio 5
        contarFrecuenciasSinMap(letras);
        // Salida esperada:
        // a aparece 3 veces.
        // b aparece 2 veces.
        // c aparece 1 veces.

        // ejercicio 6
        List<Integer> numerines = Arrays.asList(1, 2, 2, 1, 1, 3, 4, 5, 4, 6, 7, 7, 7);
        System.out.println(repetidosSinDuplicados(numerines));
        // 2,4,7

        // === EJERCICIO 7: contarUnicos() ===
        List<String> palabras1 = Arrays.asList("sol", "luna", "sol", "estrella", "mar", "luna", "cielo");
        System.out.println("E7 - Elementos únicos: " + contarUnicos(palabras1));
        // Esperado: 3 (estrella, mar, cielo)

        // === EJERCICIO 8: convertirASetOrdenadoDescendente() ===
        List<Integer> numeros2 = Arrays.asList(5, 2, 3, 2, 8, 1, 4);
        Set<Integer> ordenadosDesc = convertirASetOrdenadoDescendente(numeros2, Comparator.naturalOrder());
        System.out.println("E8 - Set ordenado descendente: " + ordenadosDesc);
        // Esperado: [8, 5, 4, 3, 2, 1]

        // === EJERCICIO 9: filtrarPorPredicado() ===
        List<Integer> lista = Arrays.asList(10, 15, 20, 25, 30);
        List<Integer> mayoresDe20 = filtrarPorPredicado(lista, x -> x > 20);
        System.out.println("E9 - Mayores de 20: " + mayoresDe20);
        // Esperado: [25, 30]

        // === EJERCICIO 10: elementoMasFrecuente() ===
        List<Character> letras3 = Arrays.asList('a', 'b', 'c', 'a', 'b', 'a');
        System.out.println("E10 - Más frecuente: " + elementoMasFrecuente(letras3));
        // Esperado: a

        // === EJERCICIO 11: invertirLista() ===
        List<String> ciudades = Arrays.asList("Madrid", "Paris", "Roma", "Berlin");
        System.out.println("E11 - Invertida: " + invertirLista(ciudades));
        // Esperado: [Berlin, Roma, Paris, Madrid]

        // === EJERCICIO 12: eliminarNulos() ===
        List<String> nombres = Arrays.asList("Ana", null, "Luis", null, "Eva");
        System.out.println("E12 - Sin nulos: " + eliminarNulos(nombres));
        // Esperado: [Ana, Luis, Eva]

        // 13 contar kis qye cumplen una condicion
        List<Integer> nums = Arrays.asList(3, 6, 9, 12, 15);
        System.out.println("E13 - Divisibles por 3: " + contarPorCondicion(nums, x -> x % 3 == 0));
        // Esperado: 5

        // 14, eliminarSI
        List<String> palabras3 = Arrays.asList("rojo", "verde", "azul", "rosa", "violeta");
        System.out.println("E14 - Sin palabras con 'r': " + eliminarSi(palabras3, s -> s.contains("r")));
        // Esperado: [azul, violeta]

        // son TODOS mayores de edad?
        List<Integer> edades = Arrays.asList(18, 21, 30);
        System.out.println("E15 - ¿Todos mayores de edad? " + todosCumplen(edades, edad -> edad >= 18));
        // Esperado: true

        // es ALGUNO mayor de edad?
        List<String> frutas = Arrays.asList("manzana", "pera", "kiwi");
        System.out.println("E16 - ¿Alguna contiene 'z'? " + algunoCumple(frutas, f -> f.contains("z")));
        // Esperado: false

        // E17 - barajarLista
        List<String> nombres2 = Arrays.asList("Ana", "Luis", "Pedro", "Sofía");
        System.out.println("E17 - Lista original: " + nombres2);
        System.out.println("E17 - Lista barajada: " + barajarLista(nombres2));

        // E18 - mezclarListasAlternando
        List<String> li1 = Arrays.asList("a", "c", "e");
        List<String> li2 = Arrays.asList("b", "d", "f", "g", "h");
        System.out.println("E18 - Mezcladas alternando: " + mezclarListasAlternando(li1, li2));

        // E19 - extraerAleatorio
        List<Integer> numeros3 = Arrays.asList(10, 20, 30, 40, 50);
        System.out.println("E19 - Lista: " + numeros3);
        System.out.println("E19 - Elemento aleatorio: " + extraerAleatorio(numeros3));

        // E20 - rotarLista
        List<String> dias = Arrays.asList("Lunes", "Martes", "Miércoles", "Jueves", "Viernes");
        System.out.println("E20 - Original: " + dias);
        System.out.println("E20 - Rotada +2: " + rotarLista(dias, 2));
        System.out.println("E20 - Rotada -1: " + rotarLista(dias, -1));

        // E21 - duplicarElementos
        List<Integer> base = Arrays.asList(1, 2, 3);
        System.out.println("E21 - Original: " + base);
        System.out.println("E21 - Duplicados: " + duplicarElementos(base));

        // 22
        List<String> palabras4 = Arrays.asList("casa", "coche", "sol", "luz", "lago", "ratón");
        Map<Integer, List<String>> agrupadas = agruparPor(palabras4, s -> s.length());
        System.out.println("E22 - Agrupadas por longitud: " + agrupadas);
        // Ej: {3=[sol, luz], 4=[casa, lago], 5=[coche, ratón]}

        // 23 mas largo
        List<String> nombres3 = Arrays.asList("Ana", "Beatriz", "Zoe", "Cristina");
        String masLargo = maximo(nombres3, Comparator.comparing(String::length));

        System.out.println("Nombre más largo: " + masLargo);
        // Ejemplo de salida: Cristina o Beatriz

        // 23B mas corto
        String masCorto = minimo(nombres, Comparator.comparing(String::length));
        System.out.println("Nombre más corto: " + masCorto);
        // Salida esperada: Ana

        // 24
        Map<String, Integer> notas = new HashMap<>();
        notas.put("Luis", 7);
        notas.put("Ana", 10);
        notas.put("Pedro", 5);

        // 25
        Map<String, Integer> ordenado = ordenarPorValorDesc(notas);
        System.out.println("Ordenado por valor descendente (orden NO garantizado):");
        System.out.println(ordenado);
        // Salida (orden puede variar visualmente, pero el mapa está ordenado al
        // insertarlo)

    }
}
