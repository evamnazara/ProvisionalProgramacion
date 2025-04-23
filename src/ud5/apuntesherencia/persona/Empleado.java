package ud5.apuntesherencia.persona;

public class Empleado extends Persona {

    double salario; 
    String estatura;
    //ojo si se sobreescriben datos 

    //constructor especifico
    //mientras, se puede declarar 
    Empleado() {};

    //CONSTRUCTOR
     /*para esto hay que cambiar la privacidad o 
            poner un setter y un getter */
        //setNombre(nombre);

    Empleado(String nombre, int edad, double salario) {
        super(nombre,edad);
        this.nombre = nombre;
        this.salario = salario;
    }

    public Empleado(String nombre, int edad, String estatura, double salario) {
        this.nombre = nombre; // asigna el parámetro al atributo
        this.edad = edad;
        this.estatura = estatura;
        this.salario = salario;
    }

    /*public void mostrarDatos() {

        System.out.println(salario + " euros mensuales.");
    }*/

//SOBRECARGAS 

        /* si el parametro es diferente, el override no funciona pq no esta sobrecargando ninguno
         * va por separado 
         * 
         * no puede tener otra salida ni otra visibilidad
         *           excepto protected y publid en algun momento
         */

    
    @Override 
    void mostrarDatos() {
        System.out.println("EMPLEADO: ");
        super.mostrarDatos();
        //System.out.println(getApellido2());
        System.out.println("Sueldo: " + salario + " euros mensuales.");
    }

    public static void main(String[] args) {
        Empleado maria = new Empleado("María",34, 3000);
        Empleado pepe = new Empleado("Pepe", 25, "XL",1500 );
        
        maria.cumplirAnhos();
        pepe.saludar();

        Persona pepeRSONA = pepe; 
        System.out.println(pepeRSONA.edad);
            //pepe es una persona > apuntan al mismo sitio 
            //pero solo tienes las funiones de persona 

        //pepeRSONA.mostrarDatos();
        
        pepeRSONA.getClass();


        //de vuelta hay que castearlo
        Empleado pepeAgain = (Empleado) pepeRSONA;
        System.out.println(pepeAgain.estatura);
        //pepeAgain.mostrarDatos();

    }
}
