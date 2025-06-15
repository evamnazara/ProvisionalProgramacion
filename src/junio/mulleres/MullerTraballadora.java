package junio.mulleres;

public abstract class MullerTraballadora {
    String nome;
    String apelidos;
    int anoNacemento;

    public MullerTraballadora(String nome, String apelidos, int anoNacemento) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.anoNacemento = anoNacemento;
    }

    public int getIDade(int anoActual) {
        int idade = anoActual - anoNacemento;

        return idade;
    }

    public abstract String descripcionContribucion();

}
