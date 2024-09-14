package co.edu.konradlorenz.model;

public class Reserva {
	private Finca finca;
	private int numeroPersonas;
	private String fechaInicio;
	private double costoTotal;
	public Reserva(Finca finca, int numeroPersonas, String fechaInicio, double costoTotal) {
		super();
		this.finca = finca;
		this.numeroPersonas = numeroPersonas;
		this.fechaInicio = fechaInicio;
		this.costoTotal = costoTotal;
	}
	
	private double calcularCosto() {
		return finca.getPrecioPorPersona();
	}

	public Finca getFinca() {
		return finca;
	}

	public void setFinca(Finca finca) {
		this.finca = finca;
	}

	public int getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}
	
	
	
}
