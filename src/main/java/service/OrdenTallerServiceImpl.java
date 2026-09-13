package service;

import model.OrdenTaller;
import model.Pieza;
import repository.OrdenTallerRepository;
import repository.PiezaRepository;


import enums.EstadoOrden;

public class OrdenTallerServiceImpl implements OrdenTallerService{

    private final OrdenTallerRepository ordenTallerRepository;
    private PiezaRepository piezaRepository;

    


    public OrdenTallerServiceImpl(OrdenTallerRepository ordenTallerRepository, PiezaRepository piezaRepository) {
        this.ordenTallerRepository = ordenTallerRepository;
        this.piezaRepository = piezaRepository;
    }

    @Override
    public OrdenTaller registrarOrden(OrdenTaller orden) {
        return ordenTallerRepository.guardar(orden);
        
    }

    @Override
    public OrdenTaller cambiarEstado(Long ordenId, EstadoOrden nuevoEstado) {
        OrdenTaller orden = ordenTallerRepository.buscarPorId(ordenId);
        if(orden != null){
            orden.setEstado(nuevoEstado);
            ordenTallerRepository.guardar(orden);
            return orden;
        }else{return null;
        }
    }

    @Override
    public OrdenTaller agregarPiezaAOrden(Long ordenId, String referenciaPieza, int cantidad) {
       OrdenTaller orden = ordenTallerRepository.buscarPorId(ordenId);
       if(orden != null){
    Pieza pieza = piezaRepository.buscarPorReferencia(referenciaPieza);
       if(pieza != null){
        cantidad++;
       }
       }
        return orden;
    }

    
}
