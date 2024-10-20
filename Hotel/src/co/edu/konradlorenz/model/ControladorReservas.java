package co.edu.konradlorenz.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControladorReservas {
    private List<Reserva> reservas;
    private CalendarioReservas calendario;

    public ControladorReservas(CalendarioReservas calendarioReservas) {
        this.reservas = new ArrayList<>();
        this.calendario = calendarioReservas;
    }

    public boolean hacerReserva(Map<String, Integer> diasHospedaje, int numeroPersonas) {
        for (String dia : diasHospedaje.keySet()) {
            if (!calendario.esDiaDisponible(dia)) {
                return false; 
            }
        }

        // Agregar la reserva con los días solicitados
        reservas.add(new Reserva(numeroPersonas, diasHospedaje));
        
        // Reservar los días en el calendario
        for (String dia : diasHospedaje.keySet()) {
            calendario.reservarDia(dia);
        }
        
        return true;
    }

    public String mostrarFechasLibres() {
        return calendario.mostrarDiasLibres();
    }

    public Map<String, Boolean> obtenerEstadoDiasDeLaSemana() {
        return calendario.getDiasDisponibles();
    }
    
    public List<Reserva> obtenerReservas() {
        return reservas;
    }
}
