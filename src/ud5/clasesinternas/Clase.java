package ud5.clasesinternas;

import java.util.Comparator;
public class Clase { 
    static class ClaseAnidadaEstatica {

    }
    class ClaseInterna{

    }
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        class ClaseInternaLocal {
            @SuppressWarnings("unused")
            int claseIL;
        }

        @SuppressWarnings("unused")
        Comparator claseAnonima = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                return o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());

            }

    
        };
    }
}
