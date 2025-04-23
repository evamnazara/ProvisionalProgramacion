package mulleres;

public class Cientifica extends MullerTraballadora implements IPioneira {

    String descubrimento; 
    
    public Cientifica (String nome, String apelidos, int anoNacemento, String descubrimento) {
        super(nome, apelidos, anoNacemento);
        this.descubrimento = descubrimento;
    }

//implementan los metodos abstractosd e la clases que heredan
   @Override
   public String descricionContribucion() {

       return nome + apelidos + " foi unha científica pioneira.";
   }
   
   @Override
   public String getDescubrimentoOuAporte() {
       return descubrimento;
   }

}
