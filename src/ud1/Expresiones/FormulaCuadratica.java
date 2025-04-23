package ud1.Expresiones;
import java.util.*;

public class FormulaCuadratica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double discriminante = Math.pow(b, 2) -4 * a * c;
        
        System.out.println(discriminante);
        sc.close();
    }
}
