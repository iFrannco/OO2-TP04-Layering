package ar.unrn.tp4.ejercicio2.model;

import java.time.LocalDate;
import java.time.MonthDay;

public class Persona {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String correo;

    public Persona(String nombre, String apellido, LocalDate fechaNacimiento, String correo) {
        // validar que los campos cumplen con las reglas de negocio.

        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public boolean cumpleAñosEn(MonthDay diaMes) {
        return this.fechaNacimiento.getMonth() == diaMes.getMonth() && this.fechaNacimiento.getDayOfMonth() == diaMes.getDayOfMonth();
    }

    public String getCorreo() {
        return this.correo;
    }
}
