import model.Cliente;
import model.Vehiculo;
import repository.ClienteRepositoryMemoria;
import repository.VehiculoRepositoryMemoria;
import service.ClienteService;
import service.ClienteServiceImpl;

import enums.*;


public class Main {
    public static void main(String[] args){
    Vehiculo seat = new Vehiculo("1234-bbb", "Seat", "Ibiza", TipoCombustible.GASOLINA);
   
    Cliente miguel = new Cliente("Miguel", "Granados", "50616897-F", "667566766", "miguelcorreo@gmail.com");

    miguel.agregarVehiculo(seat);

    System.out.println("Cliente: "+ miguel.getNombre()+ " "+ miguel.getApellidos());
    System.out.println("Vehículos asociados: "+ miguel.getVehiculos().size());

    Cliente manuel = new Cliente("Manuel", "Mola", "34759434-L", "677444988", "manuelcorreo@gmail.com");
    Cliente jaime = new Cliente("Jaime", "Molola", "32359434-L", "677454988", "jaimecorreo@gmail.com");

    ClienteRepositoryMemoria repositorio = new ClienteRepositoryMemoria();
    VehiculoRepositoryMemoria vehiculoRepo = new VehiculoRepositoryMemoria();
    ClienteService clienteService = new ClienteServiceImpl(repositorio, vehiculoRepo);
    repositorio.guardar(manuel);
    repositorio.guardar(jaime);
    repositorio.guardar(miguel);

    Cliente clienteEncontrado = clienteService.obtenerDni("50616897-F");

    System.out.println("Cliente: " + clienteEncontrado.getNombre());
    System.out.println("Vehiculos asociados: " + clienteEncontrado.getVehiculos().size());

    System.out.println("Se ha encontrado al cliente: " + clienteEncontrado.getNombre() );

    repositorio.eliminar(1L);

    System.out.println("Clientes en total: " + repositorio.buscarTodos().size());

    

    Cliente clienteNuevo = new Cliente("Carlos", "Sáez", "11223344-A",
     "600111222", "carlos@email.com");

    clienteService.registrarCliente(clienteNuevo);

    Vehiculo vehiculoNuevo = new Vehiculo("9988-XYZ", "Toyota", "Corolla", TipoCombustible.HIBRIDO);
    clienteService.asociarVehiculoACliente("11223344-A", vehiculoNuevo);

    System.out.println("Hemos encontrado a " +  clienteService.obtenerDni("11223344-A").getNombre()+", "+ 
    "Vehiculos asociados: " + clienteService.obtenerDni("11223344-A").getVehiculos().size());
    }

}

