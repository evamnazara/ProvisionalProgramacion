package ud1.Expresiones;

// import Identificadores.operaciones;

public class conversiones {
    public static void main(String[] args) {
       /*  
        // Ejercicio 3: Conversión implícita entre tipos primitivos

        short s = 5;
        int i = s;
        long l = i ;
        float f = l;
        double d = f;

        d += 1000000000; //un numero tan grande java lo convierte en circular para comprimirlo
        s = (short) d; //fuerza la compresion aunque el tipo no sea conversible
        System.out.println(s); //comprime el doble - se pierde el decimal
        System.out.println(d); 

       // Ejercicio 4: Conversión explícita de double a int en divisiones

        int a = 5;
        double b = 2.0;
        double resultado = a / b; 
        System.out.println(resultado); //devuelve el tipo mas concreto 
        
        // Ejercicio 5: Casting de tipos primitivos a char

        

        int num = 65;
        char letra = (char) num; //convierte el numero a letra
        letra++; //aumenta el valor en 1 > siguiente letra
        
        boolean mayuscula = letra >= 'A' && letra <= 'Z';

        System.out.println(letra++); 
        System.out.println(mayuscula);

        System.out.println("en minuscula sería " + (char)(letra + 32) );

        
        // Ejercicio 6: Conversión de tipos en operaciones con literales

        

        int x = 100;
        double y = 20.5;
        double resultado = x + y;

        System.out.println((int)resultado);

        Ejercicio 7: Casting con pérdida de información

        long grande = 9876543210L;
        int pequeno = (int) grande;
        System.out.println((byte)pequeno);
        
       // Ejercicio 8: Conversión de tipos con caracteres y números
       // convierte el char a su equivalente ascii 

        

        char c = 'w';
        int ascii = (int) c;

        System.out.println(ascii);

        // Ejercicio 9: Conversión de tipos con byte y operaciones aritméticas
       
        byte b = 120;
        int resultado = b + 10;
        System.out.println(resultado);


        // Ejercicio 10: Conversión de String a tipos numéricos


        String numeroTexto = "100";
        int numero = Integer.parseInt(numeroTexto);
        System.out.println(numero);

       // EJERCICIO COMBINADO
       
        

        int a = 5;
        double b = 6.4;
        double c = (double) b + a / 2.0;
        System.out.println(c);
        */

        //EJERCICIO COMBINADO 2

        byte x = 50;
        int y = 200;
        double resultado = (double) (x + y) / 3;
        System.out.println(resultado);

     
    }
}
