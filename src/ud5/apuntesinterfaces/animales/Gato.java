package ud5.apuntesinterfaces.animales;

public class Gato implements Sonido {

    @Override
    public void voz() {
        System.out.println("miau");
        System.out.println("prrrrrr");
    }
}
