package junio.mulleres;

public class Politica extends MullerTraballadora implements IActivista {
    
    String causa;


    public Politica(String nome, String apelidos, int anoNacemento, String causa) {
            super(nome, apelidos, anoNacemento);
            this.causa = causa;
    }


    @Override
    public String getCausaDefendida() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCausaDefendida'");
    }


    @Override
    public String descripcionContribucion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'descripcionContribucion'");
    }
    
       

    
    
}
