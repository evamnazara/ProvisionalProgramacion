package ud7.apuntesficherostexto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjermploBufferedReader {
    static final String PATH = "src/ud7/apuntesficherostexto/";

    public static void main(String[] args) {

        try {
            //combinar invocacion anterior con esta 
            BufferedReader in = new BufferedReader(new FileReader(PATH + "texto.txt")); 
            int ch = in.read(); //da un numero 
            //caracter a caracter 
            while (ch != -1) {
                System.out.println((char)ch); //castear y leer cada letra en una fila 
                ch = in.read();
            }
            
        } catch (FileNotFoundException e) { //error de no encontrar 
            System.out.println(e.getMessage()); //(El sistema no puede encontrar el archivo especificado)
        } catch (IOException e) { //error de entrada salida 
            System.out.println(e.getMessage());
        }

    }
}
