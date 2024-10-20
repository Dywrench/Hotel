package co.edu.konradlorenz.model;

public abstract class Propiedad {
    private String nombre;
    private double precioPorPersona;

    public Propiedad(String nombre, double precioPorPersona) {
        this.nombre = nombre;
        this.precioPorPersona = precioPorPersona;
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

    // Método abstracto
    public abstract String getDescripcion();
}
