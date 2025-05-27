/*2. Inventario (4)
Paquete: inventario
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

public class Inventario {
    
}
