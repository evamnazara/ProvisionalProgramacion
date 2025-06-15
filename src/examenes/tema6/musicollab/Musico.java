package examenes.tema6.musicollab;

import java.util.List;
import java.util.Set;

public class Musico implements Comparable<Musico> {

    private String nombre;
    private String alias;
    private List<String> instrumentosDomina;
    private Set<Cancion> repertorio;

    public Musico(String nombre, String alias, List<String> instrumentosDomina, Set<Cancion> repertorio) {
        this.nombre = nombre;
        this.alias = alias;
        this.instrumentosDomina = instrumentosDomina;
        this.repertorio = repertorio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setInstrumentosDomina(List<String> instrumentosDomina) {
        this.instrumentosDomina = instrumentosDomina;
    }

    public void setRepertorio(Set<Cancion> repertorio) {
        this.repertorio = repertorio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAlias() {
        return alias;
    }

    public List<String> getInstrumentosDomina() {
        return instrumentosDomina;
    }

    public Set<Cancion> getRepertorio() {
        return repertorio;
    }

    @Override
    public int compareTo(Musico o) {
        return alias.compareTo(o.alias);
    }

    @Override
    public String toString() {
        return "[" + alias + "](" + nombre + "): " + instrumentosDomina;
    }

}

/*
 * Clase Musico (1)
 * Implementa la clase.
 * Atributos:
 * ● nombre (String).
 * ● alias (String, único).
 * ● Instrumentos que domina (List<String>, sin repetidos).
 * ● Repertorio: canciones que conoce y podría tocar (por gusto o experiencia).
 * Otros Requisitos:
 * 1. Orden natural: Por alias alfabético.
 * 2. Método toString():
 * ○ Muestra [Alias] (Nombre): [lista de instrumentos].
 */