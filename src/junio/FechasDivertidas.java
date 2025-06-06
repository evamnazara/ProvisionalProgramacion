package junio;

/*Pero si se escribe con el formato habitual en los países anglosajones, donde escriben primero el mes, luego el día y finalmente el año, la situación cambia: 12−31−23. Ahora ¡aparece el 123 dos veces seguidas! Es verdad que su forma de escribir las fechas no tiene ningún sentido, porque está desordenada… la "unidad" más pequeña, los días, va en medio, por delante tiene los meses, que es la "unidad" intermedia, y detrás los años, la "unidad" más grande. Pero ¡oye! En este caso este formato da un poco de gracia a una fecha que de otro modo sería insulsa.

Crea un método fechaDivertida() que reciba una cadena con una fecha en formato dd-mm-aa y devuelva:
true si si hay una forma de ordenar los tres números de modo que formen dos bloques de 3 dígitos iguales
false en otro caso.
 */
public class FechasDivertidas {

    public static void main(String[] args) {
        System.out.println(fechaDivertida("31 12 23"));
        System.out.println(fechaDivertida("01 02 03"));
        System.out.println(fechaDivertida("90 09 99"));

        // System.out.println(Arrays.toString(partes));

        // String fecha = "31 12 23";

    }

    public static boolean fechaDivertida(String fecha) {
        String[] partes = fecha.split(" ");

        // Probar todas las combinaciones posibles de dos elementos concatenados
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == i) continue;
                int k = 3 - i - j;

                String bloque1 = partes[i] + partes[j];
                String bloque2 = partes[k] + partes[i];

                if (bloque1.length() == 3 && bloque2.length() == 3 && bloque1.equals(bloque2)) {
                    return true;
                }
            }
        }

        return false;
    }

}
