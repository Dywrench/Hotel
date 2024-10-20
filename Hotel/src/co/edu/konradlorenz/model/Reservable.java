package co.edu.konradlorenz.model;

import co.edu.konradlorenz.exceptions.FechaNoDisponibleException;

public interface Reservable {
    boolean reservar(String fecha, int numeroPersonas) throws FechaNoDisponibleException;
}