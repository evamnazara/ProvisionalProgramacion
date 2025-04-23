/* ClaseMath. 
Escribe un programa que genere y muestre un número aleatorio no entero
con decimales en el rango de -360 a 360 utilizando Math.random().
A continuación realizará y mostrará los siguientes cálculos:
● su raíz cuadrada utilizando el método Math.sqrt().
● el número redondeado a la cifra entera más cercana utilizando Math.round().
● el número redondeado hacia arriba y hacia abajo utilizando los métodos
Math.ceil() y Math.floor().
● su valor absoluto utilizando Math.abs().
● La potencia al cubo de ese número utilizando el método Math.pow().
● su logaritmo natural utilizando Math.log().
● suponiendo que el número representa la medida un ángulo en grados, muestra el
seno y coseno de ese ángulo utilizando Math.sin() y Math.cos().
Solicita al usuario que ingrese otros dos números y calcula y muestra el mayor de los 3 (el
generado y los introducidos por teclado) utilizando Math.max(). Calcula y muestra
también el menos con Math.min().
Observa los resultados de sqrt() y log() cuando el número es negativo. */

package ud3.ejerciciosapi;

public class ClaseMath {
    public static void main(String[] args) {
        //número aleatorio no entero con decimales de -360 a 360 utilizando Math.random().
       double random = Math.random() * 720 - 360;
       System.out.println("Numero aleatorio" + random);

       double sqr = Math.sqrt(random);
       System.out.println("Raiz cuadrada:"+ sqr);

       System.out.println("Su redondeo:");
       double redondeo = Math.round(random);
       double redondeoArriba = Math.ceil(random);
       double redondeoAbajao = Math.floor(random);
       System.out.println("Su redondeo:" + redondeoAbajao);
       System.out.println(redondeo);
       System.out.println(redondeoArriba);
       System.out.println(redondeoAbajao);


       double valorAbsoluto = Math.abs(random);
       System.out.println("Su valor absoluto:" + valorAbsoluto);

       double potenciaCubo = Math.pow(random, 3);
       System.out.println("Cubo:" + potenciaCubo);

       
       double logaritmo = Math.log(random);
       System.out.println("Su logaritmo:" + logaritmo);


       double seno = Math.sin(random);
       double coseno = Math.cos(random);
       System.out.println("Seno y coseno:");
       System.out.println(seno);
       System.out.println(coseno);

    }
}
