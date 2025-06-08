package ar.unrn.tp4.ejercicio3.model;

import java.util.List;
import java.util.Optional;

public interface RegistroConcurso {
    Optional<Concurso2> obtenerConcurso(int idConcurso);

    List<Concurso2> obtenerConcursos();
}
