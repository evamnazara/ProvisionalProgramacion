package junio.ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
Notas y medias de DAM
El fichero calificacion_alumnos.csv contiene las notas finales obtenidas por el alumnado del ciclo DAM en el siguiente formato:
Los datos se presentan en filas con la información separada por punto y coma (;)
La primera fila contiene las cabeceras de la información
Las siguientes filas representan la nota de un alumno/a en un módulo.

Elabora un programa que lea el fichero y muestre:
el nombre y la nota media de cada alumno/a ordenados descendentemente por media
el nombre y el número de suspensos de cada módulo ordenados ascendentemente por número de suspensos.
Genera un fichero de texto de salida de nombre "InformeDAM1.txt" que contengo un informe con el siguiente contenido:


Informe Avaliación DAM1
=======================
Total Alumnado = ??

Alumnado con…:
- Todo aprobado: ??
- 1 módulo suspenso: ??
- 2 módulos suspensos: ??
- 3 módulos suspensos: ??
- Máis de 3 módulos suspensos: ??
etc.
 */

public class NotasDAM {
    static final String PATH = "src/junio/ficheros/";

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(PATH + "calificacion_alumnos.csv"));
            String linea = in.readLine();

            // linea a linea
            while (linea != null) {
                System.out.println(linea);
                linea = in.readLine();
            }

            in.close();
        } catch (FileNotFoundException e) { // error de no encontrar
            System.out.println(e.getMessage()); // (El sistema no puede encontrar el archivo especificado)
        } catch (IOException e) { // error de entrada salida
            System.out.println(e.getMessage());
        }
    }

}
