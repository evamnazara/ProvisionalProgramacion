package ud5.interfacesejercicios.EP0931_Llamada;

import java.time.LocalDateTime;

public class AppLlamada {
    public static void main(String[] args) {
       Llamada llamada1 = new Llamada("666777444", "666555888", true, LocalDateTime.of(2025, 3, 14, 12, 0), LocalDateTime.of(2025, 3, 14, 12, 30), Llamada.ZonaInterlocutor.ZONA1);
       Llamada llamada2 = new Llamada("666777444", "666111222", false, LocalDateTime.of(2025, 3, 14, 13, 0), LocalDateTime.of(2025, 3, 14, 13, 20), Llamada.ZonaInterlocutor.ZONA3);
       Llamada llamada3 = new Llamada("666888999", "666777444", true, LocalDateTime.of(2025, 3, 14, 14, 0), LocalDateTime.of(2025, 3, 14, 14, 10), Llamada.ZonaInterlocutor.ZONA5);

       System.out.println(llamada1);
       System.out.println(llamada2);
       System.out.println(llamada3);

       System.out.println(llamada1.compareTo(llamada2));
       
       System.out.println(llamada1.equals(llamada1));
       System.out.println(llamada1.equals(llamada3));

    }
}
