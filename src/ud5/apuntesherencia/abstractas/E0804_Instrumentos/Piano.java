package ud5.apuntesherencia.abstractas.E0804_Instrumentos;

import java.util.Arrays;

public class Piano extends Instrumento {        
    
    @Override 
    public void interpretar() {
        System.out.println("Piano: " + Arrays.toString(melodia));
    }

    
    public static void main(String[] args) {
        Piano piano1 = new Piano();
        piano1.interpretar();
    }
}
