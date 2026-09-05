package model;

import java.math.BigDecimal;
import java.security.PrivateKey;

public class Servicio {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private BigDecimal horasEstimadas;
    private boolean activo;
    public Servicio() {
    }
    public Servicio(String nombre, String descripcion, BigDecimal precio, BigDecimal horasEstimadas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.horasEstimadas = horasEstimadas;
        this.activo = true;
        
    }

    

}
