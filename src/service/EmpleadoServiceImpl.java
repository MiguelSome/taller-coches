package service;

import java.util.List;

import model.Empleado;
import repository.EmpleadoRepository;

public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
     
    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }



    @Override
    public Empleado registrarEmpleado(Empleado empleado) {
       return empleadoRepository.guardar(empleado);
    }
    @Override
    public Empleado obtenerPorDni(String dni) {
    
        return empleadoRepository.buscarPorDni(dni);
    }

    @Override
    public List<Empleado> obtenerTodos() {
        return empleadoRepository.buscarTodos();
    }
    @Override
    public void darDeBaja(Long id) {
        Empleado empleado = empleadoRepository.buscarPorId(id);
        if (empleado != null) {
            empleado.setActivo(false);
            empleadoRepository.guardar(empleado);
        }
    }
    
}
