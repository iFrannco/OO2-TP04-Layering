package ar.unrn.tp4.ej3.persistencia;

import ar.unrn.tp4.ej3.model.Inscripcion;
import ar.unrn.tp4.ej3.model.RegistroInscripcion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegistroInscripcionArchivo implements RegistroInscripcion {
    private String pathArchivo;

    public RegistroInscripcionArchivo(String pathArchivo) {
        this.pathArchivo = pathArchivo;
    }

    @Override
    public void guardarInscripcion(Inscripcion inscripcion) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathArchivo, true))) {
            String linea = String.format("%s, %s, %s, %s, %d",
                    inscripcion.getApellido(),
                    inscripcion.getNombre(),
                    inscripcion.getTelefono(),
                    inscripcion.getEmail(),
                    inscripcion.getConcursoId());

            writer.write(linea);
            writer.newLine(); // Agrega un salto de línea
        } catch (IOException e) {
            System.err.println("Error al guardar la inscripción: " + e.getMessage());
        }
    }
}

