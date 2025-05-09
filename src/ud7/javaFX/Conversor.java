package ud7.javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Conversor extends Application {

    TextField txt1 = new TextField("Unidades en kg");
    Button btnkGLibra = new Button("Convertir a libras");
    Label lblResultad1 = new Label();

    TextField txt2 = new TextField("Unidades en libras");
    Button btmLibraKg = new Button("Convertir a KG");
    Label lblResultad2 = new Label();


    @Override
    public void start(Stage primaryStage) throws Exception {

        // funcionalidades
        btnkGLibra.setOnAction(e -> {
            Double gramosLibra = 453.592;
            Double LibraKilos = gramosLibra / 1000;

            int masa1 = Integer.parseInt(txt1.getText());

            double resultado = masa1 * LibraKilos;

            lblResultad1.setText(masa1 + " kg son " + String.valueOf(resultado) + " libras. ");

        });


        btmLibraKg.setOnAction(e -> {
            Double gramosLibra = 453.592;
            Double kgLibra = 1000 / gramosLibra;

            int masa = Integer.parseInt(txt2.getText());
            
            double resultado2 = masa * kgLibra;

            lblResultad2.setText(masa + " libras son " + String.valueOf(resultado2) + " KG. ");
        });

        // nodo padre y escena
        VBox vbox = new VBox(txt1, btnkGLibra, lblResultad1, txt2, btmLibraKg, lblResultad2);

        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Conversor");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
