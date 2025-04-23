package ud6.apuntesstream.E1304;

import java.util.ArrayList;
/*
E1304. 
    Implementar un método estático (filtrar) al que se pasa como parámetro una tabla de tipo genérico y un predicado. El método devuelve otra tabla con los elementos de la tabla original que verifiquen la condición del predicado. Aplicarlo a una tabla de 50 enteros entre 1 y 100 que devuelve los múltiplos de 3. 
    Prueba a implementar una versión del método que utilice listas en lugar de arrays.  */
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import ud6.apuntescolecciones.Cliente;

public class Filtrar {

    public static void main(String[] args) {
        Integer[] numeros = new Integer[50];
        List<Integer> listaNumeros = new ArrayList<>();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random() * 20 + 1);
            listaNumeros.add((int)(Math.random() * 20 + 1));
        }

       System.out.println(Arrays.toString(numeros));
       System.out.println("Multiplos de 3:");
       
       //el segundo parametro es el predicado , se puede pasar como expresion lamda
       Integer[] multiplosDe3 = filtrar(numeros, n -> n % 3 == 0);
       System.out.println(Arrays.toString(multiplosDe3));


       //de la lista:

       System.out.println("Filtrando pares de la lista");
       List<Integer> numerosPares = filtrar(listaNumeros, n -> n % 2 == 0);
       System.out.println(numerosPares);

       System.out.println("Clientes; ");
       List<Cliente> clientes = Cliente.clientesDeEjemplo();
       System.out.println(clientes);
       List<Cliente> mayoresEdad = filtrar(clientes,c -> c.edad() >= 18);
       System.out.println(mayoresEdad);


    }

    static <T> T[] filtrar(T[] t, Predicate<T> p) {
        // instanciar tabla -- no se puede hacer un tabla de genericos 
        T[] tablaNueva = Arrays.copyOf(t,0);
        // recorrer tabla original
        for (T elemento : t) {
            // si un elemento cumple el predicado añadir a una tabla nueva
            if (p.test(elemento)) {
                tablaNueva = Arrays.copyOf(tablaNueva, tablaNueva.length + 1);
                tablaNueva [tablaNueva.length - 1] = elemento;
            }
        }

        // devolver tabla nueva

        return tablaNueva;

    }

    
    static <T> List<T> filtrar(List<T> l, Predicate<T> p) {
        // instanciar tabla --SI se puede hacer lista de genericos 
        List<T> lista = new ArrayList<>();
        // recorrer tabla original
        for (T e : l) {
            if (p.test(e)) {
                lista.add(e);
            }
        }
        // si un elemento cumple el predicado añadir a una tabla nueva

        // devolver tabla nueva

        return lista;

    }

}
