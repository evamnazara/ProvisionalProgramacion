//corregir xd 
package ud1.oneexamen;

import java.util.Scanner;

public class AreaPerimetroCorreccion {
     public static void main(String[] args) {
        // Perímetro círculo = 2 𝑥 𝑃𝐼 𝑥 𝑅
        // Área círculo = 𝑃𝐼 𝑥 𝑅2
        Scanner sc = new Scanner(System.in);

        final int CARRERA = 21097;

        System.out.println("Introduce, en metros, el largo del terreno");
        double largo = sc.nextDouble();

        System.out.println("Ahora, introduce el ancho del terreno: ");
        double ancho = sc.nextDouble();
        
        sc.close();

        double radioCirculo = ancho / 2;
        double areaCirculo = Math.PI * radioCirculo * radioCirculo;
        double perimetroCirculo = 2 * Math.PI * radioCirculo;
        // double longitudRectangulo = largo - radioCirculo;
        double areaRectangulo = ancho * (largo - perimetroCirculo);

        double areaTotal = areaCirculo + areaRectangulo;

        System.out.println("El perímetro del círculo son  " + perimetroCirculo + " metros, y su área es es " + areaCirculo + " metros");
        System.out.println("El área del rectángulo son " + areaRectangulo + " metros.");
        System.out.println("El área total del terreno son " + areaTotal + " metros.");
        

        double vueltas = CARRERA / areaTotal;
        double restoVueltas = CARRERA % areaTotal;
            //math.ceil
        System.out.println("Para una media maratón en este terreno, los participantes darán " + (int)vueltas + " vueltas y tendrán que hacer " + (int)restoVueltas + " metros a mayores. ");

     }
}
