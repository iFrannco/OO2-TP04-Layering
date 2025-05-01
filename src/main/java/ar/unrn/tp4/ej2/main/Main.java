package ar.unrn.tp4.ej2.main;

import ar.unrn.tp4.ej2.model.Api;
import ar.unrn.tp4.ej2.model.Persona;
import ar.unrn.tp4.ej2.service.ImportadorArchivo;
import ar.unrn.tp4.ej2.service.NotificadorEmail;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        var notificador = new NotificadorEmail(
                "franco",
                "asdf",
                "213",
                "gmail",
                "true",
                "true",
                "correodeprueba@gmail.com");

        var importador = new ImportadorArchivo("/home/franco/personas.txt");

        var api = new Api(notificador, importador);

        List<Persona> personas = api.obtenerPersonas();

        for (Persona persona : personas) {
            api.saludarCumpleaños(persona);
        }
    }
}
