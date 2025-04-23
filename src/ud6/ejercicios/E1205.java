package ud6.ejercicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

/*E1205. 
Implementar una aplicación en la que se insertan en una colección 100 números enteros aleatorios entre 1 y 10 (incluídos), que pueden estar repetidos. 
A continuación, se crea una lista con los mismos elementos sin repeticiones.  */
public class E1205 {
    public static void main(String[] args) {
        Collection <Integer> numeros = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 100; i++) {
            numeros.add(rnd.nextInt(10) + 1);
        }
        System.out.println(numeros);
        

        //como no queremos duplcados, hashset
        //directamente la clase ya no admite duplicados
        Collection<Integer> sinRepetidos = new HashSet<>();
        for(Integer numero : numeros){
            sinRepetidos.add(numero);
        }
        System.out.println("Sin repetidos:");  
        System.out.println(sinRepetidos);      
    }
}
