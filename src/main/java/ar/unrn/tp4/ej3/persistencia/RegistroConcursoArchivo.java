package ar.unrn.tp4.ej3.persistencia;

import ar.unrn.tp4.ej3.model.Concurso2;
import ar.unrn.tp4.ej3.model.RegistroConcurso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RegistroConcursoArchivo implements RegistroConcurso {
    private String rutaArchivo;

    public RegistroConcursoArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }


    @Override
    public Optional<Concurso2> obtenerConcurso(int idConcurso) {
        return obtenerConcursos().stream()
                .filter(c -> c.obtenerId() == idConcurso)
                .findFirst();
    }

    @Override
    public List<Concurso2> obtenerConcursos() {
        List<Concurso2> concursos = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.trim().isEmpty()) continue; // ignorar líneas vacías
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0].trim());
                String nombre = partes[1].trim();
                LocalDate fechaInicio = LocalDate.parse(partes[2].trim(), formatter);
                LocalDate fechaFin = LocalDate.parse(partes[3].trim(), formatter);

                concursos.add(new Concurso2(id, nombre, fechaInicio, fechaFin));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer concursos desde archivo", e);
        }

        return concursos;
    }
}
