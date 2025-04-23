// autora: Otero Názara, Eva María


package ud1.oneexamen;
import java.util.*;

public class CompraConjunta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final double AMIGOS = 3;

        System.out.println("Introduce en euros el precio del artículo a comprar: ");
        double precio = sc.nextDouble();

        System.out.println("Introduce en euros el importe que aporta cada uno: ");
        double aportado = sc.nextDouble();
        sc.close();

        double totalAportado = aportado * AMIGOS;

        String resultado = totalAportado > precio ? "Es suficiente, y " + precio % totalAportado + " euros      pueden ser anhadidos al bote. " :
        "El dinero no es suficiente, faltan " + (precio - totalAportado) + " euros" ;

        System.out.println(resultado);

                         

        



        
    
        
    }
}
