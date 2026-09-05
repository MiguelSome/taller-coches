package repository;
import model.Vehiculo;
import java.util.List;

public interface VehiculoRepository {

    Vehiculo guardar(Vehiculo vehiculo);
    Vehiculo buscarPorId(Long id);
    Vehiculo buscarPorMatricula(String matricula);
    List<Vehiculo> buscarTodos();
    void eliminar(Long id);

}
