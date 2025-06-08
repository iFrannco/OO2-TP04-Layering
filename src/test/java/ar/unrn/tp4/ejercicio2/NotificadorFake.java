package ar.unrn.tp4.ejercicio2;

import ar.unrn.tp4.ejercicio2.model.Notificador;
import ar.unrn.tp4.ejercicio2.model.Persona;

public class NotificadorFake implements Notificador {
    private String saludos = new String();

    @Override
    public void saludarCumpleaños(Persona persona, String mensaje) {
        saludos += mensaje + " " + persona.obtenerNombre() + System.lineSeparator();
    }

    public String obtenerSaludos() {
        return saludos;
    }
}
