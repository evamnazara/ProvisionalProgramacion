package u6.meigas;

import java.util.*;

public class Feitizo {
    String nome;
    List<String> ingredientes;
    Integer nivelDificultade;

    // el original se crea como List<String> feitizos, pero el te pasa en el ejemplo
    // array d strings xd asiq hay que cambiarlo y generar la lista
    public Feitizo(String nome, String[] ingredientes, Integer nivelDificultade) {
        this.nome = nome;
        this.ingredientes = new ArrayList<>();
        this.nivelDificultade = nivelDificultade;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public Integer getNivelDificultade() {
        return nivelDificultade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setNivelDificultade(Integer nivelDificultade) {
        this.nivelDificultade = nivelDificultade;
    }

    // colección de todos os ingredientes únicos empregados no festival.

    // public Set ingredientesUnicos(List<Feitizo> ingredientes) {
    public static Collection<String> ingredientesUnicos(Collection<Feitizo> feitizos) {
        Set<String> ingredientesUnicos = new TreeSet<>();

        // en el foreach se pasan los parametros q pone el constructor de la funcion
        for (Feitizo feitizo : feitizos) {
            ingredientesUnicos.addAll(feitizo.ingredientes);
        }

        return ingredientesUnicos;
    }

    // Xera un listado dos feitizos que se poden facer cunha lista de ingredientes
    // dados.
    public static List<Feitizo> feitizosUsanIngrediente(String ingrediente, Collection<Feitizo> feitizos) {
        // se invoca lista
        List<Feitizo> feitizosUsanIngrediente = new ArrayList<>();

        return feitizosUsanIngrediente;
    }

    // Permite listar os 3 ingredientes máis usados en total (pista: podes usar un
    // Map<String, Integer> para contar).
    // Métodos para engadir, eliminar ou substituir un ingrediente dun feitizo.
    public boolean addIngrediente(String ingrediente) {
        return false;

    }

    public boolean removeIngrediente(String ingrediente) {
        return false;

    }

    public boolean cambiarIngrediente(String ingredienteViejo, String ingredienteNuevo) {
        return false;

    }

    // Xera unha lista de feitizos que utilizan un ingrediente dado.

    public static Feitizo[] crearFeitizosExemplo() {
        String[] ingredientes1 = { "auga de río encantada", "pétalos de rosa silvestre", "fume de lareira" };
        String[] ingredientes2 = { "auga do mar", "salicornia", "berberechos místicos" };
        String[] ingredientes3 = { "raíz de toxo", "auga bendita", "po de estrela fugaz" };
        String[] ingredientes4 = { "auga de río encantada", "raíz de toxo", "pel de serpe" };
        String[] ingredientes5 = { "auga do mar", "po de estrela fugaz", "cinza de bidueiro" };
        String[] ingredientes6 = { "auga bendita", "pétalos de rosa silvestre", "brétema das fragas" };

        Feitizo f1 = new Feitizo("Encantamento da Chuvia Mansa", ingredientes1, 3);
        Feitizo f2 = new Feitizo("Invocación Mariña", ingredientes2, 4);
        Feitizo f3 = new Feitizo("Luz do Luar", ingredientes3, 2);
        Feitizo f4 = new Feitizo("Garda da Fraga", ingredientes4, 3);
        Feitizo f5 = new Feitizo("Respiro Oceánico", ingredientes5, 4);
        Feitizo f6 = new Feitizo("Bendición Floral", ingredientes6, 2);

        return new Feitizo[] { f1, f2, f3, f4, f5, f6 };
    }

    public static void main(String[] args) {

        Feitizo[] feitizos = crearFeitizosExemplo();

        System.out.println(ingredientesUnicos(List.of(feitizos)));
        // System.out.println(ingredientesVecesUsados(List.of(feitizos)));
        String[] ingredientes = { "auga do mar", "salicornia", "berberechos místicos" };
        // System.out.println(feitizosPosibles(Set.of(ingredientes),
        // List.of(crearFeitizosExemplo())));

    }

}
