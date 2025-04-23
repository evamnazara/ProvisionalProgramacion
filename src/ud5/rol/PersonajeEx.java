package ud5.rol;

import ud5.rol.inventario.Arma;
import ud5.rol.inventario.Armadura;
import ud5.rol.inventario.Item;

/* 
El número entero de monedas que posee el personaje, que por defecto se inicializará a cero.
El inventario o lista de Items que posee y carga el personaje.
Modifica la visibilidad de los atributos de la superclase o añade getters y setters cuando sea necesario.
 */

class PersonajeEx extends Personaje {
    @SuppressWarnings("unused")
    private int monedas = 0;
    private Item[] inventario;
    private int numItems;
    private final double cargaMaxima;


    Item itemManoIzq; //Arma o Armadura tipo escudo
    Item itemManoDch;
    Armadura armaduraCabeza; // null o Armadura YELMO.
    Armadura armaduraCuerpo; // null o Armadura ARMADURA.
    
    
    // Constructor
    //La carga máxima en kilos que un personaje puede transportar es igual a 50 + Constitución * 2
    public PersonajeEx(String nombre, int constitucion, int monedas, int numItems) {
        super(nombre, constitucion);
        this.monedas = monedas;
        this.inventario = new Item[100];
        this.numItems = numItems;
        this.cargaMaxima = 50 + constitucion * 2;
    }

    public PersonajeEx(String nombre, int constitucion, int monedas) {
        super(nombre, constitucion);
        this.monedas = monedas;
        this.inventario = new Item[100];
        this.numItems = 0;
        this.cargaMaxima = 50 + constitucion * 2;
    }

    public PersonajeEx(String nombre, int constitucion) {
        super(nombre, constitucion);
        this.monedas = 0;
        this.inventario = new Item[100];
        this.numItems = 0;
        this.cargaMaxima = 50 + constitucion * 2;
    }
    
    private double calcularCargaTotal() {
        double cargaTotal = 0;

        for (int i = 0; i < numItems; i++) {
            cargaTotal += inventario[i].getPeso();
        }

        return cargaTotal;
    }


    //devuelve true si el objeto ha podido ser añadido al inventario y false en caso contrario. 
    //un objeto no podrá añadirse si supone superar la carga máxima del personaje.
    public boolean addToInventario(Item item) {
        
        if (calcularCargaTotal() + item.getPeso() > cargaMaxima) {
            return false;
        }
        inventario[numItems++] = item;
        return true;
    }

/* SALIDA DE EJEMPLO A IMITAR: 
    Inventario de Arturo:
    1. Cota de Malla, peso: 10.0 kilos, precio: 2000 monedas
    2. Espada larga, peso: 3.0 kilos, precio: 10000 monedas
 */
    public void mostrarInventario() {
        System.out.println("Inventario de " + getNombre() + ":");
        for (int i = 0; i < numItems; i++) {
            System.out.println((i + 1) + ". " + inventario[i]);
        }
        System.out.println("Carga total transportada: " + calcularCargaTotal() + "/" + cargaMaxima + " kilos\n");
    }
	
    /*  
        manos: Armadura ESCUDO o Arma, menos si es arma a dos manos
        armaduraCabeza: null o Armadura YELMO
        armaduraCuerpo: null o Armadura ARMADURA
     */
    public boolean equipar(Item item) {
       if (item instanceof Arma) {
            Arma arma = (Arma) item;
            if (arma.esDosManos()) {
                if (itemManoIzq == null && itemManoDch == null) {
                    itemManoIzq = itemManoDch = arma;
                    return true;
                }
            } else {
                if (itemManoDch == null) {
                    itemManoDch = arma;
                    return true;
                } else if (itemManoIzq == null) {
                    itemManoIzq = arma;
                    return true;
                }
            }
        } else if (item instanceof Armadura) {
            Armadura armadura = (Armadura) item;
            switch (armadura.getTipo()) {
                case YELMO:
                    if (armaduraCabeza == null) {
                        armaduraCabeza = armadura;
                        return true;
                    }
                    break;
                case ARMADURA:
                    if (armaduraCuerpo == null) {
                        armaduraCuerpo = armadura;
                        return true;
                    }
                    break;
                case ESCUDO:
                    if (itemManoDch == null) {
                        itemManoDch = armadura;
                        return true;
                    } else if (itemManoIzq == null) {
                        itemManoIzq = armadura;
                        return true;
                    }
                    break;
            }
        }
        return false;
    }


    /* SALIDA DE EJEMPLO A IMITAR: 
        2. Armas y Armaduras
        ====================

        Equipo de combate de Valkiria:
        - Yelmo de hierro (+5 defensa)
        - Cota de Malla (+20 defensa)

 */
    public void mostrarEquipo() {

        System.out.println("\nEquipo de combate de " + getNombre() + ":");
        if (armaduraCabeza != null) {
            System.out.println("- " + armaduraCabeza.getNombre() + " (+" + armaduraCabeza.getDefensa() + " defensa)");
         }
        if (armaduraCuerpo != null)  {
            System.out.println("- " + armaduraCuerpo.getNombre() + " (+" + armaduraCuerpo.getDefensa() + " defensa)");
        }
        
        //si el objeto es un arma muestra atauqe
        //si es armadura muestra la defensa 
        if (itemManoDch != null) {
            System.out.print("- " + itemManoDch.getNombre());
                
            if (itemManoDch instanceof Arma) {
                System.out.println(" (+" + ((Arma) itemManoDch).getAtaque() + " ataque)");
                
            } else if (itemManoDch instanceof Armadura) {
                    System.out.println(" (+" + ((Armadura) itemManoDch).getDefensa() + " defensa)");
                    }
        }

        //+ comprueba si hay algo en la izquierda y si es algo de dos manos no lo imprime 
        if (itemManoIzq != null && itemManoIzq != itemManoDch) {
            System.out.print("- " + itemManoIzq.getNombre());
            
            if (itemManoIzq instanceof Arma) {
                System.out.println(" (+" + ((Arma) itemManoIzq).getAtaque() + " ataque)");
            } else if (itemManoIzq instanceof Armadura) {
                System.out.println(" (+" + ((Armadura) itemManoIzq).getDefensa() + " defensa)");
            }
        }
    }
}
