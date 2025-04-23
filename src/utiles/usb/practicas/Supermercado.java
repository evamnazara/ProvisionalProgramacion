//Echo por André Pazo y Arón Satome con la ayuda de David Besada para: (Función para desglosar el cambio)

package utiles.usb.practicas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Supermercado {
    static Scanner sc = new Scanner(System.in);

    // Funcion para validar cantidades
    public static int validarCantidad() {
        int num = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Introduce la cantidad de unidades del producto (numero entero): ");
                num = sc.nextInt();
                if (num > 0) { // Asegurarse de que sea mayor que cero
                    valido = true;
                } else {
                    System.out.println("\n**El valor debe ser mayor que cero. Inténtelo de nuevo.**\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n**Error: Debes introducir un número entero válido.**\n");
                sc.nextLine(); // Limpiar el buffer
            }
        }
        return num;
    }

    // Funcion para validar precios
    public static double validarPrecio() {
        double num = 0.0;
        boolean valido = false;

        while (!valido) {
            try {
                num = sc.nextDouble();
                if (num > 0) { // Asegurarse de que sea mayor que cero
                    valido = true;
                } else {
                    System.out.println("\n**El valor debe ser mayor que cero. Inténtelo de nuevo.**\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n**Error: Debes introducir un número decimal válido. Intentelo de nuevo**\n");
                sc.nextLine();
            }
        }
        return num;
    }

    // Función para desglosar el cambio
    public static void desglosarCambio(double cambio) {
        // Valores de billetes y monedas
        final int QUINIENTOS = 500;
        final int DOSCIENTOS = 200;
        final int CIEN = 100;
        final int CINCUENTA = 50;
        final int VEINTE = 20;
        final int DIEZ = 10;
        final int CINCO = 5;
        final int DOS = 2;
        final int UNO = 1;

        // Céntimos
        final int CINCUENTA_CENTIMOS = 50;
        final int VEINTE_CENTIMOS = 20;
        final int DIEZ_CENTIMOS = 10;
        final int CINCO_CENTIMOS = 5;
        final int DOS_CENTIMOS = 2;
        final int UN_CENTIMO = 1;

        int sinDecimales = (int) Math.floor(cambio); // Parte entera (euros)
        int decimales = (int) Math.floor((cambio - sinDecimales) * 100); // Parte decimal (céntimos)

        System.out.printf("Billetes de 500 euros: %d\n", sinDecimales / QUINIENTOS);
        sinDecimales %= QUINIENTOS;

        System.out.printf("Billetes de 200 euros: %d\n", sinDecimales / DOSCIENTOS);
        sinDecimales %= DOSCIENTOS;

        System.out.printf("Billetes de 100 euros: %d\n", sinDecimales / CIEN);
        sinDecimales %= CIEN;

        System.out.printf("Billetes de 50 euros: %d\n", sinDecimales / CINCUENTA);
        sinDecimales %= CINCUENTA;

        System.out.printf("Billetes de 20 euros: %d\n", sinDecimales / VEINTE);
        sinDecimales %= VEINTE;

        System.out.printf("Billetes de 10 euros: %d\n", sinDecimales / DIEZ);
        sinDecimales %= DIEZ;

        System.out.printf("Billetes de 5 euros: %d\n", sinDecimales / CINCO);
        sinDecimales %= CINCO;

        System.out.printf("Monedas de 2 euros: %d\n", sinDecimales / DOS);
        sinDecimales %= DOS;

        System.out.printf("Monedas de 1 euros: %d\n", sinDecimales / UNO);
        sinDecimales %= UNO;

        System.out.printf("Monedas de 50 céntimos: %d\n", decimales / CINCUENTA_CENTIMOS);
        decimales %= CINCUENTA_CENTIMOS;

        System.out.printf("Monedas de 20 céntimos: %d\n", decimales / VEINTE_CENTIMOS);
        decimales %= VEINTE_CENTIMOS;

        System.out.printf("Monedas de 10 céntimos: %d\n", decimales / DIEZ_CENTIMOS);
        decimales %= DIEZ_CENTIMOS;

        System.out.printf("Monedas de 5 céntimos: %d\n", decimales / CINCO_CENTIMOS);
        decimales %= CINCO_CENTIMOS;

        System.out.printf("Monedas de 2 céntimos: %d\n", decimales / DOS_CENTIMOS);
        decimales %= DOS_CENTIMOS;

        System.out.printf("Monedas de 1 céntimo: %d\n", decimales / UN_CENTIMO);
    }

    public static void main(String[] args) {
        boolean nuevoCliente;
        do {
            // Pedir precio y cantidad del producto
            System.out.println("BIENVENIDO - NUEVA COMPRA\n");
            int cantidad = validarCantidad();
            System.out.print("Introduce el precio del producto (en euros): ");
            double precio = validarPrecio();
            double importeTotal = precio * cantidad;

            // Mostrar información de la compra
            System.out.printf("\n-----------------------");
            System.out.println("\nResumen de la compra:");
            System.out.printf("Cantidad producto: %d uds%n", cantidad);
            System.out.printf("Precio producto: %.2f euros%n", precio);
            System.out.printf("Importe total: %.2f euros%n", importeTotal);
            System.out.println("-----------------------");

            // Pedir método de pago
            int metodoPago = 0;
            do {
                System.out.print("\n¿Quieres pagar con efectivo (1) o con tarjeta (2)?: ");
                try {
                    metodoPago = sc.nextInt();

                    if (metodoPago != 1 && metodoPago != 2) {
                        System.out.println("\n**Opción no válida. Debes elegir 1 para efectivo o 2 para tarjeta.**\n");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\n**Error: Valor no válido**\n");
                    sc.nextLine(); 
                }
            } while (metodoPago != 1 && metodoPago != 2); // Repetir hasta obtener un valor válido

            // Manejar metodo de pago
            if (metodoPago == 1) {
                // Pago en efectivo
                double efectivo;
                do {
                    System.out.print("Introduce el importe entregado por el cliente: ");
                    efectivo = validarPrecio();
                    if (efectivo < importeTotal) {
                        System.out.println("El importe entregado no cubre el total. Inténtelo de nuevo:");
                    }
                } while (efectivo < importeTotal);

                double cambio = efectivo - importeTotal;
                System.out.println("\n------------------------------");
                System.out.printf("Cambio a devolver: %.2f euros%n", cambio);
                desglosarCambio(cambio);
            } else if (metodoPago == 2) {
                // Pago con tarjeta
                System.out.println("Pago realizado con tarjeta. Gracias por su compra.");
            } else {
                System.out.println("\n**Opción no válida. Inténtelo de nuevo.**\n");
            }

            // Preguntar si se desea procesar otro cliente
            String respuesta;
            do {
                System.out.print("\n¿Desea realizar otra compra? (si / no): ");
                respuesta = sc.next().trim().toLowerCase();
                if (!respuesta.equals("si") && !respuesta.equals("no")) {
                    System.out.println("\n**Por favor, introduce 'si' o 'no'.**\n");
                }
            } while (!respuesta.equals("si") && !respuesta.equals("no"));

            nuevoCliente = respuesta.equals("si");
        } while (nuevoCliente);

        System.out.println("Gracias confiar en nosotros para su compra. ¡Hasta pronto!");
        sc.close();
    }
}