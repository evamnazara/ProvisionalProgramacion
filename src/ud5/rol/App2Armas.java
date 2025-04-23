package ud5.rol;

import ud5.rol.inventario.Arma;
import ud5.rol.inventario.Armadura;
import ud5.rol.inventario.Armadura.TipoArmadura;

public class App2Armas {
    public static void main(String[] args) {
        PersonajeEx valkiria = new PersonajeEx("Valkiria", 80);
        PersonajeEx arturo = new PersonajeEx("Arturo", 90);
        
        valkiria.equipar(new Armadura("Yelmo de hierro", 2.0, 500, 5, TipoArmadura.YELMO));
        valkiria.equipar(new Armadura("Cota de Malla", 10.0, 2000, 20, TipoArmadura.ARMADURA));
        valkiria.equipar(new Arma("Espada larga", 3.0, 10000, 60, false));
        valkiria.equipar(new Armadura("Escudo de madera", 5.0, 100, 10, TipoArmadura.ESCUDO));
        
        arturo.equipar(new Armadura("Yelmo de plata", 2.5, 1000, 5, TipoArmadura.YELMO));
        arturo.equipar(new Armadura("Coraza", 15.0, 3000, 30, TipoArmadura.ARMADURA));
        arturo.equipar(new Arma("Espadón a dos manos", 5.0, 1000, 50, true));
        
        System.out.println("2. Armas y Armaduras\n====================\n");
        valkiria.mostrarEquipo();
        arturo.mostrarEquipo();
    }
}
