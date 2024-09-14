package co.edu.konradlorenz.model;
import java.util.HashMap;
public class CalendarioReservas {
	private HashMap <String, Boolean> fechasDisponibles;
	
	public CalendarioReservas() {
		fechasDisponibles = new HashMap<>();
		
	}
	public boolean esFechaDoisponible (String fecha) {
		return fechasDisponibles.getOrDefault(fecha, false);
	}
	public void reservarFecha (String fecha) {
		fechasDisponibles.put(fecha, false); //fecha no disponible
	}
}
