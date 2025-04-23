//Eva María Otero Názara 

package ud5.oneexamen;

import java.util.Arrays;

public class Servidor extends Host {
    String nombreServicio;
    Integer puerto;
    String protocolo;

    Integer numServicios;

    //el constructor por defecto no lleva servicio
    public Servidor(String nombre, String mac, String ip) {
        super(nombre,mac,ip);

    }

    public boolean addServicio(Servicio servicio) {
        if (servicio instanceof Servicio) {
           if (nombreServicio != null && puerto != null)  {
                return true;
            }
        }
        return false;
    }

    private void addServicio(String nombreServicio,Integer puerto, String protocolo) {
        this.nombreServicio = nombreServicio;
        this.puerto = puerto;
        this.protocolo = protocolo;
    }

    public int contarServicios(String[] servidores) {
        //sin hacer 

        return numServicios;
    }

    @Override
    public String toString() {
        return nombre + "(" + ip + ")\n * " + nombreServicio + "(" + puerto + "/" + protocolo + ")"; 
    }

    public static void main(String[] args) {
        System.out.println("\nClase Servidor");
        System.out.println("==============\n");
        Servidor s1 = new Servidor("dam1", "192.168.0.117", "CC-11-22-33-44-AA");
        s1.addServicio("MySQL", 3306, "TCP");
                                    
        Servidor s2 = new Servidor("seixo", "192.168.0.11", "BB:11:22:33:44:55");
        s2.addServicio("HTTP", 80, "TCP");
        s2.addServicio("Proxy", 3128, "TCP");
                                    
        Servidor s3 = new Servidor("lapaman", "192.168.0.9", "AA:11:22:33:44:55");
        s3.addServicio("HTTP", 80, "TCP");
        s3.addServicio("Web", 80, "TCP");
        s3.addServicio("DNS", 53, "UDP");
        s3.addServicio("DNS", 53, "UDP");
        s3.addServicio("FTP", 21, "TCP");
        s3.addServicio("SSH", 22, "TCP");        
                                
        Servidor[] servidores = { s1, s2, s3 };
        for (Servidor s : servidores) {
                System.out.println(s);
                        }
    

        // Tu código aquí


        System.out.println("Servidores ordenados descendentemente por servicios:");
        System.out.println("=====================================================");

        CompServidores compServ = new CompServidores();
        Arrays.sort(servidores,compServ.reversed());
        for (Servidor s : servidores) {
            System.out.println(s);
        }

                                
}
            

                
        

}
