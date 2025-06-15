package ud4.aceptaelreto.arrays;

public class SalvemosALLince {

    public static void main(String[] args) {
        // Crear un scanner para leer la entrada
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Leer el número de casos de prueba
        System.out.print("Introduce el número de descripciones de carreteras: ");
        int numCasos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Procesar cada caso de prueba
        for (int i = 0; i < numCasos; i++) {
            System.out.print("Introduce la descripción de la carretera para el caso " + (i + 1) + ": ");
            String carretera = scanner.nextLine();
            int tuneles = calcularTuneles(carretera);
            System.out.println("Número mínimo de túneles necesarios: " + tuneles);
        }

        // Cerrar el scanner
        scanner.close();
    }

    // Función para calcular el número mínimo de túneles necesarios
    public static int calcularTuneles(String carretera) {
        int tuneles = 0;
        int i = 0;
        int n = carretera.length();

        // Recorrer la carretera
        while (i < n) {
            // Si encontramos una sección sin valla ('.')
            if (carretera.charAt(i) == '.') {
                tuneles++; // Colocamos un túnel en esta sección
                i += 3; // Saltamos 3 secciones (el túnel cubre esta y las dos siguientes)
            } else {
                i++; // Si es una sección vallada, simplemente avanzamos
            }
        }

        return tuneles;
    }
}

/*
 * Salvemos al lince ibérico
 * 
 * Una señal de tráfico que recuerda la existencia de linces en las
 * inmediaciones
 * El lince ibérico (Lynx pardinus) es un animal que habita en la península
 * ibérica. Desgraciadamente, a día de hoy quedan muy pocos individuos (no
 * muchos más de 300) lo que hace que sea la especie de felino más amenazada del
 * mundo.
 * 
 * Una de las amenazas principales de esta especie son los atropellos en las
 * carreteras. Por eso es importante adecuar las infraestructuras de las pocas
 * zonas donde habitan para minimizar las posibilidades de que estos preciosos
 * animales terminen cruzando por el asfalto.
 * 
 * Hace años se hizo el esfuerzo de colocar, en muchas carreteras que atraviesan
 * el hábitat de los linces, vallas protectoras que no permiten que éstos salten
 * desde los laterales hacia la carretera. Se instalaron en las zonas de baja
 * visibilidad donde era probable que al conductor no le diera tiempo a ver con
 * la antelación suficiente a un despistado lince cruzando.
 * 
 * Sin embargo, no todo el mundo estuvo a favor, pues, aseguraban, hay mejores
 * soluciones que las vallas. Los ecologistas, por ejemplo, consideran que
 * debido a la imposibilidad de ser cruzadas, las carreteras valladas
 * interrumpen las rutas de migración y segmentan las poblaciones de vida
 * silvestre. Por su parte, los expertos en seguridad vial las ven peligrosas,
 * pues ante un accidente impiden que los accidentados puedan abandonar la
 * carretera y dirigirse al campo.
 * 
 * La polémica ha vuelto a abrirse, porque se quiere ampliar el programa de
 * protección para garantizar que no habrá más muertes de linces, asegurando
 * también el resto de tramos que aún no tienen valla. La opción que se está
 * planteando en estos momentos es la construcción de pequeños pasos
 * subterráneos o túneles por debajo de las carreteras. Cuando existen, los
 * animales que quieren cruzar, en vez de pisar el frío asfalto, se decantan por
 * ir por el túnel, salvándose así de una muerte casi segura.
 * 
 * Los ingenieros de caminos han dividido las carreteras en secciones de 100
 * metros de longitud, y ahora tienen que decidir dónde colocan esos pasos
 * subterráneos. Los biólogos expertos en linces han determinado que un túnel
 * colocado en una sección da servicio a tres secciones; es decir, si un lince
 * llega a una sección sin vallar y sin paso subterráneo, no se lanzará a cruzar
 * por la carretera si una de las secciones adyacentes tiene túnel.
 * 
 * Aún se está en una fase muy temprana del proyecto y, de momento, se quiere
 * plantear un presupuesto. Éste depende únicamente del número de túneles y no
 * de su posición. Dada la descripción de una carretera, ¿cuál es el mínimo
 * número de túneles que hay que construir para que los linces no crucen por el
 * asfalto?
 * 
 * Entrada
 * La entrada comienza con un número que indica cuántas descripciones de
 * carreteras vendrán a continuación. Cada descripción consta de una única línea
 * de no más de 10.000 caracteres. Cada uno de esos caracteres representa una
 * sección de la carretera y puede ser o bien . o bien X. El símbolo X indica
 * que esa sección ya tiene colocada una valla y que por lo tanto los linces no
 * podrán cruzar por ahí. Los . indican secciones por las que un lince podría
 * intentar cruzar y que, por tanto, hay que proteger con un paso subterráneo.
 * 
 * Salida
 * +Para cada caso de prueba se escribirá una única línea con un número que
 * indique el número mínimo de pasos subterráneos que hay que construir. Ten en
 * cuenta que lo que se quiere evitar es que los linces crucen la carretera por
 * la superficie en cualquier punto, algo que ya consiguen las vallas en sus
 * tramos (X). No obstante, es posible, si así se considera oportuno, construir
 * un paso subterráneo en un tramo vallado.
 * 
 * Entrada de ejemplo
 * 3
 * ...
 * ...X.
 * XXX.X.
 * Salida de ejemplo
 * 
 * 1
 * 2
 * 1
 * 
 */