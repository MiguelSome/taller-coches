package service;
import model.Pieza;
import repository.PiezaRepository;
import java.util.List;


public class PiezaServiceImpl implements PiezaService {
    
    public final PiezaRepository piezaRepository;

    public PiezaServiceImpl(PiezaRepository piezaRepository){
        this.piezaRepository = piezaRepository;
    }
    
    @Override 
    public Pieza registrarPieza(Pieza pieza){
        return piezaRepository.guardar(pieza);
    }

    @Override 
    public Pieza obtenerPorReferencia(String referencia){
        return piezaRepository.buscarPorReferencia(referencia);
    }

    @Override 
    public List<Pieza>obtenerTodas(){
        return piezaRepository.buscarTodos();
    }

    @Override 
    public void actualizarStock(String referencia, int cantidad){
        Pieza pieza = piezaRepository.buscarPorReferencia(referencia);
        if(pieza != null){
            pieza.setStock(pieza.getStock()+ cantidad);
            piezaRepository.guardar(pieza);
        }
    }

}
