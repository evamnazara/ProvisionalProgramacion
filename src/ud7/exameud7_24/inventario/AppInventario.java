package ud7.exameud7_24.inventario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppInventario {

    static final String PATH = "src/ud7/exameud7_24/inventario/inventario.dat";
    static List<Producto> inventario = new ArrayList<>();

    public static void main(String[] args) {
        // inventario.add(new Producto(3, "Fantasma", 1, 3.50));
        // guardarFichero(PATH);
        cargarFicheroDat(PATH); // clueless ....................................
        //mostrarInventario();
        Scanner sc = new Scanner(System.in);

        System.out.println("INVENTARIO");
        System.out.println("1. Agregar producto");
        System.out.println("2. Mostrar inventario");
        System.out.println("3. Buscar producto por código");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        switch (opcion) {
            case 1:
                System.out.print("Ingrese código del producto: ");
                int codP = sc.nextInt();
                sc.nextLine(); // buffer

                System.out.print("Ingrese nombre del producto: ");
                String nombreP = sc.nextLine();

                System.out.print("Ingrese cantidad del producto: ");
                int cantidadP = sc.nextInt();

                System.out.print("Ingrese precio del producto: ");
                double precioP = sc.nextDouble();

                anadirProducto(codP, nombreP, cantidadP, precioP);
                break;

            case 2: // Mostrar inventario
                mostrarInventario();
                break;

            case 3: // Buscar producto por código
                System.out.print("Ingrese el código del producto a buscar: ");
                int codigo = sc.nextInt();
                buscarProducto(codigo);
                break;

            default:
                System.out.println("Opción no válida. Intenta de nuevo.");
                break;
        }

        sc.close();
    }

    private static void mostrarInventario() {
        /*
         * Listar Todos los Productos:
         * ● Mostrará todos los productos del inventario, uno por cada línea,
         * ordenados ascendentemente por código.
         */

        for (Producto producto : inventario) {
            System.out.println(producto);
        }
    }

    static public void anadirProducto(int cod, String nombre, int cantidad, double precio) {
        // 1. Solicitar al usuario ingresar los datos del producto.
        // 2. Almacenar el producto en el fichero inventario.dat
        if (buscarProducto(cod) != null || nombre.isEmpty() || nombre == null) {
            System.out.println("f");
        } else {
            System.out.println("no existe ");
            inventario.add(new Producto(cod, nombre, cantidad, precio));
            guardarFichero(PATH);
            //mostrarInventario(); provisional para ver 
        }

        // 3 No se podrá añadir un producto nuevo si el código ya existe o si elnombre
        // está en blanco.

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
        /*
         * Buscar un Producto por Código:
         * Solicitará al usuario el código del producto a buscar y mostrará la
         * información del producto si existe, o un mensaje indicando que no se
         * encontró.
         */
        for (Producto producto : inventario) {
            if (producto.getCodigo() == codigoP) {
                System.out.println("Ya existe: ");
                System.out.println(producto);
                return producto;
            } else {
                return null;
            }
        }
        return null;
    }

    static public void cargarFicheroDat(String path) {
        // Carga un fichero binario para lectura
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            inventario = (List<Producto>) in.readObject();
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
