package ud5.clasesejercicios.E0710_Trenes.personal;

import java.time.LocalDate;
import ud5.clasesejercicios.E0710_Trenes.maquinaria.Locomotora;

public class Mecanico {
    String nombre;
    String telefono;
    Especialidad especialidad;

    public Mecanico(String nombre, String telefono, Especialidad especialidad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "MECÁNICO: \\n [nombre=" + nombre + " \\n" + //
                        "telefono=" + telefono + "\\n" + //
                        "Especialidad=" + especialidad + "]";
    }

    public void revisar(Locomotora locomotora) {
        System.out.println("Le mecanique " + nombre + "Se revisó al locomotora: " + locomotora + "especialidad: " + especialidad + "con fecha" + LocalDate.now());
    }
}
