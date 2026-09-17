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
import javafx.scene.layout.VBox;
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

    private VBox crearMenuLateral() {
        VBox menu = new VBox(10);
        menu.setPadding(new Insets(15));
        menu.setStyle("-fx-background-color: #1c2630;");
        menu.setPrefWidth(200);

        Button btnInicio = new Button("📊 INICIO");
        Button btnOrdenes = new Button("📋 ÓRDENES");
        Button btnCliente = new Button("👥 CLIENTES");
        Button btnStock = new Button("📦 STOCK");
        Button btnAgenda = new Button("📅 AGENDA");
        Button btnVehiculos = new Button("🚗 VEHÍCULOS");
        Button btnFacturas = new Button("🧾 FACTURAS");
        Button btnInformes = new Button("📈 INFORMES");
        Button btnConfig = new Button("⚙️ CONFIG ");

        String estiloBoton = "-fx-background-color: transparent; -fx-text-fill: white; -fx-alignment: BASELINE_LEFT; -fx-font-size: 14px;";
        btnInicio.setStyle(estiloBoton);
        btnAgenda.setStyle(estiloBoton);
        btnVehiculos.setStyle(estiloBoton);
        btnCliente.setStyle(estiloBoton);
        btnOrdenes.setStyle(estiloBoton);
        btnStock.setStyle(estiloBoton);
        btnFacturas.setStyle(estiloBoton);
        btnInformes.setStyle(estiloBoton);
        btnConfig.setStyle(estiloBoton);

        menu.getChildren().addAll(btnInicio, btnAgenda, btnVehiculos, btnCliente, btnOrdenes, btnStock, btnFacturas,
                btnInformes, btnConfig);
        return menu;
    }

    private HBox crearBarraSuperior() {
        HBox topBar = new HBox(20);
        topBar.setPadding(new Insets(10, 20, 10, 20));
        topBar.setStyle("\"-fx-background-color: #ffffff; -fx-border-color: #e0e0e0; -fx-border-width: 0 0 1 0;\"");
        topBar.setAlignment(Pos.CENTER_LEFT);

        Label logo = new Label("🔧 TallerMecánico");
        logo.setStyle("fx-font-weight: bold; -fx-font-size: 16px;");

        javafx.scene.control.TextField txtBuscar = new javafx.scene.control.TextField();
        txtBuscar.setPromptText("🔍 Buscar...");
        txtBuscar.setPrefWidth(200);

        javafx.scene.layout.Region spacer = new javafx.scene.layout.Region();
        HBox.setHgrow(spacer, javafx.scene.layout.Priority.ALWAYS);

        Label notificaciones = new Label("🔔(3)");
        Label usuario = new Label("👤 Miguel Somé ▼");
        usuario.setStyle("-fx-font-weight: bold;");

        topBar.getChildren().addAll(logo, txtBuscar, spacer, notificaciones, usuario);
        return topBar;
    }

    private VBox crearTarjetaMetrica(String icono, String valor, String titulo, String colorBorde) {
        VBox tarjeta = new VBox(5);
        tarjeta.setPadding(new Insets(15));
        tarjeta.setPrefWidth(160);
        tarjeta.setStyle("-fx-background-color: white; \" +\n" + //
                "                     \"-fx-background-radius: 8; \" +\n" + //
                "                     \"-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 5, 0, 0, 2); \" +\n" + //
                "                     \"-fx-border-color: \" + colorBorde + \"; \" +\n" + //
                "                     \"-fx-border-width: 0 0 0 4; \" +\n" + //
                "                     \"-fx-border-radius: 8;");
        Label lblValor = new Label(icono + " " + valor);
        lblValor.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label lblTitulo = new Label(titulo);
        lblTitulo.setStyle("-fx-font-size: 12px; -fx-text-fill: #7f8c8d;");

        tarjeta.getChildren().addAll(lblValor, lblTitulo);
        return tarjeta;
    }

    private HBox crearPanelMetricas() {
        HBox panel = new HBox(15);
        panel.setPadding(new Insets(0, 0, 15, 0));

        VBox cardVehiculos = crearTarjetaMetrica("🚘", "12", "Vehiculos en taller", "#3498db");
        VBox cardOrdenes = crearTarjetaMetrica("📋", "8", "Órdenes abiertas", "#e67e22");
        VBox cardPendientes = crearTarjetaMetrica("⏳", "5", "Pendientes de cita", "#f1c40f");
        VBox cardIngresos = crearTarjetaMetrica("💰", "3.240 €", "Ingresos hoy", "#2ecc71");

        panel.getChildren().addAll(cardVehiculos, cardOrdenes, cardPendientes, cardIngresos);
        return panel;
    }

    private VBox crearPanelProximasCitas() {

        VBox panel = new VBox(10);
        panel.setPadding(new Insets(15));
        panel.setStyle(
                "-fx-background-color: white; -fx-background-radius: 8; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 5, 0, 0, 2);");

        Label titulo = new Label("📅 Próximas Citas");
        titulo.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        Label cita1 = new Label("• 10:30 - Ford Focus (Revisión)");
        Label cita2 = new Label("• 11:15 - BMW Serie 3 (Frenos)");
        Label cita3 = new Label("• 12:00 - Audi A4 (Cambio aceite)");

        panel.getChildren().addAll(titulo, cita1, cita2, cita3);
        return panel;
    }

    private VBox crearPanelAvisos() {

        VBox panel = new VBox(10);
        panel.setPadding(new Insets(15));
        panel.setStyle(
                "-fx-background-color: #fff9e6; -fx-background-radius: 8; -fx-border-color: #ffeaa7; -fx-border-radius: 8;");

        Label titulo = new Label("⚠️ Avisos del Sistema");
        titulo.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #d35400;");

        Label aviso1 = new Label("• Stock bajo: Filtros de aceite (2 restantes)");
        Label aviso2 = new Label("• ITV próxima: 3 vehículos este mes");

        panel.getChildren().addAll(titulo, aviso1, aviso2);
        return panel;
    }

    private VBox crearPanelTablaOrdenes() {
        VBox panel = new VBox(10);
        panel.setPadding(new Insets(15));
        panel.setStyle(
                "-fx-background-color: white; -fx-background-radius: 8; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 5, 0, 0, 2);");

        Label titulo = new Label("📋 Órdenes de Trabajo Recientes");
        titulo.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        // Aseguramos que la tabla ocupe todo el espacio vertical disponible dentro del
        // panel
        VBox.setVgrow(tablaOrdenes, javafx.scene.layout.Priority.ALWAYS);

        panel.getChildren().addAll(titulo, tablaOrdenes);
        return panel;
    }

    private void cargarDatosEjemplo() {
        javafx.collections.ObservableList<OrdenTaller> lista = javafx.collections.FXCollections.observableArrayList();

        // 1. Crear objetos auxiliares de prueba
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Juan Pérez"); // Ajusta al método setter real de tu clase Cliente

        Vehiculo vehiculo1 = new Vehiculo();
        vehiculo1.setMatricula("1234-BBB"); // Ajusta al método setter real de tu clase Vehiculo

        // 2. Crear una orden con tu constructor existente: OrdenTaller(Long, Vehiculo,
        // Cliente, EstadoOrden)
        OrdenTaller orden1 = new OrdenTaller(1L, vehiculo1, cliente1, enums.EstadoOrden.PENDIENTE);
        OrdenTaller ordenGuardada = this.servicio.registrarOrden(orden1);

        // 3. Añadir a la lista
        lista.add(ordenGuardada);

        // 4. Asignar la lista a la TableView
        tablaOrdenes.setItems(lista);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("🛠️ Taller Mecánico ");
        tablaOrdenes = new TableView<>();

        OrdenTallerRepository repository = new OrdenTallerRepositoryMemoria(); // O la implementación que estés usando
        PiezaRepositoryMemoria piezaRepository = new PiezaRepositoryMemoria();
        this.servicio = new OrdenTallerServiceImpl(repository, piezaRepository);

        // 1. Panel Principal
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15));
        root.setLeft(crearMenuLateral());

        // 2. Encabezado (Arriba)

        root.setTop(crearBarraSuperior());

        // 3. Tabla de Órdenes (Centro)

        // 1. Fila Superior: Órdenes (Izquierda) + Citas (Derecha)

        // Hacemos que la tabla ocupe más espacio que las citas (por ejemplo, ratio 2 a
        // 1)

        // 2. Fila Inferior: Avisos del Sistema (Ocupa todo el ancho)
        TableColumn<OrdenTaller, String> colId = new TableColumn<>("ID");
        TableColumn<OrdenTaller, String> colCliente = new TableColumn<>("Cliente");
        TableColumn<OrdenTaller, String> colVehiculo = new TableColumn<>("Vehículo");
        TableColumn<OrdenTaller, String> colEstado = new TableColumn<>("Estado");

        colId.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("id"));
        colCliente.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(
                cellData.getValue().getCliente() != null ? cellData.getValue().getCliente().getNombre()
                        : "Sin cliente"));
        colVehiculo.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(
                cellData.getValue().getVehiculo() != null ? cellData.getValue().getVehiculo().getMatricula()
                        : "Sin vehículo"));
        colEstado.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("estado"));

        tablaOrdenes.getColumns().addAll(colId, colCliente, colVehiculo, colEstado);

        HBox filaVentanasSuperiores = new HBox(15);
        VBox panelTabla = crearPanelTablaOrdenes();
        VBox panelCitas = crearPanelProximasCitas();

        HBox.setHgrow(panelTabla, javafx.scene.layout.Priority.ALWAYS);
        panelCitas.setPrefWidth(300);

        filaVentanasSuperiores.getChildren().addAll(panelTabla, panelCitas);

        VBox panelAvisos = crearPanelAvisos();

        VBox contenedorCentro = new VBox(15);
        contenedorCentro.setPadding(new Insets(15));
        contenedorCentro.getChildren().addAll(
                crearPanelMetricas(),
                filaVentanasSuperiores,
                panelAvisos);

        root.setCenter(contenedorCentro);


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
        Scene scene = new Scene(root, 1050, 680);
        primaryStage.setScene(scene);
        cargarDatosEjemplo();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}