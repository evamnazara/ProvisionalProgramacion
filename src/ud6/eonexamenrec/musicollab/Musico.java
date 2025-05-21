//Eva María Otero Názara

package ud6.eonexamenrec.musicollab;

import java.util.List;

public class Musico implements Comparable<Musico> {
    private String nombre;
    private String alias; //unico
    private List<String> instrumentos;
    private List<String> repertorio;


    public Musico(String nombre, String alias, List<String> instrumentos, List<String> repertorio) {
        this.nombre = nombre;
        this.alias = alias;
        this.instrumentos = instrumentos;
        this.repertorio = repertorio;
    }

    public Musico(String nombre, String alias, List<String> instrumentos) {
        this.nombre = nombre;
        this.alias = alias;
        this.instrumentos = instrumentos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAlias() {
        return alias;
    }

    public List<String> getInstrumentos() {
        return instrumentos;
    }


    public List<String> getRepertorio() {
        return repertorio;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setInstrumentos(List<String> instrumentos) {
        this.instrumentos = instrumentos;
    }

    public void setRepertorio(List<String> repertorio) {
        this.repertorio = repertorio;
    }

    //Por alias alfabético. 
    @Override
    public int compareTo(Musico o) {
        return this.alias.compareTo(o.alias);
    }

    @Override
    public String toString() {
        return "[" + alias +  "] (" + nombre + "): " + instrumentos;
    }


    public static void main(String[] args) {
        Musico m1 = new Musico("Ana López", "BassQueen", List.of("bajo", "voz"));
        System.out.println(m1);
    }




}
