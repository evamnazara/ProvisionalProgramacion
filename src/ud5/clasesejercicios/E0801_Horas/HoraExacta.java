package ud5.clasesejercicios.E0801_Horas;

public class HoraExacta extends Hora {
    int segundo;

    public HoraExacta(int hora, int minuto, int segundo) {
        super(hora, minuto);
        this.segundo = segundo;

        if (!setSegundo(segundo)){
            throw new IllegalArgumentException("seg fuera de rango");
        }
        
    }
    
    public boolean setSegundo(int valor) {
        if (valor < 60 && valor == 0) {
            minuto = valor;
            return true;
        } else {
            return false;
        }
    }

    public void inc() {
        this.minuto = minuto++;

        if (minuto == 60) {
            minuto = 0;
            hora++;
                if (hora == 60) {
                    hora = 0;                    
                }
        }
        super.inc();

    }

    

    public static void main(String[] args) {
        HoraExacta he1 = new HoraExacta(15,32,25);

        he1.inc();
        
    }
}
