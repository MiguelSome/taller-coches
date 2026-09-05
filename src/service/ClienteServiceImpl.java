package service;

import repository.ClienteRepository;
import repository.VehiculoRepository;

import java.util.List;

import model.Cliente;
import model.Vehiculo;


public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final VehiculoRepository vehiculoRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository, VehiculoRepository vehiculoRepository) {
        this.clienteRepository = clienteRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) {
        return clienteRepository.guardar(cliente);
    }
    @Override
    public Cliente obtenerDni(String dni) {

        return clienteRepository.buscarPorDni(dni);
    }
    @Override
    public List<Cliente> obtenerTodos() {
        return clienteRepository.buscarTodos();
    }
    @Override
    public void asociarVehiculoACliente(String dniCliente, Vehiculo vehiculo) {
        Cliente cliente = clienteRepository.buscarPorDni(dniCliente);
        Vehiculo vehiculoGuardado = vehiculoRepository.guardar(vehiculo);
        cliente.agregarVehiculo(vehiculoGuardado);

    }

    
}