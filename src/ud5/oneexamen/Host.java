//Eva María Otero Názara 

package ud5.oneexamen;


import java.util.Arrays;

public class Host implements Comparable {
    String nombre; //no puede ser nula
    String mac; //no puede ser nula y tiene que validar
    String ip; //puede ser nula, si no es nula tiene que validar


    public Host(String nombre, String mac, String ip) {

        if (mac == null) {
            throw new IllegalArgumentException(
                "La dirección MAC no puede estar vacía.");
        }
        if (mac != null && validarMAC(mac) == false ) {
            throw new IllegalArgumentException(
                "La dirección MAC es inválida.");
        }
        
        if (ip == null) { //no puede estar vacía según la prueba 
            throw new IllegalArgumentException(
                "La dirección IP no puede estar vacía.");
        }
        if (validarIP(ip) == false ) {
            throw new IllegalArgumentException(
                "La dirección IP es inválida.");
        }

        if (nombre == null) {
            throw new IllegalArgumentException(
                "El nombre no puede estar vacío.");
        }

        this.nombre = nombre; 
        this.mac = mac;
        this.ip = ip;

    }
    
    boolean validarIP(String ip) {
        return ip.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
    }
    
    boolean validarMAC(String mac) {
            return mac.matches("([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})");
        }


    //nombre (ip / mac)
    @Override
    public String toString() {
        return nombre + " ( " + ip  + " / " + mac + " )";
    }

    //iguales si son la misma mac. ignora mayusculas y el caracter separador.
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Host other = (Host) obj;
        if (mac == null) {
            if (other.mac != null)
                return false;
        } else if (!mac.equals(other.mac))
            return false;
        return true;
    }

    //compareTo natural alfabetico del nombre
    @Override
    public int compareTo(Object o) {
        Host host = (Host) o;
        int res = nombre.compareTo(host.nombre);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("\nClase Host");
        System.out.println("==========\n");
        
        Host h100 = new Host("host100", "192.168.117.100", "00:11:22:33:44:55");
        Host h101 = new Host("equipo101", "192.168.117.101", "00:11:22:33:44:55");
        Host h102 = new Host("nodo100", "192.168.117.100", "00-11-22-33-44-AA");
        Host h103 = new Host("host103", "192.168.117.103", "00-11-22-33-44-55");
       
        System.out.println(h100.toString());

        //comparator

        System.out.println("PRUEBA: Comparator:");

        Host[] hosts = { h100, h101, h102, h103};
        compHosts comparatorHosts = new compHosts();
        Arrays.sort(hosts, comparatorHosts);

       for (Host h : hosts) {
        System.out.println(h);
        }


        System.out.println(h100.nombre + " = " + h101.nombre + "? " + h100.equals(h101)); // true
        System.out.println(h100.nombre + " = " + h102.nombre + "? " + h100.equals(h102)); // false
        System.out.println(h100.nombre + " = " + h103.nombre + "? " + h100.equals(h103)); // true


        System.out.println("PRUEBA COMPARE TO:");
        System.out.println(h100.compareTo(h101));
        System.out.println(h100.compareTo(h100));

        
    }


}
