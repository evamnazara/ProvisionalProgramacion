package ud1.Identificadores;

import java.time.*;


public class api {
    public static void main(String[] args) {
        System.out.println("Numero aleatorio: " + Math.random());

        System.out.println("¿Que numero es menor, 8 o 4? " + Math.min(8, 4));
    
        System.out.println("Resultado de 5 elevado a 8: " + Math.pow(5, 8));

        System.out.println("Hoy es " + LocalDate.now ()  );
        System.out.println("La hora es " + LocalTime.now());


        LocalDateTime ahora;
        ahora = LocalDateTime.now();
        System.out.println("ahora es " + ahora );
        /* al haber guardado la variable se le pueden aplicar métodos que extraen x datos */
        ahora.getDayOfMonth();
        ahora.getHour();
        ahora.getMonthValue();
        ahora.getMinute();

        /* se pueden guardar los métodos dentro de variables int */

        int hora = ahora.getHour();
        int minuto = ahora.getMinute();
        int mes = ahora.getMonthValue();
        int anho = ahora.getYear();

        System.out.println("Son las " + hora + ":" + minuto + " del mes " + mes + " del año " + anho);

    }
}
