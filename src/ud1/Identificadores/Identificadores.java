package ud1.Identificadores;

public class Identificadores {
    
    public static void main(String[] args) {

        final  int NUMERO_ALUMNOS = 33; 
            /** *las constantes  (final int) se escribe en mayuscula separada por _ */

        String numeroDeTelefono = "666666666"; 
        double totalVentas = 567.55;
        byte edad;
        edad = 0b10000;
            /** * 0b lo convierte a binario si el numero no se sale de rango */
        edad = (byte) (edad + 1);  // conversion explicita: para cuando no puede hacerlo solo //


        float monedero = 50.35f;
            /** *java pasa a interpretar el numero como float y no double si se añade la s */


        long numeroEnorme = 9223372036854775807l;
            /** *java pasa a interpretar el numero como long en vez de int si se añade la l  */

        boolean estaLloviendo;

        String minombre = "Eva"; 

        char letraPreferida ='a';
            /** * char se marca con '' no con ""  */


        System.out.print("Numero de telefono "); 
            /** * print saca el dato  sin saltar de linea  */
        System.out.println(numeroDeTelefono);

        System.out.println("Total ventas:" + totalVentas);
            /** *  + concatena los datos (texto + variable)  */

        System.out.println("Me llamo " + minombre);

        estaLloviendo = true;
        System.out.println("Está lloviendo? " + estaLloviendo);

        System.out.println("Letra preferida: " + letraPreferida);
        System.out.println(edad); 
            /** *  devuelve el decimal (16) del valor binario que le dimos (10000)  */
    
        System.out.println(monedero);
        System.out.println(numeroEnorme);

        System.out.println("hay " + NUMERO_ALUMNOS + " alumnos en DAM1");

    }    
}
