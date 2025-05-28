package ud7.ejercicios;
/*E1103. Pedir un entero n por consola y, a continuación, generar n números aleatorios de tipo double, que iremos insertando en una tabla. Guardar la tabla en un archivo binario.

Implementa un programa que lea la tabla de números guardada en ese fichero de datos y los muestre por pantalla.
 */
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class E1103bis {
    static final String PATH = "src/ud7/apuntesficherosbinarios/";

    public static void main(String[] args) {
        double[] t = null;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PATH + "numerosDouble.dat"))) {
            t = (double[]) in.readObject();
            System.out.println(Arrays.toString(t));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
