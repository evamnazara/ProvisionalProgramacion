//Eva María Otero Názara 

package ud5.oneexamen;

import java.util.Arrays;

public class Cliente extends Host {
    // Tu código aquí
    enum SO {WINDOWS,LINUX,ANDROID,MAC,IOS};
    SO sistema;
    String resolucion;

    
    public Cliente(String nombre, String mac, String ip, SO sistema, String resolucion) {
        super(nombre, mac, ip);
        this.sistema = sistema;
        this.resolucion = resolucion;
    }
    

    //nombre (so + resolucion)
    @Override
    public String toString() {
        return nombre + " (" + sistema + " " + resolucion + ")";
    }


    public int getPixeles(){
        String[] px = resolucion.split("x");
        int ancho = Integer.parseInt(px[0]);
        int alto = Integer.parseInt(px[1]);

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

        System.out.println("Prueba toString independiente: " );
        System.out.println(cAnd4.toString());
       
        Cliente[] clientes = { cWin1, cLin2, cMac3, cAnd4, cIos5 };
        Arrays.sort(clientes);
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        System.out.println();
        System.out.println();

        System.out.println("Clientes ordenador por SO");
        System.out.println("==========================");

        comCliSO compSistema = new comCliSO();
        Arrays.sort(clientes,compSistema);
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        System.out.println();
        System.out.println();

        System.out.println("Clientes ordenador por resolución");
        System.out.println("=================================");
        compCliResolucion compResolucion = new compCliResolucion();
        Arrays.sort(clientes,compResolucion);
        for (Cliente c : clientes) {
            System.out.println(c);
        }



    }
    
}
