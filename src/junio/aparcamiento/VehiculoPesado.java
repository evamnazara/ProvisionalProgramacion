package junio.aparcamiento;

public class VehiculoPesado extends Vehiculo {
    private double peso;
    private double altura;

    public VehiculoPesado(String matricula, String marca, String modelo, double peso, double altura) {
        super(matricula, marca, modelo);
        this.peso = peso;
        this.altura = altura;
    }

    public VehiculoPesado(String matricula, double peso, double altura) {
        super(matricula);
        this.peso = peso;
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return super.toString() + " (Pesado. " + peso + "kg. Altura " + altura + " m)";
    }
}
