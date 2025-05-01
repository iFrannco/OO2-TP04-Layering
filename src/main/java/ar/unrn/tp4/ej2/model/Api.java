package ar.unrn.tp4.ej2.model;

import java.util.List;

public class Api {
    private Notificador notificador;
    private Importador importador;

    public Api(Notificador notificador, Importador importador) {
        this.notificador = notificador;
        this.importador = importador;
    }

    public List<Persona> obtenerPersonas() {
        return importador.importarPersonas();
    }

    public void saludarCumpleaños(Persona persona) {
        if (persona.cumpleAños()) {
            notificador.saludarCumpleaños(persona);
        }
    }

}
