/*E1101. Escribir en un archivo datos.dat los valores de diez números enteros.  
Repite la actividad escribiendo los números enteros en el archivo datos.dat como un array 
y no como números enteros individuales.  */
package ud7.ejercicios;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class E1101 {
    public static void main(String[] args) {
        try {ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src\\ud7\\ejercicios\\datos.dat"));
            for (int i = 0; i < 10; i++) {
                out.writeInt(i);
            }
        } catch (IOException e) {
            System.out.println("Error E/S");
        }
    }
}
