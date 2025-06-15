package examenes.tema5;

import java.util.Arrays;
import java.util.Comparator;

/*Clase Cliente (4)
La clase Cliente extiende la clase Host y representa un equipo cliente en la red añadiendo los
siguientes atributos:
● Sistema operativo. Tipo enumerado (SO) con los sistemas operativos utilizados en la red
(WINDOWS, LINUX, MAC, ANDROID, IOS).
● Resolución de pantalla. Cadena que recoge el ancho y alto en pixeles de la pantalla
separados por una x (ancho x alto)
Métodos:
● Constructor para inicializar los atributos de instancia.
● toString(): Incluye el nombre del cliente y entre paréntesis, el sistema operativo y la
resolución.
Completa la clase Cliente de modo que al ejecutar el programa principal genere la siguiente salida:
Amplía el programa principal de modo que muestre los clientes ordenados según se indica y se
muestra en la captura:
1. alfabéticamente por sistema operativo.
2. de mayor a menor resolución de pantalla, calculando el número de píxeles resultantes de
multiplicar el ancho por el alto. */

public class Cliente extends Host {

    enum SO {
        WINDOWS, LINUX, MAC, ANDROID, IOS
    };

    private String resolucion;
    private SO so;

    public Cliente(String nombre, String ip, String mac, SO sistema, String resolucion) {
        super(nombre, ip, mac);
        this.so = sistema;
        this.resolucion = resolucion;
    }

    public String getResolucion() {
        return resolucion;
    }

    public SO getSo() {
        return so;
    }

    @Override
    public String toString() {
        // CAMBIAR EL ENUM AQUI:
        String strSistema = switch (so) {
            case SO.WINDOWS -> "Windows";
            case SO.LINUX -> "Linux";
            case SO.MAC -> "Mac";
            case SO.ANDROID -> "Android";
            case SO.IOS -> "iOS";
            default -> "";
        };

        return getNombre() + " (" + strSistema + " " + resolucion + ")";
    }

    public int getPixeles() {
        String[] partes = resolucion.toLowerCase().split("x");
        int ancho = Integer.parseInt(partes[0]);
        int alto = Integer.parseInt(partes[1]);
        return ancho * alto;
    }

    public static void main(String[] args) {
        System.out.println("\nClase Cliente");
        System.out.println("=============\n");
        Cliente cWin1 = new Cliente("Cliente1", "192.168.1.2", "02:1A:2B:3C:4D:5E", SO.WINDOWS, "1920x1080");
        Cliente cLin2 = new Cliente("Cliente2", "192.168.1.3", "01:1A:2B:3C:4D:5F", SO.LINUX, "1366x768");
        Cliente cMac3 = new Cliente("Cliente3", "192.168.1.4", "04:1A:2B:3C:4D:60", SO.MAC, "2560x1440");
        Cliente cAnd4 = new Cliente("Cliente4", "192.168.1.5", "03:1A:2B:3C:4D:61", SO.ANDROID, "1080x2340");
        Cliente cIos5 = new Cliente("Cliente5", "192.168.1.6", "05:1A:2B:3C:4D:62", SO.IOS, "1170x2532");

        Cliente[] clientes = { cWin1, cLin2, cMac3, cAnd4, cIos5 };
        Arrays.sort(clientes);
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        /* alfabéticamente por sistema operativo. */

        System.out.println("Clientes ordenados por SO");
        System.out.println("==========================");

        Comparator<Cliente> compNombreSO = new Comparator<>() {

            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o1.so.toString().compareTo(o2.so.toString());
            }

        };
        Arrays.sort(clientes, compNombreSO);
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        /*
         * de mayor a menor resolución de pantalla, calculando el número de píxeles
         * resultantes de
         * multiplicar el ancho por el alto.
         */
        System.out.println("Clientes ordenados por resolucion");
        System.out.println("==========================");
        // Cannot invoke compareTo(int) on the primitive type intJava(67108978)
        // Comparator<Cliente> porResolucion = (c1, c2) ->
        // c1.getPixeles().compareTo(c2.getPixeles());

        Comparator<Cliente> compResolucion = new Comparator<>() {
            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o1.getPixeles() - o2.getPixeles();
            }

        };

        Arrays.sort(clientes, compResolucion.reversed());
        for (Cliente c : clientes) {
            System.out.println(c);
        }

    }

}
