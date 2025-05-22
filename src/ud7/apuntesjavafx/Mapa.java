package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//q el robot se mueva de la a a la z con los cursores o awsd 
//si se pisa un amina, dialogo de rror,
//si se llega a la meta un cuadro de exito 

public class Mapa extends Application {
    String[] mapa = {
            "  Z       ",
            " *        ",
            "  *  *    ",
            "          ",
            " A        "
    };
    final static int FILA = 0;
    final static int COLUMNA = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Mapa");

        GridPane gridpane = new GridPane();
        // representar mapa
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length(); j++) { // es un array
                Label lbl = new Label(String.valueOf(mapa[i].charAt(j)));

                // formato
                String css ="-fx-border-width:1 1 1 1; -fx-border-color: pink pink pink pink;";
                switch (String.valueOf(mapa[i].charAt(j))) {
                    case "*" : css += "-fx-background-color: pink"; break;
                    case "A" : css += "-fx-background-color: palegreen"; break;
                    case "Z" : css += "-fx-background-color: lightblue"; break;
                }
                lbl.setStyle(css);
                

                lbl.setPrefSize(50, 50);
                lbl.setAlignment(Pos.CENTER);
                gridpane.add(lbl, j, i); // columna j, fila i
            }

        
        }

        primaryStage.setTitle("Mapa");
        primaryStage.setResizable(false);

        Scene scene = new Scene(gridpane);
        scene.setOnKeyTyped( e -> {
            System.out.println(e.getCode() + " - " + e.getCharacter());
            switch (e.getCharacter()) {
                case "a":
                    gridpane.getChildren(); 
                    break;
                case "w": break;
                case "s": break;
                case "d": break;
            }
       });

        primaryStage.setScene(new Scene(gridpane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        // evento de pulsacion de teclas
        // reconocer teclas
        // mover personaje
    }

}
