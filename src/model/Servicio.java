package model;

import java.math.BigDecimal;


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
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public BigDecimal getHorasEstimadas() {
        return horasEstimadas;
    }
    public void setHorasEstimadas(BigDecimal horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }   
        
}
