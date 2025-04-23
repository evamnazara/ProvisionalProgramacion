package ud1.Identificadores;

public class tiposPrimitivos {
    public static void main(String[] args) {

        byte valorbyte = 124;
        short valorshort = 12234;
        int valorint = 214748360;
        long valorlong = 922332036854775007l;
        float valorfloat = 5.5f;
        double valordouble = 3.35;
        char valorchar = 'E';
        String varString = "DAM";
        boolean valorboolean = false;
        

        System.out.println("Tipo NumBits Valor");
        System.out.println("------------------");
        System.out.println("byte     1 "+ valorbyte );
        System.out.println("short    2  " + valorint);
        System.out.println("int      4 " + valorlong);
        System.out.println("long     8 " + valordouble);
        System.out.println("float    4 " + valorshort);
        System.out.println("double   8  " + valorchar );
        System.out.println("float   2  " + valorfloat );
        System.out.println("String   ? " + varString);
        System.out.println("boolean  t/f" + valorboolean);

    } 
}
