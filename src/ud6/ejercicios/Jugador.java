package ejercicios;
/*EP1237. Queremos gestionar la plantilla de un equipo de fútbol, en la que a cada jugador se le asigna un dorsal que no puede estar repetido. 
Para ello vamos a crear una estructura de tipo Map cuyas entradas corresponden a los jugadores, con el dorsal como clave y un objeto de la clase Jugador como valor. De cada jugador se guarda el DNI, el nombre, la posición en el campo - para simplificar, los jugadores pueden ser porteros, defensas, centrocampistas y delanteros - y su estatura. 
Define la clase Jugador y un enumerado para la posición en el campo, e implementa los siguientes métodos estáticos:

static void altaJugador(Map<Integer, Jugador> plantilla, Integer dorsal, Jugador jugador), que añade una entrada al mapa con el dorsal pasado como parámetro y el jugador creado dentro del método.

static Jugador eliminarJugador(Map<Integer, Jugador> plantilla, Integer dorsal), que elimina la entrada correspondiente al jugador cuyo dorsal se pasa como parámetro. 
Dicho dorsal desaparece del mapa hasta que se asigne a otro jugador por medio de un alta. El método devuelve el jugador eliminado.
static void mostrar (Map<Integer, Jugador> plantilla), que muestra una lista de los dorsales con los nombres de los jugadores correspondientes.
dorsal - jugador
dorsal2 - jugador2
…

static void mostrar (Map<Integer, Jugador> plantilla, String posicion), que muestra una lista de los jugadores que comparten una misma posición. Por ejemplo, todos los defensas o todos los delanteros. 
static boolean editarJugador(Map<Integer, Jugador> plantilla, Integer dorsal, Jugador jugador), que permite modificar los datos de un jugador, excepto su dorsal y su DNI. Devuelve true si el dorsal existe y false en caso contrario. */

import java.util.HashMap;
import java.util.Map;

enum Posicion {
    PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO;
}

public class Jugador {
    private String dni;
    private String nombre;
    private Posicion posicion;
    private Double estatura;

    // Constructor
    public Jugador(String dni, String nombre, Posicion posicion, double estatura) {
        this.dni = dni;
        this.nombre = nombre;
        this.posicion = posicion;
        this.estatura = estatura;
    }

    // getters
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    @Override
    public String toString() {
        return "Jugador: \nDNI: " + dni + "\nNombre: " + nombre + "\nPosicion: " + posicion + "\nEstatura:"
                + estatura;
    }

    static void altaJugador(Map<Integer, Jugador> plantilla, Integer dorsal, Jugador jugador) {
        // Solo añadimos si el dorsal no está ya en uso
        if (!plantilla.containsKey(dorsal)) {
            plantilla.put(dorsal, jugador);
        } else {
            System.out.println("El dorsal ya está asignado.");
        }
    }

    static Jugador eliminarJugador(Map<Integer, Jugador> plantilla, Integer dorsal) {
        return plantilla.remove(dorsal); // funcion de mapa. remove devuelve el objeto eliminado o null si no existe
    }

    static void mostrar(Map<Integer, Jugador> plantilla) {
        for (Map.Entry<Integer, Jugador> entry : plantilla.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    static void mostrar(Map<Integer, Jugador> plantilla, String posicion) {
        Posicion pos;
        try {
            pos = Posicion.valueOf(posicion.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Posición no válida.");
            return;
        }

        // Recorremos el mapa buscando jugadores con esa posición
        for (Map.Entry<Integer, Jugador> entry : plantilla.entrySet()) {
            Jugador jugador = entry.getValue();
            if (jugador.getPosicion() == pos) {
                System.out.println(entry.getKey() + " - " + jugador);
            }
        }
    }

    static void editarJugador(Map<Integer, Jugador> plantilla, Integer dorsal, Jugador jugador) {
        // Buscamos si el dorsal existe en el mapa
        if (plantilla.containsKey(dorsal)) {
            Jugador jugadorExistente = plantilla.get(dorsal);
            // Solo actualizamos nombre, posición y estatura
            jugadorExistente.setNombre(jugador.getNombre());
            jugadorExistente.setPosicion(jugador.getPosicion());
            jugadorExistente.setEstatura(jugador.getEstatura());
        }
    }

    public static void main(String[] args) {
        // antes de nada, hayq eu implementar el hashmap

        Map<Integer, Jugador> plantilla = new HashMap<>();

        // creo 2 jugadores
        // No enclosing instance of type Futbol is accessible. Must qualify the
        // allocation with an enclosing instance of type Futbol (e.g. x.new A() where x
        // is an instance of Futbol). -- se arregla PONIENDO EL STATIC EN LA CLASE
        Jugador j1 = new Jugador("12345678A", "Pedro", Posicion.DEFENSA, 1.82);
        Jugador j2 = new Jugador("12345678A", "Pedro", Posicion.DEFENSA, 1.82);

        Jugador.altaJugador(plantilla, 1, j1);
        Jugador.altaJugador(plantilla, 2, j2);
        Jugador.mostrar(plantilla);
        // es un enum, asi q en la implementacion del metodo se cambia del valor del
        // string
        Jugador.mostrar(plantilla, "defensa");
    }

}