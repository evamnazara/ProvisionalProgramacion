package ud5.practicas.Inmobiliaria;


public class Casa extends Inmueble {
    int metrosTerreno;
     
        public Casa (String direccion, int metrosCuadrados, int numHabitaciones, int numBanhos,  int metrosTerreno) {
            super(direccion,metrosCuadrados,numHabitaciones,numBanhos);
            this.metrosTerreno = metrosTerreno;
        }

        @Override
        public String detalle() {
            String detalle = "Casa en " + direccion + ".\n" + 
            metrosCuadrados + " m2, " + numHabitaciones + " habitaciones, " + numBanhos + " baños, y " 
            + metrosTerreno + " metros de terreno. \nPrecio de venta: " + precioAlquiler +" euros.";
    
            return detalle;
        };

       
    
}
