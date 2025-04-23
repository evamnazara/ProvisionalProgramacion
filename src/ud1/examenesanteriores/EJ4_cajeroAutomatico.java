/*CajeroAutomatico.java
Realiza un programa que simule el funcionamiento de un cajero automático. 
El programa solicitará al usuario el importe en efectivo que desea retirar, que será un número entero de euros (€). 
El programa calculará el número mínimo de billetes de 50, 20, 10 y 5 euros para
obtener dicho importe y presentará la información al usuario.
Si el importe introducido por el usuario no es múltiplo de 5 se informará también al usuario
del importe que el cajero no es capaz de satisfacer por no disponer de billetes de esa
cantidad. 
Por ejemplo, si el usuario introduce 78 €, el programa informará de que se
retirarán 75 € en los billetes que corresponda y que 3 € no se pueden retirar por no existir
billetes tan pequeños. 

*/
package ud1.examenesanteriores;

import java.util.*;

public class EJ4_cajeroAutomatico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int BILLETES50 = 50;
        final int BILLETES20 = 20;
        final int BILLETES10 = 10;
        final int BILLETES5 = 5; 

        System.out.println("¿Qué cantidad desea retirar?");
        int retirado = sc.nextInt();

        int billetesMinimos = retirado / BILLETES50;
        System.out.println(billetesMinimos);

        int resto = retirado % 50; 

        int billetes20 = resto / BILLETES20;
        resto = resto % BILLETES20 ;

        int billetes10 = resto / BILLETES10 ;
        resto = resto % 10; //resto se sobreescribe cada vez

        int billetes5 = resto / BILLETES5; 
        resto = resto % 5;
        

        System.out.println("Se van a retirar: " + retirado + " euros.");
        System.out.println(billetesMinimos + " billetes de 50 euros.");
        System.out.println(billetes20 + " billetes de 20 euros");
        System.out.println(billetes10 + " billetes de 10 euros");
        System.out.println(billetes5 + " billetes de 5 euros");
        System.out.println("No puedo entregarte " + resto + " euros, sólo multiplos de 5.");

        sc.close();
    }
}
