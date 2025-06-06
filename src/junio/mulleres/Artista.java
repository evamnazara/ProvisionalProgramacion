package junio.mulleres;

public class Artista extends MullerTraballadora {

    String estilo;

    public Artista(String nome, String apelidos, int anoNacemento, String estilo) {
        super(nome, apelidos, anoNacemento);
        this.estilo = estilo;
    }

    @Override
    public String descripcionContribucion() {
        String descripcion = " destacou na arte co estilo: " + estilo;

        return descripcion;
        
    }

}
