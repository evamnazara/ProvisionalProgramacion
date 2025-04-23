
package ud5.clasesejercicios.E0711_Listas;

import java.util.Arrays;
//import ud5.clasesejercicios.E0711.*;

public class Lista {
    Lista[] lista;
    int numElementos;

    public Lista(Lista[] listaNumeros) {
        //int[] lista = new int[0];
        //this.numElementos = numElementos;
    }


    public int numeroElementos(Lista []lista) {
        return lista.length;
    }

    public String mostrarLista (int[] lista) {
        Arrays.toString(lista);
        String mostrarLista = "e"; 
        return mostrarLista;
    }

    public int addElementoPrincipio(int[] lista, int valor){
        System.out.println(Arrays.toString(lista));
        int[] listas = Arrays.copyOf(lista, lista.length + 1);
        listas[lista.length] = valor;
        return valor;
    }

    public int addElementoFinal(int[] lista, int valor) {
        int elemento = 0;
        return elemento;
    }
}
    
/*
Los números se guardarán en una tabla que se redimensionará con las inserciones y 
eliminaciones
Entre los métodos de la clase, se incluirán las siguientes tareas: 
1.  Un constructor que inicialice la tabla con un tamaño 0. 
2.  Obtener el número de elementos insertados en la lista. 
3.  Insertar un número al final de la lista. 
4.  Insertar un número al principio de la lista. 
5.  Insertar un número en un lugar de la lista cuyo índice, que es el de la tabla, se pasa como parámetro. 
6.  Añadir al final de la lista los elementos de otra lista que se pasa como parámetro. 
7.  Eliminar un elemento cuyo índice en la lista se pasa como parámetro. 
8.  Obtener el elemento cuyo índice se pasa como parámetro. 
9.  Buscar un número en la lista, devolviendo el índice del primer lugar donde se 
encuentre. Si no está, devolverá -1. 
10. Mostrar los elementos de la lista por consola.  */