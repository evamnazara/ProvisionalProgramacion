package ud5.rol.monstruos;

import java.util.Random;

public class Troll extends Monstruo {
    
    public Troll (String nombre, int ataque, int defensa, int velocidad, int puntosdeVida) {
        super(nombre, ataque, defensa, velocidad, puntosdeVida);
        Random rnd = new Random();

        this.ataque = rnd.nextInt(60,120) + 1;
        this.defensa = rnd.nextInt(50,70) + 1;
        this.velocidad = rnd.nextInt(20,40) + 1;
        this.puntosdeVida = rnd.nextInt(100,200) + 1;
    }

    public Troll(int ataque, int defensa, int velocidad, int puntosdeVida) {
        super(ataque, defensa, velocidad, puntosdeVida);
        Random rnd = new Random();

        this.ataque = rnd.nextInt(60,120) + 1;
        this.defensa = rnd.nextInt(50,70) + 1;
        this.velocidad = rnd.nextInt(20,40) + 1;
        this.puntosdeVida = rnd.nextInt(100,200) + 1;   
     }
}
