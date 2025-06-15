package junio.gestionEmbarque;

import java.util.Scanner;

import junio.gestionEmbarque.Transbordador.MatriculaRepetidaException;
import junio.gestionEmbarque.Transbordador.SuperadoPesoMaximoException;

public class AppEmbarque {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Transbordador transbordador = new Transbordador();
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE EMBARQUE ---");
            System.out.println("1. Embarca vehículo");
            System.out.println("2. Informe vehículos embarcados");
            System.out.println("3. Reseteo embarque");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Tipo de vehículo (turismo/camion/autobus): ");
                    String tipo = sc.nextLine().trim().toLowerCase();
                    System.out.print("Matrícula: ");
                    String matricula = sc.nextLine().trim();
                    System.out.print("Nº de pasajeros: ");
                    int pasajeros = sc.nextInt();

                    Vehiculo vehiculo = null;

                    try {
                        switch (tipo) {
                            case "turismo":
                                vehiculo = new Turismo(matricula, pasajeros);
                                break;
                            case "camion":
                                System.out.print("Peso del camión: ");
                                double pesoCamion = sc.nextDouble();
                                vehiculo = new Camion(matricula, pasajeros, pesoCamion);
                                break;
                            case "autobus":
                                System.out.print("Peso del autobús: ");
                                double pesoAutobus = sc.nextDouble();
                                vehiculo = new Autobus(matricula, pasajeros, pesoAutobus);
                                break;
                            default:
                                System.out.println("Tipo no válido.");
                                continue;
                        }

                        transbordador.embarcarVehiculo(vehiculo);
                        System.out.println("Vehículo embarcado correctamente.");

                    } catch (MatriculaRepetidaException | SuperadoPesoMaximoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    transbordador.informe();
                    break;

                case 3:
                    transbordador.resetear();
                    System.out.println("Transbordador reseteado.");
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
