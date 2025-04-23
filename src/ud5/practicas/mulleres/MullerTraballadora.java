package mulleres;

public abstract class MullerTraballadora {
    protected String nome;
    protected String apelidos;
    protected int anoNacemento;


    public MullerTraballadora(String nome, String apelidos, int anoNacemento) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.anoNacemento = anoNacemento;
    }

    public abstract String descricionContribucion();

    public int getAnoNacemento() {
        return anoNacemento;
    }

    public int getIdade(int anoActual) {
        int edad = anoActual - anoNacemento;
        return edad;
    }

}
