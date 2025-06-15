package junio.examenesPasados.tema4_rec;

/* 3. vogais (4)
Implementa unha función que reciba como parámetros de entrada unha frase e unha vogal
(a, e, i, o, u) e que devolva unha copia da mesma frase pero con todas as vogais
substituídas pola que se lle indicou como parámetro de entrada.
A función deberá ter en conta a distinción entre maiúsculas e minúsculas, é dicir, as vogais
maiúsculas substituiranse pola vogal indicada en maiúscula e as vogais minúsculas pola
correspondente minúscula.
As vogais con tilde ou con diérese (ü) substituiranse pola vogal correspondente, maiúscula
ou minúscula, sen tilde nin diérese.
static String cambiaVogais(String str, char vogal)
Exemplo:
Frase: “Programar en Java mentres fas piragüismo é complicado”
Vogal: “i”
Resultado: “Prigrimir in Jivi mintris fis pirigiismi i cimplicidi” */
public class Vogais {

    public static void main(String[] args) {

        String frase = "QuÉ DICES lombrices";
        String fraseCambiada = cambiaVogais(frase, 'a');
        System.out.println(frase);
        System.out.println(fraseCambiada);

    }

    public static String cambiaVogais(String str, char vogal) {
        if (str == null || vogal == 0) {
            return str;
        }

        String vogais = "aeiouAEIOU";
        String vogaisTildes = "áéíóúÁÉÍÓÚ";
        String fraseCambiada = "";

        for (int i = 0; i < str.length(); i++) {
            char letra = str.charAt(i);

            if (vogais.indexOf(letra) != -1 || vogaisTildes.indexOf(letra) != -1) {
                // si es -1 es vocal (o con tilde), la cambiamos

                if (Character.isUpperCase(letra)) {
                    fraseCambiada += Character.toUpperCase(vogal);
                } else { // si es vocal pero no mayuscula
                    fraseCambiada += vogal;
                }
            } else { // si no es vocal sale
                fraseCambiada += letra;
            }
        }

        return fraseCambiada;

    }

}
