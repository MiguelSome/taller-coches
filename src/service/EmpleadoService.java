package service;
import model.Empleado;
import java.util.List;

public interface EmpleadoService {
    Empleado registrarEmpleado(Empleado empleado);
    Empleado obtenerPorDni(String dni);
    List<Empleado> obtenerTodos();
    void darDeBaja(Long id);

}

