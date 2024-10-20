package co.edu.konradlorenz.controller;

import co.edu.konradlorenz.view.Vista;
import co.edu.konradlorenz.model.CalendarioReservas;
import co.edu.konradlorenz.model.ControladorReservas;

public class AplMain {
    public static void main(String[] args) {
        Vista vista = new Vista();
        CalendarioReservas calendario = new CalendarioReservas();
        ControladorReservas controladorReservas = new ControladorReservas(calendario);
        Control control = new Control(controladorReservas, vista);

        control.run();
    }
}
