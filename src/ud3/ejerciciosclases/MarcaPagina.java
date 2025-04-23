package ud3.ejerciciosclases;

public class MarcaPagina {
    int pagina;
    //String libro;
    
    public void incrementarPagina() {
        pagina++;
    }


    public void reiniciarLibro() {
        pagina = 0;
    }

    // GETTERS Y SETTERS
    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        if (pagina >= 0)
            this.pagina = pagina;
    }



    public static void main(String[] args) {
        // Crea  marcapáginas
        MarcaPagina mp = new MarcaPagina();
        //MarcaPagina mp2 = new MarcaPagina();

        // Imprime la página actual (página inicial)
        System.out.println(mp.getPagina());

        // Incrementamos la página
        mp.incrementarPagina();
        mp.incrementarPagina();

        System.out.println(mp.getPagina());

        // Reiniciar libro
        mp.reiniciarLibro();

        System.out.println(mp.getPagina());

    }



    
}
