/*ClaseCharacter. Crea un programa que lea un caracter de teclado y, utilizando los 
métodos anteriores de la clase Character, imprima: 
●  Si es un dígito 
●  Si es una letra 
●  Si es un dígito o una letra 
●  etc. 
●  Si es mayúscula y en caso afirmativo mostrar la letra minúscula equivalente. 
●  Si es minúscula y en caso afirmativo mostrar la letra mayúscula equivalente.  */

package ud4.caracteres;
import java.util.*;

public class ClaseCaracter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("caracter:");
        String linea; 
        do {
            linea = sc.nextLine();
        } while (linea.equals(""));
        char caracter = linea.charAt(0);
        sc.close();

        System.out.println("¿Es dígito? " + Character.isDigit(caracter)); 
        
        System.out.println("¿Es letra?" + Character.isLetter(caracter));  
            if ( Character.isLetter(caracter) == true) {
                if (Character.isUpperCase(caracter) == true) {

                    System.out.println("Está escrito en mayúscula.");
                    System.out.println("En minúscula seria: " + Character.toLowerCase(caracter));
                   }
                if (Character.isLowerCase(caracter) == true) {
                    System.out.println("Está escrito en minúscula.");
                    System.out.println("En mayuscula seria: " + Character.toUpperCase(caracter));
                }   
            }
        
    }
    
}
