package ud7.ejerciciosjavaFX.ejemplos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*  Actividad 3. 
    Crear una ventana con dos campos de texto y un botón que, al hacer clic, 
    muestre la suma de los números ingresados en un tercer campo de texto o en una 
    etiqueta. 

    Modificar para que se actualice.
*/
public class Ejemplo3 extends Application {

    TextField txtNum1 = new TextField("Escribe un número");
    TextField txtNum2 = new TextField("Escribe otro número");
    Button btnSumar = new Button("Sumar");
    Label lblResultad = new Label();

    @Override
    public void start(Stage primaryStage) throws Exception {

        // actualizacion
        txtNum1.setOnKeyTyped(e -> sumar());
        btnSumar.setOnAction(e -> sumar());
                                //KeyEvent.KEY_TYPED
        txtNum1.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> System.out.println("dentro"));
        txtNum1.addEventHandler(MouseEvent.MOUSE_EXITED, e -> System.out.println("fuera"));
        // nodo padre y escena
        VBox vbox = new VBox(txtNum1, txtNum2, btnSumar, lblResultad);
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculadora");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    private void sumar() {
        int resultado;
        int n1 = 0;
        int n2 = 0;// inicializar a 0 para que el compilador no se queje si salta la excepcion
        try {
            n1 = Integer.parseInt(txtNum1.getText());
            n2 = Integer.parseInt(txtNum2.getText());
            resultado = n1 + n2;
            // no admite int asi que hay que convertirlo a string
            lblResultad.setText(String.valueOf(resultado));

        } catch (Exception excepcion) {
            lblResultad.setText(String.valueOf("ERROR: Alguno de los operandos no es un número."));
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
