package ud5.clasesejercicios.EP0825;

public class Punto {
    public static final int z = 0;
    int x;
    int y;

    

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public double distancia(Punto p1, Punto p2){
        if (p2 == null ){
            return -1;
        }
        double distanciaPuntos= Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
        return distanciaPuntos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Punto that = (Punto) obj;
    
        return x == that.x && y == that.y;

    }

}

/*
EP0825. Define la clase Punto, que tiene como atributos las coordenadas x e y, de tipo 
entero, que lo sitúan en el plano. Además del constructor, implementa el método  
 
double distancia(Punto otroPunto) 
 
que devuelve la distancia a otro punto que se le pasa como parámetro. 
 
A partir de Punto, por herencia, implementa la clase Punto3D, que representa un punto en 
tres dimensiones y necesita una coordenada adicional z. Reimplementa el método 
distancia() para puntos 3D. 
 
 
EP0826. A partir de la clase Calendario, implementada en la Actividad de aplicación 7.15, 
escribe la clase CalendarioExacto, que determina un instante de tiempo exacto formado 
por un año, un mes, un día, una hora y un minuto. Implementa los métodos toString(), 
equals() y aquellos necesarios para manejar la clase. 
*/