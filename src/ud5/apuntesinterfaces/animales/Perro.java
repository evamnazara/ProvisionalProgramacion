package ud5.apuntesinterfaces.animales;

public class Perro implements Sonido{
    String nombre;

    @Override
    public void voz() {
        System.out.println("woof");
    }

    
}
