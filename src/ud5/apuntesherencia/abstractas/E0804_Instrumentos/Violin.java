
package ud5.apuntesherencia.abstractas.E0804_Instrumentos;

import java.util.Arrays;

public class Violin extends Instrumento {        
    
    @Override 
    public void interpretar() {
        System.out.println("Violin: " + Arrays.toString(melodia));
    }

}

