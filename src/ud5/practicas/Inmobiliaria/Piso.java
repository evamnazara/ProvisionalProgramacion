package ud5.practicas.Inmobiliaria;

public class Piso extends Inmueble{
    int planta;

    public Piso(String direccion, int metrosCuadrados, int numHabitaciones, int numBanhos, int precioVenta,
            int precioAlquiler, int planta) {
        super(direccion, metrosCuadrados, numHabitaciones, numBanhos);
        this.planta = planta;
    }

    public Piso(String direccion, int metrosCuadrados, int numHabitaciones, int numBanhos, int planta) {
        super(direccion, metrosCuadrados, numHabitaciones, numBanhos);
        this.planta = planta;
    }

    @Override
    public String detalle() {
        String detalle = ""; 
        if (precioAlquiler == 0 && precioVenta == 0) { 
            detalle = "Piso en " + direccion + ".\n" 
                        + metrosCuadrados + " m2, " + numHabitaciones + " habitaciones, " + numBanhos + " baños, " + planta + "ª planta.";

        } else if (precioAlquiler != 0 ) {
            detalle = "Piso en " + direccion + ".\n" + 
                    metrosCuadrados + " m2, " + numHabitaciones + " habitaciones, " + numBanhos + " baños, " + planta 
                    + "ª planta. \nPrecio de alquiler:" + precioAlquiler +" euros.";

        } else if (precioVenta != 0) {
            detalle = "Piso en " + direccion + ".\n" 
                    + metrosCuadrados + " m2, " + numHabitaciones + " habitaciones, " + numBanhos + " baños, " + planta 
                    + "ª planta. \nPrecio de venta:" + precioVenta +" euros.";

        } else if (precioAlquiler != 0 && precioVenta != 0) {
            detalle = "Piso en " + direccion + 
            ".\n" + metrosCuadrados + " m2, " + numHabitaciones + " habitaciones, " + numBanhos + " baños, " 
        + planta + "ª planta. \nPrecio de alquiler:" + precioAlquiler +" euros.\n Precio de venta: " + precioVenta;

        }

        System.out.println(detalle);
        
        return detalle;
    };

    
}
