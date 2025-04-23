package ud5.rol.monstruos;

import java.util.Random;

public class Orco extends Monstruo {


    public Orco (String nombre, int ataque, int defensa, int velocidad, int puntosdeVida) {
        super(nombre, ataque, defensa, velocidad, puntosdeVida);
        Random rnd = new Random();

        this.ataque = rnd.nextInt(30,80) + 1;
        this.defensa = rnd.nextInt(30,50) + 1;
        this.velocidad = rnd.nextInt(30,80) + 1;
        this.puntosdeVida = rnd.nextInt(30,100) + 1;
    }

    public Orco (int ataque, int defensa, int velocidad, int puntosdeVida) {
        super(ataque, defensa, velocidad, puntosdeVida);
        Random rnd = new Random();

        this.ataque = rnd.nextInt(30,80) + 1;
        this.defensa = rnd.nextInt(30,50) + 1;
        this.velocidad = rnd.nextInt(30,80) + 1;
        this.puntosdeVida = rnd.nextInt(30,100) + 1;
    }
}
