package ud6.ejercicios;

import java.util.Arrays;

import ud3.apuntes.Persona;

public class E1201_MetodosGenericos {
    static <U> int numeroDeNulos(U[] tabla) { 
        int cont = 0; 
        for (U e : tabla) 
            if (e == null) 
                cont++; 
        return cont; 
    } 
    /*  Implementar un método genérico estático que realice la 
    inserción de un objeto al final de una tabla, ambos del mismo tipo genérico, que se pasan 
    como parámetros. Devuelve una nueva tabla con el resultado de la inserción. */
 
    public static <U> U[] add(U e, U[] t) {
        t = Arrays.copyOf(t, t.length + 1);
        t[t.length -1] = e;

        return t;
    }
     
/*Implementa un método genérico que devuelva true si un elemento se encuentra en un 
array y false en caso contrario. */
 
    public static <U> boolean buscar(U e, U[] t)  {
        boolean resultado = false;
        for (int i = 0; i < t.length; i++) {
            if (t[i] != null && t[i].equals(e)) {
                resultado =  true;
            } 
        }

        return resultado;
    }    


    public static <U, V> Object[] concatenarDistintos(U[] t1, V[] t2)  {
        Object [] t3 = Arrays.copyOf(t1, t1.length + t2.length);
            for (int i = 0; i < t2.length; i++) {
            t3[t1.length + i] = t2[i];
            
            }
        return t3;
    }

    /* Implementa un método genérico estático al que se le pasan como parámetros dos tables 
    con elementos del mismo tipo genérico y devuelve una nueva tabla con los elementos de 
a   mbas concatenados (los de la segunda después de los de la primera).  */
 
    public static <U> U[] concatenar(U[] t1, U[] t2) {
        U[] t3 = Arrays.copyOf(t1, t1.length + t2.length);
            for (int i = 0; i < t2.length; i++) {
                t3[t1.length + i] = t2[i];
            }
        
        return t3;
        
    }



    public static void main(String[] args) {
        Integer[] numeros = {3,5,null,6,7,null};
        Persona[] personas = {new Persona("pepe"), null, new Persona("yago")};

        System.out.println(numeroDeNulos(numeros));
        System.out.println(numeroDeNulos(personas));

        //1
        numeros = add(7, numeros);
        System.out.println(Arrays.toString(numeros));
        personas = add(new Persona("Juancho"), personas);
        System.out.println(Arrays.toString(personas));

        System.out.println("Hay un 8 en números? " + buscar(8, numeros));
        System.out.println("Hay un 6 en números? " + buscar(6, numeros));

        System.out.println("Está Pepe? " + buscar(new Persona("Pepe"), personas));

        Integer[] numeros2 = {23, 45, 78, 23};
        Integer[] masNumeros = concatenar(numeros, numeros2);
        System.out.println(Arrays.toString(masNumeros));


    }
}
