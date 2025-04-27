package u6.apuntes;

public class Contenedor <T> {
    //si no llevase T, aunque no da error de compilacion, hay una excepcion al terminar el metodo

    private T objeto; // se inicializa a null: contenedor vacío


    public Contenedor() {
    }


    void guardar(T nuevo) {
        objeto = nuevo;
    }


    T extraer() {
        T res = objeto;
        objeto = null; // el contenedor vuelve a estar vacio
        return res;
    }
}

