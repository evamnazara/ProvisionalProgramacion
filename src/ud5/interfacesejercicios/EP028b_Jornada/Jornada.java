/*
    Implementar la clase Jornada, cuyos objetos son los datos de cada 
día de trabajo de los empleados de una empresa. 
En ella se identificará al trabajador por su 
DNI y figurarán la fecha y las horas de entrada y salida del trabajo de cada jornada. Un 
método computará el número de minutos trabajados en la jornada. El criterio de orden 
natural de las jornadas será el de los DNI, y para igual DNI, el de la fecha de la jornada, con 
objeto de que aparezcan consecutivas todas las jornadas de cada trabajador. Asimismo 
implementar el método toString() que muestre el DNI del empleado, la fecha y la 
duración en minutos de las jornadas. 
  */

package ud5.interfacesejercicios.EP028b_Jornada;

import java.time.Duration;
//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Jornada {

    String dni;
    LocalDateTime entrada;
    LocalDateTime salida;
    LocalDateTime jornada;

    String fecha;
    int fechaDia;
    Month fechaMes;

    
    public Jornada(String dni) {
        this.dni = dni;
    }


    public Jornada(String dni, LocalDateTime entrada, LocalDateTime salida, LocalDateTime jornada) {
        this.dni = dni;
        this.entrada = entrada;
        this.salida = salida;
        this.jornada = jornada;
    }

    public void ficharEntrada() {
        entrada = LocalDateTime.now();
        //entrada = LocalDateTime.of(2025, 1, 2, 13, 00);
        System.out.println("Entrada fichada a las " + entrada);
    }

    public void ficharSalida() {
        salida = LocalDateTime.now();
        //salida = LocalDateTime.of(2025, 1, 2, 18, 00);
        System.out.println("Salida fichada a las " + salida);
    }


    public void mostrarJornada() {
        Duration jornada = Duration.between(entrada, salida);
        System.out.println("Duración de la jornada: \n" + jornada.toMinutes() + " minutos. (" + jornada.toHours() + " horas)");
    }

    public void getFecha() {
        fechaMes = entrada.getMonth();
        fechaDia = entrada.getDayOfMonth();
        fecha = fechaDia + " de " + fechaMes;
        System.out.println(fecha);
    }

    // DNI del empleado, la fecha y la duración en minutos de las jornadas
    @Override
    public String toString() {
        return "Empleado: \nDNI: " + dni + "\nFecha: " + fecha + "\nJornada: " + jornada + " minutos";
    }
}
