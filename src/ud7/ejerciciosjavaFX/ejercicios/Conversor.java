package ud7.ejerciciosjavaFX.ejercicios;
/*
 * Conversor. 
 * Crea una aplicación que permita convertir cantidades de un sistema de medida a otro
 * Por ejemplo, de euros a dólares (1 € = 1,13 $), de libras a kilos (1 libra = 0.453592 
 * kilos), de millas a kilómetros (1 milla = 1.609344 kilómetros), etc.
 * Experimenta con nuevos controles para ampliar el programa y que permita convertir en ambos sentidos o cambiar de un tipo de conversión a otra.

 */

 import javafx.application.Application;
 import javafx.scene.Scene;
 import javafx.scene.control.*;
 import javafx.scene.layout.VBox;
 import javafx.stage.Stage;
 
 public class Conversor extends Application {
 
     Label lblInicio = new Label("Cantidad a convertir:");
     TextField txtEntrada = new TextField();
     Label lblConv = new Label("Conversión");
     Label lblResultado = new Label("Resultado:");
     ComboBox<String> comboConversion = new ComboBox<>();
     Button btnConvertir = new Button("Convertir");
 
     @Override
     public void start(Stage primaryStage) {
         // promtptext para que salga como placeholder
         txtEntrada.setPromptText("Introduce la cantidad a convertir");
         // se añaden las pestañas a la caja
         comboConversion.getItems().addAll(
                 "Euros a Dólares",
                 "Libras a Kilos",
                 "Millas a Kilómetros");
         btnConvertir.setOnAction(e -> convertir());
 
         VBox vbox = new VBox(lblInicio, txtEntrada, lblConv, comboConversion, btnConvertir, lblResultado);
 
         vbox.setStyle( // igual que css pero con -fx-
                 "-fx-padding: 15;" +
                 "-fx-spacing: 10;");
         Scene scene = new Scene(vbox, 350, 250);
 
         primaryStage.setScene(scene);
         primaryStage.setTitle("Conversor");
         primaryStage.setResizable(false);
         primaryStage.show();
     }
 
     private void convertir() {
         try {
             double cantidad = Double.parseDouble(txtEntrada.getText());
             double resultado = 0;
 
             switch (comboConversion.getValue()) {
                 case "Euros a Dólares":
                     resultado = cantidad * 1.13;
                     break;
                 case "Libras a Kilos":
                     resultado = cantidad * 0.4535924;
                     break;
                 case "Millas a Kilómetros":
                     resultado = cantidad * 1.609344;
                     break;
             }
 
             lblResultado.setText(String.format("%.2f", resultado));
 
         } catch (NumberFormatException e) {
             lblResultado.setText("error");
         }
     }
 
     public static void main(String[] args) {
         launch(args);
     }
 }
 
