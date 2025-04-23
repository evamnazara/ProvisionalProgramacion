/*E1215. Implementar una aplicación para gestionar las existencias de una tienda de 
repuestos de automóviles. Cada producto se identifica por un código alfanumérico. La 
aplicación permitirá dar de alta o de baja productos y actualizar el número de unidades en 
stock de cada uno de ellos. Los datos se mantendrán en un fichero que deberá 
actualizarse al cerrar el programa. */

package ejerciciosmapas;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class E1215_Existencias {

    public class Producto {
        String codigo;
        String nombre;


        public Producto(String codigo, String nombre) {
            this.codigo = codigo;
            this.nombre = nombre;
        }


        @Override
        public String toString() {
            return codigo + " - " + nombre;
        }

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        //instancia mapa, 
        //si queremos compararlos, TreeMap  da problemas porque odena por clriterio natural de clave 
        Map<Producto,Integer> stock = new TreeMap<>();

        do {
            opcion = opcionMenu();
    
            switch (opcion) {
                case 1:
                System.out.println("codigo:");
                    String codigo=sc.nextLine();
                    System.out.println("nombre:");
                    String nombre=sc.nextLine();
                    System.out.println("unidades: ");
                    Integer unidades = sc.nextInt();
                    //Producto p = new Producto(codigo, nombre);
                    //stock.put(p, unidades);
                    break;
            
                case 2:
                    break;
    
                case 3: 
                    break;
    
                default:
                    break;
            }
        } while (opcion != 0);
       

        
        
    }

    public static int opcionMenu() {
        int opcion;

        System.out.println("STOCK REPUESTOS AUTOMOVIL:");
        Scanner sc = new Scanner(System.in);

        System.out.println("1. dar de alta");
        System.out.println("2. dar de baja");
        System.out.println("3. actualizar número de unidades");
        System.out.println("0. salir");
   
        System.out.println("opción:");
        opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }
}
