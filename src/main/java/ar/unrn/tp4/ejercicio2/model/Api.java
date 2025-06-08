package ar.unrn.tp4.ejercicio2.model;

import java.time.MonthDay;
import java.util.List;

public class Api {
    private Notificador notificador;
    private Importador importador;

    public Api(Notificador notificador, Importador importador) {
        this.notificador = notificador;
        this.importador = importador;
    }

    public void saludarPorCumpleaños(MonthDay diaMes, String mensaje) {
        List<Persona> personas = importador.importarPersonas();
        for (Persona persona : personas) {
            if (persona.cumpleAñosEn(diaMes)) {
                notificador.saludarCumpleaños(persona, mensaje);
            }
        }
    }

}
