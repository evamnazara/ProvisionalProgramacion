package junio;

/*Pero si se escribe con el formato habitual en los países anglosajones, donde escriben primero el mes, luego el día y finalmente el año, la situación cambia: 12−31−23. Ahora ¡aparece el 123 dos veces seguidas! Es verdad que su forma de escribir las fechas no tiene ningún sentido, porque está desordenada… la "unidad" más pequeña, los días, va en medio, por delante tiene los meses, que es la "unidad" intermedia, y detrás los años, la "unidad" más grande. Pero ¡oye! En este caso este formato da un poco de gracia a una fecha que de otro modo sería insulsa.

Crea un método fechaDivertida() que reciba una cadena con una fecha en formato dd-mm-aa y devuelva:
true si si hay una forma de ordenar los tres números de modo que formen dos bloques de 3 dígitos iguales
false en otro caso.
 */
public class FechasDivertidas {

    public static void main(String[] args) {
        System.out.println(fechaDivertida("31 12 23")); // ✅ true
        System.out.println(fechaDivertida("01 02 03")); // ❌ false
        System.out.println(fechaDivertida("23 12 31")); // ✅ true
        System.out.println(fechaDivertida("90 09 99")); // ❌ false
    }

    public static boolean fechaDivertida(String fecha) {
        String[] partes = fecha.split(" "); // divide en [dd, mm, aa]

        // Probar las 6 permutaciones posibles de las tres partes
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == i)
                    continue;
                for (int k = 0; k < 3; k++) {
                    if (k == i || k == j)
                        continue;

                    // Concatenamos las 3 partes en un orden específico
                    String combinacion = partes[i] + partes[j] + partes[k];

                    // Comprobamos si los primeros 3 dígitos son iguales a los últimos 3
                    if (combinacion.length() == 6 &&
                            combinacion.substring(0, 3).equals(combinacion.substring(3, 6))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}