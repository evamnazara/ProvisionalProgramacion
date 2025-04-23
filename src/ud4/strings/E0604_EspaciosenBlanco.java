/* E0604. Diseña una aplicación que pida al usuario que introduzca una frase por teclado e 
indique cuántos espacios en blanco tiene. 
 Implementa un método con el siguiente prototipo: 
static int contarEspacios(String cad)  */

package ud4.strings;
import java.util.*;


public class E0604_EspaciosenBlanco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Frase:");
        String frase = sc.nextLine();
        
        int numEspacios = contarEspacios(frase);
        System.out.println("El número de espacios en blanco en " + frase + " son: " + numEspacios);

        sc.close();


    }

    static int contarEspacios(String cad) {
        int numEspacios = 0;
        for (int i = 0; i < cad.length(); i++ ){
            if (Character.isWhitespace(i)) { //o cad.charat(0) == ' '
                numEspacios++;
            }

        }
        System.out.println("Numero de espacios:" + numEspacios);

        return numEspacios;

    }
}
