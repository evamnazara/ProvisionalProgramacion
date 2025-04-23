package ud1.ejercicios;
import java.util.*;

public class EP0135_ConversionPresion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //conversion en julios 
        final double CAL = 4184;
        final double KWH = 3600000;

        System.out.println("Introduce la cantidad de energía");
        double cantidadOriginal = sc.nextDouble(); sc.nextLine();

        System.out.println("Introduce la medida de energía (julios, calorias o kilovatios-hora):");
        char medidaOriginal = sc.nextLine().charAt(0);

        System.out.println("Introduce la medida a la que los quieres convertir: ");
       // char medidaDestino = sc.nextLine().charAt(0);

        sc.close();

        double cantJulios = medidaOriginal == 'j' ? cantidadOriginal : medidaOriginal == 'c' ? medidaOriginal * CAL : cantidadOriginal * KWH ;

        System.out.println( cantJulios );




    }
    
}
