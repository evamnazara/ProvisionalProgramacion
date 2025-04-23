package ud1.ejercicios.one20241004;

/* EP0123_ConversionMasa. Escribe un programa que convierta unidades de masa entre kilogramos y libras o viceversa. El programa solicitará al usuario la cantidad de masa y la unidad de medida origen (kilogramos o libras).
1 kilogramo = 1000 gramos
1 libra = 453.592 gramos
El programa deberá manejar las conversiones automáticamente y mostrar el resultado al usuario. Utiliza el operador ternario para evaluar la unidad de medida introducida por el usuario. El programa mostrará por pantalla el resultado con la unidad de medida adecuada.
 */
import java.util.*;

public class EP0123_conversionmasa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        final double GRAMOS_LIBRA = 453.592;

        System.out.println("Este programa convierte Kilogramos a Libras.");
        System.out.println("Primero introduce la cantidad de masa, sin unidades: ");
        double masaOrigen = sc.nextDouble();

        System.out.println("Ahora, introduce la unidad de medida [kilogramos (1) o libras (2)]");
        int unidadMedida = sc.nextInt();

        double resultado = unidadMedida == 1 ? masaOrigen * 1000 / GRAMOS_LIBRA : 
                            masaOrigen * GRAMOS_LIBRA / 1000; //si unidad es 1 es kg y multiplica, si no el contrario
        
        // int conversion = unidadMedida == 1 ? 2 : 1;

    //System.out.println(masaOrigen + (unidadMedida == 1 ? "kg" : "lb") + " equivalen a " + resultado + " " + (conversion == 1 ? "kg" : "lb"));
       //System.out.println("El resultado es %.3f %d" + conversion);
       System.out.println(resultado);
       System.out.printf("El resultado es %.3f %d" + resultado);

        sc.close();

    }
    
}

