package co.edu.konradlorenz.model;

public class Finca {
	private String nombre;
	private double precioPorPersona;
	private String temporada; // Altao baja
	private String comodidades;
	public Finca(String nombre, double precioPorPersona, String temporada, String comodidades) {
		super();
		this.nombre = nombre;
		this.precioPorPersona = precioPorPersona;
		this.temporada = temporada;
		this.comodidades = comodidades;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecioPorPersona() {
		return precioPorPersona;
	}
	public void setPrecioPorPersona(double precioPorPersona) {
		this.precioPorPersona = precioPorPersona;
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
	
	
}
