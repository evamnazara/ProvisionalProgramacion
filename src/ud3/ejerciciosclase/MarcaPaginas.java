/* EP0711. 
Escribe la clase MarcaPagina, que ayuda a llevar el control de la lectura de un libro. 
Deberá disponer de métodos para incrementar la página leída, para obtener
información de la última página que se ha leído y para comenzar desde el principio una
nueva lectura del mismo libro. */

package ud3.ejerciciosclase;

public class MarcaPaginas {
    int pagina;

    

    public MarcaPaginas(int pagina) {
        this.pagina = pagina;
    }

    public void incrementarPagina(int pagina) {
        pagina++;
    }

    public void reiniciarLibro (int pagina) {
        pagina = 0;
    }



    public static void main(String[] args) {
        
    }


}


