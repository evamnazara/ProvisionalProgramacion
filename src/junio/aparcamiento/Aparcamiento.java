package junio.aparcamiento;

import java.util.*;

public class Aparcamiento {
    private int capacidadMaxima;
    private Vehiculo[] plazas;
    private double alturaMaxima;

    public Aparcamiento() {
        this(100, 2.5); // Altura máxima por defecto
    }

    public Aparcamiento(int capacidadMaxima) {
        this(capacidadMaxima, 2.5);
    }

    public Aparcamiento(int capacidadMaxima, double alturaMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.alturaMaxima = alturaMaxima;
        this.plazas = new Vehiculo[capacidadMaxima];
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public boolean aparcarVehiculo(Vehiculo vehiculo) {
        if (consultarPlazaVehiculo(vehiculo) != -1) {
            return false;
        }

        if (vehiculo instanceof VehiculoPesado) {
            VehiculoPesado vp = (VehiculoPesado) vehiculo;
            if (vp.getAltura() > alturaMaxima) {
                return false;
            }
        }

        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == null) {
                plazas[i] = vehiculo;
                return true;
            }
        }

        return false;
    }

    public boolean sacarVehiculo(Vehiculo vehiculo) {
        for (int i = 0; i < plazas.length; i++) {
            if (vehiculo.equals(plazas[i])) {
                plazas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int numPlazasLibres() {
        int libres = 0;
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == null) {
                libres++;
            }
        }
        return libres;
    }

    public int numPlazasOcupadas() {
        return capacidadMaxima - numPlazasLibres();
    }

    public void mostrarEstado() {
        for (int i = 0; i < plazas.length; i++) {
            String estado = (plazas[i] == null) ? "Libre" : "Ocupada";
            System.out.println("Plaza " + i + ": " + estado);
        }
    }

    public void mostrarEstadoDetallado() {
        System.out.println("Plaza\tVehículo");
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] != null) {
                System.out.println(i + "\t" + plazas[i]);
            }
        }
    }

    public Vehiculo consultarPlaza(int numeroPlaza) {
        if (numeroPlaza < 0 || numeroPlaza >= capacidadMaxima) {
            return null;
        }
        return plazas[numeroPlaza];
    }

    public int consultarPlazaVehiculo(Vehiculo vehiculo) {
        for (int i = 0; i < plazas.length; i++) {
            if (vehiculo.equals(plazas[i])) {
                return i;
            }
        }
        return -1;
    }

    public int[] plazasLibres() {
        int totalLibres = numPlazasLibres();
        int[] libres = new int[totalLibres];
        int index = 0;

        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == null) {
                libres[index++] = i;
            }
        }

        return libres;
    }

    public int[] plazasOcupadas() {
        int totalOcupadas = numPlazasOcupadas();
        int[] ocupadas = new int[totalOcupadas];
        int index = 0;

        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] != null) {
                ocupadas[index++] = i;
            }
        }

        return ocupadas;
    }

    public boolean aparcarGrupoVehiculos(List<Vehiculo> vehiculos) {
        // Comprobar si alguno ya está aparcado o supera la altura
        for (Vehiculo v : vehiculos) {
            if (consultarPlazaVehiculo(v) != -1) {
                return false;
            }
            if (v instanceof VehiculoPesado) {
                VehiculoPesado vp = (VehiculoPesado) v;
                if (vp.getAltura() > alturaMaxima) {
                    return false;
                }
            }
        }

        if (numPlazasLibres() < vehiculos.size()) {
            return false;
        }

        // Aparcar
        for (Vehiculo v : vehiculos) {
            aparcarVehiculo(v);
        }

        return true;
    }

    public boolean sacarGrupoVehiculos(List<Vehiculo> vehiculos) {
        boolean todosEstaban = true;

        for (Vehiculo v : vehiculos) {
            if (!sacarVehiculo(v)) {
                todosEstaban = false;
            }
        }

        return todosEstaban;
    }

    public List<Vehiculo> vehiculosAparcados() {
        List<Vehiculo> lista = new ArrayList<>();

        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] != null) {
                lista.add(plazas[i]);
            }
        }

        if (lista.isEmpty()) {
            return null;
        }

        Collections.sort(lista);
        return lista;
    }

    public Map<Integer, Vehiculo> plazasVehiculos() {
        Map<Integer, Vehiculo> mapa = new HashMap<>();
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] != null) {
                mapa.put(i, plazas[i]);
            }
        }
        return mapa.isEmpty() ? null : mapa;
    }

    public Map<Vehiculo, Integer> vehiculosPlazas() {
        Map<Vehiculo, Integer> mapa = new HashMap<>();
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] != null) {
                mapa.put(plazas[i], i);
            }
        }
        return mapa.isEmpty() ? null : mapa;
    }
}
