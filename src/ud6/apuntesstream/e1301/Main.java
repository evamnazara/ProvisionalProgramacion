/* 
E1301. Definir una interfaz funcional cuya función abstracta permita generar un saludo 
dirigido al objeto que se le pasa como parámetro. Implementar un saludo para nombres 
(clase String) y otro para clientes (clase Cliente). Aplicarlas a varios casos particulares.  */

package ud6.apuntesstream.e1301;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ud6.apuntescolecciones.Cliente;
import ud6.apuntesstream.ComparaNombres;

public class Main {
    public static void main(String[] args) {
        // definir
        // dirigido a objeto q se pasa > se crea como string
        Saludo<String> saludoString;

        // forma1 - clase anónima
        saludoString = new Saludo<String>() {
            @Override
            public String saludar(String str) {
                return "Hola " + str;
            }
        };

        // forma 2 - equivalente con expresion lambda

        // no tiene pq ser str
        // saludoString = (str) -> {};
        saludoString = (cadena) -> {
            return "Hola " + cadena;
        };

        // importando clase clientes
        Saludo<Cliente> saludoClientes = (c) -> {
            return "Buenos días " + c.getNombre();
        };

        System.out.println(saludoString.saludar("Pepe"));
        System.out.println(saludoClientes.saludar(new Cliente("Maria")));

        // llamada metod e1302
        String[] tString = { "Pepe", "María", "Mercedes" };
        List<String> saludos = saludar(saludoString, tString);
        System.out.println(saludos);


        //metodo con clientes
        Cliente[] tCliente = {
            new Cliente("1", "Pepe", "01/01/2008"), 
            new Cliente("2","María", "01/01/2006"), 
            new Cliente("3","Marcos", "01/01/2000"), 
            new Cliente("4","Ana", "01/01/2005")
            };

        List<String> saludosClientes = saludar((c) -> "Que pasa, " + c.getNombre() + "?", tCliente);
        System.out.println(saludosClientes);

        //E1303 
        


    };

    /*
     * E1302. Utilizando la interfaz Saludo de la Actividad E1301, implementar un
     * método estático que aplique un saludo a un grupo de personas que se le pasa
     * como parámetro en una tabla. Devolverá los saludos en una lista de cadenas.
     * Aplicarlo a una tabla de clientes.
     */

    // METODO E1302

    // obj al q se saluda > tabla de clientes
    static <T> List<String> saludar(Saludo<T> s, T[] t) {
        // declarar la lista
        List<String> saludos = new ArrayList<>();

        for (T elemento : t) {
            saludos.add(s.saludar(elemento));
        }
        return saludos;
    }
    

    /* E1303. 
    Implementar un método estático (max) al que se pasa como parámetro una tabla de tipo genérico y un comparador para dicho tipo. El método devuelve el valor máximo de los elementos de la tabla según el criterio de orden del comparador. Aplicarlo a una tabla de clientes para buscar el de más edad.  */
    //METODO E1303 

    static <T> T max(T[] t, Comparator <T> c) {
        return null;
    }

    Comparator<Cliente> compEdad = new Comparator<Cliente>() {
        @Override
        public int compare(Cliente cl, Cliente c2) {
            return cl.edad().compareTo(c2.edad());
        }
    };

}
