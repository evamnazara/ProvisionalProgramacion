package ud1.Expresiones;

import java.util.*;

public class AreaTriangulo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double b = sc.nextDouble();
        double h = sc.nextDouble();

        double area = b * h / 2;
        System.out.println(area);
        sc.close();
    }
    
}
