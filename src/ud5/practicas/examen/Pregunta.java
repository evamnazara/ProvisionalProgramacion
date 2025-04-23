package examen;

public class Pregunta {
    private String enunciado;
    private String[] respuestas;
    private int respuestaCorrecta;

    public Pregunta(String enunciado, String[] respuestas, int respuestaCorrecta) {
        if (respuestas == null || respuestas.length < 2) {
            throw new IllegalArgumentException("La pregunta tiene que tener al menos 2 respuestas diferentes.");
        }
        if (respuestaCorrecta < 0 || respuestaCorrecta >= respuestas.length) {
            throw new IllegalArgumentException("Respuesta fuera de límites.");
        }
        this.enunciado = enunciado;
        this.respuestas = respuestas;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Pregunta(String enunciado) {
        this.enunciado = enunciado;
    }

    public Pregunta(String[] respuestas, int respuestaCorrecta) {
        this.respuestas = respuestas;
        this.respuestaCorrecta = respuestaCorrecta;
    }



    public boolean corregir(int opcionElegida) {
        return opcionElegida == respuestaCorrecta;
    }

    @Override
    public String toString() {
        String resultado = enunciado + "\n";
        char opcion = 'a';
        for (int i = 0; i < respuestas.length; i++) {
            resultado += opcion + ") " + respuestas[i] + "\n";
            opcion++; 
        }
        return resultado;
    }

    //considerará iguales dos preguntas que tengan el mismo enunciado y la misma lista de respuestas. 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;

        Pregunta otra = (Pregunta) obj;

        return enunciado.equals(otra.enunciado) &&
               respuestas.length == otra.respuestas.length;
    }

}