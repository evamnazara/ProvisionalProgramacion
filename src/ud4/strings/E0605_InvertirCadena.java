/*E0605. Diseña una función a la que se le pase una cadena de caracteres y la devuelva 
invertida. Por ejemplo: la cadena “Hola mundo” se devolvería como “odnum aloH”. 
 
Puedes implementar un método con el siguiente prototipo: 
 
static String invertirCadena(String cad)  */

package ud4.strings;
import java.util.Scanner;

public class E0605_InvertirCadena {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Frase:");
        String frase = sc.nextLine();
        
        String fraseInvertida = invertirCadena(frase);
        System.out.println(fraseInvertida);

        sc.close();
    }

   static String invertirCadena(String cad) {
        String cadenaInvertida = "";

        //concatenar en una cadena vacía 
        //palabra palindromo 

        for (int i = cad.length() -1; i >= 0; i-- ){
            cadenaInvertida += cad.charAt(i); 
            //recorre frase de principio a fin en una cadena nueva xd
        }

        return cadenaInvertida;
    }
}
