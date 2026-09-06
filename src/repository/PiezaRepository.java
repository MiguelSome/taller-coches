package repository;
import model.Pieza;
import java.util.List;


public interface PiezaRepository {

    Pieza guardar(Pieza pieza);
    Pieza buscarPorId(Long id);
    Pieza buscarPorReferencia(String referencia);
    List<Pieza>buscarTodos();
    void eliminar(Long id);
   
}
