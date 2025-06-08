package ar.unrn.tp4.ejercicio2;

import ar.unrn.tp4.ejercicio2.model.Api;
import org.junit.jupiter.api.Test;

import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEjercicio2 {

    @Test
    void ningunoCumpleAños() {
        // set up
        var importador = new ImportadorFake();
        var notificador = new NotificadorFake();
        var api = new Api(notificador, importador);

        // excercise
        api.saludarPorCumpleaños(MonthDay.of(2, 23), "Feliz cumpleaños!");

        // verify
        assertEquals("", notificador.obtenerSaludos());

    }

    @Test
    void unoCumpleAños() {
        // set up
        var importador = new ImportadorFake();
        var notificador = new NotificadorFake();
        var api = new Api(notificador, importador);

        // excercise
        api.saludarPorCumpleaños(MonthDay.of(8, 3), "Feliz cumpleaños");

        // verify
        assertEquals("Feliz cumpleaños pablo" + System.lineSeparator(),
                notificador.obtenerSaludos());

    }
}
