package ud3.repasoexamen;

import java.util.Random;

public class CocheCarreras {
    private String nombre;
    private int velocidadMaxima;
    private int turbosRestantes;
    private int maxTurbos;
    private int autonomiaRestante;
    private int maxAutonomia;
    private int distanciaRecorrida;

    // CONSTRUCTORES
    
    public CocheCarreras(String nombre, int velocidadMaxima, int maxTurbos, int maxAutonomia) {
        //el this se genera para que no se repitan los nombres de parámetro
        this.nombre = nombre; 
        if (velocidadMaxima < 1 || velocidadMaxima > 100)
            throw new IllegalArgumentException("La Velocidad Máxima debe estar entre 1 y 100");
        else
            this.velocidadMaxima = velocidadMaxima;
        this.maxTurbos = maxTurbos < 0 ? 0 : maxTurbos;
        this.maxAutonomia = maxAutonomia < 0 ? 0 : maxAutonomia;

        distanciaRecorrida = 0;
        autonomiaRestante = maxAutonomia;
        turbosRestantes = maxTurbos;
    }

    public CocheCarreras(String nombre, int velocidadMaxima, int maxAutonomia) {
        this(nombre, velocidadMaxima, 3, maxAutonomia);
    } 

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public int getTurbosRestantes() {
        return turbosRestantes;
    }

    public int getAutonomiaRestante() {
        return autonomiaRestante;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    } 

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    // OTROS MÉTODOS

    public int avanzar() {
        Random rnd = new Random();
        int metros = rnd.nextInt(1, velocidadMaxima + 1);
        metros = Math.min(metros, autonomiaRestante);
        autonomiaRestante -= metros;
        distanciaRecorrida += metros;
        return metros;
    }

    public int usarTurbo() {
        int metros = 0;
        if (turbosRestantes > 0) {
            turbosRestantes--;
            metros = (int)(velocidadMaxima * 1.5);
            // TO DO -> Implementar un método privado para evitar repetir el siguiente código
            metros = Math.min(metros, autonomiaRestante);
            autonomiaRestante -= metros;
            distanciaRecorrida += metros;    
        }
        return metros;
    }

    public void repostar() {
        turbosRestantes = maxTurbos;
        autonomiaRestante = maxAutonomia;
    }

    public void reiniciarDistancia() {
        distanciaRecorrida = 0;
    }

    public void mostrar() {
        System.out.println("Coche: " + nombre);
        System.out.println("Velocidad Máxima: " + velocidadMaxima + " mps");
        System.out.println("Turbos: " + turbosRestantes + "/" + maxTurbos);
        System.out.println("Autonomía: " + autonomiaRestante + "/" + maxAutonomia);
        System.out.println();
    }


    // PROGRAMA PRINCIPAL DE EJEMPLO
    public static void main(String[] args) {
        System.out.println("RAYO");
        System.out.println("====");
        CocheCarreras rayo = new CocheCarreras("Rayo", 90, 400);
        rayo.mostrar();
        rayo.avanzar();
        rayo.usarTurbo();
        rayo.mostrar();
        
        System.out.println("TRUENO");
        System.out.println("======");
        CocheCarreras trueno = new CocheCarreras("Trueno", 60, 5, 300);
        trueno.mostrar();
        while (trueno.getAutonomiaRestante() != 0)
            trueno.usarTurbo();
        trueno.mostrar();
        trueno.repostar();
        trueno.mostrar();                
    }
}
