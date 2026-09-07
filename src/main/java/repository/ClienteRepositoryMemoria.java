package repository;

import java.util.ArrayList;
import model.Cliente;
import java.util.List;




public class ClienteRepositoryMemoria implements ClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();
    private Long secuenciasId = 1L;


    @Override
    public Cliente guardar(Cliente cliente) {
        if (cliente.getId() == null) {
            cliente.setId(secuenciasId);
            secuenciasId++;
        }
        clientes.add(cliente);
        return cliente;
    }
    @Override
    public Cliente buscarPorDni(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id){
        for (Cliente cliente : clientes){
            if (cliente.getId().equals(id)){
                return cliente;
            }
        }
        return null;
    }
    @Override
    public List<Cliente> buscarTodos(){
        return clientes;
    }

    @Override
    public void eliminar(Long id){
        for (Cliente cliente : clientes){
            if (cliente.getId().equals(id)){
                clientes.remove(cliente);
                return;
            }
        }
    }
}
