package praiasdegalicia;

import java.util.Arrays;
import java.util.Comparator;

public class Praia implements Comparable<Praia> {
    private int id;
    private String nome;
    private String concello;
    private String provincia;
    private double lat;
    private double lon;

    public Praia() {
    }

    public Praia(int id) {
        this.id = id;
    }

    public Praia(int id, String nome, String concello, String provincia) {
        this.id = id;
        this.nome = nome;
        this.concello = concello;
        this.provincia = provincia;
    }

    public Praia(int id, String nome, String concello, String provincia, double lat, double lon) {
        this.id = id;
        this.nome = nome;
        this.concello = concello;
        this.provincia = provincia;
        this.lat = lat;
        this.lon = lon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConcello() {
        return concello;
    }

    public void setConcello(String concello) {
        this.concello = concello;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return id + " - " + nome + " - " + concello + " - " + provincia + " - (" + lat + ", " + lon + ")";
    }

    @Override
    public int compareTo(Praia outra) {
        return Integer.compare(this.id, outra.id);
    }

    public void mostrarDetalles() {
        System.out.println(id + " - " + nome + " - " + concello + " - " + provincia + " - (" + lat + ", " + lon + ")");
    }

    public static void imprimirLista(Praia[] praias, int limite) {
        for (int i = 0; i < Math.min(limite, praias.length); i++) {
            System.out.println(praias[i]);
        }
    }

    /* 2. Ordenar y buscar
        Crea en la clase Praia los siguientes métodos estáticos:
        Praia[] sortLatitudNorteSur(Praia[] p);
        Devuelve una copia del array con las playas ordenadas por latitud de norte a sur. Ojo! El método no debe modificar el array original.
        Praia[] sortProvinciaConcelloNome(Praia[] p); 
        Devuelve una copia del array con las playas ordenadas provincia, concello y nombre de playa.

        Usando estos métodos implementa el programa AppOrden.java que muestre los siguientes listados: 

        Las 10 playas más al norte


        Todas las playas ordenadas por Provincia, Concello y Nombre.
        */

    public static Praia[] sortLatitudNorteSur(Praia[] p) {
        Praia[] copia = Arrays.copyOf(p, p.length);
        Arrays.sort(copia, Comparator.comparingDouble(Praia::getLat).reversed());
        return copia;
    }

    public static Praia[] sortProvinciaConcelloNome(Praia[] p) {
        Praia[] copia = Arrays.copyOf(p, p.length);
        Arrays.sort(copia, Comparator.comparing(Praia::getProvincia)
                .thenComparing(Praia::getConcello)
                .thenComparing(Praia::getNome));
        return copia;
    }
}