/* TresTablas. 
Crea tres tablas de cinco elementos: la primera de números enteros, la segunda de double y la tercera de booleanos. 
Muestra las referencias en las que se encuentra almacenada cada una de las tablas. 
*/

package ud4;

public class Arrays {
    public static void main(String[] args) {
        //o tablaInt[] = {valor1,2,3...}        

        int[] tablaInt = {18, 24, 37, 27}; 
        double[] tablaDouble = {4.53, 1.25, 7.00, 4.77};
        boolean [] tablaBoolean = {true, false, false, true};

        System.out.println(tablaInt);
        System.out.println(tablaDouble);
        System.out.println(tablaBoolean);
        
    }
}
