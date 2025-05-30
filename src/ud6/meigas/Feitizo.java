package ud6.meigas;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

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

    public Feitizo(String nome, String[] ingredientes, Integer nivelDificultade) {
        this.nome = nome;
        // this.ingredientes = Arrays.asList(ingredientes); despues esta linea da
        // problemas porq la lista no se puede alterar
        // alt: this.ingredientes = List.of(ingredientes);

        this.ingredientes = new ArrayList<>(Arrays.asList(ingredientes)); // Lista mutable

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
        if (ingrediente.isEmpty())
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
        if (ingredientes != null && ingredientes.contains(ingrediente)) { // comprueba si esta
            ingredientes.remove(ingrediente); // se elimina ok
            return true;
        }
        return false;
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

    // Contar cal é o ingrediente máis usado.
    public static String ingredienteMaisUsado(Collection<Feitizo> feitizos) {
        Map<String, Integer> contador = ingredientesVecesUsados(feitizos);

        String maisUsado = null;
        int max = 0;

        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maisUsado = entry.getKey();
            }
        }
        return maisUsado;
    }
    // Implementa un sistema de recomendación: dado un ingrediente, suxerir ás
    // meigas un novo feitizo que o use e que non teñan nos seus favoritos.
    // Buscar feitizos que compartan ingredientes

    public static List<Feitizo> feitizosConIngredientesComunes(Feitizo base, List<Feitizo> todos) {
        List<Feitizo> feitizosComparten = new ArrayList<>();
        for (Feitizo f : todos) {
            if (f == base) {
                for (String i : f.getIngredientes()) {
                    if (base.getIngredientes().contains(i)) {
                        feitizosComparten.add(f);
                        break;
                    }
                }
            }

        }
        return feitizosComparten;
    }

    // Recomendar feitizos a meigas segundo ingredientes favoritos.
    public static List<Feitizo> recomendarPorIngredientesFavoritos(Meiga meiga, List<Feitizo> base) {
        Set<String> favoritos = new HashSet<>();
        for (Feitizo f : meiga.getFeitizosFavoritos()) {
            favoritos.addAll(f.getIngredientes());
        }

        List<Feitizo> recomendados = new ArrayList<>();
        for (Feitizo f : base) {
            if (meiga.getFeitizosFavoritos().contains(f))
                continue;
            for (String ing : f.getIngredientes()) {
                if (favoritos.contains(ing)) {
                    recomendados.add(f);
                    break;
                }
            }
        }
        return recomendados;
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

        // Feitizo[] feitizos = crearFeitizosExemplo();

        // System.out.println(ingredientesUnicos(List.of(feitizos)));
        // System.out.println(ingredientesVecesUsados(List.of(feitizos)));
        // String[] ingredientes = { "auga do mar", "salicornia", "berberechos místicos"
        // };
        // System.out.println(feitizosPosibles(Set.of(ingredientes),
        // List.of(crearFeitizosExemplo())));

        // Crear feitizos de ejemplo
        Feitizo[] feitizos = crearFeitizosExemplo();
        List<Feitizo> listaFeitizos = Arrays.asList(feitizos);

        System.out.println("--- Ingredientes únicos ---");
        System.out.println(ingredientesUnicos(listaFeitizos));

        System.out.println("\n--- Feitizos posibles con ingredientes dados ---");
        Set<String> misIngredientes = Set.of("auga do mar", "salicornia", "berberechos místicos");
        System.out.println(feitizosPosibles(misIngredientes, listaFeitizos));

        System.out.println("\n--- Veces que se usan los ingredientes ---");
        System.out.println(ingredientesVecesUsados(listaFeitizos));

        System.out.println("\n--- Ingrediente máis usado ---");
        System.out.println(ingredienteMaisUsado(listaFeitizos));

        System.out.println("\n--- Añadir, eliminar y cambiar ingredientes ---");
        // contructor indefinido -> Feitizo prueba = new Feitizo("Proba Mágica", new
        // ArrayList<>(List.of("lama dourada", "fume de lareira")), 1);
        Feitizo prueba = new Feitizo("Proba Mágica", new String[] { "lama dourada", "fume de lareira" }, 1);
        System.out.println("Original: " + prueba.getIngredientes());

        prueba.addIngrediente("auga bendita");
        System.out.println("Tras añadir: " + prueba.getIngredientes());

        prueba.removeIngrediente("fume de lareira");
        System.out.println("Tras eliminar: " + prueba.getIngredientes());

        prueba.cambiarIngrediente("lama dourada", "folla de carballo");
        System.out.println("Tras cambiar: " + prueba.getIngredientes());

        System.out.println("\n--- Feitizos que usan un ingrediente ---");
        System.out.println(feitizosUsanIngrediente("auga do mar"));

        System.out.println("\n--- Recomendacións para unha meiga ---");

        Meiga meiga = new Meiga("Morgana");
        meiga.engadirFeitizoFavorito(feitizos[0]); // Encantamento da Chuvia Mansa
        meiga.engadirFeitizoFavorito(feitizos[5]); // Bendición Floral

        System.out.println("Favoritos da meiga: " + meiga.getFeitizosFavoritos());
        List<Feitizo> recomendados = recomendarPorIngredientesFavoritos(meiga, listaFeitizos);
        System.out.println("Recomendados: " + recomendados);

    }

}
