package ud5.apuntesinterfaces.relacionable;

public class Linea implements Relacionable {
    private double x1;
    private double y1;
    private double x2;    
    private double y2;
    

    public Linea(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;       
        this.y2 = y2;
    }
    public double longitud() {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    //Implementación del método abstracto esMayorQue de la interface
    @Override
    public boolean esMayorQue(Relacionable a) {
        if (a == null) {
            return false;
        }
        if (!(a instanceof Linea)) {
            return false;
        }
        Linea linea = (Linea) a;
        return this.longitud() > linea.longitud();
    }

    //Implementación del método abstracto esMenorQue de la interface
    @Override
    public boolean esMenorQue(Relacionable a) {                                                             
        if (a == null) {
            return false;
        }
        if (!(a instanceof Linea)) {
            return false;
        }
        Linea linea = (Linea) a;
        return this.longitud() < linea.longitud();
    }

    //Implementación del método abstracto esIgualQue de la interface
    @Override
    public boolean esIgualQue(Relacionable a) {                                                             
        if (a == null) {
            return false;
        }
        if (!(a instanceof Linea)) {
            return false;
        }
        Linea linea = (Linea) a;
        return this.longitud() == linea.longitud();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coordenadas inicio linea: ");
        sb.append(x1);
        sb.append(" , ");
        sb.append(y1);
        sb.append("\nCoordenadas final linea: ");
        sb.append(x2);
        sb.append(" , ");
        sb.append(y2);
        sb.append("\nLongitud: ");
        sb.append(longitud());
        return sb.toString();
    }   
}
