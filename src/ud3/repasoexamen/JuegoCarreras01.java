package ud3.repasoexamen;

public class JuegoCarreras01 {
    public static void main(String[] args) {
        final int DISTANCIA = 500;
        CocheCarreras rayo = new CocheCarreras("Rayo", 90, 400);
        CocheCarreras trueno = new CocheCarreras("Trueno", 60, 5, 300);

        rayo.mostrar();
        trueno.mostrar();

        boolean turnoRayo = rayo.getVelocidadMaxima() >= trueno.getVelocidadMaxima();

        while (rayo.getDistanciaRecorrida() < DISTANCIA && trueno.getDistanciaRecorrida() < DISTANCIA) {
            if (turnoRayo)
                turno(rayo);
            else
                turno(trueno);

            turnoRayo = !turnoRayo;
        }

        if (rayo.getDistanciaRecorrida() >= DISTANCIA)
            ganador(rayo);
        else
            ganador(trueno);

    }

    private static void turno(CocheCarreras coche) {
        if (coche.getAutonomiaRestante() == 0) {
            coche.repostar();
            System.out.println(coche.getNombre() + " para a repostar.");
        } else if (coche.getTurbosRestantes() > 0 && Math.random() <= 0.25) {
            int metros = coche.usarTurbo();
            System.out.println(coche.getNombre() + " usa un turbo y avanza "
                    + metros + " metros. Quedan " + coche.getTurbosRestantes()
                    + " turbos. (Total recorrido: " + coche.getDistanciaRecorrida() + ").");
        } else {
            int metros = coche.avanzar();
            System.out.println(coche.getNombre() + " avanza "
                    + metros + " metros. (Total recorrido: " + coche.getDistanciaRecorrida() + ").");
        }
    }

    private static void ganador(CocheCarreras coche) {
        System.out.println("¡" + coche.getNombre() + " ha cruzado la meta y es el ganador!");
    }
}
