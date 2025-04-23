package mulleres;


public class Politica extends MullerTraballadora {
    String causa;

    public Politica(String n, String a, int ano, String desc) {
        super(n, a, ano);

        }

    @Override
    public String descricionContribucion() {
       String descripcion = getDescubrimentoOuAporte();
              return descripcion;
           }
       
    private String getDescubrimentoOuAporte() {
        return causa;
    }

}
