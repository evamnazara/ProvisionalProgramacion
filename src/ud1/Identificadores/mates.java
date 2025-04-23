package ud1.Identificadores;

public class mates {
    public static void main(String[] args) {
        /* 
        int x = 5;
        int resultado = x++ * 2; 
        int resulta2 = ++x * 2;
        // si se pone despues el ++, multiplica con el valor de x (da 10) y si se pone ++x suma 1 a 5 (6) y lo multiplica //

        System.out.println(resultado);        
        System.out.println(resulta2); */

        int resultado1 = 12 / 4 + 3 * (2 + 1) - 5 % 2;
        System.out.println(resultado1);

        /**

        operadores lógicos:
        && AND - verdadero si ambos se complen
        || OR - verdadero si alguno se cumple
        ! NOT - invierte el valor dado
        */

        /** boolean resultado2 = (8 * 2 + 1) >= (5 + 10 / 2) && 7 % 2 == 1;
        System.out.println(resultado2); */

        boolean a = true, b = false, c = true;
        boolean resultado3 = !a || (b && c) || (a && !b);
        System.out.println(resultado3);

        int resultado4 = 10 + 5 * (3 + 8 / 4) - (6 * (3 - 1));
        System.out.println(resultado4);

        int a1 = 15, b1 = 20, c1 = 10;
        int resultado5 = (a1 > b1) ? a1 : (b1 < c1) ? b1 : c1;
        System.out.println(resultado5);

        int resultado6 = (5 + 3 * 2) / (2 + 3);
        System.out.println(resultado6);

        int resultado7 = (20 % 3) * (2 + 4 % 3) - 5;
        System.out.println(resultado7);

        int x = 4, y = 7;
        int resultado8 = ++x * (y-- + 2) - x++;
        System.out.println(resultado8);

        int resultado9 = (3 + 5 * (2 + 1)) - ((8 / 2) * (3 + 1));
        System.out.println(resultado9);
    }
    

 

}
