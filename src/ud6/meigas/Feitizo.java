package meigas;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

/* Base de datos de Feitizos: 
Cada feitizo ten un nome, unha lista de ingredientes (que non se poden repetir 
no mesmo feitizo), e un nivel de dificultade. 
a.  A partir de todos os feitizos rexistrados queremos obter unha colección de 
todos os ingredientes únicos empregados no festival. 
b.  Xera un listado dos feitizos que se poden facer cunha lista de ingredientes 
dados. 
c.  Permite listar os 3 ingredientes máis usados en total (pista: podes usar un 
Map<String, Integer> para contar). 
d.  Métodos para engadir, eliminar ou substituir un ingrediente dun feitizo. 
e.  Xera unha lista de feitizos que utilizan un ingrediente dado.  */
public class Feitizo {
    private String nome;
    private List<String> ingredientes;
    private Integer nivelDificultade;

    // constructores
    public Feitizo(String nome, List<String> ingredientes) {
        this.nome = nome;
        this.ingredientes = ingredientes;
    }

    public Feitizo(String nome, String[] ingredientes, Integer nivelDificultade) {
        this.nome = nome;
        this.ingredientes = Arrays.asList(ingredientes);
        // this.ingredientes = List.of(ingredientes);

        this.nivelDificultade = nivelDificultade;
    }

    public Feitizo(String nome) {
        this.nome = nome;
    }

    // getter y setters
    public String getNome() {
        return nome;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public Integer getNivelDificultade() {
        return nivelDificultade;
    }

    public static Collection<String> ingredientesUnicos(Collection<Feitizo> feitizos) {
        Set<String> ingredientesUnicos = new TreeSet<>();
        for (Feitizo feitizo : feitizos) {
            for (String i : feitizo.ingredientes) {
                ingredientesUnicos.add(i);
            }
        }
        return ingredientesUnicos;

        /*
         * otra forma;
         * al añadir todo, solo añade los que no estén ya en la lista
         * 
         * for (Feitizo feitizo : feitizos) {
         * for (String i : feitizo.ingredientes) {
         * ingredientesUnicos.add(i);
         * }
         * }
         */
    }

    public boolean addIngrediente(String ingrediente) {
        if (ingrediente == null || ingrediente.isEmpty())
            return false; // No se permite añadir un ingrediente vacío o nulo

        if (ingredientes == null)
            ingredientes = new ArrayList<>(); // Si la lista no existe, se crea

        if (!ingredientes.contains(ingrediente)) { // Solo se añade si no está ya
            ingredientes.add(ingrediente);
            return true; // Se añadió correctamente
        }
        return false; // si ya estaba, no se añade
    }

    public boolean removeIngrediente(String ingrediente) {

        return true;
    }

    public boolean cambiarIngrediente(String ingredienteViejo, String ingredienteNuevo) {
        if (ingredienteViejo == null || ingredienteNuevo == null || ingredientes == null)
            return false; // No válido si alguno es nulo

        int posicionIngredente = ingredientes.indexOf(ingredienteViejo); // Buscamos su posición
        if (posicionIngredente != -1 && !ingredientes.contains(ingredienteNuevo)) {
            ingredientes.set(posicionIngredente, ingredienteNuevo); // Sustituimos por el nuevo
            return true;
        }
        return false; // si no se encontró, o el nuevo ya estaba
    }

    public static List<Feitizo> feitizosUsanIngrediente(String ingrediente) {
        List<Feitizo> resultado = new ArrayList<>();
        List<Feitizo> feitizos = Arrays.asList(crearFeitizosExemplo());

        for (Feitizo f : feitizos) {
            if (f.ingredientes != null && f.ingredientes.contains(ingrediente)) {
                resultado.add(f); // Añadimos si lo contiene
            }
        }
        return resultado;
    }

    // original sin el collection
    public static List<Feitizo> feitizosPosibles(Set<String> ingredientes, Collection<Feitizo> feitizos) {
        List<Feitizo> feitizosPosibles = new ArrayList<>();

        for (Feitizo feitizo : feitizos) {
            if (ingredientes.containsAll(feitizo.ingredientes)) {
                feitizosPosibles.add(feitizo);
            }
        }

        /*
         * List<Feitizo> feitizos = Arrays.asList(crearFeitizosExemplo());
         * 
         * for (Feitizo f : feitizos) {
         * if (feitizos.contains(ingredientes)) {
         * feitizosPosibles.add(f);
         * }
         * }
         */
        return feitizosPosibles;
    }

    public static Map<String, Integer> ingredientesVecesUsados(Collection<Feitizo> feitizos) {
        Map<String, Integer> ingredientesUsados = new HashMap<>();
        for (Feitizo f : feitizos) {
            for (String i : f.ingredientes) {
                if (ingredientesUsados.get(i) == null) {
                    ingredientesUsados.put(i, 1);
                } else {
                    ingredientesUsados.put(i, ingredientesUsados.get(i) + 1);
                }
            }
        }
        return ingredientesUsados;
    }

    @Override
    public String toString() {
        return "Feitizo: " + nome;
    }

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
        System.out.println(feitizosPosibles(Set.of(ingredientes), List.of(crearFeitizosExemplo())));

    }

}
