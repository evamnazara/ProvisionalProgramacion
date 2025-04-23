/*
3. Números ordenados
NumerosOrdenados.java
Escribe un programa que lea 3 números por teclado e indique si están ordenados o no, de
menor a mayor, y de mayor a menor. 
 */
package ud1.examenesanteriores;
import java.util.*;

public class EJ3_numerosOrdenados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        System.out.println("Introduce el primer numero");
        int num1 = sc.nextInt();

        System.out.println("Introduce el segundo numero");
        int num2 = sc.nextInt();

        System.out.println("Introduce el tercer numero");
        int num3 = sc.nextInt();

        String resultado = 
                        num1 > num2 && num2 > num3 ? "Está ordenado de mayor a menor" : 
                        num1 < num2 && num2 < num3 ? "Esta ordenado de menor a mayor" : 
                        "Están desordenados";

        System.out.println(resultado);
        sc.close();

        
    }
    
}
