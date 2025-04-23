//Eva María Otero Názara

package ud4.eonexamenrec;

public class Vogais {
    public static void main(String[] args) {
        String frase = "que dices, lombrices";

        char vogal = 'e';
        System.out.println(cambiaVogais(frase, vogal));
    }

    //si es minuscula devuelve minuscula
    static String cambiaVogais(String str, char vogal) {
        String fraseCambiada = "";
        //String vogais = "aeiouAEIOU";

        for( int i = 0; i < str.length(); i++) {
        Character caracter = str.charAt(i);

            if (caracter.equals(vogal)) { 
                fraseCambiada = str.replace('e', 'a').replace('i','a').replace('o', 'a').replace('u', 'a');
            }

        }

        return fraseCambiada;
    }
    
}

/*Implementa unha función que reciba como parámetros de entrada unha frase e unha vogal
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