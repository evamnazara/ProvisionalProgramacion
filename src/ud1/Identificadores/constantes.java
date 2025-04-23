package ud1.Identificadores;

public class constantes {
    public static void main(String[] args) {
        System.out.println("Programa de inicio e impresion de constantes");

        final int ALUMNOS_MATRICULADOS = 32;
        final int NUMERO_SESIONES = 288;
        final int SESIONES_SEMANALES = 9;
        final int MESES_AÑO = 12;
            /* hay que declarar el tipo de valor (int para todos) */

        System.out.println("En DAM hay " + ALUMNOS_MATRICULADOS + " alumnos matriculados");
        System.out.println("Hay " + NUMERO_SESIONES + " durante el curso");
        System.out.println("Repartidas en " + SESIONES_SEMANALES + " sesiones a la semana");
        System.out.println("Hay " + MESES_AÑO + " meses en el año" );
    }
}
