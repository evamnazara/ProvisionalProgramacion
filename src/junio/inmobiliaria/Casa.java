package junio.inmobiliaria;

public class Casa extends Inmueble {
    int metrosTerreno;

    public Casa(String direccion, int metrosCuadrados, int numHabitaciones, int numBanhos, int precioAlquiler, int precioVenta, int metrosTerreno) {
        super(direccion, metrosCuadrados, numHabitaciones, numBanhos, precioAlquiler, precioVenta);
        this.metrosTerreno = metrosTerreno;
    }


    public Casa(String direccion, int metrosCuadrados, int numHabitaciones, int numBanhos, int metrosTerreno) {
        super(direccion, metrosCuadrados, numHabitaciones, numBanhos);
        this.metrosTerreno = metrosTerreno;
    }

    public String detalle (){
        String detalle = "Casa en " + direccion + ".\n" + 
            metrosCuadrados + " m2, " + numHabitaciones + " habitaciones, " + numBanhos + " baños, con terreno de  " + metrosTerreno +"\nPrecio de alquiler: " + precioAlquiler + "\nPrecio de Venta: " + precioVenta; 

        return detalle;
    }



    
}
