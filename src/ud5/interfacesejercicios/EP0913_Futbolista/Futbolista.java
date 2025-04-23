/*
EP0913_Futbolista. Diseñar la clase Futbolista con los siguientes atributos: dni, 
nombre, edad y número de goles. Implementar: 
 
●  Un constructor y los métodos toString() y equals() (este último basado en el 
DNI).  
●  La interfaz Comparable con un criterio de ordenación basado también en el DNI. 
●  Un comparador para hacer ordenaciones basadas en el nombre y otro basado en la 
edad. 
 
Crear una tabla con 5 futbolistas y mostrarlos ordenados por DNI, por nombre y por edad. 
 
Añade un comparador que ordene los futbolistas por edades y, para aquellos que tienen la 
misma edad, por nombres.  
*/

package ud5.interfacesejercicios.EP0913_Futbolista;

public class Futbolista {
    String dni;
    String nombre;
    Integer edad;
    int numerodeGoles;


    public Futbolista(String dni, String nombre, int edad, int numerodeGoles) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.numerodeGoles = numerodeGoles;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Futbolista other = (Futbolista) obj;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "\nDNI: " + dni + " | Nombre: " + nombre + " | Edad: " + edad + " | Goles: " + numerodeGoles;
    }
    
    public int compareTo(Object o) {
        Futbolista futbolista = (Futbolista) o;
        int res = dni.compareTo(futbolista.dni);
        if (res == 0) {
            res = this.nombre.compareTo(futbolista.dni);
        }
        return res;
    }
    

    

    
}
