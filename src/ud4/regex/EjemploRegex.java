package ud4.regex;
import java.util.*;  


class EjemploRegex {  
 
    public static void main(String[ ] args) {  
  
       String respuesta;  
       boolean siguePatron = false;

       Scanner sc = new Scanner(System.in);  
       do{  
          System.out.print("Escribe una matrícula: ");  
          respuesta = sc.nextLine();  
          siguePatron = respuesta.matches("[0-9]{4}[BCDFGHJKLMPRSTWXZ]{3}+");
          respuesta.split(" "); //separa la cadena por espacios 

          if(!siguePatron)  
             System.out.println("La expresion no encaja con el patrón");  
          } while(!siguePatron);  
  
       System.out.println("Expresión correcta!");  

       sc.close();
    }  
 } 