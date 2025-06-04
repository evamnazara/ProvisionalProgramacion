package junio.inmobiliaria;

public class Piso extends Inmueble {
    int planta;

    public Piso(String direccion, int metrosCuadrados, int numHabitaciones, int numBanhos, int precioAlquiler,
            int precioVenta, int planta) {
        super(direccion, metrosCuadrados, numHabitaciones, numBanhos, precioAlquiler, precioVenta);
        this.planta = planta;
    }

    public Piso(String direccion, int metrosCuadrados, int numHabitaciones, int numBanhos, int planta) {
        super(direccion, metrosCuadrados, numHabitaciones, numBanhos);
        this.planta = planta;
    }

    public String detalle (){
        String detalle ="";
        if (precioAlquiler == 0 && precioVenta != 0) {
            detalle = "Piso en " + direccion + ". \n" 
        + metrosCuadrados + "m2, " + numHabitaciones + " habitaciones, " + numBanhos + "baños, " + planta + "ª planta."+"\nPrecio de Venta: " + precioVenta;
        }

        if (precioAlquiler != 0 && precioVenta == 0) {
            detalle = "Piso en " + direccion + ". \n" 
        + metrosCuadrados + "m2, " + numHabitaciones + " habitaciones, " + numBanhos + "baños, " + planta + "ª planta."+"\nPrecio de Alquiler: " + precioAlquiler;
        }

        if (precioAlquiler != 0 && precioVenta != 0) {
            detalle = "Piso en " + direccion + ". \n" 
        + metrosCuadrados + "m2, " + numHabitaciones + " habitaciones, " + numBanhos + "baños, " + planta + "ª planta."+"\nPrecio de alquiler: " + precioAlquiler + "\nPrecio de Venta: " + precioVenta;
        }
        
        

        return detalle;
    }
}
