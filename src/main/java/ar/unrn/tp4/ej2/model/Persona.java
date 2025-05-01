package ar.unrn.tp4.ej2.model;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String correo;

    public Persona(String nombre, String apellido, LocalDate fechaNacimiento, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", correo='" + correo + '\'' +
                '}';
    }

    public boolean cumpleAños() {
        LocalDate hoy = LocalDate.now();
        return this.fechaNacimiento.getMonth() == hoy.getMonth() && this.fechaNacimiento.getDayOfMonth() == hoy.getDayOfMonth();
    }
}
