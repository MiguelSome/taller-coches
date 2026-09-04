package model;
import java.util.ArrayList;
import java.util.List;


public class Cliente {
    private Long id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String telefono;
    private String email;
    private List<Vehiculo> vehiculos;

public Cliente (String nombre, String apellidos, String dni, String telefono,
     String email, List<Vehiculo> vehiculos){
this.nombre = nombre;
this.apellidos = apellidos;
this.dni = dni;
this.telefono = telefono;
this.email = email;
this.vehiculos = new ArrayList<>();
}

public void agregarVehiculo(Vehiculo vehiculo) {
    this.vehiculos.add(vehiculo);
}

public void eliminarVehiculo(Vehiculo vehiculo) {
    this.vehiculos.remove(vehiculo);
}

public Cliente(List<Vehiculo> vehiculos) {
    this.vehiculos = new ArrayList<>();
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

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public List<Vehiculo> getVehiculos() {
    return vehiculos;
}

public void setVehiculos(List<Vehiculo> vehiculos) {
    this.vehiculos = vehiculos;
} 



}
