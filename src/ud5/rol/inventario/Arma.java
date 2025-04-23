package ud5.rol.inventario;

public class Arma extends Item {
    
    int ataque;
    boolean dosManos = false;

    public Arma(String nombre, double peso, int precio, int ataque, boolean dosManos) {
            super(nombre, peso, precio);
            this.ataque = ataque;
            this.dosManos = dosManos;
    }

    public int getAtaque() {
        return ataque;
    }

    public boolean esDosManos() {
        return dosManos;
    }
}
