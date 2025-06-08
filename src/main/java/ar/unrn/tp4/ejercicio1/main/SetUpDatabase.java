package ar.unrn.tp4.ejercicio1.main;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetUpDatabase {
    private final String username;
    private final String pwd;
    private String conn;

    public SetUpDatabase(String conn, String username, String pwd) {
        this.conn = conn;
        this.username = username;
        this.pwd = pwd;
    }

    public void inicializar() {
        try (var connection = DriverManager.getConnection(conn, username, pwd)) {
            var stmt = connection.createStatement();
            dropTableConcurso(stmt);
            createTableParticipantes(stmt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void dropTableConcurso(Statement stmt) {
        try {
            //hago esto porque drop table falla si la tabla no existe
            //y Derby no soporta drop table if exists
            //try/catch sin lanzar la exception solo en inicializaciones como esta
            //no es una buena práctica hacer esto
            stmt.executeUpdate("DROP TABLE participantes");
        } catch (Exception e) {
            //no hagamos nada, creamos la tabla
        }
    }

    private void createTableParticipantes(Statement stmt) throws SQLException {
        stmt.executeUpdate("CREATE TABLE participantes (id_concurso INT NOT NULL "
                + " primary key generated always as identity (start with 1, increment by 1), "
                + " nombre varchar(255), telefono varchar(255), region varchar(255))");
    }

}