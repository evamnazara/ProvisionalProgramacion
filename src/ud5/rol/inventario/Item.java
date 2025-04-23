package ud5.rol.inventario;

/*
Cada item tendrá un nombre, un peso (en kilos con decimales), y un precio base (un número entero de monedas).
 */

public class Item {
    private String nombre;
    private double peso;
    private int precio;
    
    public Item(String nombre, double peso, int precio) {
        this.nombre = nombre;
        this.peso = peso;
        this.precio = precio;
    }

    
    public String getNombre() { 
        return nombre; 
    }
    public double getPeso() { 
        return peso; 
    }
    public int getPrecio() { 
        return precio; 
    }
    
    //que considere iguales dos objetos que tengan el mismo nombre, peso y mismo precio.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;

        Item item = (Item) obj;
        return Double.compare(item.peso, peso) == 0 && precio == item.precio && nombre.equals(item.nombre);
    }
    
    @Override
    public String toString() {
        return nombre + ", peso: " + peso + " kilos, precio: " + precio + " monedas";
    }
}
