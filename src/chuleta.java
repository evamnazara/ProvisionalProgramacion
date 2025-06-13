import java.util.Random;

public class chuleta {
    public static void main(String[] args) {
        // declarar un numero Random entre X y Y
        int min = 1;
        int max = 100;

        Random random = new Random();
        int rnd = random.nextInt(max - min + 1) + min;

        // System.out.println("Número aleatorio entre " + min + " y " + max + ": " +
        // rnd);

    }
}
