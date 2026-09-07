package service;

import model.Cliente;
import model.Vehiculo;
import java.util.List;


public interface ClienteService {
    Cliente registrarCliente(Cliente cliente);
    Cliente obtenerDni(String dni);
    List<Cliente> obtenerTodos();
    void asociarVehiculoACliente(String dniCliente, Vehiculo vehiculo);
    
}
