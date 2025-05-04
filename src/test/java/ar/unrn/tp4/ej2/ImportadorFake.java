package ar.unrn.tp4.ej2;

import ar.unrn.tp4.ej2.model.Importador;
import ar.unrn.tp4.ej2.model.Persona;

import java.time.LocalDate;
import java.util.List;

public class ImportadorFake implements Importador {

    @Override
    public List<Persona> importarPersonas() {
        return List.of(
                new Persona("matias",
                        "monsalve",
                        LocalDate.of(2000, 12, 1),
                        "correo1@gmail.com"),
                new Persona("pablo",
                        "sanchez",
                        LocalDate.of(2000, 8, 3),
                        "correo2@gmail.com"),
                new Persona("marita",
                        "bloom",
                        LocalDate.of(2000, 7, 30),
                        "correo3@gmail.com"));
    }
}
