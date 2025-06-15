package examenes.tema3;

public class AppCarreras {
    public static void main(String[] args) {
        // ncluye en la clase un método main() de prueba que deberá funcionar
        // correctamente con elsiguiente código:
        System.out.println("RAYO");
        System.out.println("====");
        CocheCarreras rayo = new CocheCarreras("Rayo", 90, 400);
        rayo.mostrar();
        rayo.avanzar();
        rayo.usarTurbo();
        rayo.mostrar();
        System.out.println("TRUENO");
        System.out.println("======");
        CocheCarreras trueno = new CocheCarreras("Trueno", 60, 5, 300);
        trueno.mostrar();
        while (trueno.getAutonomiaRestante() != 0)
            trueno.usarTurbo();
        trueno.mostrar();
        trueno.repostar();
        trueno.mostrar();
    }
}
