package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Cliente;
import model.OrdenTaller;
import model.Vehiculo;
import repository.OrdenTallerRepository;
import repository.OrdenTallerRepositoryMemoria;
import repository.PiezaRepositoryMemoria;
import service.OrdenTallerService;
import service.OrdenTallerServiceImpl;

public class AppTaller extends Application {

    private TableView<OrdenTaller> tablaOrdenes;
    private OrdenTallerService servicio;

    private void cargarDatosEjemplo() {
    javafx.collections.ObservableList<OrdenTaller> lista = javafx.collections.FXCollections.observableArrayList();
    
    // 1. Crear objetos auxiliares de prueba
    Cliente cliente1 = new Cliente();
    cliente1.setNombre("Juan Pérez"); // Ajusta al método setter real de tu clase Cliente

    Vehiculo vehiculo1 = new Vehiculo();
    vehiculo1.setMatricula("1234-BBB"); // Ajusta al método setter real de tu clase Vehiculo

    // 2. Crear una orden con tu constructor existente: OrdenTaller(Long, Vehiculo, Cliente, EstadoOrden)
    OrdenTaller orden1 = new OrdenTaller(1L, vehiculo1, cliente1, enums.EstadoOrden.PENDIENTE);
    OrdenTaller ordenGuardada = this.servicio.registrarOrden(orden1);
    
    // 3. Añadir a la lista
    lista.add(ordenGuardada);
    
    // 4. Asignar la lista a la TableView
    tablaOrdenes.setItems(lista);
}

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("🛠️ Taller Mecánico - Gestión de Órdenes");

        OrdenTallerRepository repository = new OrdenTallerRepositoryMemoria(); // O la implementación que estés usando
        PiezaRepositoryMemoria piezaRepository = new PiezaRepositoryMemoria();
        this.servicio = new OrdenTallerServiceImpl(repository, piezaRepository);
        

        // 1. Panel Principal
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15));

        // 2. Encabezado (Arriba)
        Label titulo = new Label("📋 Registro de Órdenes de Trabajo");
        titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        BorderPane.setAlignment(titulo, Pos.CENTER);
        root.setTop(titulo);

        // 3. Tabla de Órdenes (Centro)
        tablaOrdenes = new TableView<>();
        
        TableColumn<OrdenTaller, String> colId = new TableColumn<>("ID");
        TableColumn<OrdenTaller, String> colCliente = new TableColumn<>("Cliente");
        TableColumn<OrdenTaller, String> colVehiculo = new TableColumn<>("Vehículo");
        TableColumn<OrdenTaller, String> colEstado = new TableColumn<>("Estado");

        tablaOrdenes.getColumns().addAll(colId, colCliente, colVehiculo, colEstado);
        root.setCenter(tablaOrdenes);
        // Muestra el ID
    colId.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("id"));

// Extrae directamente el nombre del cliente (asumiendo que Cliente tiene getNombre())
    colCliente.setCellValueFactory(cellData -> 
    new javafx.beans.property.SimpleStringProperty(
        cellData.getValue().getCliente() != null ? cellData.getValue().getCliente().getNombre() : "Sin cliente"
    )
);

// Extrae la matrícula del vehículo (asumiendo que Vehiculo tiene getMatricula())
    colVehiculo.setCellValueFactory(cellData -> 
    new javafx.beans.property.SimpleStringProperty(
        cellData.getValue().getVehiculo() != null ? cellData.getValue().getVehiculo().getMatricula() : "Sin vehículo"
    )
);

// Muestra el estado del enum
    colEstado.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("estado"));

        // 4. Botones de Acción (Abajo)
        HBox panelBotones = new HBox(10);
        panelBotones.setPadding(new Insets(10, 0, 0, 0));
        panelBotones.setAlignment(Pos.CENTER);

        Button btnActualizar = new Button("🔄 Cargar Órdenes");
        Button btnCambiarEstado = new Button("⚡ Cambiar Estado");

btnCambiarEstado.setOnAction(event -> {
    // 1. Obtener la orden seleccionada por el usuario en la TableView
    OrdenTaller ordenSeleccionada = tablaOrdenes.getSelectionModel().getSelectedItem();

    if (ordenSeleccionada != null) {
        // 2. Por ahora, cambiamos el estado directamente para probar el refresco visual
        servicio.cambiarEstado(ordenSeleccionada.getId(), enums.EstadoOrden.COMPLETADA);
        
        // 3. Refrescamos la tabla para mostrar el cambio
        tablaOrdenes.refresh();
        System.out.println("✅ Estado de la orden " + ordenSeleccionada.getId() + " cambiado a EN_PROCESO");
    } else {
        System.out.println("⚠️ Por favor, selecciona una orden de la tabla primero.");
    }
});

        panelBotones.getChildren().addAll(btnActualizar, btnCambiarEstado);
        root.setBottom(panelBotones);

        // 5. Escena y Mostrar
        Scene scene = new Scene(root, 700, 450);
        primaryStage.setScene(scene);
        cargarDatosEjemplo();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}