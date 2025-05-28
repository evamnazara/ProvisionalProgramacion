package ud7.apuntesjavafx.examenUD7;

import java.io.Serializable;

//Serializable para poder usar writeObject(clase) que permite guardar las clases directamente en archivos binarios
public class Producto implements Serializable, Comparable<Producto> {

    private int codigo;
    private String name;
    private double price;
    private int amount;

    Producto(int codigo) {
        this.codigo = codigo;
    }

    Producto(int codigo, String name, Double price, int amount) {
        this.codigo = codigo;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;

        Producto other = (Producto) obj;
        return codigo == other.codigo; // Añadir el resto de parametros si no es suficiente solo con tener el mismo
                                       // codigo
    }

    @Override
    public String toString() {
        return String.format("%d - %s   precio: %.2f cantidad: %d", codigo, name, price, amount);
    }

    // Ordenar ascendentemente implements Comparable<Producto>
    @Override
    public int compareTo(Producto p) {
        return this.codigo - p.codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

}
