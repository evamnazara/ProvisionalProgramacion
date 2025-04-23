/*
EP0713. En el momento de decorar una casa, una habitación o cualquier objeto, se plantea 
el problema de elegir la paleta de colores que vamos a utilizar en nuestra decoración. Existe 
una solución, algo atrevida, que consiste en utilizar colores al azar. 
Diseña la clase Colores, que alberga por defecto una serie de colores (mediante una 
cadena), aunque es posible añadir tantos como necesitemos. La clase tendrá un método 
que devuelve una tabla con los n colores que necesitemos elegidos al azar sin repeticiones. 
*/ 
package ud5.clasesejercicios.EP0713_Colores;

import java.util.Arrays;
//import java.util.Random;

public class Colores {
    String color;
    String[] colores = {"Beige", "Verde", "Negro"};



    public Colores(String color, String[] colores) {
        this.color = color;
        this.colores = colores;
    }
    public Colores(String color) {
        this.color = color;
    }



    private void addColor() {
        throw new UnsupportedOperationException("Unimplemented method 'addColor'");
    }
    
    public String elegirColores(int numColores, String color){
        String[] coloresAzar = null;
       // Random rnd = new Random();


        return Arrays.toString(coloresAzar);
    }
    
    //main
    
    public static void main(String[] args) {
            Colores rosa = new Colores("rosa");

            rosa.addColor();
    
     }
                    
                    
}
