import model.Cliente;
import model.Vehiculo;
import enums.*;


public class Main {
    public static void main(String[] args){
    Vehiculo seat = new Vehiculo("1234-bbb", "Seat", "Ibiza", TipoCombustible.GASOLINA);
   
    Cliente miguel = new Cliente("Miguel", "Granados", "50616897-F", "667566766", "miguelcorreo@gmail.com");

    miguel.agregarVehiculo(seat);

    System.out.println("Cliente: "+ miguel.getNombre()+ " "+ miguel.getApellidos());
    System.out.println("Vehículos asociados: "+ miguel.getVehiculos().size());

    }

}

