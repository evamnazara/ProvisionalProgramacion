package examen;

public class Examen {
    private String titulo;
    private int numPreguntas;
    private Pregunta[] preguntas;

    public Examen(String titulo, int maxPreguntas) {
        this.titulo = titulo;
        this.preguntas = new Pregunta[maxPreguntas];
        this.numPreguntas = 0;
    }

    public boolean addPregunta(Pregunta pregunta) {
        //no repetidos 
        for (int i = 0; i < numPreguntas; i++) {
            if (preguntas[i].equals(pregunta)) {
                return false; 
                }
            }

            if (numPreguntas < preguntas.length) {
                preguntas[numPreguntas] = pregunta;
                numPreguntas++;
                return true;
            }
            return false; 
    }

    //devuelve el número de preguntas del examen. 
    public int numPreguntas() {
        return numPreguntas;
    }

    //titulo del examen + preguntas numeradas, con enunciado y respuestas pero sin respuesta
    @Override
    public String toString() {
        String resultado = "Examen: " + titulo + "\n";

        for (int i = 0; i < numPreguntas; i++) {
            resultado += (i + 1) + ". " + preguntas[i].toString() + "\n";
        }

        return resultado;
    }
}
