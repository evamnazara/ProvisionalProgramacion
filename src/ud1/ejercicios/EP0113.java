package ud1.ejercicios;

/* EP0113. Dado el siguiente polinomio de segundo grado:
    y = ax
    2 + bx + c
    crea un programa que pida los coeficientes a, b y c, así como el valor de x, y calcula el valor
    correspondiente de y.
 */
import java.util.*;

public class EP0113 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el coeficiente A:");
        double coeficienteA = sc.nextDouble();

        System.out.println("Introduce el coeficiente B:");
        double coeficienteB = sc.nextDouble();

        System.out.println("Introduce el coeficiente C:");
        double coeficienteC = sc.nextDouble();

        System.out.println("Introduce el coeficiente X:");
        double coeficienteX = sc.nextDouble();
        
        double primeraPotencia = Math.pow(coeficienteX, 2);
        double valorY = coeficienteA * primeraPotencia + coeficienteB * coeficienteX + coeficienteC;
        System.out.println("El valor correspondiente a Y es: " + valorY);
        sc.close();

    }
    
}
