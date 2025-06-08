package ar.unrn.tp4.ejercicio3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Api2 {

    private RegistroInscripcion registroInscripcion;
    private RegistroConcurso registroConcursos;
    private ProveedorDeFechas proveedorDeFechas;

    public Api2(RegistroInscripcion registroInscripcion, RegistroConcurso registroConcursos, ProveedorDeFechas proveedorDeFechas) {
        this.registroInscripcion = registroInscripcion;
        this.registroConcursos = registroConcursos;
        this.proveedorDeFechas = proveedorDeFechas;
    }

    public void guardarInscripcion(String nombre, String apellido, String dni, String email, String telefono, int idConcurso) {
        Optional<Concurso2> concurso = registroConcursos.obtenerConcurso(idConcurso);
        if (concurso.isPresent()) {
            registroInscripcion.guardarInscripcion(new Inscripcion(nombre, apellido, dni, email, telefono, concurso.get()));
        } else {
            throw new RuntimeException("No se encontro un concurso con ese id");
        }
    }

    public List<ConcursoRecord> obtenerConcursosActivos() {
        List<ConcursoRecord> concursos = new ArrayList<>();
        for (Concurso2 concurso : registroConcursos.obtenerConcursos()) {
            if (concurso.estaActivo(proveedorDeFechas.obtenerFecha())) {
                concursos.add(new ConcursoRecord(concurso.obtenerId(), concurso.obtenerNombre()));
            }
        }
        return concursos;
    }
}
