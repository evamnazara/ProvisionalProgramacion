package ud5.clasesejercicios.EP0825;

public class Suceso extends Punto3D{
    int tiempo;
    String descripcion;
    

    public Suceso(int x, int y, int z, int tiempo, String descripcion) {
        super(x, y, z);
        this.tiempo = tiempo;
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Suceso other = (Suceso) obj;
        if (tiempo != other.tiempo)
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        return true;
    }
}
