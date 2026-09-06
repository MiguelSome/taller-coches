package service;

import model.Pieza;
import java.util.List;

public interface PiezaService {
    Pieza registrarPieza(Pieza pieza);
    Pieza obtenerPorReferencia(String referencia);
    List<Pieza> obtenerTodas();
    void actualizarStock(String referencia, int cantidad);
}
