package ar.unrn.tp4.ejercicio3.persistencia;

import ar.unrn.tp4.ejercicio3.model.Inscripcion;
import ar.unrn.tp4.ejercicio3.model.RegistroInscripcion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroInscripcionDB implements RegistroInscripcion {
    private String url;
    private String user;
    private String password;

    public RegistroInscripcionDB(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void guardarInscripcion(Inscripcion inscripcion) {
        String query = "INSERT INTO inscripciones (nombre, apellido, dni, email, telefono, id_concurso) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, inscripcion.getNombre());
            stmt.setString(2, inscripcion.getApellido());
            stmt.setString(3, inscripcion.getDni());
            stmt.setString(4, inscripcion.getEmail());
            stmt.setString(5, inscripcion.getTelefono());
            stmt.setInt(6, inscripcion.getConcursoId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar la inscripción", e);
        }
    }
}