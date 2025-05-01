package ar.unrn.tp4.ej1.main;

import ar.unrn.tp4.ej1.database.JDBCRegistroParticipante;
import ar.unrn.tp4.ej1.model.Concurso;
import ar.unrn.tp4.ej1.ui.VentanaPrincipal;

import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static final String CONNSTR = "jdbc:derby:memory:ventas;create=true";
    public static final String USERNAME = "app";
    public static final String PWD = "app";

    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    inicializarDatabase();
                    var registroParticipante = new JDBCRegistroParticipante(CONNSTR, USERNAME, PWD);
                    var concurso = new Concurso(registroParticipante);
                    new VentanaPrincipal(concurso).AgregarParticipante();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    private static void inicializarDatabase() {
        var jdbc = new SetUpDatabase(CONNSTR,
                USERNAME,
                PWD);
        jdbc.inicializar();
    }
}