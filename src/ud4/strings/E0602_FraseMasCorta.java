/*E0602. Introducir por teclado dos frases e indicar cuál de ellas es la más corta, es decir, la 
que contiene menos caracteres.  */

package ud4.strings;
import java.util.*;

public class E0602_FraseMasCorta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Frase 1: ");
        String frase1 = sc.nextLine();
        int long1 = frase1.length();

        System.out.println("Frase 2: ");
        String frase2 = sc.nextLine();
        int long2 = frase2.length();

        if (long1 > long2) {
            System.out.println("La cadena más larga es: " + frase1);
        } else {
            System.out.println("La cadena más larga es: " + frase2);
        }

        sc.close();

    }
}
