package ud5.rol;

import java.util.Random;

public class AppCombateSingular {
    public static void main(String[] args) {
        Personaje Levi = new Personaje("Levi Ackerman", Raza.HOBBIT);
        Personaje Zeke = new Personaje("Zeke Jaeger", Raza.TROLL);


        //Personaje Levi = new Personaje("Levi Ackerman", Raza.ENANO, 150, 350, 70, 9, 96, 210);     
        Levi.mostrar();

        //Personaje Zeke = new Personaje("Zeke Jaeger", Raza.TROLL, 360, 190, 120, 10, 100, 180);
        Zeke.mostrar();


        System.out.println("¡Comienza el combate!");

        Random rnd = new Random();
        Personaje atacante, defensor;

        if (Zeke.agilidad > Levi.agilidad) {
            atacante = Levi;
            defensor = Zeke;
        } else if (Zeke.agilidad > Levi.agilidad) {
            atacante = Zeke;
            defensor = Levi;
        } else {
            atacante = (rnd.nextBoolean()) ? Levi : Zeke;
            defensor = (atacante == Levi) ? Zeke : Levi;
        }

        while (Levi.estaVivo() && Zeke.estaVivo()) {
            atacante.atacar(defensor);

            if (!defensor.estaVivo()) {

                System.out.println(defensor.nombre + " ha sido derrotado.");
                break;
            }

            //cambio turnos
            Personaje auxiliar = atacante;

            atacante = defensor;
            defensor = auxiliar;
        }

        System.out.println("=== RESULTADO ===");
        Levi.mostrar();
        Zeke.mostrar();
    }
}
