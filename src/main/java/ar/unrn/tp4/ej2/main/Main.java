package ar.unrn.tp4.ej2.main;

import ar.unrn.tp4.ej2.service.NotificadorEmail;

import java.sql.SQLException;

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

//        var importador = new ImportadorArchivo("/home/franco/personas.txt");
//
//        var api = new Api(notificador, importador);
//
//        List<Persona> personas = api.obtenerPersonas();
//        String mensaje = "Feliz cumpleaños!";
//
//        for (Persona persona : personas) {
//            api.saludarSiCumpleAños(persona, mensaje);
//        }
    }
}
