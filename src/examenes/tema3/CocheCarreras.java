package examenes.tema3;
/* ENUNCIADO
 * Cada coche tendrá los siguientes atributos:
● nombre: una cadena que lo identificará.
● velocidad máxima, entre 1 y 100, en metros por segundo.
● número máximo de "turbos" que podrá consumir el coche antes de repostar.
● autonomía: indica el número de metros que puede recorrer el coche con el depósito lleno (o
la batería totalmente cargada).
● Otros atributos almacenarán la autonomía restante y el número de turbos restantes, y la
distancia recorrida en metros.
Los atributos serán privados y la clase dispondrá de los siguentes métodos para acceder a ellos:
● getNombre()
● getAutonomiaRestante()
● getTurbosRestantes()
● getDistanciaRecorrida()
● Podrán añadirse los métodos getters y setters que se consideren necesarios, siempre que su
implementación mantenga la coherencia de los atributos (por ejemplo, la velocidad máxima
no puede ser menor que 1 ni mayor que 100, la autonomía restante no puede ser negativa,
etc.).
Un coche podrá construirse: * 
 * Otros métodos a implementar:
● avanzar(): intentará hacer avanzar el coche un número aleatorio de metros entre 1 y la
velocidad máxima. Sin embargo, el número real de metros recorridos estará limitado por la
autonomía restante del coche, que se decrementará adecuadamente y no podrá ser inferior a
cero. El método incrementará también la distancia recorrida del coche y devolverá el valor
real de metros recorridos.
● usarTurbo(): Al usar un turbo, si es que quedan turbos disponibles, el coche avanzará un
número de metros igual al 150% de su velocidad máxima. Al igual que en el método anterior,
los metros reales recorridos estarán limitados por la autonomía restante, que se
decrementará al igual que se incrementará la distancia recorrida del coche. También se
decrementará el número de turbos restante. El método devolverá el valor real de metros
recorridos.
● repostar(): restablecerá la autonomía y el número de turbos a sus valores máximos.
● reiniciarDistancia(): reiniciará la distancia recorrida a cero.
● mostrar(): Imprimirá las características del coche con el siguiente formato:
Coche: <Nombre>
Velocidad Máxima: <velocidadMaxima> mps
Turbos: <turbosRestantes>/<maxTurbos>
Autonomía: <autonomiaRestante>/<autonomiaMaxima>
 * 
 */

import java.util.Random;

public class CocheCarreras {
    private String nombre;
    private int velocidadMaxima;
    private int numeroTurbos;
    private int autonomia;

    private int autonomiaRestante;
    private int turbosRestantes;
    private int distancia;

    final int TURBOSDEFECTO = 3;

    // nombre, la velocidad máxima, el número máximo de turbos y la autonomía máxima
    // como parámetros en su constructor.
    // La distancia recorrida inicial al crear el coche será cero. Asimismo el coche
    // dispondrá inicialmente de toda su autonomía y sus turbos.

    public CocheCarreras(String nombre, int velocidadMaxima, int numeroTurbos, int autonomia) {
        this.nombre = nombre;
        if (velocidadMaxima > 1 && velocidadMaxima <= 100) {
            this.velocidadMaxima = velocidadMaxima;
        } else {
            throw new IllegalArgumentException("Velocidad máxima incorrecta. Debe estar entre 1 y 100.");
        }

        this.numeroTurbos = numeroTurbos;
        this.autonomia = autonomia;

        this.distancia = 0;
        this.autonomiaRestante = autonomia;
        this.turbosRestantes = numeroTurbos; // inicializa igual !! no olvidarse de atributos como este
    }

    // nombre, su velocidad máxima y su autonomía, en cuyo caso dispondrá de 3
    // turbos por defecto y los mismos valores iniciales que
    // en el constructor anterior.

    public CocheCarreras(String nombre, int velocidadMaxima, int autonomia) {
        this.nombre = nombre;
        this.velocidadMaxima = velocidadMaxima;
        this.numeroTurbos = TURBOSDEFECTO;
        this.autonomia = autonomia;

        this.distancia = 0;
        this.autonomiaRestante = autonomia;
        this.turbosRestantes = numeroTurbos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public int getAutonomiaRestante() {
        return autonomiaRestante;
    }

    public int getTurbosRestantes() {
        return turbosRestantes;
    }

    public int getDistanciaRecorrida() {
        return distancia;
    };

    public void mostrar() {
        String mostrar = "";

        mostrar = "Coche: " + nombre + "\nVelocidad Máxima: " + velocidadMaxima + " mps. \nTurbos: " + turbosRestantes
                + "/" + numeroTurbos
                + "\nAutonomía: " + autonomiaRestante + "/" + autonomia;
        System.out.println(mostrar);

    }

    public int avanzar() {
        Random rnd = new Random();
        int avance = rnd.nextInt(velocidadMaxima) + 1;

        int metrosReales = Math.min(avance, autonomiaRestante);
        distancia += metrosReales;
        autonomiaRestante -= metrosReales;

        System.out.println(nombre + "ha avanzado " + metrosReales + " metros.");
        return metrosReales;
    }

    public int usarTurbo() {
        if (turbosRestantes > 0) {
            int avance = (int) (velocidadMaxima * 1.5);
            int metrosReales = Math.min(avance, autonomiaRestante);

            distancia += metrosReales;
            autonomiaRestante -= metrosReales;
            turbosRestantes--;

            System.out.println("AVANCE DEL TURBO: " + metrosReales);
            return metrosReales;

        } else {
            System.out.println("No te quedan turbos.");
            return 0;
        }
    }

    public void repostar() {
        autonomiaRestante = autonomia;
        turbosRestantes = numeroTurbos;
    }

    public void reiniciarDistancia() {
        distancia = 0;
    }

}
