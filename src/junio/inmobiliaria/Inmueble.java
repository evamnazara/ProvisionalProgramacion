package junio.inmobiliaria;

public class Inmueble {
    protected String direccion;
    protected int metrosCuadrados;
    protected int numHabitaciones;
    protected int numBanhos;
    protected int precioAlquiler;
    protected int precioVenta;

    public Inmueble(String direccion, int metrosCuadrados, int numHabitaciones, int numBanhos, int precioAlquiler,
            int precioVenta) {
        this.direccion = direccion;
        this.metrosCuadrados = metrosCuadrados;
        this.numHabitaciones = numHabitaciones;
        this.numBanhos = numBanhos;
        this.precioAlquiler = precioAlquiler;
        this.precioVenta = precioVenta;
    }

    public Inmueble(String direccion, int metrosCuadrados, int numHabitaciones, int numBanhos) {
        this.direccion = direccion;
        this.metrosCuadrados = metrosCuadrados;
        this.numHabitaciones = numHabitaciones;
        this.numBanhos = numBanhos;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public int getNumBanhos() {
        return numBanhos;
    }

    public int getPrecioAlquiler() {
        return precioAlquiler;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public void setNumBanhos(int numBanhos) {
        this.numBanhos = numBanhos;
    }

    public void setPrecioAlquiler(int precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String detalle (){
        String detalle = "Inmueble en " + direccion + "(" + metrosCuadrados + "m2, " + numHabitaciones + " habitaciones).";

        return detalle;
    }

    @Override
    public String toString() {
        return "Inmueble en " + direccion + "(" + metrosCuadrados + "m2, " + numHabitaciones + " habitaciones).";
    }

    
    
}
