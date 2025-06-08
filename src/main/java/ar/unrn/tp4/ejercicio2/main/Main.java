package ar.unrn.tp4.ejercicio2.main;

import ar.unrn.tp4.ejercicio2.model.Api;
import ar.unrn.tp4.ejercicio2.service.ImportadorArchivo;
import ar.unrn.tp4.ejercicio2.service.NotificadorEmail;

import java.time.MonthDay;

public class Main {
    public static void main(String[] args) {

        var importador = new ImportadorArchivo("/home/franco/personas.txt");
        var notificador = new NotificadorEmail("fcabeza91@gmail.com");
        var api = new Api(notificador, importador);
        api.saludarPorCumpleaños(MonthDay.of(10, 8), "Feliz Cumpleaños!");

    }
}
