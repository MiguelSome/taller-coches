package repository;

import java.util.ArrayList;
import java.util.List;

import model.Pieza;

public class PiezaRepositoryMemoria implements PiezaRepository{
    List<Pieza>piezas = new ArrayList<>();
    Long secuenciasId = 1L;
    

    public Pieza guardar(Pieza pieza){
        if(pieza.getId() == null){
        pieza.setId(secuenciasId);
        secuenciasId++;
    }
    piezas.add(pieza);
    return pieza;
    }

    public Pieza buscarPorId(Long id){
        for(Pieza pieza: piezas){
            if(pieza.getId().equals(id)){
                return pieza;
            }
        }
        return null;
    }

    public Pieza buscarPorReferencia(String referencia){
        for(Pieza pieza: piezas){
            if(pieza.getReferencia().equals(referencia)){
                return pieza;
            }
        }
        return null;
    }

    public List<Pieza> buscarTodos(){
        return piezas;
    }

    public void eliminar(Long id){
        for(Pieza pieza: piezas){
            if(pieza.getId().equals(id)){
                    piezas.remove(pieza);
                    return;
            }
        }
        
    }
}
