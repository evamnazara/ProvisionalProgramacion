package ud7.apuntesficherostexto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
    E1006. Crea con un editor el fichero de texto Enteros.txt en la carpeta del proyecto actual 
y escribir en él una serie de enteros separados por secuencias de espacios y tabuladores, 
incluso en líneas distintas, tal como: 
 
 * 
 *  Implementar un programa que acceda a Enteros.txt con un objeto Scanner a través de un 
flujo de entrada, lea los números y calcule su suma y su media aritmética, mostrando los 
resultados por pantalla. 
 
¿Qué pasará si una línea contiene datos alfanuméricos intercalados con los números 
enteros? 
 
Piensa como modificar el programa para que se salte los datos no enteros que pueda 
encontrar y sí procese los siguientes números. 
Muestra por consola los valores que no correspondan a números enteros y contabiliza 
cuántos de estos “errores” tiene el fichero. 
 */
public class E1006_ejemploScanner {
    static final String PATH = "src/ud7/apuntesficherostexto/";

    public static void main(String[] args) {

        int suma = 0; 
        try {
            BufferedReader in = new BufferedReader(new FileReader(PATH + "Enteros.txt"));
            Scanner sc = new Scanner(in);


            while (sc.hasNextInt()) {
               int num = sc.nextInt();
               suma += num;
            }
            in.close();

            System.out.println("suma: " + suma);
        } catch (FileNotFoundException e) { // error de no encontrar
            System.out.println(e.getMessage()); // (El sistema no puede encontrar el archivo especificado)
        } catch (IOException e) { // error de entrada salida
            System.out.println(e.getMessage());
        }
    }
}
