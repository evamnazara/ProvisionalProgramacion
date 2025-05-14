package ud7.apuntesficherostexto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjemploFileReader {

    static final String PATH = "src/ud7/apuntesficherostexto/";

    public static void main(String[] args) {

        try {
            FileReader fichero = new FileReader(PATH + "texto.txt"); // canta por si solo, hay q ponerle un trycatch
            int ch = fichero.read(); //da un numero 
            while (ch != -1) {
                System.out.println((char)ch); //castear y leer cada letra en una fila 
                ch = fichero.read();
            }
            
        } catch (FileNotFoundException e) { //error de no encontrar 
            System.out.println(e.getMessage()); //(El sistema no puede encontrar el archivo especificado)
        } catch (IOException e) { //error de entrada salida 
            System.out.println(e.getMessage());
        }

    }

}
