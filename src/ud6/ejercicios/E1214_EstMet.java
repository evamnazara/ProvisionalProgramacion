package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
E1214_EstMet. Implementar una aplicación que simula el registro de las temperaturas, a lo largo de un dia, en una estación meteorológica. La aplicación mostrará un menú con las opciones:
Nuevo registro (que introduciremos manualmente, aunque se supone que, en el sistema original estaria controlado por un reloj). Cada registro constará de la temperatura en grados centígrados y la hora, que se leerá del sistema (por consola) en el momento de la creación del registro.
Listar registros.
Mostrar estadistica (con los valores máximo. mínimo y promedio de las temperaturas registradas hasta el momento desde la primera lectura del día).
Salir. */
/*EP1234. Amplía la Actividad E1214, de forma que se gestionen los registros de temperatura de diferentes días en la misma aplicación. 
Para ello, implementa un mapa cuyas entradas tendrán como clave la fecha y como valor el conjunto con los registros de un dia. 
Implementa también un programa que gestione los registros del dia actual y permita visualizar los de un día cualquiera, junto con sus estadísticas.  */

public class E1214_EstMet {

    // Clase interna para representar un registro de temperatura
    static class Registro {
        private double temperatura;
        private String hora;

        public Registro(double temperatura, String hora) {
            this.temperatura = temperatura;
            this.hora = hora;
        }

        public double getTemperatura() {
            return temperatura;
        }

        public String getHora() {
            return hora;
        }

        @Override
        public String toString() {
            return "Hora: " + hora + " | Temperatura: " + temperatura + "°C";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Registro> registros = new ArrayList<>();
        int opcion;

        do {
            // Mostrar menú
            System.out.println("\n--- Estación Meteorológica ---");
            System.out.println("1. Nuevo registro");
            System.out.println("2. Listar registros");
            System.out.println("3. Mostrar estadística");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    // Opción 1: Nuevo registro
                    System.out.print("Introduzca la temperatura (°C): ");
                    double temp = scanner.nextDouble();
                    scanner.nextLine(); // Consumir salto de línea
                    System.out.print("Introduzca la hora del registro (ej. 14:30): ");
                    String hora = scanner.nextLine();

                    Registro nuevo = new Registro(temp, hora);
                    registros.add(nuevo);
                    System.out.println("Registro añadido correctamente.");
                    break;

                case 2:
                    // Opción 2: Listar registros
                    if (registros.isEmpty()) {
                        System.out.println("No hay registros.");
                    } else {
                        System.out.println("Registros guardados:");
                        for (Registro r : registros) {
                            System.out.println(r);
                        }
                    }
                    break;

                case 3:
                    // Opción 3: Mostrar estadísticas
                    if (registros.isEmpty()) {
                        System.out.println("No hay registros para mostrar estadísticas.");
                    } else {
                        double max = Double.MIN_VALUE;
                        double min = Double.MAX_VALUE;
                        double suma = 0;

                        for (Registro r : registros) {
                            double t = r.getTemperatura();
                            if (t > max)
                                max = t;
                            if (t < min)
                                min = t;
                            suma += t;
                        }

                        double promedio = suma / registros.size();

                        System.out.printf("Máxima: %.2f°C\n", max);
                        System.out.printf("Mínima: %.2f°C\n", min);
                        System.out.printf("Promedio: %.2f°C\n", promedio);
                    }
                    break;

                case 4:
                    System.out.println("Saliendo de la aplicación.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}
