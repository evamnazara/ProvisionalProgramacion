package ud5.clasesejercicios.EP0812a3;

public class CajaCarton extends Caja {
    double volumen; //80% 

    double medida; 
    double superficieCarton;

    public CajaCarton(int ancho, int alto, int fondo, Unidad unidad, double medida,
            double superficieCarton) {
        super(ancho, alto, fondo, unidad);
        this.medida = medida;
        this.superficieCarton = superficieCarton;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen * 0.8;
    }

    double getSuperficie() {
        return 2 * alto * ancho + 2 * ancho * fondo + 2 * alto * fondo;
    }
    
}


/*EP0813. La empresa de mensajería BiciExpress, que reparte en bicicleta, para disminuir el 
peso que transportan sus empleados solo utiliza cajas de cartón. El volumen de éstas se 
calcula como el 80% del volumen real, con el fin de evitar que se deformen y se rompan. 
Otra característica de las cajas de cartón es que sus medidas siempre están en 
centímetros. Por último, la empresa, para controlar costes, necesita saber cuál es la 
superficie total de cartón utilizado para construir todas las cajas. 
 
Escribe la clase CajaCarton heredando de la clase Caja.  */