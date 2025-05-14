package ud7.ejerciciosjavaFX.ejemplos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo4 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button();
        btn.setText("Button");
        

        Button btn2 = new Button();
        btn2.setText("Button2");
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("3. Button Event Handler"));
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("2. Button Event Filter"));
        /***
         * Campo de texto que al presionar las teclas del teclado imprime
         * un mensaje en consola con el ćodigo de tecla pulsada
         ***/
        TextField campoTexto = new TextField();
        campoTexto.setOnKeyPressed((KeyEvent evento) -> System.out.println("Se ha pulsado la tecla " + evento.getCode()));

        
        VBox root = new VBox(btn, btn2, campoTexto);
        root.getChildren().add(btn);
        root.getChildren().add(btn2);
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> System.out.println("1. VBox Event Filter"));
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> System.out.println("4. VBox Event Handler"));

        Scene scene = new Scene(root, 300, 250);
        /***
         * Filtro de evento que detiene la propagación de un evento de teclado
         * cuando el caracter escrito no es un número
         ***/
        scene.addEventFilter(KeyEvent.KEY_TYPED, e -> {
            if (!Character.isDigit(e.getCharacter().charAt(0))) {
                e.consume();
            }
        });

        primaryStage.setTitle("JavaFX Manejo de Eventos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
