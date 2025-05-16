package ud7.apuntesjavafx.empresas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppEmpresa extends Application {

    static List<Empresa> empresas = new ArrayList<>();
    public static String ficheroEmpresas ="src/ud7/apuntesjavafx/empresas/empresas.csv";
    static Stage stagePrincipal;


    public static void main(String[] args) {
        empresas.add(new Empresa(1, "IES Chan do Monte", "http://ieschandomonte.edu.es/ies/"));

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Empresas");
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(AppEmpresa.class.getResource("Empresa.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        stagePrincipal = primaryStage;
    }

    // metodos para guardar
    static public void guardarFichero(String ruta) {
        // crear un fichero de texto para escritura
        try (BufferedWriter out = new BufferedWriter(new FileWriter(ruta));) {
            // recurrer la lista de empresas
            for (Empresa empresa : empresas) {
                // x cada una generar n string y dividirlo
                // grabar en el fichero los datos de las empresas separados por comar
                String linea = empresa.getId() + "," + empresa.getNombre() + "," + empresa.getWeb();
                out.newLine(); // salto sin mas
                out.write(linea);

            }

        } catch (Exception e) {
            System.out.println("Error de entrada/salida");
        }

        // cerrar ficheros
    }

    static public void cargarFichero(String ruta) {
        // abrir fichwero
        try (BufferedReader in = new BufferedReader(new FileReader(ruta));) {
            // recurrer la lista de empresas
            String linea = in.readLine();
            empresas.clear(); //vacia lista antes de añadir 
            while (linea != null) {
               //contruir empresa
               String[] campos = linea.split(",");
               Empresa empresa = new Empresa (Integer.parseInt(campos[0]), campos[1], campos[2]);
               //ñadir linea a la lista
               //leer otra linea
            }

        } catch (Exception e) {
            System.out.println("Error de entrada/salida");
        }

        // cerrar ficheros
    }

    static public void guardarFicheroDat(String path) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(empresas);
        } catch (Exception e) {
            System.out.println("error de entrada salida");
        }

    }
}
