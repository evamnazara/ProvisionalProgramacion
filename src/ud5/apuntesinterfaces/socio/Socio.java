package ud5.apuntesinterfaces.socio;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class Socio implements Comparable { 
    int id; 
    String nombre;
    LocalDate fechaNacimiento;


    public Socio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    

    public Socio(int id, String nombre, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;        
    }
    
    
    
     @Override
     public String toString() {
         return "\nID: " + id + " | Nombre: " + nombre + " | Fecha: " + fechaNacimiento;
     }
    
    
    
        //... 
        @SuppressWarnings("unchecked")
        public static void main(String[] args) {
            Socio s = new Socio(1,"Maria", LocalDate.of(2001, 8, 30));
       
            Socio s2 = new Socio(2, "Lolo", LocalDate.of(1998, 1, 30));
    
            if (s.compareTo(s2) == 0) {
                System.out.println("son iguales");
            } else if (s.compareTo(s2) < 0) {
                System.out.println(s + " es menor ");
            } else {
                System.out.println(s + " es mayor ");
            }
    
    
            System.out.println("array de socios ordenado ");
    
            Socio[] socios = {
                    s, 
                    s2, 
                new Socio (8, "Eva", LocalDate.of(1998, 1, 30)),
                new Socio (4, "Paco", LocalDate.of(1976, 3, 5)),
                new Socio (6, "Laura", LocalDate.of(1998, 9, 30)),
            };
        System.out.println(Arrays.toString(socios));
        Arrays.sort(socios);
        System.out.println(Arrays.toString(socios));

        //COMPARATOR
            //instancia objeto 
        comparaSociosFecha ordenFecha = new comparaSociosFecha();

        System.out.println("COMPARATOR por FECHA DE NACIMIENTO ");
        Arrays.sort(socios, ordenFecha);
        System.out.println(Arrays.toString(socios));


        System.out.println("COMPARATOR por FECHA DE NACIMIENTO al reves");

        Arrays.sort(socios,ordenFecha.reversed());
        System.out.println(Arrays.toString(socios));
    
        //COMPARATOR NOMBRE

        System.out.println("ordenador por nombre");
        comparaSociosNombre ordenNombre = new comparaSociosNombre();
        Arrays.sort(socios,ordenNombre);
        System.out.println(Arrays.toString(socios));

        System.out.println("nombres al reves");
        Arrays.sort(socios, ordenNombre.reversed());
        System.out.println(Arrays.toString(socios));

        //sin implementr objetos 
        //hay q importarlo para usarlo asi 
        System.out.println("por id con otra implementacion ");
        Arrays.sort(socios, new Comparator() {
                @Override
                public int compare (Object o1, Object o2) {
                    return ((Socio) o1).id - ((Socio) o2).id;
                }
        });

    }

    /*@Override 
    public int compareTo(Object o) { 
        //Socio otroSocio = ((Socio) o); es un ejemplo de casteo para entender la comparacion

        int resultado = id - ((Socio) o).id;       
        return resultado;  

        /* si lo pide ordenado al reves

         * int resultado = otroSocio.id - id;
         * 
        
    } */

    //ordena alfabeticamente ascendentemente
    @Override 
    public int compareTo(Object o) {
        Socio socio  = ((Socio) o);
        int res = fechaNacimiento.compareTo(fechaNacimiento);
            if (res == 0) {
                res = this.nombre.compareTo(socio.nombre);
                if (res == 0) {
                    res = this.id = socio.id;
                }
            }
        return fechaNacimiento.compareTo(socio.fechaNacimiento);
        //ORDENAR A LA INVERSA: 
        //return -nombre.compareTo(otroSocio.nombre);
        //return otroSocio.nombre.compareTo(nombre);

    }
}  