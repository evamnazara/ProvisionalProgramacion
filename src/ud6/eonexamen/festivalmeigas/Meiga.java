//Eva María Otero Názara 
package ud6.eonexamen.festivalmeigas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Comparator;

public class Meiga implements Comparable<Meiga> {
    // Atributos
    private String nome;
    private String alcume;
    private List<Feitizo> feitizos;
    private Map<String, Integer> inventario;

    // Constructores
    public Meiga(String nome, String alcume, Collection<Feitizo> feitizos, Map<String, Integer> inventario) {
        this.nome = nome;
        this.alcume = alcume;
        this.feitizos = new ArrayList<Feitizo>(feitizos);
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return nome + " (" + alcume + ")\nFeitizos: " + feitizos + "\nInventario: " + inventario.toString();
    }

    
    public Map<String, Integer> getInventario() {
        return inventario;
    }

    // EXEMPLO DE USO
    public static Meiga[] crearMeigasExemplo(Feitizo[] feitizosDisponibles) {
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

    static Collection<Feitizo> getFeitizosRnd(Collection<Feitizo> feitizos) {
        // Gentea un sublista aleatoria de Feitizo
        List<Feitizo> feitizosRnd = new ArrayList<>(feitizos);
        Collections.shuffle(feitizosRnd);
        // Selecciona un número aleatorio de feitizos entre 1 e o tamaño da lista
        int numFeitizos = new Random().nextInt(feitizosRnd.size()) + 1;
        // Crea unha sublista con ese número de feitizos aleatorios
        List<Feitizo> subFeitizos = feitizosRnd.subList(0, numFeitizos);
        // Retorna a sublista como un Collection<Feitizo>
        return new ArrayList<>(subFeitizos);
    }

    static Map<String, Integer> getIngredientesRnd(Collection<String> ingredientes, int i) {
        // Gentea un mapa aleatorio de ingredientes e cantidades
        Map<String, Integer> inventario = new java.util.HashMap<>();
        List<String> ingredientesRnd = new ArrayList<>(ingredientes);
        Collections.shuffle(ingredientesRnd);
        // Selecciona un número aleatorio de ingredientes entre 1 e o tamaño da lista
        int numIngredientes = new Random().nextInt(ingredientesRnd.size()) + 1;
        // Crea un mapa con ese número de ingredientes aleatorios e cantidades entre 1 e
        // 5
        for (int j = 0; j < numIngredientes; j++) {
            String ingrediente = ingredientesRnd.get(j);
            int cantidade = new Random().nextInt(5) + 1;
            inventario.put(ingrediente, cantidade);
        }
        return inventario;
    }


    /*
     * O método lanzarFeitizos() da clase Meiga de xeito que:
     * i. a meiga tentará lanzar cada feitizo unha única vez por orde
     * decrecente de dificultade.
     * ii. O método devolverá un número enteiro que será a suma das
     * dificultades dos feitizos lanzados, e que simbolizará a puntuación
     * obtida no festival.
     * iii. a meiga só lanzará un feitizo se ten polo menos unha unidade de
     * cada ingrediente necesario. Nese caso axustarase o inventario
     * segundo os ingredientes consumidos. Se o número de unidades
     * dalgún ingrediente chega a cero eliminarase do inventario.
     * iv. Se a meiga non ten ingredientes suficientes para lanzar un feitizo
     * amosarase unha mensaxe coma a da captura.
     */

     public int lanzarFeitizos() {
        throw new UnsupportedOperationException(":(");
    }

    public int lanzarFeitizo(Feitizo feitizo) {
        int dificultades = 0;

        // só lanzará un feitizo se ten polo menos unha unidade de cada ingrediente
        // necesario
        Map<String, Integer> ingredientesNecesarios = new HashMap<>();
        for (String ingrediente : feitizo.getIngredientes()) {
            ingredientesNecesarios.put(ingrediente, 1);
        }

        for (Map.Entry<String, Integer> entry : ingredientesNecesarios.entrySet()) {
            String ingrediente = entry.getKey();
            int udNecesarias = entry.getValue();

            if (inventario.getOrDefault(ingrediente, 0) < udNecesarias) {
                System.out.println(nome + " non ten suficientes " + ingrediente + " para lanzar este feitizo.");
            }
        }

        /*
         * axustarase o inventario segundo os ingredientes consumidos. Se o número de
         * unidades
         * dalgún ingrediente chega a cero eliminarase do inventario.
         */
        for (Map.Entry<String, Integer> entry : ingredientesNecesarios.entrySet()) {
            String ingrediente = entry.getKey();
            int necesario = entry.getValue();
            inventario.put(ingrediente, inventario.get(ingrediente) - necesario);
        }

        System.out.println(nome + " lanza o feitizo: " + feitizo.getNome());
        System.out.println("A puntuación total é de: ");

        dificultades = feitizo.getDificultade();

        return dificultades;
        // devuelve suma de dificultades de los hechizos
    }
    

    public List<Feitizo> getFeitizos() {
        return feitizos;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Meiga other = (Meiga) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (alcume == null) {
            if (other.alcume != null)
                return false;
        } else if (!alcume.equals(other.alcume))
            return false;
        if (feitizos == null) {
            if (other.feitizos != null)
                return false;
        } else if (!feitizos.equals(other.feitizos))
            return false;
        if (inventario == null) {
            if (other.inventario != null)
                return false;
        } else if (!inventario.equals(other.inventario))
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println("\nMEIGAS DE EXEMPLO:");
        System.out.println("====================\n");
        // Crear un array de meigas de exemplo
        Meiga[] meigasExemplo = Meiga.crearMeigasExemplo(Feitizo.crearFeitizosExemplo());

        Comparator<Meiga> compMeiga = new Comparator<Meiga>() {
            @Override
            public int compare(Meiga o1, Meiga o2) {
                return 0;
            }
            
        };

        // Mostrar as meigas de exemplo
        for (Meiga meiga : meigasExemplo) {
            System.out.println(meiga);
            System.out.println();
        }

        Arrays.sort(meigasExemplo,compMeiga);

        // Lanzar feitizos de exemplo
        // System.out.println(meigasExemplo[0].alcume + " lanzando feitizos de
        // exemplo:");
        // meigasExemplo[0].lanzarFeitizos();
    }
    
    

    @Override
    public int compareTo(Meiga o) {
        return nome.compareTo(o.nome);
        
    }

}
