package ud6.meigas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Meiga {
    String nome;
    String alcumeMaxico;
    // List feitizosFavoritos; no sirve !! hay que poner de que es la lista
    // Hhay que invocar un alista en el constructor!!
    List<Feitizo> feitizosFavoritos;
    Map<String, Integer> inventario;

    public Meiga(String nome) {
        this.nome = nome;
        this.feitizosFavoritos = new ArrayList<>(); // Aseguramos que la lista esté inicializada

    }

    public Meiga(String nome, String alcumeMaxico) {
        this.nome = nome;
        this.alcumeMaxico = alcumeMaxico;
    }

    // para evitar el aviso del rawType, poner en Collection lo q es, <Feitizo>
    public Meiga(String nome, String alcumeMaxico, Collection<Feitizo> feitizosFavoritos) {
        this.nome = nome;
        this.alcumeMaxico = alcumeMaxico;
        // this.feitizosFavoritos = feitizosFavoritos;
        // this.feitizosFavoritos = new ArrayList<>(feitizosFavoritos); NO ESTA VACIA
        this.feitizosFavoritos = new ArrayList<>();

    }

    public Meiga(String nome, String alcumeMaxico, Collection<Feitizo> feitizosFavoritos,
            Map<String, Integer> inventario) {
        this.nome = nome;
        this.alcumeMaxico = alcumeMaxico;
        this.feitizosFavoritos = new ArrayList<>(feitizosFavoritos); // otra vez
        this.inventario = inventario;
    }

    public String getNome() {
        return nome;
    }

    public String getAlcumeMaxico() {
        return alcumeMaxico;
    }

    public List<Feitizo> getFeitizosFavoritos() {
        return feitizosFavoritos;
    }

    public Map<String, Integer> getInventario() {
        return inventario;
    }

    public void engadirFeitizoFavorito(Feitizo f) {
        if (!feitizosFavoritos.contains(f)) {
            feitizosFavoritos.add(f);
        }
    }

    // e. seleccione devolva unha colección aleatoria de feitizos a partir da
    // colección que recibe como parámetro.

    public static Collection<Feitizo> getFeitizosRnd(Collection<Feitizo> feitizosExemplo) {
        List<Feitizo> lista = new ArrayList<>(feitizosExemplo); // haces una lista nueva con los hechizos originales
        Collections.shuffle(lista); // mezclas aleatoriamente

        int n = new Random().nextInt(lista.size()) + 1; // aleatorio de int, el +1 es para coger al menos 1
        return lista.subList(0, n); // Devuelve los primeros n hechizos mezclados
    }

    /*
     * f. Crea o método getIngredientesRnd() seleccione aleatoriamente
     * ingredientes dunha colección que se lle pasa como parámetro e para cada un
     * deles un número aleatorio de unidades entre 1 e un número máximo que
     * tamén se pasa como parámetro.
     */
    public static Map<String, Integer> getIngredientesRnd(Collection<String> ingredientesExemplo, int udMaximas) {
        Map<String, Integer> ingredientesAleatorios = new HashMap<>(); // generar el mapa
        Random rnd = new Random();

        for (String ingrediente : ingredientesExemplo) {
            // por ejemplo, un 50% de probabilidad de incluir el ingrediente
            if (rnd.nextBoolean()) {
                int cantidad = rnd.nextInt(udMaximas) + 1; // Entre 1 y udMaximas
                ingredientesAleatorios.put(ingrediente, cantidad);
            }
        }

        return ingredientesAleatorios;
    }

    // Xerar unha lista de meigas que comparten un mesmo ingrediente nun dos seus
    // feitizos favoritos.
    public static List<Meiga> meigasCompartenIngrediente(List<Meiga> meigas, String ingrediente) {
        List<Meiga> compartenIngredientes = new ArrayList<>();
        for (Meiga meiga : meigas) {
            for (Feitizo f : meiga.getFeitizosFavoritos()) {
                if (f.getIngredientes().contains(ingrediente)) {
                    compartenIngredientes.add(meiga);
                }
            }
        }
        return compartenIngredientes;
    }

    // Implementa un sistema de recomendación: dado un ingrediente, suxerir ás
    // meigas un novo feitizo que o use e que non teñan nos seus favoritos.
    public static List<Feitizo> recomendarFeitizosPorIngrediente(List<Feitizo> base, Meiga meiga, String ingrediente) {
        List<Feitizo> recomendados = new ArrayList<>();
        for (Feitizo feitizo : base) {
            if (feitizo.getIngredientes().contains(ingrediente) && !meiga.getFeitizosFavoritos().contains(feitizo)) {
                recomendados.add(feitizo);
            }
        }
        return recomendados;
    }

    /*
     * g. Crea un método de instancia lanzarFeitizo(Feitizo) que, en caso de que
     * haxa ingredientes suficientes, imprima o nome da meiga e do feitizo e elimine
     * do inventario os ingredientes utilizados.
     * se comprueba que se pueda lanzar, (si esta en su lista y si tiene
     * ingredientes) y si si, que se lance un hechizo y se resten los ingredientes
     * de esa lista
     */

    
     //tiene q devolver la suma de las dificultades
    public void lanzarFeitizo(Feitizo feitizo) {
        // Verifica si el hechizo está entre sus favoritos
        if (!feitizosFavoritos.contains(feitizo)) {
            System.out.println(nome + " non coñece o feitizo " + feitizo.getNome());
            return;
        }

        // NOTA: aquí daba un error Type mismatch: cannot convert from List<String> to
        // Map<String,Integer>
        // Map<String, Integer> ingredientesNecesarios = feitizo.getIngredientes();
        // SE cambia de una Lista a un mapa.

        Map<String, Integer> ingredientesNecesarios = new HashMap<>();
        for (String ingrediente : feitizo.getIngredientes()) {
            ingredientesNecesarios.put(ingrediente, 1); // Asumiendo que se necesita 1 unidad de cada ingrediente
        }

        // Verifica si tiene ingredientes suficientes
        for (Map.Entry<String, Integer> entry : ingredientesNecesarios.entrySet()) {
            String ingrediente = entry.getKey();
            int udNecesarias = entry.getValue();

            if (inventario.getOrDefault(ingrediente, 0) < udNecesarias) {
                System.out.println(nome + " non ten suficientes " + ingrediente + " para lanzar o feitizo.");
                return;
            }
        }

        // Si tiene todos los ingredientes, los descuenta del inventario, y si llega a 0, se elimina
        for (Map.Entry<String, Integer> entry : ingredientesNecesarios.entrySet()) {
            String ingrediente = entry.getKey();
            int necesario = entry.getValue();
            inventario.put(ingrediente, inventario.get(ingrediente) - necesario);
        }

        System.out.println(nome + " lanza o feitizo: " + feitizo.getNome());
    }

    public static Meiga[] crearMeigasExemplo(Feitizo[] feitizosDisponibles) {
        // Random rnd = new Random();

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

            // PARA EL ERROR he constructor Meiga(String, String, Collection<Feitizo>,
            // Map<String,Integer>) is undefined
            // se arregla cambiando el constructos a una Coleccion, en vez de una lista
        }

        return meigas;

    }

    @Override
    public String toString() {
        return "Meiga.\nNome: " + nome + "\nAlcume máxico=" + alcumeMaxico + "\n Feitizos Favoritos="
                + feitizosFavoritos
                + ", inventario: " + inventario;
    }

}
