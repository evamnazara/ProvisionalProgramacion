/*autora: Eva María Otero Názara */


package ud3.oneexamen;

public class CocheCarreras {
    private String nombre; 
    private double velocidadMaxima, autonomia, maximoTurbos;

    private double autonomiaRestante;
    private double metrosRecorridos;
    private double turbosRestantes;
    //private double distanciaRecorrida;

    


    public CocheCarreras(String nombre, double velocidadMaxima, double autonomia, double maximoTurbos) {
        nombre = getNombre();
        maximoTurbos = 3;         
    }

        public String getNombre() {
            return nombre;
        }

        public double getVelocidadMaxima() {
            if (velocidadMaxima >= 1 && velocidadMaxima <= 100) {}
            return velocidadMaxima;
        }
    
    
        public double getAutonomia() {
            return autonomia;
        }
    
    
        public double getMaximoTurbos() {
            return maximoTurbos;
        }

        public double getMetrosRecorridos() {
            

            return metrosRecorridos;
        }
    
    
        public double getTurbosRestantes() {
            return turbosRestantes;
        }


        private void mostrar() {
            System.out.println("Coche: " + nombre );
            System.out.println("Velocidad máxima: " + velocidadMaxima + "mps" );
            System.out.println("Turbos máximos: " + maximoTurbos );
            System.out.println("Turbos restantes: " + maximoTurbos );
            System.out.println("Autonomía: " + autonomia );
            System.out.println("Autonomía restante: " + autonomiaRestante );

    
        }

        private void avanzar() {
            double metrosAvance = Math.random() * (velocidadMaxima - 1) - velocidadMaxima;

            if ( autonomia > metrosAvance) {
                    metrosRecorridos = metrosRecorridos + metrosAvance;
                    autonomiaRestante = autonomiaRestante - metrosRecorridos;

                    System.out.println("metros recorridos:" + metrosRecorridos);
                    System.out.println("metros recorridos:" + autonomiaRestante);
            } else {
                System.out.println(0);
            }

        }

        private void usarTurbo(){
  
                if  (turbosRestantes > 0 && metrosRecorridos < autonomiaRestante) {

                    metrosRecorridos = velocidadMaxima * 0.15;

                    turbosRestantes = turbosRestantes - 1;
                    
                }

        }

        private void repostar() {
            autonomiaRestante = autonomia;
            turbosRestantes = maximoTurbos;

        }

        private double getAutonomiaRestante() {
          double autonomiaRestante = metrosRecorridos - autonomia;
          return autonomiaRestante;

        }

        private void reiniciarDistancia() {
            metrosRecorridos = 0;
        }
    
    public static void main(String[] args) {
        System.out.println("RAYO");
        System.out.println("====");
        CocheCarreras rayo = new CocheCarreras("Rayo", 60,700, 5);
        rayo.mostrar();
        rayo.avanzar();
        rayo.usarTurbo();
        rayo.mostrar();
        rayo.reiniciarDistancia();
        rayo.mostrar();

        
        System.out.println("TRUENO");
        System.out.println("======");
        CocheCarreras trueno = new CocheCarreras("Trueno", 80, 900, 9);
        trueno.mostrar();

        while (trueno.getAutonomiaRestante() != 0) {
                trueno.usarTurbo();
                trueno.mostrar();
                trueno.repostar();
                trueno.mostrar(); }
    }


}

