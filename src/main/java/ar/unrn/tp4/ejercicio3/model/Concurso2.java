package ar.unrn.tp4.ejercicio3.model;

import java.time.LocalDate;

public class Concurso2 {
    private int idConcurso;
    private String nombre;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinInscripcion;

    public Concurso2(int idConcurso, String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {
        // se podria comprobar si la fecha de inicio es anterior a la fecha fin
        this.fechaFinInscripcion = fechaFinInscripcion;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.idConcurso = idConcurso;
        this.nombre = nombre;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public int obtenerId() {
        return this.idConcurso;
    }

    public boolean estaActivo(LocalDate fechaActual) {
        if (fechaActual.isBefore(this.fechaFinInscripcion) && fechaActual.isAfter(this.fechaInicioInscripcion)) {
            return true;
        }
        return false;
    }
}
