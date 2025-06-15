package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class GalosRomanos {

    public static void main(String[] args) {
        // Crear un scanner para leer la entrada
        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de casos de prueba
        int casosDePrueba = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea después del número de casos

        // Recorremos los casos de prueba
        for (int i = 0; i < casosDePrueba; i++) {
            // Leer el nombre completo del caso de prueba
            String nombre = sc.nextLine().trim(); // Eliminar espacios al principio y al final

            // Variable para determinar el origen
            String origen = "";

            // Verificar si el nombre es "PICTO"
            if (nombre.startsWith("MAC")) {
                origen += "PICTO ";
            }

            // Verificar si el nombre termina en las terminaciones correspondientes
            if (nombre.endsWith("IX")) {
                origen += "GALO ";
            }
            if (nombre.endsWith("US") || nombre.endsWith("UM")) {
                origen += "ROMANO ";
            }
            if (nombre.endsWith("IC")) {
                origen += "GODO ";
            }
            if (nombre.endsWith("AS")) {
                origen += "GRIEGO ";
            }
            if (nombre.endsWith("AF")) {
                origen += "NORMANDO ";
            }
            if (nombre.endsWith("IS") || nombre.endsWith("OS") || nombre.endsWith("AX")) {
                origen += "BRETON ";
            }
            if (nombre.endsWith("EZ")) {
                origen += "HISPANO ";
            }
            if (nombre.endsWith("A")) {
                origen += "INDIO ";
            }

            // Limpiar el espacio extra al final del string
            origen = origen.trim();

            // Si el origen tiene más de una categoría, es "MULATO"
            if (origen.contains(" ") && !origen.contains("MULATO")) {
                origen = "MULATO";
            }

            // Si no hay ningún origen, es "PLUS ULTRA"
            if (origen.isEmpty()) {
                origen = "PLUS ULTRA";
            }

            // Mostrar el resultado
            System.out.println(origen);
        }

        // Cerrar el scanner
        sc.close();
    }
}

/*
 * Galos, romanos y otras gentes
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * Obélix riéndose sobre el nombre de los Normandos
 * En los cómics de cierto galo irreductible, es posible averiguar la
 * procedencia de un personaje a partir de su nombre. Por ejemplo, Astérix,
 * Caius Bonus, Teóric o Plexiglás tienen las terminaciones específicas de
 * galos, romanos, godos y griegos respectivamente.
 * 
 * Los nombres elegidos buscan ser humorísticos, apoyándose a menudo en
 * pronunciaciones parecidas para crear juegos de palabras. Por desgracia, no
 * son siempre fáciles de traducir, y en ocasiones se pierde el sentido. Por
 * ejemplo, el perro de Obelix, Idéfix (o Ideafix, según el cómic) en francés
 * coincide fonéticamente con idée fixe que significa "idea fija". Por su parte,
 * Asurancetúrix, el bardo, en el original es Assurancetourix que suena como
 * assurance tous risques, que significa "seguro a todo riesgo".
 * 
 * Ejemplos de nombres de los diferentes pueblos que aparecen en los cómics son:
 * 
 * Galos: terminan en -ix: Astérix, Obélix, Panoramix, Idéfix, Asurancetúrix,
 * Abraracúrcix, Caligulaminix.
 * Romanos: terminan en -us o -um: Caius Bonus, Gracolinus, Belicus, Nihablarum,
 * Caius Rodrigus, Julius Pompilious, Caligula Minus.
 * Godos: terminan en -ic: Teóric, Histéric, Periféric, Clorhídric, Teleféric,
 * Quiméric.
 * Griegos: terminan en -as: Plexiglás, Sopaconondas, Fuldeas.
 * Normandos: terminan en -af: Olaf Grosenbaf, Soldaf, Paf, Cinematograf, Pataf,
 * Batiscaf, Epitaf, Complementaf, Mataf, Soldaf, Castaniaf.
 * Bretones: terminan en -is, -os o -ax: Espikininglis, Cassivellaumos, Bigbos,
 * Buentórax, Relax, Furax, Ántrax, Danlax, Mustax.
 * Hispanos: terminan en -ez: Sopalajo de Arrierez, Sueltalamosca y Acelerez,
 * Porrompompero y Fandanguez.
 * Indios: terminan en -a: Ahivá, Passayá, Dhalekanya, Fahazada, Majarahatha,
 * Ermahana.
 * Pictos: empiezan por Mac: Mac Loch, Mac Abeo, Mac II, Mac Ariño, Mac Mini,
 * Mac Ramé, Mac Uto, Mac Areto, Macario.
 * Entrada
 * La entrada comienza con un número que indica la cantidad de casos de prueba
 * que vendrán a continuación.
 * 
 * Cada caso de prueba será un nombre de no más de 50 letras (quizá con
 * espacios) en una única línea. Los nombres tendrán únicamente letras del
 * alfabeto inglés en mayúsculas (sin tildes).
 * 
 * Salida
 * El programa escribirá, para cada caso de prueba, el origen del nombre: GALO,
 * ROMANO, GODO, GRIEGO, NORMANDO, BRETON, HISPANO, INDIO o PICTO. Si el nombre
 * puede pertenecer a más de una localización, se indicará MULATO. Si no es
 * posible identificar el origen, se escribirá PLUS ULTRA.
 * 
 * Entrada de ejemplo
 * 3
 * ASTERIX
 * SOPALAJO DE ARRIEREZ
 * AHIVA
 * Salida de ejemplo
 * 
 * GALO
 * HISPANO
 * INDIO
 */