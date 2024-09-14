package co.edu.konradlorenz.view;

import co.edu.konradlorenz.model.CalendarioReservas;
import co.edu.konradlorenz.model.Finca;

public class InterfazUsuario {
	public void mostrarDetallesFinca(Finca finca) {
		System.out.println("Finca:"+finca.getNombre());
		System.out.println("Precio por persona:"+finca.getPrecioPorPersona());
		System.out.println("Comodidades:"+finca.getComodidades());
	}
	public void mostrarCalendario (CalendarioReservas calendario) {
		//agregar para mostrar fechas disponibles
	}
}
