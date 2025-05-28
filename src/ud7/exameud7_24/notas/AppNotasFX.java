/*(1 punto) El programa AppNotasFX.java debe leer el fichero notas.txt, calcular el promedio
de cada estudiante y mostrar los resultados en una interfaz gráfica, además de escribirlos
en un nuevo fichero de texto promedio.txt.
 */

package ud7.exameud7_24.notas;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AppNotasFX extends Application {
    
    TextField text1 = new TextField("Notas alumnos:");
    Button btnMedia = new Button("Obtener media");
    Label lblMedia = new Label("Media:");

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
    }
    
}
