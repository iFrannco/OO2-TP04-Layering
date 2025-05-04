package ar.unrn.tp4.ej3.persistencia;

import ar.unrn.tp4.ej3.model.Concurso2;
import ar.unrn.tp4.ej3.model.RegistroConcurso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RegistroConcursoDB implements RegistroConcurso {
    private String url;
    private String user;
    private String password;

    public RegistroConcursoDB(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public Optional<Concurso2> obtenerConcurso(int idConcurso) {
        String query = "SELECT * FROM concursos WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idConcurso);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Concurso2(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getDate("fecha_inicio").toLocalDate(),
                            rs.getDate("fecha_fin").toLocalDate()
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener el concurso", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Concurso2> obtenerConcursos() {
        List<Concurso2> concursos = new ArrayList<>();
        String query = "SELECT * FROM concursos";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                concursos.add(new Concurso2(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDate("fecha_inicio").toLocalDate(),
                        rs.getDate("fecha_fin").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener los concursos", e);
        }
        return concursos;
    }
}
