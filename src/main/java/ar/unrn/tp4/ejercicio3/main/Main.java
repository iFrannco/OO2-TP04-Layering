package ar.unrn.tp4.ejercicio3.main;

import ar.unrn.tp4.ejercicio3.model.Api2;
import ar.unrn.tp4.ejercicio3.model.ProveedorDeFechas;
import ar.unrn.tp4.ejercicio3.model.ProveedorDeFechasReal;
import ar.unrn.tp4.ejercicio3.persistencia.RegistroConcursoArchivo;
import ar.unrn.tp4.ejercicio3.persistencia.RegistroInscripcionArchivo;
import ar.unrn.tp4.ejercicio3.ui.PrimeraVentana;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().start();
                } catch (Exception e) {
// log exception...
                    System.out.println(e);
                }
            }
        });
    }

    private void start() {
        RegistroInscripcionArchivo registroInscripcionArchivo = new RegistroInscripcionArchivo("/home/franco/inscriptos.txt");
        RegistroConcursoArchivo registroConcursoArchivo = new RegistroConcursoArchivo("/home/franco/concursos.txt");
        ProveedorDeFechas proveedorDeFechas = new ProveedorDeFechasReal();
        Api2 api = new Api2(registroInscripcionArchivo, registroConcursoArchivo, proveedorDeFechas);
        new PrimeraVentana(api);
    }
}