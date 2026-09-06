package repository;

import java.util.List;
import model.OrdenTaller;

public interface OrdenTallerRepository {
    OrdenTaller guardar(OrdenTaller orden);
    OrdenTaller buscarPorId(Long id);
    List<OrdenTaller> buscarPorClienteId(Long clienteId); 
    List<OrdenTaller> buscarTodas();
    void eliminar(Long id);
}