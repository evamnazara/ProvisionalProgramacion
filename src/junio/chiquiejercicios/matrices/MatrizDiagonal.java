package junio.chiquiejercicios.matrices;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrizDiagonal {
    public static void main(String[] args) {

        int[][] matriz = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };

        System.out.println(esDiagonal(matriz));

    }

    public static boolean esDiagonal(int[][] matriz) {
        // verificar si esta vacia o no
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return false;
        }

        // verificar si es cuadrada
        if (matriz.length != matriz[0].length) {
            return false;
        }

        // Si i == j, estamos en la diagonal principal → cualquier valor es válido
        // Si i != j, el valor debe ser 0, si no → devuelve false
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i != j && matriz[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;

    }

    @Test
    public void pruebaMatrizDiagonal() {
        int[][] matriz = { { 1, 0, 0 }, { 0, 2, 0 }, { 0, 0, 3 } };
        assertTrue(esDiagonal(matriz));
    }

    @Test
    public void pruebaMatrizNoDiagonal() {
        int[][] matriz = { { 1, 0, 0 }, { 0, 2, 0 }, { 0, 1, 3 } };
        assertFalse(esDiagonal(matriz));
    }

    @Test
    public void pruebaMatrizNoCuadrada() {
        int[][] matriz = { { 1, 0, 0 }, { 0, 2, 0 } };
        assertFalse(esDiagonal(matriz));
    }

    @Test
    public void pruebaMatrizNoCuadrada2() {
        int[][] matriz = { { 1, 0 }, { 0, 2 }, { 0, 0 } };
        assertFalse(esDiagonal(matriz));
    }

    @Test
    public void pruebaMatrizVacia() {
        int[][] matriz = {};
        assertFalse(esDiagonal(matriz));
    }

    @Test
    public void pruebaMatrizNull() {
        int[][] matriz = null;
        assertFalse(esDiagonal(matriz));
    }

}