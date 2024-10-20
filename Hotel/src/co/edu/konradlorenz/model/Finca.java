package co.edu.konradlorenz.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.edu.konradlorenz.exceptions.FechaNoDisponibleException;

public class Finca extends Propiedad implements Reservable {
    private static final String NOMBRE_FINCA = "KoFinca"; // Nombre fijo para la finca
    private String temporada;
    private String comodidades;
    
    // Lista para llevar el registro de fechas ocupadas
    private List<LocalDate> fechasOcupadas;
    
    // Capacidad máxima de la finca
    private static final int CAPACIDAD_MAXIMA = 10; // Por ejemplo, 10 personas

    public Finca(double precioPorPersona, String temporada, String comodidades) {
        super(NOMBRE_FINCA, precioPorPersona);
        this.temporada = temporada;
        this.comodidades = comodidades;
        this.fechasOcupadas = new ArrayList<>(); // Inicializar la lista
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getComodidades() {
        return comodidades;
    }

    public void setComodidades(String comodidades) {
        this.comodidades = comodidades;
    }

    @Override
    public String getDescripcion() {
        return "Finca: " + getNombre() + " - Temporada: " + temporada + 
               " - Capacidad máxima: " + CAPACIDAD_MAXIMA + " personas.";
    }

    @Override
    public boolean reservar(String fecha, int numeroPersonas) throws FechaNoDisponibleException {
        LocalDate fechaReserva = LocalDate.parse(fecha);

        // Validar si la fecha ya está ocupada
        if (fechasOcupadas.contains(fechaReserva)) {
            throw new FechaNoDisponibleException("La fecha " + fecha + " ya está ocupada.");
        }
        
        // Validar si el número de personas excede la capacidad máxima
        if (numeroPersonas > CAPACIDAD_MAXIMA) {
            throw new IllegalArgumentException("El número de personas excede la capacidad máxima de " + CAPACIDAD_MAXIMA + ".");
        }

        // Si pasa todas las validaciones, añadir la fecha a las ocupadas
        fechasOcupadas.add(fechaReserva);
        return true; // La reserva se realizó con éxito
    }
}