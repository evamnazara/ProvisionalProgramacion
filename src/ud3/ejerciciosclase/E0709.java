//4 diciembre

/*E0709. Bombilla. 
Modelar una casa con muchas bombillas, de forma que cada bombilla
se pueda encender o apagar individualmente. Para ello, implementar una clase
Bombilla con una variable privada que indique si está encendida o apagada, así como
un método que nos diga el estado de una bombilla concreta. Además, queremos poner un
interruptor general, de forma que si éste se apaga, todas las bombillas quedan apagadas.
Cuando el interruptor general se activa, las bombillas vuelven a estar encendidas o
apagadas, según estuvieran antes. Cada bombilla se enciende y se apaga
individualmente, pero solo responde que está encendida si su interruptor particular está
activado y además hay luz general. */

package ud3.ejerciciosclase;

public class E0709 {
    public static void main(String[] args) {
        //con 3 bombillas
        Bombilla b1 = new Bombilla();
        Bombilla b2 = new Bombilla();
        Bombilla b3 = new Bombilla();

        b1.encenderBombilla();
        b3.encenderBombilla();

        Bombilla.encencerInterruptorGeneral();
        System.out.println(b1.estado() +  " " + b2.estado() + " " + b3.estado());

        b2.encenderBombilla();
        System.out.println(b1.estado() +  " " + b2.estado() + " " + b3.estado());

        Bombilla.apagarInterruptorGeneral();
        System.out.println(b1.estado() +  " " + b2.estado() + " " + b3.estado());
        System.out.println(Bombilla.estado(b2));
    }
    
}
