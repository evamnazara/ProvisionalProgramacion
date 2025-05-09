package ud7.ejercicios;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
 * Actividad 11. Ejercicio con BorderPane: 
 * Crea una aplicación que contenga un BorderPane con un menú en la parte superior y un 
panel en el centro. El menú debe tener dos opciones: "Rojo" y "Verde". Al seleccionar la 
opción "Rojo", el panel debe cambiar su color de fondo a rojo; al seleccionar la opción 
"Verde", el panel debe cambiar su color de fondo a verde. 
 */
public class Ejemplo11_BorderPane extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //definir items del top 
        MenuItem menuRojo = new MenuItem("Rojo");
        MenuItem menuAzul = new MenuItem("Azul");
        MenuItem menuVerde = new MenuItem("Verde");
        

        Menu colores = new Menu("Colores");
        //añadir los items 
        colores.getItems().addAll(menuRojo,menuAzul,menuVerde);
        MenuBar menuBar = new MenuBar(colores);
        BorderPane borderPane = new BorderPane();
       
        Label label1 = new Label("panel central");
        Pane panelCentral = new Pane (label1);
        label1.setStyle("-fx-align-items: center;");


        borderPane.setTop(menuBar);
        borderPane.setCenter(panelCentral);
        //declarar el centro

        //eventos 
        menuVerde.setOnAction(e -> borderPane.setStyle("-fx-background-color: PaleGreen;"));
        menuAzul.setOnAction(e -> borderPane.setStyle("-fx-background-color: lightblue;"));
        menuRojo.setOnAction(e -> borderPane.setStyle("-fx-background-color: pink;"));

        Scene scene = new Scene(borderPane, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("BorderPane con menú y colores de fondo");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
