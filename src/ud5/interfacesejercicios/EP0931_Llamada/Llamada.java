/*
EP0931_Llamada. En una compañía de telecomunicaciones se desean registrar los datos de todas las llamadas de sus clientes. 
    Implementar la clase Llamada, que guardará los siguientes datos: 
        número de teléfono del cliente, 
        número del interlocutor, a
        tributo booleano que indique si la llamada es saliente, 
        fecha y hora del inicio de la llamada y del fin, 
        atributo enumerado que indique la zona del interlocutor (suponer cinco zonas con tarifas distintas) y 
        tabla de constantes con las tarifas de las zonas en céntimos de euro/minuto. 
        
        En la clase se establecerá un orden natural compuesto basado en el número del teléfono del cliente como primer criterio y en la fecha y hora de inicio como segundo criterio. 
        Asimismo, se implementará un método 
        que devuelva la duración en minutos de la llamada y 
        otro que calcule su coste, si es saliente. 
        
        Por último, implementar el método toString(), que muestre los dos números de teléfono, la fecha y hora del inicio, la duración y el coste.  
*/

package ud5.interfacesejercicios.EP0931_Llamada;

import java.time.Duration;
import java.time.LocalDateTime;

public class Llamada implements Comparable<Llamada> {
    String telefonoCliente;
    String telefonoInterlocutor;
    boolean saliente;
    LocalDateTime fechaInicioLlamada;
    LocalDateTime fechaFinLlamada;
    
    enum ZonaInterlocutor {ZONA1, ZONA2, ZONA3, ZONA4, ZONA5}
    ZonaInterlocutor zona;
    
    static final double tarifaZona1 = 0.01;
    static final double tarifaZona2 = 0.02;
    static final double tarifaZona3 = 0.03;
    static final double tarifaZona4 = 0.04;
    static final double tarifaZona5 = 0.05;
    
    public Llamada(String telefonoCliente, String telefonoInterlocutor, boolean saliente, LocalDateTime fechaInicioLlamada, LocalDateTime fechaFinLlamada, ZonaInterlocutor zona) {
        this.telefonoCliente = telefonoCliente;
        this.telefonoInterlocutor = telefonoInterlocutor;
        this.saliente = saliente;
        this.fechaInicioLlamada = fechaInicioLlamada;
        this.fechaFinLlamada = fechaFinLlamada;
        this.zona = zona;
    }
    
    public long getDuracionMinutos() {
        return Duration.between(fechaInicioLlamada, fechaFinLlamada).toMinutes();
    }
    
    public double setTarifaCliente() {
        if (!saliente) return 0.0;
        double tarifaCliente = 0.0;
        switch (zona) {
            case ZONA1:
                tarifaCliente = getDuracionMinutos() * tarifaZona1;
                break;
            case ZONA2:
                tarifaCliente = getDuracionMinutos() * tarifaZona2;
                break;
            case ZONA3:
                tarifaCliente = getDuracionMinutos() * tarifaZona3;
                break;
            case ZONA4:
                tarifaCliente = getDuracionMinutos() * tarifaZona4;
                break;
            case ZONA5:
                tarifaCliente = getDuracionMinutos() * tarifaZona5;
                break;
        }
        System.out.println("Tarifa: " + tarifaCliente);
        return tarifaCliente;
    }
    
    @Override
    public String toString() {
        return "Llamada de " + telefonoCliente + " a " + telefonoInterlocutor + " | Inicio: " + fechaInicioLlamada + " | Duración: " + getDuracionMinutos() + " min | Costo: " + setTarifaCliente() + "€";
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Llamada other = (Llamada) obj;
        if (telefonoCliente == null) {
            if (other.telefonoCliente != null)
                return false;
        } else if (!telefonoCliente.equals(other.telefonoCliente))
            return false;
        return true;
    }

    @Override
    public int compareTo(Llamada otra) {
        int comparacionTelefono = this.telefonoCliente.compareTo(otra.telefonoCliente);
        if (comparacionTelefono != 0) return comparacionTelefono;
        return this.fechaInicioLlamada.compareTo(otra.fechaInicioLlamada);
    }
}
