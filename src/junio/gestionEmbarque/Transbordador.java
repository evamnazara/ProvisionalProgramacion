package junio.gestionEmbarque;

import java.util.*;

public class Transbordador {
    private static final double PESO_MAXIMO = 20000;
    private List<Vehiculo> embarcados;

    public Transbordador() {
        embarcados = new ArrayList<>();
    }

    public void embarcarVehiculo(Vehiculo v) throws MatriculaRepetidaException, SuperadoPesoMaximoException {
        for (Vehiculo ve : embarcados) {
            if (ve.getMatricula().equalsIgnoreCase(v.getMatricula())) {
                throw new MatriculaRepetidaException("Matrícula ya embarcada: " + v.getMatricula());
            }
        }

        if (getPesoTotal() + v.calcularPeso() > PESO_MAXIMO) {
            throw new SuperadoPesoMaximoException("Peso máximo superado. No se puede embarcar.");
        }

        embarcados.add(v);
    }

    public void resetear() {
        embarcados.clear();
    }

    public double getPesoTotal() {
        double total = 0;
        for (Vehiculo v : embarcados) {
            total += v.calcularPeso();
        }
        return total;
    }

    public void informe() {
        for (Vehiculo v : embarcados) {
            System.out.println(v.informe());
        }
        System.out.printf("Peso total embarcado: %.2f Kg%n", getPesoTotal());
    }

    public class MatriculaRepetidaException extends Exception {
        public MatriculaRepetidaException(String msg) {
            super(msg);
        }
    }

    public class SuperadoPesoMaximoException extends Exception {
        public SuperadoPesoMaximoException(String msg) {
            super(msg);
        }
    }

}
