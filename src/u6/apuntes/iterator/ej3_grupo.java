package u6.apuntes.iterator;

import java.util.ArrayList;
import java.util.Iterator;

//clase q implementa Iterable 
public class ej3_grupo {

    //Clase raiz alumno 
    public class Alumno {
        public String nombre;
        public String dni;
        public int edad;

        public Alumno(String nombre, String dni, int edad) {
            this.nombre = nombre;
            this.dni = dni;
            this.edad = edad;
        }

        public Alumno(String nombre) {
            this.nombre = nombre;
        }

    }

    //ahora, la clase grupo implementa un Iterator de ALUMNOS para hacer x cosas
    public class Grupo implements Iterable<Alumno> {
        public String nombre;
        public ArrayList<Alumno> alumnos;

        //obligatorio implementar el metodo
        //ahora se puede recorrer el arraylist de grupo de alumnos
        @Override
        public Iterator<Alumno> iterator() {
           return new IteratorGrupo(); 
        }
        //se crea una clase interna q implementa Iterator y devuelve una instancia de esa clase
        private class IteratorGrupo implements Iterator<Alumno> {
            private int posicion = 0; 
            public boolean hasNext() {
                return posicion < alumnos.size();
            }
            public Alumno next() {
                return alumnos.get(posicion++);
            }
        }
        

    }
    
}
