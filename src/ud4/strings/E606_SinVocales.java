package ud4.strings;

import java.util.Scanner;

public class E606_SinVocales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre: ");

        String nombre = sc.nextLine();

        System.out.println(sinVocales(nombre));
        sc.close();
    }
    
    static String sinVocales(String cad) {
        String sinVocales = "";
        String vocales ="aeiouáéíóúAEIOUÁÉÓÍÚöÖüÜ";

        for( int i = 0; i < cad.length(); i++) {
            char caracter = cad.charAt(i);

            if (vocales.indexOf(caracter) == -1 ) { //si NO CONTIENE devuelve -1
                //añadir al resultado
                sinVocales = sinVocales + caracter;
            }

        }

        return sinVocales;


    }
}
