package ud5.interfacesejercicios.EP0913_Futbolista;

import java.util.Arrays;


public class AppFutbolista {
    //suprime el warning del Comparable<T>
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Futbolista futbolista1 = new Futbolista("77845674F", "Futbolista F", 25, 11);
        Futbolista futbolista2 = new Futbolista("77845124G", "Futbolista G", 25, 11);

        Futbolista[] futbolistas = {
            new Futbolista("77416510M", "A Futbolista", 14, 5),
            new Futbolista("11589761C", "B Futbolista", 24, 9),
            new Futbolista("74658211B", "C Futbolista", 20, 7),
            new Futbolista("76987510Y", "Z Futbolista", 19, 3),
            new Futbolista("78463610L", "E Futbolista", 18, 4),
        };

        System.out.println(Arrays.toString(futbolistas));
        futbolista1.compareTo(futbolista2);


        System.out.println("Ordenados por DNI: ");
        CompFutDNI comparaFutbol = new CompFutDNI();
        Arrays.sort(futbolistas, comparaFutbol);
        System.out.println(Arrays.toString(futbolistas));

        System.out.println("Ordenados por edad:");
        CompFutEdad comparaFutbol2 = new CompFutEdad();
        Arrays.sort(futbolistas,comparaFutbol2);
        System.out.println(Arrays.toString(futbolistas));


        
    }

}
