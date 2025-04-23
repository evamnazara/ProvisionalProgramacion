
//INMOBILIARIA 1 Y 2 
package Inmobiliaria;

import java.util.Arrays;

public class AppInmobiliaria {
   @SuppressWarnings("unchecked")
   public static void main(String[] args) {
        //Crea un piso en una 5a planta, de 100m2, 3 habitaciones y 2 baños en la dirección “Calle Curtidoira”. 
        //Establece los precios de alquiler y de Venta. 

        Inmueble piso1 = new Piso("Calle Curtidoira", 100, 3, 2, 5); 
        piso1.setPrecioAlquiler(500); 
        piso1.setPrecioVenta(200000);
         
        // Crea otros dos pisos 
        Inmueble piso2 = new Piso("Praza Maior", 80, 2, 2, 3); 
        piso2.setPrecioAlquiler(400); 
        Inmueble piso3 = new Piso("Calle Rosalía de Castro", 140, 4, 2, 2); 
        piso3.setPrecioVenta(250000); 
        
        // Crea una casa de 250m2 construídos, 3000m2 de terreno, 4 habitaciones y 3 baños en la dirección “Carretera de Marín”. 
        Inmueble casa1 = new Casa("Carretera de Marín", 250, 4, 3, 3000); 
        casa1.setPrecioAlquiler(800); 
        casa1.setPrecioVenta(350000); 
        
        // Crea otra casa 
        Inmueble casa2 = new Casa("Lapaman", 150, 3, 2, 1000); 
        casa2.setPrecioVenta(400000); 
        
        // Imprimir Inmueble: Piso, Casa 
        System.out.println(piso1); 
        System.out.println(casa1); 
        System.out.println(""); 
        
        // Mostrar Detalle Inmueble: Piso, Casa 
        System.out.println(piso1.detalle()); 
        System.out.println(""); 
        System.out.println(piso2.detalle()); 
        System.out.println(""); 
        System.out.println(casa2.detalle());




      //SEGUNDA PARTE DEL EJERCICIO 

        // 1.2. Lista de inmuebles 
         System.out.println("\nTODOS LOS INMUEBLES:"); 
         Inmueble[] inmuebles = {piso1, piso2, piso3, casa1, casa2};
         Inmueble.mostrarInmuebles(inmuebles); 


         System.out.println("\nINMUEBLES ORDENADOS ALFABETICAMENTE:");
         CompInmAlfabeticamente comparaAlfabeticamente = new CompInmAlfabeticamente();
         Arrays.sort(inmuebles,comparaAlfabeticamente);
         Inmueble.mostrarInmuebles(inmuebles); 
         

         System.out.println("\nINMUEBLES ORDENADOS  POR m2 (ascendente):");
         CompInmM2 comparaMetros = new CompInmM2();
         Arrays.sort(inmuebles,comparaMetros);
         Inmueble.mostrarInmuebles(inmuebles); 

      }
      
     
         
      

}
