package ud5.clasesejercicios.E0801_Horas;

public class Hora {
    int hora;
    int minuto;

    public Hora(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
        //validaciones 
        if (!setHora(hora)){
            throw new IllegalArgumentException("hora fuera de rango");
        }

        if (!setMinuto(minuto)){
            throw new IllegalArgumentException("min fuera de rango");
        }
    }




    //metodo de instancia 
    public void inc() {
        this.minuto = minuto++;

        if (minuto == 60) {
            minuto = 0;
            hora++;
                if (hora == 60) {
                    hora = 0;                    
                }
        }

    }

  public boolean setMinuto(int valor) {
        if (valor < 60 && valor == 0) {
            minuto = valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean setHora(int valor) {
        if (valor < 24 ) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString(){
        //string.format noseq
        String horas = hora + ":" + minuto;
        
        return horas;
    }

    
    public static void main(String[] args) {
        Hora hora1 = new Hora(1,54);
        hora1.toString();
       // hora1.inc();
        hora1.toString();
        System.out.println(hora1);

        Hora hora2 = new Hora(55,3);
        System.out.println(hora1);

        hora2.toString();
      //  hora2.inc();
        hora2.toString();

        Hora hora3 = new Hora(3,59);
        hora3.toString();
        System.out.println(hora1);

        hora3.inc();
        hora3.toString();
        System.out.println(hora1);

    }
}
