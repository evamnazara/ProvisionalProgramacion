package ud5.clasesejercicios.EP0812a3;

/*EP0812. Las empresas de transporte, para evitar daños en los paquetes, embalan todas 
sus mercancías en cajas con el tamaño adecuado. Una caja se crea expresamente con un 
ancho, un alto y un fondo y, una vez creada, se mantiene inmutable. Cada caja lleva pegada 
una etiqueta, de un máximo de 30 caracteres, con información útil como el nombre del 
destinatario, dirección, etc. Implementa la clase Caja con los siguientes métodos: 

●  double getVolumen(): que devuelve el volumen de la caja en metros cúbicos. 
●  void setEtiqueta(String etiqueta): que modifica el valor de la etiqueta de 
la caja. 
●  String toString(): que devuelve una cadena con la representación de la caja.  */
public class Caja {
    //el enunciado dice q son inmutables
    final int ancho;
    final int alto; 
    final int fondo;

    enum Unidad {CM, M};

    String etiqueta;
    String destinatario;
    String direccion;

    public Caja(int ancho, int alto, int fondo, Unidad unidad) {
        int multiplicador = switch (unidad) 
            { 
                case CM -> 1;
                case M -> 100;
                default -> 0;
            };

        this.ancho = ancho * multiplicador;
        this.alto = alto * multiplicador;
        this.fondo = fondo * multiplicador;
    }

    public double getVolumen(int an, int al, int fo) {
        double volumen = an * al * fo / 1000000.0;
        return volumen;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getDireccion() {
        return direccion;
    }
    

    public void setEtiqueta(String etiqueta){
        if (etiqueta != null && etiqueta.length() <= 30)
            this.etiqueta = etiqueta;
    }

    @Override
    //modificar despues
    public String toString() {
        String caja = "Caja: [ancho=" + ancho + ", alto=" + alto + ", fondo=" + fondo + "]";
        return caja + etiqueta;
    };

}
