package co.edu.konradlorenz.controller;

import co.edu.konradlorenz.model.ControladorReservas;
import co.edu.konradlorenz.model.Reserva;
import co.edu.konradlorenz.view.Vista;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Control {
    private static final String NOMBRE_FINCA = "KonFinca";
    private static final double PRECIO_POR_PERSONA = 50000.0;
    private static final int CAPACIDAD_MAXIMA = 10; // Capacidad máxima de personas

    private ControladorReservas controladorReservas;
    private Vista vista;

    public Control(ControladorReservas controladorReservas, Vista vista) {
        this.controladorReservas = controladorReservas;
        this.vista = vista;
    }

    public void run() {
        vista.mostrarMensaje("_____________________________________________________________________________________");
        vista.mostrarMensaje("");
        vista.mostrarMensaje("Bienvenid@ a KonFinca");
        vista.mostrarMensaje("Recuerde que la capacidad máxima de la finca es de " + CAPACIDAD_MAXIMA + " personas.");
        vista.mostrarMensaje("_____________________________________________________________________________________");

        boolean continuar = true;
        while (continuar) {
            int opcion = vista.leerEntero("Seleccione una opción:\n1. Registrar nueva reserva\n2. Mostrar reservas\n3. Mostrar días libres\n4. Salir\n");
            switch (opcion) {
                case 1:
                    registrarReserva();
                    break;
                case 2:
                    mostrarReservas();
                    break;
                case 3:
                    mostrarDiasLibres();
                    break;
                case 4:
                	vista.mostrarMensaje("Hasta pronto");
                	
                    continuar = false;
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private void registrarReserva() {
        Map<String, Boolean> diasDisponibles = controladorReservas.obtenerEstadoDiasDeLaSemana();
        vista.mostrarDiasDisponibles(diasDisponibles);
        
        String diasSeleccionados = vista.leerTexto("Ingrese los días que desea reservar (separados por comas, ej. Lunes, Miércoles):");
        
        if (diasSeleccionados == null || diasSeleccionados.trim().isEmpty()) {
            vista.mostrarMensaje("Entrada vacía, por favor ingrese un día válido.");
            return;
        }

        String[] diasElegidos = diasSeleccionados.split(",");
        Map<String, Integer> diasHospedaje = new HashMap<>();
        boolean reservaValida = true;

        // Solicitar el número de personas solo una vez
        int numeroPersonas = vista.leerEntero("Ingrese el número de personas:");

        if (numeroPersonas > CAPACIDAD_MAXIMA) {
            vista.mostrarMensaje("El número de personas excede la capacidad máxima.");
            return; // Terminar el método si el número de personas es inválido
        }

        for (String dia : diasElegidos) {
            dia = dia.trim().toLowerCase();

            // Verificar si el día está disponible
            if (diasDisponibles.containsKey(dia) && diasDisponibles.get(dia)) {
                // Sumar días para la reserva
                diasHospedaje.put(dia, 1); // Se cuenta un día por cada entrada
            } else {
                vista.mostrarMensaje(dia + " no está disponible.");
                reservaValida = false;
            }
        }

        // Realizar la reserva si es válida
        if (reservaValida && !diasHospedaje.isEmpty()) {
            if (controladorReservas.hacerReserva(diasHospedaje, numeroPersonas)) { // Usar numeroPersonas en lugar de diasHospedaje.values().size()
                vista.mostrarMensaje("Reserva realizada para los días seleccionados con " + numeroPersonas + " personas.");
            } else {
                vista.mostrarMensaje("Error al realizar la reserva.");
            }
        } else {
            vista.mostrarMensaje("No se realizaron reservas.");
        }
    }

    private void mostrarReservas() {
        List<Reserva> reservas = controladorReservas.obtenerReservas();

        if (reservas.isEmpty()) {
            vista.mostrarMensaje("No hay reservas registradas.");
        } else {
            vista.mostrarMensaje("Reservas registradas:");
            for (Reserva reserva : reservas) {
                // Obtener los días de hospedaje
                String dias = String.join(", ", reserva.getDiasHospedaje().keySet()); // Usar las claves del mapa
                String mensajeReserva = "Días: " + dias + 
                                        ", Número de personas: " + reserva.getNumeroPersonas() + 
                                        ", Costo total: " + reserva.getCostoTotal();
                vista.mostrarMensaje(mensajeReserva);
            }
        }
    }


    private void mostrarDiasLibres() {
        String diasLibres = controladorReservas.mostrarFechasLibres();
        if (diasLibres.isEmpty()) {
            vista.mostrarMensaje("No hay fechas libres disponibles.");
        } else {
            vista.mostrarMensaje(diasLibres);
        }
    }
}
