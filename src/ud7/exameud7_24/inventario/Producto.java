/*2. Inventario (4)
Se requiere implementar un programa, AppInventario.java, que administre un inventario de
productos de una tienda utilizando ficheros binarios. El programa deberá permitir agregar
nuevos productos, listar todos los productos y buscar un producto por su código.
Especificaciones:
1. El fichero binario se llamará por defecto inventario.dat.
2. Implementa una clase Producto.java que debe ser serializable y tener los siguentes
atributos:
● codigo (int)
● nombre (String)
● cantidad (int)
● precio (double)
3. Proporciona los constructores y métodos necesarios para acceder y modificar estos
atributos.
4. El programa AppInventario.java deberá mostrar un menú con las siguientes
funcionalidades:
● Agregar un Producto:
● Solicitar al usuario ingresar los datos del producto.
● Almacenar el producto en el fichero inventario.dat.
● No se podrá añadir un producto nuevo si el código ya existe o si el
nombre está en blanco.
● Listar Todos los Productos:
● Mostrará todos los productos del inventario, uno por cada línea,
ordenados ascendentemente por código.
● Buscar un Producto por Código:
● Solicitará al usuario el código del producto a buscar y mostrará la
información del producto si existe, o un mensaje indicando que no se
encontró.
5. Manejo de Excepciones. Manejar adecuadamente las posibles excepciones de E/S
(entrada/salida) mostrando los mensajes adecuados al usuario. */

package ud7.exameud7_24.inventario;

import java.io.Serializable;

public class Producto implements Comparable<Producto>, Serializable {
    private int codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(int codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Codigo:" + codigo + " Nombre:" + nombre + " Cantidad:" + cantidad + " Precio:" + precio;
    }

    @Override
    public int compareTo(Producto o) { // son putos numeros xd
        return this.getCodigo() - (o.getCodigo());

    }

}
