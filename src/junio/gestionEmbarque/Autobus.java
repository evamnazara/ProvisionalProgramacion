package junio.gestionEmbarque;

public class Autobus extends Vehiculo {
    private static final double PESO_POR_PASAJERO = 75;
    private double pesoBase;

    public Autobus(String matricula, int pasajeros, double pesoBase) {
        super(matricula, pasajeros);
        this.pesoBase = pesoBase;
    }

    @Override
    public double calcularPeso() {
        return pesoBase + pasajeros * PESO_POR_PASAJERO;
    }

    @Override
    public String informe() {
        return "Autobús: " + matricula + " - Pasajeros: " + pasajeros + " - Peso: " + pesoBase + " Kg";
    }
}
