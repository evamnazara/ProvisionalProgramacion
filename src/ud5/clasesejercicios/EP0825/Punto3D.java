package ud5.clasesejercicios.EP0825;

public class Punto3D extends Punto {
    int z;


    public Punto3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public double distancia (Punto3D p1, Punto3D p2) {
        if (p2 == null) return -1;

        double distancia = Math.sqrt(Math.pow((p1.x - p2.x), 2) 
            + Math.pow((p1.y - p2.y), 2) + Math.pow((p1.z - p2.z),2));
        return distancia;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Punto3D other = (Punto3D) obj;
        if (z != other.z)
            return false;
        return true;
    }


    
}
