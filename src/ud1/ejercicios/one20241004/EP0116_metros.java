package ud1.ejercicios.one20241004;
/* EP0116. Solicita al usuario tres distancias:
La primera, medida en milímetros.
La segunda, medida en centímetros.
La última, medida en metros.

Diseña un programa que muestre la suma de las tres longitudes introducidas (medida en
centimetros).

 */

import java.util.*;

public class EP0116_metros {
    public static void main(String[] args) {
        System.out.println("Este programa solicitará 3 distancias en diferentes unidades.");
        
        System.out.println("Introduce la primera medida, en milímetros:");
        Scanner sc = new Scanner(System.in);
        double mm = sc.nextDouble();
        double mmConvertida = mm / 1000;

        System.out.println("Introduce la segunda medida, en centímetros:");
        double cm = sc.nextDouble();
        double cmConvertida = cm / 100 ;

        System.out.println("Introduce la tercera medida, en metros:");
        double metros = sc.nextDouble();

        double medidaTotal = mmConvertida + cmConvertida + metros;

        System.out.println("La suma de estas medidas, en metros, es igual a " + medidaTotal + " metros.");

        sc.close();
    }

    
}
