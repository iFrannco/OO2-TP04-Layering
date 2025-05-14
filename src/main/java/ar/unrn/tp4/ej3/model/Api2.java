package ar.unrn.tp4.ej3.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Api2 {

    private RegistroInscripcion registroInscripcion;
    private RegistroConcurso registroConcursos;

    public Api2(RegistroInscripcion registroInscripcion, RegistroConcurso registroConcursos) {
        this.registroInscripcion = registroInscripcion;
        this.registroConcursos = registroConcursos;
    }

    public void guardarInscripcion(String nombre, String apellido, String dni, String email, String telefono, int idConcurso) {
        Optional<Concurso2> concurso = registroConcursos.obtenerConcurso(idConcurso);
        if (concurso.isPresent()) {
            registroInscripcion.guardarInscripcion(new Inscripcion(nombre, apellido, dni, email, telefono, concurso.get()));
        } else {
            // Deberia enviar desde aca la excepcion?
            throw new RuntimeException("No se encontro un concurso con ese id");
        }
    }

    public List<ConcursoRecord> obtenerConcursosActivos(LocalDate fechaActual) {
        List<ConcursoRecord> concursos = new ArrayList<>();
        for (Concurso2 concurso : registroConcursos.obtenerConcursos()) {
            if (concurso.estaActivo(fechaActual)) {
                concursos.add(new ConcursoRecord(concurso.obtenerId(), concurso.obtenerNombre()));
            }
        }
        return concursos;
    }
}
