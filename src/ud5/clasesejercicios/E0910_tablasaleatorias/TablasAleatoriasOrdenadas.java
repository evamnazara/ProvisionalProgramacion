/*E0910. Implementar una clase comparadora que permita ordenar números enteros en 
sentido decreciente. Crear una tabla de 20 números aleatorios comprendidos entre 1 y 
100 y ordenarla en sentido decreciente.  */
package ud5.clasesejercicios.E0910_tablasaleatorias;

import java.util.Comparator;
import java.util.Arrays;
import java.util.Random;

public class TablasAleatoriasOrdenadas {
    
    @SuppressWarnings("rawtypes")
    static Comparator comparador = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Integer n1 = (int) o1;
            Integer n2 = (int) o2;

            return n1-n2;
            
        }
    };
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Integer [] tabla = new Integer[20];
        int numeroRandom;

        for(int i = 0; i < 20; i++) {
            numeroRandom = new Random().nextInt(1,100);
            tabla[i] = numeroRandom;

        }

        System.out.println(Arrays.toString(tabla));
        Arrays.sort(tabla,comparador);
        System.out.println(Arrays.toString(tabla));


    }
        
   
    
}

