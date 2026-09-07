package repository;
import model.OrdenTaller;
import java.util.List;

import java.util.ArrayList;


public class OrdenTallerRepositoryMemoria implements OrdenTallerRepository {
    
    private List<OrdenTaller>ordenes = new ArrayList<>();
    private Long secuenciasId = 1L;


    @Override 
    public OrdenTaller guardar(OrdenTaller orden){
        if(orden.getId()== null){
            orden.setId(secuenciasId);
            secuenciasId++;
        }
        ordenes.add(orden);
        return orden;
    }
    @Override 
    public OrdenTaller buscarPorId(Long id){
        for(OrdenTaller orden: ordenes){
            if(orden.getId().equals(id)){
                return orden;
            }
        }
        return null;
    }

    @Override 
    public List<OrdenTaller>buscarPorClienteId(Long idCliente){
        List<OrdenTaller> resultado = new ArrayList<>();
        for(OrdenTaller orden: ordenes){
            if(orden.getCliente().getId().equals(idCliente)){
                resultado.add(orden);
            }
        }
        return resultado;
    }

    @Override
    public List<OrdenTaller>buscarTodas(){
        return ordenes;
    }

    @Override
    public void eliminar(Long id){
        ordenes.removeIf(orden -> orden.getId().equals(id));
    }
}
