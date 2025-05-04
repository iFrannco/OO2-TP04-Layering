package ar.unrn.tp4.ej3.model;

public class Inscripcion {
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private Concurso2 concurso;
    private String email;


    public Inscripcion(String nombre, String apellido, String dni, String email, String telefono, Concurso2 concurso) {
        if ("".equals(nombre)) {
            throw new RuntimeException("Nombre no puede ser vacio");
        }
        if ("".equals(apellido)) {
            throw new RuntimeException("apellido no puede ser vacio");
        }
        if ("".equals(dni)) {
            throw new RuntimeException("dni no puede ser vacio");
        }
        if (!checkEmail(email)) {
            throw new RuntimeException("email debe ser válido");
        }
        if (!checkPhone(telefono)) {
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }

        this.apellido = apellido;
        this.concurso = concurso;
        this.dni = dni;
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    private boolean checkPhone(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getEmail() {
        return this.email;
    }
    
    public int getConcursoId() {
        return this.concurso.obtenerId();
    }
}
