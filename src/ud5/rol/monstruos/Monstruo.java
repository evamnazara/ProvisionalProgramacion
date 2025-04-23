package ud5.rol.monstruos;

import java.util.Random;

public class Monstruo {
    String nombre;
    int ataque; 
    int defensa;
    int velocidad;
    int puntosdeVida;


    public Monstruo (String nombre, int ataque, int defensa, int velocidad, int puntosdeVida) {

    }
    //constructor para invocar otros monstruos sin nombre
    public Monstruo(int ataque2, int defensa2, int velocidad2, int puntosdeVida2) {
    }

    public void atacar(){

    }

    public boolean estaVivo(){
        boolean estaVivo = true;

        if (puntosdeVida <= 0) {
                estaVivo = false;
            }
        
        return estaVivo;
    }

    public void mostrar() {
        System.out.println("MONSTRUO: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa);
        System.out.println("Velocidad: " + velocidad);
        System.out.println("Puntos de Vida: " + puntosdeVida);
    }

    public boolean perderVida() {
        boolean perderVida = false;

        if (puntosdeVida <= 0) {
            perderVida = true;
            System.out.println("rip");
            return perderVida;
        }

        return perderVida;
    }
    @Override
    public String toString() {
        return "Monstruo: " + nombre + " (" + puntosdeVida + ") ";
    }

   /*
   40% de que sea un Orco 
    30% de que sea una Aranha 
    20% de que sea un Troll 
    10% de que sea un Dragon 
    
    Monstruo generaMonstruoAleatorio()  */ 
    public static Monstruo generaMonstruoAleatorio() {
        Random rdn = new Random();
        double probabilidad = rdn.nextDouble(100); // Genera un número entre 0.0 y 1.0

        if (probabilidad < 40) {
            return new Orco(0, 0, 0, 0);
        } else if (probabilidad < 70) {
            return new Aranha(0, 0, 0, 0);
        } else if (probabilidad < 90) {
            return new Troll(0, 0, 0, 0);
        } else {
            return new Dragon(0, 0, 0, 0);
        }
    }
    
}
