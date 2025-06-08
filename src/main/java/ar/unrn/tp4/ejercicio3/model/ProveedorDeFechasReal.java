package ar.unrn.tp4.ejercicio3.model;

import java.time.LocalDate;

public class ProveedorDeFechasReal implements ProveedorDeFechas {
    @Override
    public LocalDate obtenerFecha() {
        return LocalDate.now();
    }
}
