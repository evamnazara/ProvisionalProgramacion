package junio.aparcamiento;

public class Vehiculo implements Comparable<Vehiculo> {
    protected String matricula;
    protected String marca;
    protected String modelo;

    public Vehiculo(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Vehiculo))
            return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return matricula.equalsIgnoreCase(vehiculo.matricula);
    }

    @Override
    public String toString() {
        return matricula + " - " + marca + " " + modelo;
    }

    @Override
    public int compareTo(Vehiculo o) {
        return this.matricula.compareToIgnoreCase(o.matricula);
    }
}
