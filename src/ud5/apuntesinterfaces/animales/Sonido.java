package ud5.apuntesinterfaces.animales;

public interface Sonido {

    int version = 1;
    //clase abstracta - - se cimplementa en las clases que la usan 
    //son por defecto PUBLICOS y ABSTRACTOS 
    void voz();

    default void vozDurmiendo() {
        System.out.println("zzZZZZzzZZz");
    }

    static void bostezo() {
        System.out.println("oooooooooo");
    }
}
