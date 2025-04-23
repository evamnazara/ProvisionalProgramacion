package ud1.ejercicios.parejas;


import java.util.Scanner;

public class unidadesMedidas {

    public static void main(String[] args) {
        
        double m2CamposFutbol = 105 * 70;
        double m2CanchaBaloncesto = 28 * 15;
        double m2PistaTenis = 23.77 * 10.97;
        double m2ParqueRetiro = 125 * 10000;


        Scanner sc = new Scanner(System.in);
        System.out.println("Dime cuantas hectareas hay que calcular");
        double ht = sc.nextDouble();
        sc.close();

        double m2 = ht * 10000; //conversion de las hectareas a metros cuadrados 

        double numCamposFutbol = m2 / m2CamposFutbol;
        double numCanchaBaloncesto = m2 / m2CanchaBaloncesto;
        double numPistaTenis = m2 / m2PistaTenis;
        double numParqueRetiro = m2 / m2ParqueRetiro;
        
        System.out.printf("%.2f hectareas es igual a:\n", ht);
                    //printf + "", var, var;
        System.out.printf("%.2f campos de fútbol\n", numCamposFutbol);
        System.out.printf("%.2f canchas de baloncesto\n", numCanchaBaloncesto);
        System.out.printf("%.2f pistas de tenis\n", numPistaTenis);
        System.out.printf("%.2f parques del Retiro\n", numParqueRetiro);

    }
}