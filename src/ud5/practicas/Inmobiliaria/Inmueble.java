//con ejercicio 2 
package Inmobiliaria;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("rawtypes")
public abstract class Inmueble implements Comparable {
    String direccion;
    Integer metrosCuadrados;
    int numHabitaciones;
    int numBanhos;
    int precioVenta;
    int precioAlquiler;


    public Inmueble(String direccion, int metrosCuadrados, int numHabitaciones, int numBanhos, int precioVenta,
            int precioAlquiler) {
        this.direccion = direccion;
        this.metrosCuadrados = metrosCuadrados;
        this.numHabitaciones = numHabitaciones;
        this.numBanhos = numBanhos;
        this.precioVenta = precioVenta;
        this.precioAlquiler = precioAlquiler;
    }

    public Inmueble(String direccion, int metrosCuadrados, int numHabitaciones, int numBanhos) {
        this.direccion = direccion;
        this.metrosCuadrados = metrosCuadrados;
        this.numHabitaciones = numHabitaciones;
        this.numBanhos = numBanhos;
    }
    
    public void setPrecioAlquiler(int precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }
         

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    
    @Override
    public String toString() {
        return "Inmueble en direccion " + direccion + ", ("+ metrosCuadrados + " m2, " + numHabitaciones + " habitaciones";
    }

    public abstract String detalle();

    //EJERCICIO 2 
    public static void mostrarInmuebles(Inmueble[] t) {
        for (Inmueble inmueble : t ) {
           System.out.println(inmueble.toString());
        }

    }
    // Ordena Inmuebles por m2 (de mayor a menor) 
    @SuppressWarnings("unchecked")
    public void sortMetrosDesc(Inmueble[] t){
        Arrays.sort(t, new CompInmM2().reversed());
    }; 
 
    //Ordena Inmuebles por numHabitaciones y luego por m2 (de mayor a menor) 
    @SuppressWarnings("unchecked")
    public void sortHabMetrosDesc(Inmueble[] t){
        Comparator ComparaHabitaciones = new Comparator() {
            @Override

            public int compare(Object o1, Object o2) {
                Inmueble inmueble1 = ((Inmueble) o1);
                Inmueble inmueble2 = ((Inmueble) o2);
                int res = inmueble2.numHabitaciones - inmueble1.numHabitaciones;

                if (res == 0) {
                    res = inmueble2.metrosCuadrados - inmueble1.metrosCuadrados;
                }
                return res;
            }
        };  

        Arrays.sort(t,ComparaHabitaciones);

        //Arrays.sort(t,ComparaHabitaciones.thenComparing(metrosCuadrados));

    }; 
 
    //Ordena Inmuebles por precio Alquiler (de menor a mayor). (¿Y qué pasa con los inmuebles que no se ofrecen en alquiler?) 
    public void sortPrecioAlquilerAsc(Inmueble[] t){}; 
 
    //Ordena Inmuebles por precio Venta (de menor a mayor). (¿Y qué pasa con los inmuebles que no se ofrecen en venta?) 
    public void sortPrecioVentaAsc(Inmueble[] t){}; 

    @Override
    public int compareTo(Object o) {
        Inmueble inmueble = (Inmueble) o;
        int res = direccion.compareTo(inmueble.direccion);
        if (res == 0) {
            res = this.direccion.compareTo(inmueble.direccion);
        }
        return res;
    
}

}
