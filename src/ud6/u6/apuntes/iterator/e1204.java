package ud6.u6.apuntes.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*Implementar una aplicación que pida por consola números enteros no negativos hasta que se introduce un -1. 
Los números se irán insertando en una colección, pudiéndose repetir. 
Al terminar, se mostrará la colección por pantalla. 
A continuación, se mostrarán todos los valores pares. Por último, se eliminarán todos los múltiplos de 3 y se mostrará por pantalla la colección resultante.
Practica el uso de iteradores y bucles for-each para recorrer la colección.

2 5 2 7 9 3 6 7 8 -1 
 */
public class e1204 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // se declara el array vacio
        ArrayList<Integer> numeros = new ArrayList<>();

        System.out.println("Introduce números, -1 para salir");

        int num = sc.nextInt();
        while (num != -1) {
            numeros.add(num);
            num = sc.nextInt();
        }
        System.out.println(numeros.toString());

        System.out.println("Sin número pares:");
        for (Integer numero : numeros) {
            if (numero % 2 == 0) {
                System.out.println(numero + " ");
            }
        }

        System.out.println("Sin múltiplos de 3: ");
        Iterator<Integer> it = numeros.iterator();
        while (it.hasNext()) {
            Integer numero = it.next();
            if (numero / 3 == 0) {
                it.remove();
            }
        }
        System.out.println(numeros.toString());

        sc.close();
    }
}
