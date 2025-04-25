package meigas;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import meigas.Feitizo;

public class Meiga {
    String nome;
    String alcumeMaxico;
    List feitizosFavoritos;
    Map<String, Integer> inventario;

    public Meiga(String nome) {
        this.nome = nome;
    }

    public Meiga(String nome, String alcumeMaxico) {
        this.nome = nome;
        this.alcumeMaxico = alcumeMaxico;
    }

    public Meiga(String nome, String alcumeMaxico, List feitizosFavoritos) {
        this.nome = nome;
        this.alcumeMaxico = alcumeMaxico;
        this.feitizosFavoritos = feitizosFavoritos;
    }

    public Meiga(String nome, String alcumeMaxico, List feitizosFavoritos, Map<String, Integer> inventario) {
        this.nome = nome;
        this.alcumeMaxico = alcumeMaxico;
        this.feitizosFavoritos = feitizosFavoritos;
        this.inventario = inventario;
    }


    // e. seleccione devolva unha colección aleatoria de feitizos a partir da
    // colección que recibe como parámetro.
    public static Collection<Feitizo> getFeitizosRnd(Collection<Feitizo> feitizosExemplo) {
        List<Feitizo> feitizos = Arrays.asList(crearFeitizosExemplo());
        return feitizosExemplo;
    }

    /*
     * f. Crea o método getIngredientesRnd() seleccione aleatoriamente
     * ingredientes dunha colección que se lle pasa como parámetro e para cada un
     * deles un número aleatorio de unidades entre 1 e un número máximo que
     * tamén se pasa como parámetro.
     */
    public static Map<String, Integer> getIngredientesRnd(Collection<String> ingredientesExemplo, int udMaximas) {
        Map<String,Integer> ingredientesRandom = new HashMap<>();


        for (String i : ingredientesExemplo) {
            
        }

        System.out.println();
        return ingredientesRandom;
    }
    /*
     * g. Crea un método de instancia lanzarFeitizo(Feitizo) que, en caso de que
     * haxa ingredientes suficientes, imprima o nome da meiga e do feitizo e elimine
     * do inventario os ingredientes utilizados.
     * se comprueba que se pueda lanzar, (si esta en su lista y si tiene
     * ingredientes) y si si, que se lance un hechizo y se resten los ingredientes
     * de esa lista
     */

     public static Map<String,Integer> lanzarFeitizo (Collection<String> ingredientes, Integer udInventario) {
        List<String> ingredientesInventario = Arrays.asList(crearMeigasExemplo());

       Iterator<Map.Entry<String,Integer>> it;
       for
        
     }
    

    public static Meiga[] crearMeigasExemplo(Feitizo[] feitizosDisponibles) {
        Random rnd = new Random();

        String[] nomes = { "Uxía", "Lúa", "Iria", "Noa" };
        String[] alcumes = { "A das Fraguiñas", "Sombra do Vento", "Luz do Bosque", "Meiga da Brétema" };

        Meiga[] meigas = new Meiga[nomes.length];

        // Obtén todos os feitozos de exemplo e todos os seus ingredientes únicos
        Collection<Feitizo> feitizosExemplo = List.of(Feitizo.crearFeitizosExemplo());
        Collection<String> ingredientesExemplo = Feitizo.ingredientesUnicos(feitizosExemplo);

        for (int i = 0; i < nomes.length; i++) {
            String nome = nomes[i];
            String alcume = alcumes[i];
            // Xera unha colección cunha selección aleatoria de feitizos de exemplo para
            // asignar á meiga
            Collection<Feitizo> feitizos = getFeitizosRnd(feitizosExemplo);
            // Xera un mapa cunha selección aleatoria de ingredientes e cantidades de cada
            // un de exemplo para asignar á meiga
            Map<String, Integer> inventario = getIngredientesRnd(ingredientesExemplo, 3);

            // Crea a meiga e a engade ao array
            meigas[i] = new Meiga(nome, alcume, feitizos, inventario);
        }

        return meigas;

    }

    @Override
    public String toString() {
        return "Meiga.\nNome: " + nome + "\nAlcume máxico=" + alcumeMaxico + "\n Feitizos Favoritos=" + feitizosFavoritos
                + ", inventario: " + inventario;
    }

}
