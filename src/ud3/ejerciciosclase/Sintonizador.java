/*E0708. Sintonizador. 
Definir la clase que permita controlar un sintonizador digital de
emisoras FM. El controlador tendrá una interfaz que permitirá subir (up) o bajar(down) la
frecuencia en (en saltos de 0,5 MHz) y mostrar la frecuencia sintonizada en un momento
dado (display).

Supondremos que el rango de frecuencias oscila entre los 80 MHz y los 108 MHz y que,
al inicio, el controlador sintonice la frecuencia indicada en el constructor o 80 MHz por
defecto.

Si durante una operación de subida o bajada se sobrepasa uno de los dos límites, la
frecuencia sintonizada debe pasar a ser la del extremo contrario.

Escribir un pequeño programa (o clase de pruebas) Para probar su funcionamiento.Ampliar la clase:
1. para que permita guardar las frecuencias de hasta 3 emisoras y recuperarlas
cuando se desee.
2. Establece los atributos como privados y genera el setter y getter del atributo
frecuencia. Ten en cuenta en el setter que la frecuencia no exceda los límites.
Intenta no repetir código.
3. Añade dos métodos que permitan una sintonización más fina subiendo y bajando
la frecuencia en intervalos de 0,1 MHz
4. Prueba a generar una excepción cuando se intente establecer un valor de
frecuencia no válido. */

package ud3.ejerciciosclase;

public class Sintonizador {
    //se pueden convertir las maximas y minimas en constantes


    //atributo principal
    private double frecuencia;

    //MEMORIAS 
    private double memoria1;
    private double memoria2;
    private double memoria3;


   
    public void fijarMemoria1(double memoria1) {
        //pred guarda memoria1
        //modificacion para guardar la frecuencia seleccionada por el usuario
        this.memoria1 = frecuencia;
// ===== PARA EVITAR ERRORES ES MEJOR PONER EL THIS SIEMPRE ANTES DE LOS ATRIBUTOS DE CLASE
    }

    public void setMemoria2(double memoria2) {
        this.memoria2 = frecuencia;
    } 

    public void setMemoria3(double memoria3) {
        this.memoria3 = frecuencia;
    }

    /* PREDETERMINADO
        public double getMemoria1() {
        return memoria1;
    } */

    public double sintonizarMemoria1() {
        if (memoria1 != 0) //no lo hace si es 0
            frecuencia = memoria1;
        return memoria1;
    }

    public double getMemoria2() {
        if (memoria2 != 0) //no lo hace si es 0
            frecuencia = memoria2;

        return memoria2;
    }
    
    public double getMemoria3() {
        if (memoria3 != 0) //no lo hace si es 0
        frecuencia = memoria3;
        return memoria3;
    }

    public Sintonizador() {
        setFrecuencia(frecuencia);
        //corrige el error por defecto
    }


    public Sintonizador(double frecuencia){
        //que es el this :()
        if (frecuencia < 80)
            this.frecuencia = 80;
        else if (frecuencia > 108) //margen no especificado, solo que 
            this.frecuencia = 108;
        else
            this.frecuencia = frecuencia;

    }


    // ========== INTERFACES 
    public void up() {
        frecuencia += 0.5;
        if (frecuencia > 108)
            frecuencia = 80;
    }

    public void down() {
        frecuencia -= 0.5;
        //  frecuencia = frecuencia - 0.5.

        if (frecuencia < 80) //si dejasemos el == o <= da fallo al sintonizar por encima o por debajo
            frecuencia = 108;


    }

    public void display(){
        System.out.println("Frecuencia sintonizada: " + frecuencia + "Mh");

    }
//FINAS 
    public void downThin() {
        if (frecuencia == 80) 
            frecuencia = 108;

            frecuencia -= 0.1;
        //  frecuencia = frecuencia - 0.5.

    }

    public void upThin() {
        if (frecuencia == 108)
            frecuencia = 80;
        else
            frecuencia += 0.1;
    }



    // ================ SETTERS Y GETTERS FRECUENCIA 
    public double getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(double frecuencia) throws IllegalArgumentException {
        if (frecuencia < 80)
            //EXCEPCION 
            throw new IllegalArgumentException("La frecuencia no puede ser inferior a 80Mhz");
        else if (frecuencia > 108) 
            throw new IllegalArgumentException("La frecuencia no puede ser inferior a 80Mhz");
        else
            this.frecuencia = frecuencia;

        /* ==== IMPLEMENTACION ORIGINAL ====
                if (frecuencia < 80)
                    this.frecuencia = 80;
                else if (frecuencia > 108) 
                    this.frecuencia = 108;
                else
                    this.frecuencia = frecuencia;
                    */
    }

    
    
    
    
}
