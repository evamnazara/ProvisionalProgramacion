package mulleres;

import java.util.Arrays;

public class Mulleres {
    public static void main(String[] args) { 
        
        Cientifica marieCurie = new Cientifica("Marie", "Curie", 1867, "Descubriu o radio e o polonio");
        Artista fridaKahlo = new Artista("Frida", "Kahlo", 1907, "Surrealismo e pintura autobiográfica"); 
        Politica rosaParks = new Politica("Rosa", "Parks", 1913, "Loita polos dereitos civís e contra a segregación racial"); 
        Cientifica adaLovelace = new Cientifica("Ada", "Lovelace", 1815, "Primeira programadora da historia"); 
     
        // al hacer el array hay que implementarlo en una clase comun -- la superclase 
        MullerTraballadora[] mulleres = {marieCurie, fridaKahlo, rosaParks, adaLovelace};

        Arrays.toString(mulleres);

        //REVISAR EL CODIGO DE OSCAR - FALTA LA ULITMA PARTE
    }
}
