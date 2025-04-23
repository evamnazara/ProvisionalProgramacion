/*E0701. Diseñar la clase CuentaCorriente, que almacena los datos: DNI y nombre del titular, asi como el saldo. Las operaciones típicas con una cuenta corriente son:

Crear una cuenta: se necesita el DNI y nombre del titular. El saldo inicial será 0.
Sacar dinero: el método debe indicar si ha sido posible llevar a cabo la operación, si existe saldo suficiente.
Ingresar dinero: se incrementa el saldo.
Mostrar información: muestra la información disponible de la cuenta corriente.

Prueba la clase y sus métodos cun un pequeño programa.

 */

package ud3.apuntes;

public class E0701 {
    public static void main(String[] args) {
        CuentaCorriente cc = new CuentaCorriente("55555555Z", "Pepe");
        cc.mostrar();

        cc.ingresarDinero(200);
        cc.mostrar();

        System.out.println(cc.sacarDinero(100));
        cc.mostrar();

        cc.ingresarDinero(-200);
        cc.mostrar();

        System.out.println("FIN");

    }
}
