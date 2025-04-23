package ud3.ejerciciosapi;

public class Esfera {
    public static void main(String[] args) {
        double random = Math.random() * 720 - 360;
        System.out.println("Numero aleatorio" + random);

        double volumenEsfera = 4 / 3 * Math.PI * Math.pow(random,3);
        System.out.println("Volumen de esfera:" + volumenEsfera);
        double volumenEsferaRedondeado = Math.round(volumenEsfera);
        System.out.println(volumenEsferaRedondeado);
    }
}
