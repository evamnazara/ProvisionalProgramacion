package junio;

public class Cafetera {
    private int capacidad;
    private int cantidadActual;

    private final int CAPACIDAD_MAXIMA = 1000;
    private final int CAPACIDAD_MINIMA = 50;


    // Constructor predeterminado: establece la capacidad máxima en 1000 (c.c.) y la
    // actual en cero (cafetera vacía).
    public Cafetera() {
        this.capacidad = CAPACIDAD_MAXIMA;
        this.cantidadActual = 0;
    }

    // Constructor con la capacidad máxima de la cafetera como parámetro; inicializa
    // la cantidad actual de café igual a la capacidad máxima.
    public Cafetera(int cantidadActual) {
        this.capacidad = CAPACIDAD_MAXIMA;
        this.cantidadActual = cantidadActual;
    }

    // Constructor con la capacidad máxima y la cantidad actual como parámetros. Si
    // la cantidad actual es mayor que la capacidad máxima de la cafetera, la
    // ajustará al máximo.

    public Cafetera(int capacidad, int cantidadActual) {
        this.capacidad = capacidad;
        if (capacidad > CAPACIDAD_MAXIMA) {
            this.capacidad = CAPACIDAD_MAXIMA;
        }
        
        if (this.cantidadActual < 0) {
            this.cantidadActual = 0;
        }
        else {
            this.cantidadActual = cantidadActual;
        }
        
    }

    // Setter para cantidadActual y getters para los dos atributos.
    public int getCapacidad() {
        return capacidad;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    // hace que la cantidad actual sea igual a la capacidad.
    public void llenarCafetera() {
        cantidadActual = CAPACIDAD_MAXIMA;
    }

    public void servirTaza(int capacidadTaza) {
        if (capacidadTaza < cantidadActual) {
            capacidadTaza = cantidadActual;
        } else {
            cantidadActual =- capacidadTaza;
        }
    }

    public void vaciarCafetera() {
        cantidadActual = 0;
    }

    public void agregarCafe(int cantidad) {
        if (cantidad + cantidadActual > CAPACIDAD_MAXIMA) {
            cantidad = CAPACIDAD_MAXIMA;
        } else {
            cantidadActual+= cantidad;
        }
    }

    public void mostrar() {
        System.out.println("Cafetera: " + cantidadActual + "/" +  capacidad  + "cc. "); 
    }

    @Override
    public String toString() {
        return "Cafetera: " + CAPACIDAD_MAXIMA;
    }

    public static void main(String[] args) {
        Cafetera cafeteraBasica = new Cafetera();
        Cafetera cafeteraPequenha = new Cafetera(500);
        Cafetera cafeteraGrande = new Cafetera(2000, 1500);

        cafeteraBasica.mostrar();
        cafeteraBasica.llenarCafetera();
        cafeteraBasica.servirTaza(150);
        cafeteraBasica.mostrar();

        cafeteraPequenha.mostrar();
        for (int i = 0; i < 4; i++)
            cafeteraPequenha.servirTaza(150);
        cafeteraPequenha.mostrar();

        cafeteraGrande.mostrar();
        cafeteraGrande.vaciarCafetera();
        cafeteraGrande.agregarCafe(200);
        cafeteraGrande.mostrar();

    }
}
