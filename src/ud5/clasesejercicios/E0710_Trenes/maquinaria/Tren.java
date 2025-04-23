package ud5.clasesejercicios.E0710_Trenes.maquinaria;

import java.util.Arrays;

import ud5.clasesejercicios.E0710_Trenes.personal.Maquinista;

public class Tren {
    static final byte MAX_VAGONES = 5;
    Locomotora locomotora;
    Vagon[] vagones;
    Maquinista maquinista;


    public Tren(Locomotora locomotora, Maquinista maquinista) {
        this(locomotora, maquinista, 0);
    }

    public Tren(Locomotora locomotora, Maquinista maquinista, int numVagones) {
        if (numVagones > MAX_VAGONES) {
            throw new ArrayIndexOutOfBoundsException("Demasiados vagones, el máximo es " + MAX_VAGONES);
        }

        this.locomotora = locomotora;
        this.maquinista = maquinista;
        vagones = new Vagon[numVagones];
        for (int i = 0; i < numVagones; i++) {
            vagones[i] = new Vagon(i);
        }
    }

    public boolean addVagon(int id, int cargaMaxima, int cargaActual, String tipoMercancia){
        //primero hay que instanciarlo, pero comprobando que no haya mas de los maximos

        if (vagones.length == MAX_VAGONES){
            return false;
        }
        Vagon vagon = new Vagon(id, cargaMaxima, cargaActual, tipoMercancia);

        vagones = Arrays.copyOf(vagones, vagones.length + 1);
        vagones[vagones.length - 1] = vagon;
        return true;
    }

    @Override
    public String toString() {
        return "Carga actual: " + getCargaActual() + " kilos.";
    }

    //metodos
    public int getNumVagones() {
        
        return vagones.length;
    }


    public int getCargaActual() {
        //recorrer vagones 
        int cargaActual = 0;

        for (Vagon vagon : vagones) {
            cargaActual += vagon.cargaActual;
        }

        return cargaActual;
    }
    

}
