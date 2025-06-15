package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class ProblemasHerencia {

    // Función para evaluar el polinomio en un valor x
    public static double evaluarPolinomio(int[] coef, double x) {
        double resultado = 0;
        int grado = coef.length - 1;
        for (int i = 0; i < coef.length; i++) {
            resultado += coef[i] * Math.pow(x, grado - i);
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Leer el grado del polinomio
            System.out.print("Introduce el grado del polinomio (o 20 para terminar): ");
            int grado = sc.nextInt();
            if (grado == 20) {
                break; // Finaliza el programa si el grado es 20
            }

            // Leer los coeficientes del polinomio
            System.out.print("Introduce los coeficientes del polinomio (de mayor a menor grado): ");
            int[] coef = new int[grado + 1];
            for (int i = 0; i <= grado; i++) {
                coef[i] = sc.nextInt();
            }

            // Leer el número de rectángulos
            System.out.print("Introduce el número de rectángulos para la aproximación: ");
            int n = sc.nextInt();

            // Aproximación del área bajo la curva usando la suma de Riemann
            double areaCain = 0;
            double totalArea = 1.0; // El total es 1 hectárea, área de la tierra

            // Calcular la suma de Riemann
            for (int i = 0; i < n; i++) {
                double x = (i + 1) / (double) n; // x = i/n
                double f_x = evaluarPolinomio(coef, x);

                // Asegurar que f(x) esté en el rango [0, 1]
                if (f_x < 0) {
                    f_x = 0;
                } else if (f_x > 1) {
                    f_x = 1;
                }

                // Añadir el área de este rectángulo
                areaCain += f_x / n;
            }

            // El área de Abel es el área total menos el área de Caín
            double areaAbel = totalArea - areaCain;

            // Calcular la diferencia de áreas
            double diferencia = Math.abs(areaCain - areaAbel);

            // Mostrar los resultados de las áreas
            System.out.println("Área de Caín: " + areaCain);
            System.out.println("Área de Abel: " + areaAbel);
            System.out.println("Diferencia entre áreas: " + diferencia);

            // Determinar el resultado
            if (diferencia <= 0.001) {
                System.out.println("El reparto es JUSTO.");
            } else if (areaCain > areaAbel) {
                System.out.println("CAIN tiene más terreno.");
            } else {
                System.out.println("ABEL tiene más terreno.");
            }
            System.out.println(); // Línea en blanco para separar los casos
        }

        sc.close();
    }
}

/*
 * Problemas de Herencia
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Caín y Abel han heredado el pedazo de tierra de su padre y deben proceder a
 * dividirlo en dos partes iguales. Sabiendo que la tierra es un cuadrado de una
 * hectárea (un cuadrado de 1x1 hectómetro), lo más fácil sería dividirlo
 * directamente por la mitad.
 * 
 * Sin embargo, Caín y Abel se han complicado un poco poniendo en práctica sus
 * conocimientos matemáticos. En concreto, cada uno de ellos va proponiendo al
 * otro una función f(x) cuyo dibujo, al evaluarse para x entre 0 y 1, divide la
 * tierra de su padre en dos partes; la parte de abajo irá para Caín y la parte
 * de arriba para Abel (figura 1.a).
 * 
 * División de tierras
 * (a) División de tierras
 * Cálculo de Riemann
 * (b) Cálculo de Riemann
 * Ejemplo de función que toca tierras colindantes
 * (c) Función que toca tierras colindantes
 * Figura 1: Problema de herencia
 * Nuestro cometido es ayudarles a decidir si esas funciones dividen
 * equitativamente el terreno (así lo consideraremos cuando el área que le queda
 * a cada uno no excede en 0.001 hm² la del otro). En una palabra, deberemos
 * decidir si sale ganando Caín, Abel o el trato es justo.
 * 
 * Para poder realizar el cálculo utilizaremos la solución que aportó el famoso
 * matemático Riemann. Riemann asegura que se puede aproximar el área que se
 * encuentra limitada superiormente por una función por las llamadas sumas de
 * Riemann. El método consiste en considerar pequeños rectángulos todos del
 * mismo ancho y cuya altura se corresponde con el valor de f(x) de manera que
 * el rectángulo toque en algún punto a la función. En nuestro caso,
 * consideraremos que la toca en el vértice superior izquierdo (figura 1.b). Una
 * buena aproximación del área total que hay por debajo de la función es la suma
 * de todos esos pequeños rectángulos. Cuantos más rectángulos utilicemos, mejor
 * será la aproximación (y más estrechos serán esos rectángulos). Observa que si
 * tenemos n rectángulos, su anchura (base) es basei = 1/n. Teniendo esto en
 * cuenta, la aproximación del área total de tierra será:
 * 
 * A=∑areai=∑basei⋅alturai=∑1n⋅alturai=∑i=0n−11n⋅f(i⋅1n)
 * El resultado de este cálculo será lo que mide el terreno de Caín. El terreno
 * que le corresponde a Abel será una hectárea menos lo que le corresponda a
 * Caín.
 * 
 * Ten presente que como Caín y Abel utilizan todo tipo de polinomios de
 * coeficientes enteros, es posible que la funcion f(x) se salga del terreno que
 * han heredado (eso ocurre cuando f(x) < 0 o f(x) > 1; ver la figura 1.c). Para
 * evitar problemas con los dueños de las tierras colindantes, hay que tener
 * cuidado con esos casos para no sumar nada a Caín (si f(x) < 0) o sumarle sólo
 * el espacio de tierra que le corresponde (si f(x) > 1).
 * 
 * Entrada
 * La entrada estará formada por un número indeterminado de casos en los que se
 * introducirá el grado del polinomio (entre 0 y 19, ambos inclusive), los
 * coeficientes en orden decreciente respecto al grado y el número de
 * rectangulos que queremos crear. Por ejemplo, la entrada (de coeficiente 3) 1
 * 2 -1 1 representa el polinomio x³ + 2x² − x + 1.
 * 
 * La entrada finalizará cuando el grado del polinomio sea 20.
 * 
 * Salida
 * Para cada caso de prueba, el programa indicará si el reparto es equitativo
 * (escribiendo "JUSTO"), si sale ganando el hermano que se queda con la sección
 * inferior ("CAIN") o si sale ganando el que opta por la superior ("ABEL").
 * Recuerda que el reparto es justo si la diferencia de áreas no excede 0.001
 * hm².
 * 
 * Entrada de ejemplo
 * 1
 * 1 0
 * 100
 * 3
 * 1 2 -1 0
 * 1000
 * 3
 * 1 2 -1 1
 * 1000
 * 1
 * 3 -1
 * 10000
 * 1
 * 3 -1
 * 2
 * 20
 * Salida de ejemplo
 * ABEL
 * ABEL
 * CAIN
 * JUSTO
 * ABEL
 */
