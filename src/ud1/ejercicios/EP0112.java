package ud1.ejercicios;

    /*. Crea un programa que pida la base y la altura de un triángulo y muestre su área. */
    import java.util.*;

public class EP0112 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la base de tu triángulo:");
        double base = sc.nextDouble();

        System.out.println("Introduce la altura de tu triángulo:");
        double altura = sc.nextDouble();

        double areaTriangulo = (base * altura) / 2;

        System.out.println("El area del triangulo es igual a " + areaTriangulo);

        sc.close();
    }
}
