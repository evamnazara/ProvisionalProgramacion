//eva
package ud5.rol;

import java.util.Random;

public class Personaje {
    final int PUNTOS_VIDA_INICIALES = 50;
    Raza raza;
    String nombre;

    int fuerza;
    int agilidad;
    int constitucion;

    int nivel;
    int experiencia;
    int puntosDeVida;
    

    //inicializaciones

    //1. todos los parámetros 
    public Personaje(String nombre, Raza raza, int fuerza, int agilidad, int constitucion, int nivel, int experiencia, int puntosDeVida) {
        this.nombre = nombre;
        this.raza = raza;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.constitucion = constitucion;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.puntosDeVida = puntosDeVida;

        if (fuerza < 1 || agilidad < 1 || constitucion < 1) {
            throw new IllegalArgumentException("Atributos inválidos. ¡Tienen que ser todos mayores a 0!");
        }
        
        //raza válida?
    }

    public Personaje(String nombre, Raza raza, int fuerza, int agilidad, int constitucion, int nivel, int experiencia) {
        this.nombre = nombre;
        this.raza = raza;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.constitucion = constitucion;
        this.nivel = nivel;
        this.experiencia = experiencia;    
    }
    // inicialización 2: nombre y raza > características físicas aleatorias 
    public Personaje(String nombre, Raza raza) {
        Random rnd = new Random();

        this.nombre = nombre;
        this.raza = raza;
        this.fuerza = rnd.nextInt(100) + 1;
        this.agilidad = rnd.nextInt(100) + 1;
        this.constitucion = rnd.nextInt(100) + 1;

        this.nivel = 1;
        this.experiencia = 0;
        this.puntosDeVida = PUNTOS_VIDA_INICIALES + constitucion;

    }

    //inicialización 3: nombre > atributos aleatorios

    public Personaje (String nombre) {
        Random rnd = new Random();

        this.nombre = nombre;
        raza = Raza.HUMANO;

        this.fuerza = rnd.nextInt(100) + 1;
        this.agilidad = rnd.nextInt(100) + 1;
        this.constitucion = rnd.nextInt(100) + 1;

        this.nivel = 1;
        this.experiencia = 0;
        this.puntosDeVida = PUNTOS_VIDA_INICIALES + constitucion;

    }



    //constructor para personajeEx
    public Personaje(String nombre, int constitucion) {
        this.nombre = nombre;
        this.constitucion = constitucion;
    }

    //getter de nombre 
    public String getNombre() {
        return nombre;
    }

    
    public int getPuntosdeVidaActuales() {
        int puntosdeVidaActuales = 0;
        return puntosdeVidaActuales;

    }

   
    public void mostrar() {
        System.out.println("____________________________");
        System.out.println();
        System.out.println("=== INFORMACIÓN DEL PERSONAJE ===");
        System.out.println();
        System.out.println("Nombre: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Fuerza: " + fuerza);
        System.out.println("Agilidad: " + agilidad);
        System.out.println("Constitución: " + constitucion);
        System.out.println("Nivel: " + nivel);
        System.out.println("Experiencia: " + experiencia);
        System.out.println("Puntos de Vida: " + puntosDeVida);
    }

    public void toString(String nombre, int pI, int pA) {
        int puntosdeVidaActuales = getPuntosdeVidaActuales();
        System.out.println(nombre + "("+ puntosDeVida+"/"+ puntosdeVidaActuales +")");
    }

    @Override
    public String toString() {
    return nombre + " (" + puntosDeVida + "/" + getPuntosdeVidaActuales() + ")"; 
    }
        

    //ejercicio 2


    public byte sumarExperiencia(int puntos) {

        int experienciaOriginal = this.experiencia;
        this.experiencia += puntos;
    
        int nivelesSubidos = (this.experiencia / 1000) - (experienciaOriginal / 1000);
    
        if (nivelesSubidos > 0) {
            this.nivel += nivelesSubidos;
            System.out.println("¡Has subido " + nivelesSubidos + " niveles!");
            }
        
            for (int i = 0; i < nivelesSubidos; i++) {
            subirNivel();
            }
    
        return (byte) nivelesSubidos;
    }
    
    //nivel +1 y caracteristicas + 5% 
    public void subirNivel() {
        this.nivel = nivel++;

        this.fuerza = fuerza + (fuerza * 5 / 100);
        this.agilidad = agilidad + (agilidad * 5 / 100);
        this.constitucion = constitucion + (constitucion * 5 / 100);
        System.out.println("El nivel de " + nombre + " ahora es " + this.nivel);
    }
    
    
    //restaura puntos de vida a original menos si son más 
    //pociones? 
    public void curar() {
        int vidaInicial = PUNTOS_VIDA_INICIALES + constitucion;
        if (puntosDeVida >= vidaInicial) {
            System.out.println("No puedes curarte, tus puntos de vida están al máximo.");
        } else {
            puntosDeVida = vidaInicial;
            System.out.println("Te has curado. Tus puntos de vida vuelven a ser " + puntosDeVida);
        }
    }

    //bajan los puntos que toquen, si los puntos llegan o bajan de 0 el personaje muere
    //completar ig
    public boolean perderVida(int puntos) {
        boolean perderVida = false;

            if (puntosDeVida <= 0) {
                perderVida = true;
                System.out.println("rip");
                return perderVida;
            }

        return perderVida;
    }

    public boolean estaVivo(){
        boolean estaVivo = true;

        if (puntosDeVida <= 0) {
                estaVivo = false;
            }
        
        return estaVivo;
    }

    public int atacar(Personaje enemigo) {
        Random rnd = new Random();

        //random 1 a 100 + fuerza 
        int ataque = this.fuerza + rnd.nextInt(100) + 1;
        //random 1 a 100 + agilidad
        int defensa = enemigo.agilidad + rnd.nextInt(100) + 1;

        int danho = ataque - defensa;

        //ajustes
            if (danho < 0) {
                danho = 0; 
                }
            
            if (danho > enemigo.puntosDeVida) {
                danho = enemigo.puntosDeVida;
            }

    
            if (danho > 0) {
                enemigo.perderVida(danho);

                this.sumarExperiencia(danho);
                enemigo.sumarExperiencia(danho);

                System.out.println(enemigo.nombre + " ha sufrido " + danho + " puntos de daño.");

            } else {

                System.out.println(this.nombre + " ataca a " + enemigo.nombre + " pero falla el ataque.");
            }

        return danho;
    }
}
    
