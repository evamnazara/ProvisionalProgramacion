//4 diciembre

package ud3.ejerciciosclase;

public class E0715 {
    public static void main(String[] args) {

        Calendario fecha = new Calendario(2024,12,31);
        fecha.incrementarDia();

        Calendario fecha2 = new Calendario(2015,1,1);
        System.out.println(fecha.iguales(fecha2));
        
        fecha.incrementarAnho(-2025);
        fecha.mostrar();
        fecha.incrementarAnho(1);
        fecha.mostrar();

        System.out.println("Fin de programa.");
    }
}

