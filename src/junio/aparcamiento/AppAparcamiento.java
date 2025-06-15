package junio.aparcamiento;

import java.util.*;

public class AppAparcamiento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Aparcamiento aparcamiento = new Aparcamiento(10, 3.0); // 10 plazas, altura máxima 3m

        while (true) {
            System.out.println("\n--- MENÚ APARCAMIENTO ---");
            System.out.println("1. Aparcar vehículo");
            System.out.println("2. Sacar vehículo");
            System.out.println("3. Mostrar estado");
            System.out.println("4. Mostrar estado detallado");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            if (opcion == 1) {
                System.out.print("Matrícula: ");
                String matricula = sc.nextLine();
                System.out.print("¿Vehículo pesado? (s/n): ");
                String respuesta = sc.nextLine();

                Vehiculo vehiculo;
                if (respuesta.equalsIgnoreCase("s")) {
                    System.out.print("Peso: ");
                    double peso = sc.nextDouble();
                    System.out.print("Altura: ");
                    double altura = sc.nextDouble();
                    sc.nextLine(); // limpiar buffer
                    vehiculo = new VehiculoPesado(matricula, peso, altura);
                } else {
                    vehiculo = new Vehiculo(matricula);
                }

                boolean exito = aparcamiento.aparcarVehiculo(vehiculo);
                System.out.println(exito ? "Vehículo aparcado." : "No se pudo aparcar el vehículo.");
            }

            else if (opcion == 2) {
                System.out.print("Matrícula del vehículo: ");
                String matricula = sc.nextLine();
                Vehiculo vehiculo = new Vehiculo(matricula);
                boolean exito = aparcamiento.sacarVehiculo(vehiculo);
                System.out.println(exito ? "Vehículo retirado." : "Vehículo no encontrado.");
            }

            else if (opcion == 3) {
                aparcamiento.mostrarEstado();
            }

            else if (opcion == 4) {
                aparcamiento.mostrarEstadoDetallado();
            }

            else if (opcion == 5) {
                System.out.println("Saliendo...");
                break;
            }

            else {
                System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}
