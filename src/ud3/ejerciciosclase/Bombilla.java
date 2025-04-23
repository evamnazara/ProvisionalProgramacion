//4 diciembre

/*E0709. Bombilla. 
Modelar una casa con muchas bombillas, de forma que cada bombilla se 
pueda encender o apagar individualmente. 

Para ello, implementar una clase Bombilla 
con una variable privada que indique si está encendida o apagada, 
así comoun 
método que nos diga el estado de una bombilla concreta. 
Además, queremos poner un interruptor general, de forma que si éste se apaga, todas las bombillas quedan apagadas.

Cuando el interruptor general se activa, las bombillas vuelven a estar encendidas o
apagadas, según estuvieran antes. Cada bombilla se enciende y se apaga
individualmente, pero solo responde que está encendida si su interruptor particular está
activado y además hay luz general. */

package ud3.ejerciciosclase;

public class Bombilla {
    //atributos principales
    //private int b1, b2, b3; 
    //atributo de instancia del estado de cada bombilla  
    private boolean interruptorEncendido; 

    //
    private static boolean interruptorGeneral;


    public static void encencerInterruptorGeneral() {
        interruptorGeneral = true;
    }
    public static void apagarInterruptorGeneral() {
        interruptorGeneral = false;
    }

    public void encenderBombilla() {
        interruptorEncendido = true;
    }

    public void apagarBombilla() {
        interruptorEncendido = false;
    }

    public boolean estado() {
        return interruptorEncendido && interruptorGeneral; 
    }
    
    public static boolean estado(Bombilla b1) {
        return b1.interruptorEncendido && interruptorGeneral;
    }
    
    

}
