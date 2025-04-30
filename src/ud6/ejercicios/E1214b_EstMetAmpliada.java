package ejercicios;

import java.time.LocalDate;
import java.util.*;

public class E1214b_EstMetAmpliada {
    // Clase interna
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
        Map<LocalDate, List<Registro>> registrosPorFecha = new HashMap<>();
        LocalDate hoy = LocalDate.now();

        int opcion;

        do {
            // Menú principal
            System.out.println("\n--- Estación Meteorológica ---");
            System.out.println("Fecha actual: " + hoy);
            System.out.println("1. Nuevo registro (hoy)");
            System.out.println("2. Listar registros del día actual");
            System.out.println("3. Mostrar estadísticas del día actual");
            System.out.println("4. Consultar registros de otro día");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    // Añadir registro al día actual
                    System.out.print("Introduzca la temperatura (°C): ");
                    double temp = scanner.nextDouble();
                    scanner.nextLine(); // Consumir salto de línea
                    System.out.print("Introduzca la hora del registro (ej. 14:30): ");
                    String hora = scanner.nextLine();

                    Registro nuevo = new Registro(temp, hora);
                    // registrosPorFecha.computeIfAbsent(hoy, k -> new ArrayList<>()).add(nuevo);
                    if (!registrosPorFecha.containsKey(hoy)) {
                        registrosPorFecha.put(hoy, new ArrayList<>());
                    }
                    registrosPorFecha.get(hoy).add(nuevo);

                    System.out.println("Registro añadido correctamente.");
                    break;

                case 2:
                    // Listar registros del día actual
                    mostrarRegistrosDeFecha(hoy, registrosPorFecha);
                    break;

                case 3:
                    // Mostrar estadísticas del día actual
                    mostrarEstadisticasDeFecha(hoy, registrosPorFecha);
                    break;

                case 4:
                    // Consultar registros y estadísticas de otra fecha
                    System.out.print("Introduce la fecha (formato AAAA-MM-DD): ");
                    String fechaStr = scanner.nextLine();
                    try {
                        LocalDate fechaConsultada = LocalDate.parse(fechaStr);
                        mostrarRegistrosDeFecha(fechaConsultada, registrosPorFecha);
                        mostrarEstadisticasDeFecha(fechaConsultada, registrosPorFecha);
                    } catch (Exception e) {
                        System.out.println("Fecha inválida. Asegúrese del formato correcto.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo de la aplicación.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 5);

        scanner.close();
    }

    // Método para mostrar registros de una fecha concreta
    private static void mostrarRegistrosDeFecha(LocalDate fecha, Map<LocalDate, List<Registro>> mapa) {
        List<Registro> registros = mapa.get(fecha);
        System.out.println("\nRegistros del día " + fecha + ":");
        if (registros == null || registros.isEmpty()) {
            System.out.println("No hay registros para esta fecha.");
        } else {
            for (Registro r : registros) {
                System.out.println(r);
            }
        }
    }

    // Método para mostrar estadísticas (mínima, máxima y promedio)
    private static void mostrarEstadisticasDeFecha(LocalDate fecha, Map<LocalDate, List<Registro>> mapa) {
        List<Registro> registros = mapa.get(fecha);
        System.out.println("\nEstadísticas del día " + fecha + ":");

        if (registros == null || registros.isEmpty()) {
            System.out.println("No hay registros suficientes para calcular estadísticas.");
            return;
        }

        double suma = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

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
}
