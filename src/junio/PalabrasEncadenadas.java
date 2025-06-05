package junio;

/*
Haz un programa/método que valide si una lista de palabras encadenadas es válida o no.

Entrada: una serie de entre 1 y 50 palabras en una misma línea. 
Cada palabra, de un mínimo de 2 caracteres y un máximo de 24, está separada de la siguiente mediante un espacio.

Podemos suponer que las palabras utilizadas están formadas por sílabas de dos letras.
Se considera que dos palabras están encadenadas si la última sílaba de la primera palabra es igual que la primera de la segunda. 
Para las palabras que tienen una única sílaba, ésta se considera simultáneamente la primera y la última.

Exigiremos que no sólo el sonido sea igual, sino que la grafía también lo sea. 
No obstante, todas las palabras se escribirán en minúscula y no se tendrán vocales con tilde u otros símbolos no pertenecientes al alfabeto inglés.

Salida: true si todas las palabras de la serie están correctamente encadenadas, y false en caso contrario.

 */
public class PalabrasEncadenadas {

    public static boolean esEncadenada(String cad) {
        if (cad.length() < 1 || cad.length() > 50) {
            System.out.println("La cadena debe contener entre 1 y 50 palabras");
            return false;
        }

        String[] palabras = cad.split(" ");

        if (palabras.length < 2 || palabras.length > 24) {
            System.out.println("Las palabras deben tener entre 2 y 24 carácteres");
            return false;            
        }

        for (int i = 0; i < palabras.length -1; i++) {
            String palabraActual = palabras[i];

            String palabraSiguiente = palabras [i + 1];

            String ultSilaba = palabraActual.substring(palabraActual.length() - 2);

            String primSilaba = palabraSiguiente.substring(0,2);
            if (ultSilaba.equals(primSilaba)) {
                return true;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        System.out.println(esEncadenada("a"));
        System.out.println(esEncadenada("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(esEncadenada("gugutata"));
        System.out.println(esEncadenada("mata tapa papa pato"));
        System.out.println(esEncadenada("seto taco coma matute")); //f
        System.out.println(esEncadenada("sien encima mapa patuco comida"));
        System.out.println(esEncadenada("cata tasama malote tejaba batama"));
        System.out.println(esEncadenada("kiosko comida")); //f

    }


    
}
