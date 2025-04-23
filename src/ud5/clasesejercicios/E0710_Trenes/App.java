package ud5.clasesejercicios.E0710_Trenes;

import java.time.LocalDate;

import ud5.clasesejercicios.E0710_Trenes.maquinaria.Locomotora;
import ud5.clasesejercicios.E0710_Trenes.maquinaria.Tren;
import ud5.clasesejercicios.E0710_Trenes.personal.*;


public class App {
    public static void main(String[] args) {
        Maquinista maquinista = new Maquinista("María", "555555555X", 40000, "A");

        Mecanico mecanicoPepe = new Mecanico("Pepe", "666666666", Especialidad.FRENOS);
        //Mecanico mecanico2 = new Mecanico("Juan", "666666666", Especialidad.valueOf("HIDRAULICA"));
        JefeEstacion jefe = new JefeEstacion("Lola", "33333333Z", LocalDate.of(2023, 10, 1));

        // Vagon solo es visible por clases vecinas
        Locomotora locomotora = new Locomotora("1111AAA", 5000, 2010, mecanicoPepe);

        Tren tren = new Tren(locomotora, maquinista);
        //EJEMPLOS DE INSTANCIA 
        /*
        Tren tren2 = new Tren(locomotora, maquinista, 5);

        try {
            Tren tren3 = new Tren(locomotora, maquinista, 50);
        } catch (Exception e) {
            System.out.println("No se puede crear el tren. " + e.getMessage());
        }
        */
        tren.addVagon(1, 10000, 5000, "MADERA");
        tren.addVagon(2, 11000, 5500, "HIERRO");
        tren.addVagon(3, 8000, 6000, "PASAJEROS");
        
        System.out.println(tren.toString());
        System.out.println();

        System.out.println(jefe);
        System.out.println(mecanicoPepe);

    }
}
