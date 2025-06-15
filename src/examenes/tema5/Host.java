package examenes.tema5;

/*/*Clase Host (4)
Host.java
La clase Host representa un equipo conectado en la red e incluye la siguiente información:
● Nombre del equipo. Una cadena que no podrá ser null.
● Dirección MAC. Deberá ser una cadena válida que represente 12 dígitos hexadecimales en
mayúsculas o minúsculas en uno de los dos formatos siguientes: hh:hh:hh:hh:hh:hh o
hh-hh-hh-hh-hh-hh. Ejemplos: 00:11:22:33:44:55, AA-BB-CC-DD-EE-FF
● Dirección IP. Una cadena que representa 4 valores entre 0 y 255 separados por puntos.
Ejemplo: 192.168.117.200
Todos los hosts de la red comparten los siguientes parámetros de red, que tendrán los valores por
defecto que se indican entre paréntesis:
● Máscara de red (255.255.0.0)
● Puerta de enlace (192.168.0.11)
● Servidores DNS (192.168.0.9)
Métodos:
● Constructor para inicializar los atributos de instancia. Si alguno de los atributos no es válido
el constructor deberá generar una excepción IllegalArgumentException con el mensaje
adecuado.
● equals(): Redefine el método para que considere que dos objetos Host son iguales si tienen
la misma dirección MAC, ignorando la diferencia entre mayúsculas y minúsculas al
representar los dígitos hexadecimales e ignorando también el carácter separador utilizado, ya
sean guiones (-) o dos puntos (:).
● toString(): Devuelve una representación en cadena del host con el siguiente formato:
nombre (ip / mac).
Define el orden natural de los objetos de la clase Host como orden alfabético ascendente de nombre
de host. */
import java.util.Arrays;

public class Host implements Comparable<Host> {

    // REV atributos estaticos
    private String nombre;
    private String mac;
    private String ip;

    public Host(String nombre, String ip, String mac) {
        if (nombre == null)
            throw new IllegalArgumentException("Error: El nombre no puede ser nulo");
        else
            this.nombre = nombre;

        if (ip != null && !validarIP(ip))
            throw new IllegalArgumentException("Error: Formato de IP no válido");
        else
            this.ip = ip;

        if (mac == null || mac != null && !validarMAC(mac))
            throw new IllegalArgumentException("Error: dirección MAC nula o con formato no válido");
        else
            this.mac = mac;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMac() {
        return mac;
    }

    public String getIp() {
        return ip;
    }

    boolean validarIP(String ip) {
        return ip.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
    }

    boolean validarMAC(String mac) {
        return mac.matches("([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})");
    }

    @Override
    public String toString() {
        return nombre + " (" + ip + " / " + mac + ")";
    }

    /*
     * son iguales si tienen
     * la misma dirección MAC, ignorando la diferencia entre mayúsculas y minúsculas
     * al representar los dígitos hexadecimales e ignorando también el carácter
     * separador utilizado, ya sean guiones (-) o dos puntos (:).
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Host other = (Host) obj;
        if (mac == null || other.mac == null)
            return false;
        else
            return this.mac.replaceAll("[:-]", "").equalsIgnoreCase(other.mac.replaceAll("[:-]", ""));
    }

    @Override
    public int compareTo(Host o) {
        return nombre.compareTo(o.nombre);
    }

    public static void main(String[] args) {
        System.out.println("\nClase Host");
        System.out.println("==========\n");
        Host h100 = new Host("host100", "192.168.117.100", "00:11:22:33:44:55");
        Host h101 = new Host("equipo101", "192.168.117.101", "00:11:22:33:44:55");
        Host h102 = new Host("nodo100", "192.168.117.100", "00-11-22-33-44-AA");
        Host h103 = new Host("host103", "192.168.117.103", "00-11-22-33-44-55");

        Host[] hosts = { h100, h101, h102, h103 };
        Arrays.sort(hosts);
        for (Host h : hosts) {
            System.out.println(h);
        }

        System.out.println(h100.nombre + " = " + h101.nombre + "? " + h100.equals(h101)); // true
        System.out.println(h100.nombre + " = " + h102.nombre + "? " + h100.equals(h102)); // false
        System.out.println(h100.nombre + " = " + h103.nombre + "? " + h100.equals(h103)); // true
    }

}
