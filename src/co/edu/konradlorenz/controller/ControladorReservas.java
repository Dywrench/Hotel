package co.edu.konradlorenz.controller;

import co.edu.konradlorenz.model.CalendarioReservas;
import co.edu.konradlorenz.model.Reserva;

public class ControladorReservas {
	private CalendarioReservas calendario;

	public ControladorReservas(CalendarioReservas calendario) {
		super();
		this.calendario = calendario;
	}
	
	public boolean hacerReserva (Reserva reserva) {
		if(calendario.esFechaDoisponible(reserva.getFechaInicio())) {
			calendario.reservarFecha(reserva.getFechaInicio());
			// falta implementar mas cosas
			return true;
		}
		return false;
	}
}	
