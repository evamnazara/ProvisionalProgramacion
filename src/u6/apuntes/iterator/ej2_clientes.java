package u6.apuntes.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class ej2_clientes {
    public static void main(String[] args) {
        //COMO ELIMINAR UN ELEMENTO EN CONCRETO - NO CON FOREACH

        ArrayList<String> clientes = new ArrayList<>();
        clientes.add("Pepe");
        clientes.add("Toni");
        clientes.add("Marta");
        clientes.add("Sara");
        clientes.add("Toño");

        //borrar una persona 
        Iterator<String> it = clientes.iterator();
        while (it.hasNext()) {
            String cliente = it.next(); //guardamos en cliente el elemento actual (Pepe)
            if (cliente.equals("Marta")) {
                it.remove();                
            }
            //System.out.println(cliente); //aqui sale toni igualmente, aunque en el arraylist ya no este
        }
        System.out.println("ArrayList de clientes, sin Marta");
        System.out.println(clientes); //martan't

        //borrar todos q el nombre empiece por T 

        Iterator<String> it2 = clientes.iterator();

        while (it2.hasNext()) {
            String clienteT = it2.next(); // volvemos  a empezar con el array q guarda el  primer cliente
            if (clienteT.charAt(0) == 'T') {
                it2.remove();
            }
        }
        System.out.println("\n+ sin clientes que empiecen por T: ");
        System.out.println(clientes);

        //este bucle genera excepcion pq se modifica la coleccion en su recorrido 
           /*  for (String c : clientes) {
                if (c.equals("Toni")) {
                    clientes.remove(c);
                }
                System.out.println(c);
            }   */ 

        
    }
}
