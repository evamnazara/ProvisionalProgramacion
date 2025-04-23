/*E0507. Implementar la función int[] sinRepetidos(int t[]) que construye y devuelve una tabla de la longitud apropiada, con los elementos de t, donde se han eliminado los datos repetidos.

Implementa una función que genere y devuelva un array de n números enteros aleatorios usando el siguiente prototipo: 

int[] tablaRandom(int n)

*/

package ud4.ejercicios;


import java.util.Arrays;

import ud4.utiles.ArraysUtil;

public class E0507_SinRepetidos {
    static Integer[] sinRepetidos(Integer t[]) {
        //CLAUSULA DE GUARDA : SALE SI EL VALOR ES NULO O INCORRECTO 

        if (t == null) {
            return null;
            
        }
        
        Integer[] sinRepetidos = new Integer[0]; //[0]a priori no sabemos la longitud del array que nos pasan
        
        for (int i = 0; i < t.length; i++) { //recorre array original
            boolean repetido = false;
            int j = 0;

            while (j < sinRepetidos.length && !repetido){//busqueda secuencial en el array
                if (t[i] == sinRepetidos[j])
                    repetido = true;
                    j++; 
                    //cambia la bandera y quita el numero, la siguiente vuelta del bucle recorre solo el array sin repetidos
            }
            
           /*  
           ALTERNATIVA CON FOR: 

            for (int j = 0; j < sinRepetidos.length; j++){//busqueda secuencial en el array
                if (t[i] == sinRepetidos[j])
                    repetido = true; //cambia la bandera y quita el numero, la siguiente vuelta del bucle recorre solo el array sin repetidos
                 }
            */
            if (!repetido) {
                sinRepetidos = Arrays.copyOf(sinRepetidos, sinRepetidos.length + 1);
                //machaca el valor que hubiera en el array 
                sinRepetidos[sinRepetidos.length - 1] = t[i];
            }
        }

        return sinRepetidos;
    }

    public static void main(String[] args) {
        Integer[] t = ArraysUtil.arrayAleatorio(20, 1, 10);
        
        System.out.println(Arrays.toString(t));

        t = sinRepetidos(t);

        System.out.println(Arrays.toString(t));        
    }
}
