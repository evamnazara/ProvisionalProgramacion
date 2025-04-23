package ud6.ejercicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/*E1204. Implementar una aplicación que pida por consola números enteros no negativos 
hasta que se introduce un -1. 
Los números se irán insertando en una colección, pudiéndose repetir. Al terminar, se mostrará la colección por pantalla.  
A continuación, se mostrarán todos los valores pares. Por último, se eliminarán todos los 
múltiplos de 3 y se mostrará por pantalla la colección resultante. 
Practica el uso de iteradores y bucles for-each para recorrer la colección.  */
public class E1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //en vez de array:
        Collection<Integer> numeros = new ArrayList<Integer>();
        System.out.println("numeros enteros no negativos ");
        int num = sc.nextInt();

        while (num != -1){
            numeros.add(num);
            num = sc.nextInt();
        }

        System.out.println(numeros.toString());
        

        //mostrar pares
        System.out.println("números pares:");
        for(Integer numero : numeros) {
            if (numero % 2 == 0) 
                System.out.println(numero + " ");
        }

        //eliminar multiplos de 3
        System.out.println("sin múltiplos de 3:");
        Iterator<Integer> it = numeros.iterator();
        
        while (it.hasNext()) {
            Integer numero = it.next();
            if (numero % 3 == 0) {
                numeros.remove(numero);
            }
        }
            
        sc.close();
            
    
        
    }


}
