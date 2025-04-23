package ud3.ejerciciosapi;

public class ClasesEnvolventes {
    public static void main(String[] args) {
        int k = 23;
        //Integer num = new Integer(k);
        //tachado por obsoleta

        Integer num = k;
            //convierte a objeto, inicializa e integra en la misma sentencia
            System.out.println(num);
        
        String s = "4.56";
        Float ft = Float.valueOf(s);
            //convierte el valor de string al numero previo de s 
            //no se imprime
        
        float floatPrimitivo = ft.floatValue(); //lo imprime
        System.out.println(floatPrimitivo);
        System.out.println("fin");


        //parse - moldear como X tipo de dato lo que se le esté pasando
        //SI QUIERES TRABAJAR CON UN VALOR PRIMITIVO -- PARSE
        //SI NECESITAS TRABAJAR CON OBJETOS -- VALUE OF


        /* ===========  CONVERSION A DECIMAL:
        Ejemplo: convertimos un número binario a decimal, declarándonos un int.
        Con el método parseInt, el primer parámetro será el número en binario (en forma de
        String), y en el siguiente, su base (2).*/ 

        int a = Integer.parseInt("101", 2);
        System.out.println (a);
        //El resultado por consola, será un 5.
        

    }
}
