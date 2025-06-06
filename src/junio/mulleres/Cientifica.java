package junio.mulleres;

public class Cientifica extends MullerTraballadora implements IPioneira {

    String descubrimento; 

    public Cientifica(String nome, String apelidos, int anoNacemento, String descubrimento) {
        super(nome, apelidos, anoNacemento);
        this.descubrimento = descubrimento;
    }

    @Override
    public String getDescubrimentoOuAporte() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescubrimentoOuAporte'");
    }

    @Override
    public String descripcionContribucion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'descripcionContribucion'");
    }
    
}
