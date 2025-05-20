package ud7.ejercicios;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*Repite la actividad escribiendo los números enteros en el archivo datos.dat como un array 
y no como números enteros individuales.  */
public class E1101_2 {
    public static void main(String[] args) {
        // Escribe 10 números enteros e un fichero binario
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src\\ud7\\apuntesficherosbinarios\\datos.dat"))) {
            out.writeObject(numeros);
        } catch (IOException ex) {
            System.out.println("Escribiendo... Error Entrada/Salida");
        }
    }
}
