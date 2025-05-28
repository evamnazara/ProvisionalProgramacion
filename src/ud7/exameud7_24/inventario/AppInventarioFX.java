
/*(2 puntos) El segundo programa, AppInventarioFX.java debe utilizar una interfaz gráfica
que gestione un inventario de productos almacenado en el fichero inventario.dat y que
permita:
● Agregar un nuevo producto al inventario.
● Listar todos los productos del inventario.
● Buscar un producto por su código y mostrar su información.
● Manejar adecuadamente las excepciones, mostrando mensajes de error en la
interfaz gráfica si ocurre algún problema al leer o escribir los ficheros, buscar un
producto. */

package ud7.exameud7_24.inventario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInventarioFX extends Application implements Initializable {

    static final String PATH = "src/ud7/exameud7_24/inventario/inventario.dat";
    static List<Producto> inventario = new ArrayList<>();
    static Stage stagePrincipal;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stagePrincipal = primaryStage;

        primaryStage.setTitle("Inventario");
        primaryStage.setResizable(false);

        //!!!!!OJOOOOOOO
        Parent root = FXMLLoader.load(getClass().getResource("Producto.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    static public void anadirProducto(int cod, String nombre, int cantidad, double precio) {
        // 1. Solicitar al usuario ingresar los datos del producto.
        System.out.println("mete datos");

        // 2. Almacenar el producto en el fichero inventario.dat
        if (buscarProducto(cod) != null || nombre.isEmpty() || nombre == null) {
            System.out.println("f");
        } else {
            inventario.add(new Producto(cod, nombre, cantidad, precio));
            guardarFichero(PATH);
        }

        // 3 No se podrá añadir un producto nuevo si el código ya existe o si elnombre
        // está en blanco.

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //AppInventarioFX.cargarInventario(AppInventarioFX.PATH);
    }
    @FXML
    void cargarInventario(ActionEvent event) {
        AppInventarioFX.cargarFicheroDat(AppInventarioFX.PATH);
    }

    static public void guardarFichero(String path) {
        // Crear un fichero binario para escritura
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(inventario);
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

    private static Producto buscarProducto(int codigoP) {
        for (Producto producto : inventario) {
            if (producto.getCodigo() == codigoP) {
                return producto;
            }
        } 
        return null;
    }

    static public void cargarFicheroDat(String path) {
        // Carga un fichero binario para lectura
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            AppInventarioFX.inventario = (List<Producto>) in.readObject();
            // Type safety: Unchecked cast from Object to List<Empresa>
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

}
