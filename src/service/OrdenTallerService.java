package service;

import enums.EstadoOrden;
import model.OrdenTaller;

public interface OrdenTallerService {

    OrdenTaller registrarOrden(OrdenTaller orden);
    OrdenTaller cambiarEstado(Long ordenId, EstadoOrden nuevoEstado);
    OrdenTaller agregarPiezaAOrden(Long ordenId, String referenciaPieza, int cantidad);
}
