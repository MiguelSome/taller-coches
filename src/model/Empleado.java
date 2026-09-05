package model;

import enums.RolEmpleado;

public class Empleado {
    private Long id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String telefono;
    private RolEmpleado rol;
    private boolean activo;
public Empleado(){}




    public Empleado(String nombre, String apellidos, String dni, String telefono, RolEmpleado rol) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.dni = dni;
    this.telefono = telefono;
    this.rol = rol;
    this.activo = true;
}




    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public RolEmpleado getRol() {
        return rol;
    }
    public void setRol(RolEmpleado rol) {
        this.rol = rol;
    }
    public Boolean getActivo() {
        return activo;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}

