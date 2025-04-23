package ud5.rol;

import ud5.rol.inventario.Item;

public class App1Inventario {
    public static void main(String[] args) {
        PersonajeEx Denji = new PersonajeEx("Denji", 50);
        PersonajeEx Mikasa = new PersonajeEx("Mikasa", 67);
        PersonajeEx Okarun = new PersonajeEx("Okarun", 110);
        
        Denji.addToInventario(new Item("Motosierra", 10.0, 3000));
        Denji.addToInventario(new Item("Pochita", 6.0, 200000));

        Okarun.addToInventario(new Item("Gafas", 0.2, 10));

        Mikasa.addToInventario(new Item("Equipo de Maniobras Tridimensionales", 5.0, 2000));
    
        
        System.out.println("1. Inventario de personaje\n==========================\n");
        Denji.mostrarInventario();
        Okarun.mostrarInventario();
        Mikasa.mostrarInventario();

    }
}
