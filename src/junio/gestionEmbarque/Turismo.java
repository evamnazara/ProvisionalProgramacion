package junio.gestionEmbarque;

public class Turismo extends Vehiculo {
    private static final double PESO_BASE = 1000;
    private static final double PESO_POR_PASAJERO = 75;

    public Turismo(String matricula, int pasajeros) {
        super(matricula, pasajeros);
    }

    @Override
    public double calcularPeso() {
        return PESO_BASE + pasajeros * PESO_POR_PASAJERO;
    }

    @Override
    public String informe() {
        return "Turismo: " + matricula + " - Pasajeros: " + pasajeros;
    }
}
