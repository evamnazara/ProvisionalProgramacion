package junio.gestionEmbarque;

public abstract class Vehiculo {
    protected String matricula;
    protected int pasajeros;

    public Vehiculo(String matricula, int pasajeros) {
        this.matricula = matricula;
        this.pasajeros = pasajeros;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public abstract double calcularPeso();

    public abstract String informe();
}
