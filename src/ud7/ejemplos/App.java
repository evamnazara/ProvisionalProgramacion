package ud7.ejemplos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

                        //!!!!!!
public class App extends Application {

    static int contador = 0;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, JavaFX");
        launch(); 
    }

    //aqui va la app 
    @Override
    public void start(Stage stage) throws Exception {
        Button btn = new Button("Púlsame"); 
        btn.setOnAction(e -> { //event listener con lmnda
            System.out.println("Botón pulsado");
            contador++;
            if (contador > 1) {
                btn.setText("botón pulsado " + contador + " veces!!");
            } else {
                btn.setText("boton pulsado");
                btn.setBackground(Background.fill(Paint.valueOf("pink")));
                btn.setBorder(Border.stroke(Paint.valueOf("lightblue")));
            }


        }); 

        Scene scene = new Scene(btn, 300,300);
        stage.setTitle("javaFX");
        stage.setScene(scene);
        stage.setResizable(false); //nos e puede cambari de tamaño 
        stage.show();
    }
}
