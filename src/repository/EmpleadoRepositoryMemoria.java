package repository;

import java.util.ArrayList;
import model.Empleado;
import java.util.List;

public class EmpleadoRepositoryMemoria implements EmpleadoRepository {

    List<Empleado> empleados = new ArrayList<>();
    Long secuenciasId = 1L;

    @Override
    public Empleado guardar(Empleado empleado) {
        if(empleado.getId() == null){
            empleado.setId(secuenciasId);
            secuenciasId++;
        }
        empleados.add(empleado);
        return empleado;
    }
    @Override
    public Empleado buscarPorId(Long id) {
        for(Empleado empleado: empleados){
            if(empleado.getId().equals(id)){
                return empleado;
            }
        }
        return null;
    }

    @Override
    public Empleado buscarPorDni(String dni) {
       for(Empleado empleado: empleados){
        if(empleado.getDni().equals(dni)){
            return empleado;
        }
       }
        return null;
    }

    @Override
    public List<Empleado> buscarTodos() {
        return empleados;
    }

    @Override
    public void eliminar(Long id) {
       for(Empleado empleado: empleados){
        if(empleado.getId().equals(id)){
            empleados.remove(empleado);
            return;
        }
       }
    }
}