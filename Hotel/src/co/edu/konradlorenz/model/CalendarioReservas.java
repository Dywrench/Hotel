package co.edu.konradlorenz.model;

import java.util.HashMap;
import java.util.Map;

public class CalendarioReservas {
    private Map<String, Boolean> diasDisponibles;

    public CalendarioReservas() {
        this.diasDisponibles = new HashMap<>();
        inicializarCalendario();
    }

    private void inicializarCalendario() {
        diasDisponibles.put("lunes", true);
        diasDisponibles.put("martes", true);
        diasDisponibles.put("miercoles", true);
        diasDisponibles.put("jueves", true);
        diasDisponibles.put("viernes", true);
        diasDisponibles.put("sabado", true);
        diasDisponibles.put("domingo", true);
    }

    public boolean esDiaDisponible(String dia) {
        return diasDisponibles.getOrDefault(dia.toLowerCase(), false);
    }

    public void reservarDia(String dia) {
        diasDisponibles.put(dia.toLowerCase(), false);
    }

    public String mostrarDiasLibres() {
        StringBuilder diasLibres = new StringBuilder("Días libres:\n");
        diasDisponibles.forEach((dia, disponible) -> {
            if (disponible) {
                diasLibres.append(dia).append("\n");
            }
        });
        return diasLibres.toString();
    }

    public Map<String, Boolean> getDiasDisponibles() {
        return diasDisponibles;
    }
}
