/*
E0804. Crear la clase abstracta Instrumento, que almacena en una tabla las notas 
musicales de una melodía (dentro de una misma octava). El método add() añade 
nuevas notas musicales. La clase también dispone del método abstracto 
interpretar() que, en cada subclase que herede de Instrumento, mostrará por 
consola las notas musicales según las interprete. Utilizar enumerados para definir las 
notas musicales. 
//instrumentos  > añade melodias a todos y haz que se reproduzcan  
*/
package ud5.apuntesherencia.abstractas.E0804_Instrumentos;
import java.util.Arrays;

public abstract class Instrumento {
    enum Nota {DO, RE, MI, FA, SOL, LA, SI};
    Nota [] melodia; 

    //public Instrumento (Nota[] melodia ) 
    
    //iniciar sin melodia
    public Instrumento () {
        this.melodia = new Nota[0];
    } 
    public void add(Nota nota) {
        melodia = Arrays.copyOf(melodia, melodia.length + 1);
        melodia[melodia.length - 1] = nota;
    }

    //clase abstracta -- no {}
    public abstract void interpretar();


    public void copiarMelodia(Instrumento instrumento){
        melodia = Arrays.copyOf(instrumento.melodia, instrumento.melodia.length);
    }; 

    public static void main(String[] args) {

        //como es abstracta no se puede instanciar solo como piano 
        // asi sí si anotas que es un piano -> Instrumento piano = new Piano();
        Piano piano1 = new Piano();

        piano1.add(Nota.RE);
        piano1.add(Nota.LA);
        piano1.add(Nota.SI);

        piano1.interpretar();

        Instrumento violin1 = new Violin();

        violin1.add(Nota.SOL);
        violin1.add(Nota.LA);
        violin1.interpretar();

        piano1.copiarMelodia(violin1);

    }
}
