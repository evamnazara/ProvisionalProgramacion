package ud6.meigas;

import java.util.List;

public class Meiga {
    String nome;
    String alcumeMaxico;
    List feitizosFavoritos;

    
    public Meiga(String nome) {
        this.nome = nome;
    }


    public Meiga(String nome, String alcumeMaxico) {
        this.nome = nome;
        this.alcumeMaxico = alcumeMaxico;
    }

    public Meiga(String nome, String alcumeMaxico, List feitizosFavoritos) {
        this.nome = nome;
        this.alcumeMaxico = alcumeMaxico;
        this.feitizosFavoritos = feitizosFavoritos;
    }


    @Override
    public String toString() {
        return "Meiga\n Nome=" + nome + "\nAlcume: " + alcumeMaxico + "\nFeitizosFavoritos=" + feitizosFavoritos;
    }

    
}
