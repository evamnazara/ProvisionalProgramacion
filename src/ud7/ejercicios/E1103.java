/*E1103. Pedir un entero n por consola y, a continuación, generar n números aleatorios de 
tipo double, que iremos insertando en una tabla. Guardar la tabla en un archivo binario. 
 
Implementa un programa que lea la tabla de números guardada en ese fichero de datos y 
los muestre por pantalla.  */

package ud7.ejercicios;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class E1103 {
    static final String PATH = "src/ud7/ejercicios/";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("número: ");
        int n = sc.nextInt();
        sc.close();

        double[] t = new double[n];
        for (int i = 0; i < n; i++)
            t[i] = Math.random() * 100;

        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(PATH + "numerosDouble.dat"))) {
            out.writeObject(t);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
