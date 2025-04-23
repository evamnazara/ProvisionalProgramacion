package ud5.clasesejercicios.E0710_Trenes.personal;

import java.time.LocalDate;
import java.time.Period;

public class JefeEstacion {
    String nombre;
    String dni;
    LocalDate fechaNombramiento;

    public JefeEstacion(String nombre, String dni, LocalDate fechaNombramiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNombramiento = fechaNombramiento;
    }

    public int getAntiguedad() {
        Period periodo = Period.between(fechaNombramiento, LocalDate.now());
        
        return periodo.getYears();
    }

    @Override
    public String toString() {
        return "JefeEstacion: [nombre=" + nombre + "antiguedad: " + getAntiguedad() + "anños]";
    }

}
