//Eva María Otero Názara
package ud7.eonexamen.entrenamiento;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Entrenamiento extends Application implements Comparable<Entrenamiento>, Serializable {

    static final String PATHARCHIVO = "src/ud7/eonexamen/entrenamiento/entrenamiento.dat";
    static final String PATHFICHERO = "src/ud7/eonexamen/entrenamiento/entrenamiento.dat";

    static List<Entrenamiento> listaEntrenamientos = new ArrayList<>();
    static Stage stagePrincipal;

    private String corredor;
    private String fecha;
    private double kmRecorridos;

    public Entrenamiento(String corredor, String fecha, double kmRecorridos) {
        this.corredor = corredor;
        this.fecha = fecha;
        this.kmRecorridos = kmRecorridos;
    }

    public String getCorredor() {return corredor;}

    public String getFecha() {return fecha;}

    public double getKmRecorridos() {return kmRecorridos;}

    public void setCorredor(String corredor) {this.corredor = corredor;}

    public void setFecha(String fecha) {this.fecha = fecha; }

    public void setKmRecorridos(double kmRecorridos) { this.kmRecorridos = kmRecorridos; }

    
    @Override
    public void start(Stage primaryStage) throws Exception {
        stagePrincipal = primaryStage;

        primaryStage.setTitle("Entrenamiento");
        primaryStage.setResizable(false);

        Parent root = FXMLLoader.load(getClass().getResource("Entrenamiento.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        /*listaEntrenamientos.add(new Entrenamiento("Corredor 1", "2025/05/28", 4.85));
        listaEntrenamientos.add(new Entrenamiento("Corredor 2", "2025/05/27", 8.85));
        listaEntrenamientos.add(new Entrenamiento("Corredor 3", "2025/05/29", 1.2));
        guardarFichero(PATHARCHIVO);
        mostrarEntrenamientos();
        cargarFichero(PATHARCHIVO);
        System.out.println(listaEntrenamientos);*/

        launch(args);
    }

    static void mostrarEntrenamientos() {
        for (Entrenamiento entrenamiento : listaEntrenamientos) {
            System.out.println(entrenamiento);
        }
    }

   static public void guardarFichero(String path) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(listaEntrenamientos);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado");
        } catch (NotSerializableException e) {
            System.out.println("objerto no serializable");
        } catch (IOException e) {
            System.out.println("Error de E/S al escribir en el archivo");
        } catch (Exception e) {
            System.out.println("Error desconocido al guardar el archivo");
        }
    }

    @SuppressWarnings("unchecked")
    static public void cargarFichero(String path) {
        // Carga un fichero binario para lectura
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            listaEntrenamientos = (List<Entrenamiento>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error de E/S al leer el archivo");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Clase no encontrada");
        } catch (Exception e) {
            System.out.println("Error desconocido al cargar el archivo");
        }
    }

    @Override
    public int compareTo(Entrenamiento o) {
        return this.getFecha().compareTo(o.getFecha());
    }

    @Override
    public String toString() {
        return "Corredor: " + corredor + "Fecha: " + fecha + "Kilometros: " + kmRecorridos;
    }

}
