

        /*Clase String, métodos más utilizados: 
            1. valueOf() 
            2. equals() 
            3. equalsIgnoreCase() 
            4. regionMatches() 
            5. compareTo() 
            6. compareToIgnoreCase() 
            7. charAt() 
            8. substring() 
            9. strip() 
            10.  stripLeading() 
            11.  stripTrailing() 
            12.  length() 
            13.  indexOf() 
            14.  lastIndexOf() 
            15.  isEmpty() 
            16.  contains() 
            17.  startsWith() 
            18.  endsWith() 
            19.  toLowerCase() 
            20.  toUpperCase() 
            21.  replace() 
            22.  split() 
            23.  toCharArray()  */

package ud4.strings;

import java.util.Scanner;

public class E0603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Contraseña");
        final int MAX_INTENTOS = 3;
        int intentos = 0; 

        String password = sc.nextLine();

        //lineas en blanco que no oculten la contraseña
        for (int i = 0; i < 50; i ++) {
            System.out.println();
        }

        String passwordJugador; 

        do { 
            passwordJugador = sc.nextLine();
            intentos++; } 
            while( 
                !password.equals(passwordJugador) && intentos < MAX_INTENTOS);


        sc.close();
    }
   
}
