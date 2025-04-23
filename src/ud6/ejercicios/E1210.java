package ud6.ejercicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/* E1210. Escribir en una lista 20 enteros aleatorios entre 1 y 10. A partir de ella, crear un 
conjunto con los elementos de la lista sin repetir, otro con los repetidos y otro con los 
elementos que aparecen una sola vez en la lista original.  */
//hashset permite ordenar con equals
//treeset no 
public class E1210 {
    public static void main(String[] args) {
        List <Integer> numeros = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 20; i++) {
            numeros.add(rnd.nextInt(10) + 1);
        }
        System.out.println(numeros);

        //sin repetir
        Collection<Integer> sinRepetidos = new HashSet<>();
        for ( Integer numero : numeros){
            sinRepetidos.add(numero);
        }

        System.out.println("Sin repetidos:");  
        System.out.println(sinRepetidos); 
    
        //elementos repetidos 
        Set<Integer> elementosRepetidos = new TreeSet<>();
        for (Integer numero : numeros){
            if (numeros.indexOf(numero) != numeros.lastIndexOf(numero)){
                elementosRepetidos.add(numero);
                }
            }
        System.out.println("repes");
        System.out.println(elementosRepetidos);

      /*Set <Integer> elementosSinRepetir = new TreeSet<>();
        elementosRepetidos.addAll(sinRepetidos);
        elementosSinRepetir.removeAll(elementosRepetidos);
        System.out.println(elementosSinRepetir); */
        
            //elementos que aparecen 1 vez 
        Set<Integer> soloUnaVez = new TreeSet<>();
        
        for (Integer numero : numeros){
            if (numeros.indexOf(numero) == numeros.lastIndexOf(numero)){
                    soloUnaVez.add(numero);
                    }
            }
        System.out.println("Números que aparecen sólo una vez:");
        System.out.println(soloUnaVez);
                
        
    }
}

