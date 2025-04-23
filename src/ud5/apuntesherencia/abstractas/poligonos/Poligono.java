package ud5.apuntesherencia.abstractas.poligonos;

public abstract class Poligono {                                                                            
  
    private int numLados;
    public Poligono() {
    }
    public Poligono(int numLados) {
        this.numLados = numLados;
    }
    public int getNumLados() {
        return numLados;
    }
    public void setNumLados(int numLados) {
        this.numLados = numLados;
    }
    //Declaración del método abstracto area()   
    
    
    //p.ej sabes calcular el area de un triangulo / cuadrado etc pero no tienes los datos 
    //especidificos / no se calculan igual 

    public abstract double area();
}