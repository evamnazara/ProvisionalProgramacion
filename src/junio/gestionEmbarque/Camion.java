package junio.gestionEmbarque;

public class Camion extends Vehiculo {
    private static final double PESO_POR_CONDUCTOR = 75;
    private double pesoBase;

    public Camion(String matricula, int pasajeros, double pesoBase) {
        super(matricula, pasajeros);
        this.pesoBase = pesoBase;
    }

    @Override
    public double calcularPeso() {
        return pesoBase + pasajeros * PESO_POR_CONDUCTOR;
    }

    @Override
    public String informe() {
        return "Camión: " + matricula + " - Pasajeros: " + pasajeros + " - Peso: " + pesoBase + " Kg";
    }
}
