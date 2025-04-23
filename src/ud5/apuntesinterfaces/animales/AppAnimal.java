package ud5.apuntesinterfaces.animales;

public class AppAnimal {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        
        //Caracol caracol = new Caracol();

        //System.out.println(Sonido.version);
        //System.out.println(perro.version); <- no es necesario instanciar un objeto para ver la version
        perro.voz();
        gato.vozDurmiendo(); 
        Leon leon = new Leon();
        leon.voz();
        leon.vozDurmiendo();

        //Sonido.bostezo();

        Sonido p = perro;
        p.voz(); //como invoca a un perro, ladra
        p = gato;
        gato.voz();
        
        System.out.println("polimorfismo con interfaces");

        Sonido [] sonidos = {perro, gato, leon};
        for (Sonido sonido : sonidos) {
            System.out.println("esto es un .... " + sonido.getClass().getSimpleName());
            sonido.voz();
            sonido.vozDurmiendo(); 
        }

        Sonido soni = new Sonido() {
            @Override
            public void voz(){
                System.out.println("jejeijaijij");
            }
        };

        //lambda -- cuando solo hay un metodo abstracto
        //Sonido soni2 = () -> System.out.println("jejeijaijij");
        soni.voz();
        soni.vozDurmiendo();
        

    }
}
