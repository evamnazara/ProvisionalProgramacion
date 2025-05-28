//Eva María Otero Názara

package ud7.eonexamen.web;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LogApache {

    static final String PATH = "src/ud7/eonexamen/web/";

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(PATH + "bacharelato_access.log"));
            Scanner sc = new Scanner(in);
            String linea ="";
            int totales = 0;
            int accesosIncorrectos = 0;

            while (sc.hasNextLine()) {

            linea = sc.nextLine().trim();
            //System.out.println("Línea leída: " + linea);

            String[] partes = PATH.split("\n");

                for (int i = 0; i < partes.length; i++) {
                    totales++;
                    if (linea.contains("404")){
                        accesosIncorrectos++;
                    }
                    
                }
            }
            
            System.out.println("Accesos totales:" + totales);
            System.out.println("Accesos incorrectos:" + accesosIncorrectos);

            in.close();
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de L/E " + e.getMessage());
        }
    
    }
}
