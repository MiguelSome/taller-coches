package repository;

import java.util.ArrayList;
import java.util.List;
import model.Vehiculo;

public class VehiculoRepositoryMemoria implements VehiculoRepository{
private List<Vehiculo> vehiculos = new ArrayList<>();
private Long secuenciasId = 1L;

    @Override
    public Vehiculo guardar(Vehiculo vehiculo) {
        if (vehiculo.getId()== null){
            vehiculo.setId(secuenciasId);
            secuenciasId++;
        }
        vehiculos.add(vehiculo);
        return vehiculo;
    }
    @Override
    public Vehiculo buscarPorId(Long id) {
        for (Vehiculo vehiculo: vehiculos){
            if (vehiculo.getId().equals(id)){
                return vehiculo;
            }
        }
        return null;
    }

    @Override
    public Vehiculo buscarPorMatricula(String matricula) {
        for (Vehiculo vehiculo: vehiculos){
            if (vehiculo.getMatricula().equals(matricula)){
                return vehiculo;
            }
        }
        return null;
    }

    @Override
    public List<Vehiculo> buscarTodos() {
        return vehiculos;
    }


    @Override
    public void eliminar(Long id) {
        for(Vehiculo vehiculo: vehiculos){
            if (vehiculo.getId().equals(id)){
                vehiculos.remove(vehiculo);
                return;
            }
        }    
    }
    
}
