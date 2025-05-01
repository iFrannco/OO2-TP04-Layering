package ar.unrn.tp4.ej2.service;

import ar.unrn.tp4.ej2.model.Importador;
import ar.unrn.tp4.ej2.model.Persona;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ImportadorArchivo implements Importador {
    private String path;

    public ImportadorArchivo(String path) {
        this.path = path;
    }

    public List<Persona> importarPersonas() {
        List<Persona> personas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    String apellido = partes[0].trim();
                    String nombre = partes[1].trim();
                    LocalDate fecha = LocalDate.parse(partes[2].trim().replace("/", "-"));
                    String email = partes[3].trim();

                    personas.add(new Persona(apellido, nombre, fecha, email));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("hubo un error al leer los datos del archivo", e);
        }

        return personas;
    }

}
