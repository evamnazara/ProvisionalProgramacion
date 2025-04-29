package u6.ejerciciosmapas;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*E1215. Implementar una aplicación para gestionar las existencias de una tienda de 
repuestos de automóviles. Cada producto se identifica por un código alfanumérico. La 
aplicación permitirá dar de alta o de baja productos y actualizar el número de unidades en 
stock de cada uno de ellos. */

public class E1215_Existencias {

    // Clase interna Producto que representa un repuesto de automóvil
    public static class Producto implements Comparable<Producto> {
        String codigo;
        String nombre;

        // Constructor
        public Producto(String codigo, String nombre) {
            this.codigo = codigo;
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return codigo + " - " + nombre;
        }

        // Comparamos productos por su código (criterio natural de orden)
        @Override
        public int compareTo(Producto otro) {
            return this.codigo.compareTo(otro.codigo);
        }

        // Sobrescribimos equals para que dos productos con el mismo código se
        // consideren iguales
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Producto producto = (Producto) obj;
            return codigo.equals(producto.codigo);
        }

        // hashCode también basado en el código, coherente con equals
        @Override
        public int hashCode() {
            return codigo.hashCode();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Producto, Integer> stock = new TreeMap<>(); // Mapa ordenado por código del producto

        int opcion;
        do {
            opcion = opcionMenu(sc); // Mostrar menú y leer opción

            switch (opcion) {
                case 1: // Alta de producto
                    System.out.println("Código:");
                    String codigo = sc.nextLine();

                    Producto existente = buscarProducto(stock, codigo);

                    if (existente != null) {
                        // Ya existe, actualizar cantidad
                        System.out.println("Ya existe: " + existente.nombre);
                        System.out.println("Unidades a añadir:");
                        int unidadesExtra = sc.nextInt();
                        sc.nextLine();
                        int total = stock.get(existente) + unidadesExtra;
                        stock.put(existente, total);
                        System.out.println("Unidades actualizadas.");
                    } else {
                        // Producto nuevo
                        System.out.println("Nombre:");
                        String nombre = sc.nextLine();
                        System.out.println("Unidades:");
                        int unidades = sc.nextInt();
                        sc.nextLine();

                        Producto nuevo = new Producto(codigo, nombre);
                        stock.put(nuevo, unidades);
                        System.out.println("Producto añadido.");
                    }
                    break;

                case 2: // Baja de producto
                    System.out.println("Código del producto a eliminar:");
                    String codigoBaja = sc.nextLine();

                    // Buscar producto por código
                    Producto aEliminar = buscarProducto(stock, codigoBaja);
                    if (aEliminar != null) {
                        stock.remove(aEliminar); // Eliminar si existe
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3: // Actualizar unidades de producto existente
                    System.out.println("Código del producto a actualizar:");
                    String codigoAct = sc.nextLine();

                    Producto aActualizar = buscarProducto(stock, codigoAct);
                    if (aActualizar != null) {
                        System.out.println("Nuevas unidades:");
                        int nuevasUnidades = sc.nextInt();
                        sc.nextLine(); // limpiar buffer
                        stock.put(aActualizar, nuevasUnidades); // Reemplazar valor
                        System.out.println("Unidades actualizadas.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4: // Mostrar todos los productos con sus unidades
                    if (stock.isEmpty()) {
                        System.out.println("No hay productos en stock.");
                    } else {
                        System.out.println("Listado de productos:");
                        // Recorremos el mapa y mostramos cada producto con su cantidad
                        for (Map.Entry<Producto, Integer> entry : stock.entrySet()) {
                            System.out.println(entry.getKey() + " | Unidades: " + entry.getValue());
                        }
                    }
                    break;

                case 0: // Salir del programa
                    System.out.println("Saliendo...");
                    break;

                default: // Opción no válida
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 0); // Se repite hasta que el usuario elige salir

        sc.close();
    }

    // Método que muestra el menú y devuelve la opción elegida
    public static int opcionMenu(Scanner sc) {
        int opcion;

        System.out.println("\nSTOCK REPUESTOS AUTOMÓVIL:");
        System.out.println("1. Dar de alta");
        System.out.println("2. Dar de baja");
        System.out.println("3. Actualizar número de unidades");
        System.out.println("4. Mostrar stock");
        System.out.println("0. Salir");
        System.out.print("Opción: ");

        // Validar que el input sea un número
        while (!sc.hasNextInt()) {
            System.out.print("Por favor, introduce un número válido: ");
            sc.next();
        }
        opcion = sc.nextInt();
        sc.nextLine(); // limpiar salto de línea

        return opcion;
    }

    // Método auxiliar para buscar un producto en el mapa por su código
    public static Producto buscarProducto(Map<Producto, Integer> stock, String codigoBuscado) {
        for (Producto p : stock.keySet()) {
            if (p.codigo.equals(codigoBuscado)) {
                return p; // Devolvemos el producto encontrado
            }
        }
        return null; // Si no se encuentra
    }
}
