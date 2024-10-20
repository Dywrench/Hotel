package co.edu.konradlorenz.view;

import co.edu.konradlorenz.model.Reserva;

import java.util.Map;
import java.util.Scanner;

public class Vista {

    private Scanner scanner;

    public Vista() {
        this.scanner = new Scanner(System.in);
    }

    public String leerCadena(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    public String leerTexto(String mensaje) {
        mostrarMensaje(mensaje);
        return scanner.nextLine();
    }

    public int leerEntero(String mensaje) {
        System.out.println(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Intente de nuevo.");
            scanner.next(); // Limpiar entrada inválida
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return valor;
    }

    public double leerDouble(String mensaje) {
        System.out.println(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Intente de nuevo.");
            scanner.next(); 
        }
        double valor = scanner.nextDouble();
        scanner.nextLine(); 
        return valor;
    }

    public void mostrarReserva(Reserva reserva) {
        System.out.println("Reserva realizada:");
        System.out.println("Número de personas: " + reserva.getNumeroPersonas());
        mostrarDiasHospedaje(reserva.getDiasHospedaje());
        System.out.println("Costo total: " + reserva.getCostoTotal());
    }

    public void mostrarDiasHospedaje(Map<String, Integer> diasHospedaje) {
        System.out.println("Días de hospedaje:");
        for (Map.Entry<String, Integer> entry : diasHospedaje.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " día(s)");
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String error) {
        System.err.println("Error: " + error);
    }

    public void mostrarDiasDisponibles(Map<String, Boolean> dias) {
        mostrarMensaje("Estado de los días de la semana:");
        for (Map.Entry<String, Boolean> entry : dias.entrySet()) {
            mostrarMensaje(entry.getKey() + ": " + (entry.getValue() ? "Disponible" : "No disponible"));
        }
    }
}
