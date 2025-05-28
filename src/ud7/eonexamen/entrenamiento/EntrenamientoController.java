//Eva María Otero Názara

package ud7.eonexamen.entrenamiento;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class EntrenamientoController implements Initializable {
    @FXML
    private ListView<Entrenamiento> lstEntrenamientos;
    @FXML
    private TextField textoFecha;

    @FXML
    private TextField textoKm;

    @FXML
    private TextField textoNombre;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Entrenamiento.cargarFichero(Entrenamiento.PATHARCHIVO);
        Entrenamiento.stagePrincipal.setTitle("Entrenamientos:" + Entrenamiento.PATHARCHIVO);

        lstEntrenamientos.getItems().addAll(Entrenamiento.listaEntrenamientos);
    }

    @FXML
    void abriArchivo(ActionEvent event) {
        Entrenamiento.cargarFichero(Entrenamiento.PATHARCHIVO + "entrenamiento.dat");
    }

    @FXML
    void guardarArchivo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar como...");
        fileChooser.setInitialDirectory(new File(Entrenamiento.PATHARCHIVO));

        File selectedFile = fileChooser.showOpenDialog(Entrenamiento.stagePrincipal);
        if (selectedFile != null) {
            Entrenamiento.cargarFichero(selectedFile.toString());
        }
    }

}
