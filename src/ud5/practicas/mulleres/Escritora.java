package mulleres;

public class Escritora extends MullerTraballadora implements IPioneira {

    private String obraMaestra; 

    public Escritora(String nome, String apelidos, int anoNacemento, String obraMaestra) {
        super(nome, apelidos, anoNacemento);
        this.obraMaestra = obraMaestra;
    }

    //poner texto correcpondiente
    @Override
    public String getDescubrimentoOuAporte() {
        System.out.println(obraMaestra);
        throw new UnsupportedOperationException("Unimplemented method 'getDescubrimentoOuAporte'");
    }

    @Override
    public String descricionContribucion() {
        throw new UnsupportedOperationException("Unimplemented method 'descricionContribucion'");
    }
    
}
