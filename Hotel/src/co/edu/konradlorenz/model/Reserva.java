package co.edu.konradlorenz.model;

import java.util.Map;

public class Reserva {
    private int numeroPersonas;
    private Map<String, Integer> diasHospedaje; 

    public Reserva(int numeroPersonas, Map<String, Integer> diasHospedaje) {
        this.numeroPersonas = numeroPersonas;
        this.diasHospedaje = diasHospedaje;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public Map<String, Integer> getDiasHospedaje() {
        return diasHospedaje;
    }

    public double getCostoTotal() {
        double costoPorDiaPorPersona = 50000; // Costo por persona por día
        int totalDias = diasHospedaje.values().stream().mapToInt(Integer::intValue).sum();
        return totalDias * numeroPersonas * costoPorDiaPorPersona;
    }
}
