package ud5.clasesejercicios.EP0825;

public class App {
    
    public static void main(String[] args) {
        Punto punto2D1 = new Punto(1,1);
        Punto punto2D2 = new Punto(1,1);

        Punto3D p3d1 = new Punto3D(1,3,5);
        Punto3D p3d2 = new Punto3D(1,1,2);

        System.out.println(p3d1.distancia(p3d1, p3d2));

        System.out.println(punto2D1.equals(punto2D2));
        System.out.println(p3d1.equals(p3d2));

        Suceso s1 = new Suceso(7, 8, 5, 1, null);
        Suceso s2 = new Suceso(7, 8, 5, 1, "1");

        System.out.println(s1.equals(s2));
    }
    

}
