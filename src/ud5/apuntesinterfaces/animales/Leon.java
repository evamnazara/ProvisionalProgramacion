package ud5.apuntesinterfaces.animales;

public class Leon implements Sonido {
    String nombre; 

    @Override
    public void voz() {
        System.out.println("gggRRRR");
        System.out.println("prrrrrr");
    }
    @Override 
    public void vozDurmiendo() {
        System.out.println("Grrrrrrrrrrrrrrrrrrrrrrrrrrrzzzzzzzzzzzzz");
    }
}
