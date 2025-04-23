package ud4.ejercicios;

import java.util.Random;
import java.util.Scanner;

public class BuscaTesouro {
    public static void main(String[] args) {

        final int MAX_FILA_COLUMNA = 40;
        System.out.println(" BUSCA EL TESORO.");
        System.out.println("_________________");

        System.out.println("Numero de filas:");
        int numFilas = leerEntero(2, MAX_FILA_COLUMNA);

        System.out.println("Numero de columnas:");
        int numColumnas = leerEntero(2, MAX_FILA_COLUMNA);


        Random rnd = new Random();
        int filaTesoro = rnd.nextInt(numFilas);
        int columnaTesoro = rnd.nextInt(numColumnas);

        final int MAX_INTENTOS = numColumnas * numColumnas / 10;
        int intentos = 0;
        boolean tesoroEncontrado = false;

        do {
            
            System.out.printf("Fila (0 - %d): ", numFilas - 1);
            int fila =leerEntero(intentos, MAX_INTENTOS);

            System.out.printf("Columna(0 - %d): ", numColumnas - 1);
            int columna =leerEntero(intentos, MAX_INTENTOS);

            intentos++;

                //comprobar coordenadas
            if (fila == filaTesoro && columna == columnaTesoro) {
                    tesoroEncontrado = true;
            } else {
                //`pista
                @SuppressWarnings("unused")
                String pista; 

                if (fila == filaTesoro) {
                    pista = columna < columnaTesoro ? "Más al Este" : "Más al Oeste";
                } else if (fila < filaTesoro) {
                    if (columna == columnaTesoro) {
                        pista = "Más al ";
                    } else {
                        pista = columna < columnaTesoro ? "Sureste" : "Suroeste";
                    }
                } else {
                    if (columna == columnaTesoro) {
                        pista = "Más al norte";
                    } else {
                        pista = columna < columnaTesoro ? "Sur" : "Norte";
                    }
                }
            }

        } while (intentos < MAX_INTENTOS && !tesoroEncontrado);

        if (tesoroEncontrado) {
            System.out.println("Enhorabuena!! Has encotnraod el tesoro en " + intentos + " intentos.");
        } else {
            System.out.println("Has perdido. Has agotado el máximo de intentos.");
        }

    }


    private static int leerEntero(int min, int max) {
        int num = -1;;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        boolean numCorrecto = false;

        do {
            try {
                num = sc.nextInt();
                    if (num < min || num > max) {
                     System.out.println("Entero entre " + min + " y " + max );   
                    } else {
                        numCorrecto = true;
                    }
            } catch (Exception e) {
                System.out.println("Entero entre " + min + " y " + max );            
                sc.nextLine();
            }
        } while (!numCorrecto);

        return num;
    }
}
