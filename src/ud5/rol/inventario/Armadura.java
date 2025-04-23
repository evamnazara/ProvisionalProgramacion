package ud5.rol.inventario;


public class Armadura extends Item {

    public enum TipoArmadura { YELMO, ARMADURA, ESCUDO };
    public TipoArmadura tipo;
    public int defensa;
    
    public Armadura(String nombre, double peso, int precio, int defensa, TipoArmadura tipo) {
        super(nombre, peso, precio);
        this.defensa = defensa;
        this.tipo = tipo;
    }
    
    public int getDefensa() { 
        return defensa; 
    }
    public TipoArmadura getTipo() { 
        return tipo; 
    }
    
    @Override
    public String toString() {
        return super.toString() + " (+" + defensa + " defensa)";
    }
}
