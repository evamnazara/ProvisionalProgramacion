package ud7.exameud7_24.notas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*1. Notas y Promedios (3)
Paquete: notas
Se requiere implementar un programa en Java, AppNotas.java, que lea y procese
información contenida en un fichero de texto. El fichero de texto contendrá una lista de
estudiantes y sus respectivas calificaciones en varias materias. El programa debe leer este fichero, calcular el promedio de cada estudiante y escribir los resultados en un nuevo fichero de texto.

Especificaciones:
1. El fichero de entrada se llamará notas.txt.
2. Cada línea del fichero contendrá el nombre de un estudiante seguido de sus
calificaciones separadas por comas. Ejemplo:
Juan Perez,80,90,85
Maria Lopez,75,88,92
Carlos Garcia,60,70,80,90

3. El programa calculará el promedio de las calificaciones de cada estudiante.
4. Escribirá los resultados en un nuevo fichero llamado promedios.txt con el siguiente
formato:
Juan Perez: 85.0
Maria Lopez: 85.0
Carlos Garcia: 75.0
5. Si el fichero notas.txt no existe, está vacío o contiene datos incorrectos, el programa
debe manejar las excepciones correspondientes e imprimir los mensajes de error
adecuados. */
public class NotasyPromedios {

    static final String PATH = "src/ud7/exameud7_24/notas";

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
