package ud7.ejercicios;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*E1102. Escribe como una cadena, en el fichero binario cancionPirata.dat, la siguiente 
estrofa: 
 
Con diez cañones por banda,  
viento en popa a toda vela, 
no corta el mar, sino vuela  
un velero bergantin. 
  */
public class E1102 {
    public static void main(String[] args) {
         try (ObjectOutputStream out = new ObjectOutputStream(
            new FileOutputStream("src\\ud7\\apuntesficherosbinarios\\cancionPirata.dat"))) {
            String pirata = "Con diez cañones por banda,\n";
            pirata += "viento en popa a toda vela,\n";
            pirata += "no corta el mar, sino vuela\n";
            pirata += "un velero bergantin.";

            out.writeObject(pirata);

        } catch (IOException e) {
            System.out.println("Error E/S");
        }
    }
}
