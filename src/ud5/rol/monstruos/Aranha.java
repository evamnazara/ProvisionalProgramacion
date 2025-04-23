package ud5.rol.monstruos;

import java.util.Random;

public class Aranha extends Monstruo {
    public Aranha (String nombre, int ataque, int defensa, int velocidad, int puntosdeVida) {
        super(nombre, ataque, defensa, velocidad, puntosdeVida);
        Random rnd = new Random();

        this.ataque = rnd.nextInt(10,50) + 1;
        this.defensa = rnd.nextInt(20,40) + 1;
        this.velocidad = rnd.nextInt(40,70) + 1;
        this.puntosdeVida = rnd.nextInt(30,80) + 1;
    }

    public Aranha(int ataque, int defensa, int velocidad, int puntosdeVida) {
        super(ataque, defensa, velocidad, puntosdeVida);
        Random rnd = new Random();

        this.ataque = rnd.nextInt(10,50) + 1;
        this.defensa = rnd.nextInt(20,40) + 1;
        this.velocidad = rnd.nextInt(40,70) + 1;
        this.puntosdeVida = rnd.nextInt(30,80) + 1;
    }
}
