package repository;

import model.Cliente;
import java.util.List;

public interface ClienteRepository {
    Cliente guardar(Cliente cliente);
    Cliente buscarPorId(Long id);
    Cliente buscarPorDni(String dni);
    List<Cliente> buscarTodos();
    void eliminar(Long id);
}
