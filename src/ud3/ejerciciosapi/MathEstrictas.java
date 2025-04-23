package ud3.ejerciciosapi;

import java.math.BigDecimal;
import java.util.Random;

public class MathEstrictas {
    public static void main(String[] args) {
        double unCentimo = 0.01;
        double suma = unCentimo + unCentimo + unCentimo + unCentimo + unCentimo + unCentimo;
        System.out.println("Suma normal: "+ suma);


        BigDecimal numero = new BigDecimal("0.01");
        BigDecimal sumaPrecisa = new BigDecimal(0);
        sumaPrecisa = sumaPrecisa.add(numero).add(numero).add(numero).add(numero).add(numero).add(numero);
        System.out.println("Suma precisa: " + sumaPrecisa);

        Random numRandom = new Random();
        numRandom.nextInt();

        Random numRandom2 = new Random();

        System.out.println(numRandom2.nextInt());
        System.out.println(numRandom2);
    }
}
