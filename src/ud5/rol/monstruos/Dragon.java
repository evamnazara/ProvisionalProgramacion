package ud5.rol.monstruos;

import java.util.Random;

public class Dragon extends Monstruo {
    public Dragon (String nombre, int ataque, int defensa, int velocidad, int puntosdeVida) {
        super(nombre, ataque, defensa, velocidad, puntosdeVida);
        Random rnd = new Random();

        this.ataque = rnd.nextInt(100,200) + 1;
        this.defensa = rnd.nextInt(60,100) + 1;
        this.velocidad = rnd.nextInt(80,120) + 1;
        this.puntosdeVida = rnd.nextInt(120,250) + 1;
    }

    public Dragon(int ataque, int defensa, int velocidad, int puntosdeVida) {
        super(ataque, defensa, velocidad, puntosdeVida);
        Random rnd = new Random();

        this.ataque = rnd.nextInt(100,200) + 1;
        this.defensa = rnd.nextInt(60,100) + 1;
        this.velocidad = rnd.nextInt(80,120) + 1;
        this.puntosdeVida = rnd.nextInt(120,250) + 1;
    }
    
}
