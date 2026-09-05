package repository;
import model.Empleado;
import java.util.List;


public interface EmpleadoRepository {
    Empleado guardar(Empleado empleado);
    Empleado buscarPorId(Long id);
    Empleado buscarPorDni(String dni);
    List<Empleado>buscarTodos();
    void eliminar(Long id);
}
