package ud7.ejemplos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo2 extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField textField = new TextField("Escribe tu nombre...");
        
        Button button = new Button("Saludar");
        Label label = new Label();

        button.setOnAction(e -> {
            label.setText("Hola " + textField.getText());

        });


        VBox vBox = new VBox(textField,button,label); //orden en q se muestran en la escena
        Scene scene = new Scene(vBox,300,200); 

        primaryStage.setScene(scene);
        primaryStage.setTitle("Saludo");
        primaryStage.setResizable(false);

        primaryStage.show();
        
    }


    public static void main(String[] args) {
        launch();
    }
    
}
