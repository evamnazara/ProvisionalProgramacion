package ud5.interfacesejercicios.EP028b_Jornada;

public class JornadaApp {
    public static void main(String[] args) {
        Jornada empleado1 = new Jornada("77416510M");

        empleado1.ficharEntrada();
        System.out.println("eeee");
        empleado1.ficharSalida();

        empleado1.mostrarJornada();
        empleado1.toString();
        empleado1.getFecha();
        System.out.println(empleado1.toString());
    }
    
    
}
