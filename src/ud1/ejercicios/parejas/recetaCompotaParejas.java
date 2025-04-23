//Eva driver, Yago navigator 

package ud1.ejercicios.parejas;

import java.util.*;

public class recetaCompotaParejas {
    public static void main(String[] args) {
        System.out.println("Compota de manzana:");
        System.out.println("Según la receta indicada en https://www.recetasderechupete.com/compota-de-manzana-casera/12509/");
       
        final double MANZANA = 1500;
        final double AGUA = 330;
        final double AZUCAR = 120;
        final double LIMON = 5;
        final int PERSONAS = 6;

        double manzanaPersona = MANZANA / PERSONAS;
        double aguaPersona = AGUA / PERSONAS;
        double azucarPersona = AZUCAR / PERSONAS;
        double limonPersona = LIMON / PERSONAS;

        System.out.println("Las cantidades están pensadas para "+ PERSONAS + " personas, y necesitaremos " + MANZANA + " gramos de manzanas, " + AGUA + " ml de agua, " + AZUCAR + " gramos de azucar "+ LIMON + " ml, aproximadamente 1 cucharadita");

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce a cuantas personas quieres adaptar esta receta: ");
        int personasAdaptadas = sc.nextInt();

        double manzanasFinales = manzanaPersona * personasAdaptadas;
        double aguaFinal = aguaPersona * personasAdaptadas;
        double azucarFinal = azucarPersona * personasAdaptadas;
        double limonFinal = limonPersona * personasAdaptadas; 
        

        System.out.println("Receta adaptada para " + personasAdaptadas + " personas:");
        System.out.println("Necesitarías " + manzanasFinales + "gr de manzanas, " + aguaFinal + "ml de agua, " + azucarFinal+ "mg de azucar, y por último, " + limonFinal + "ml de limon");

        sc.close();
    }
    
}
