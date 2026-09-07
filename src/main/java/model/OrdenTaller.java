package model;
import java.util.ArrayList;
import java.util.List;
import enums.EstadoOrden;

public class OrdenTaller {


    private Long id;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private Empleado empleado;
    private List<Pieza>piezas = new ArrayList<>();
    private String descripcion;
    private EstadoOrden estado;
    

    public OrdenTaller(){}

    

    public OrdenTaller(Long id, Vehiculo vehiculo, Cliente cliente, EstadoOrden estado) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.estado = estado;
    }



    public OrdenTaller(Vehiculo vehiculo, Cliente cliente, Empleado empleado, String descripcion){
    this.vehiculo = vehiculo;
    this.cliente = cliente;
    this.empleado = empleado;
    this.descripcion = descripcion;
    this.estado = EstadoOrden.PENDIENTE;
    }



    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Pieza> getPiezas() {
        return piezas;
    }

    public void setPiezas(List<Pieza> piezas) {
        this.piezas = piezas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public void agregarPieza(Pieza pieza){
        piezas.add(pieza);
    }

}
