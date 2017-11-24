package vista;

import eventos.BotonTirarDadosHandler;
import eventos.OpcionSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.AlgoPoly;
//import vista.eventos.BotonDireccionHandler;
//import vista.eventos.BotonMoverHandler;

public class ContenedorPrincipal extends BorderPane {

	BarraDeMenu menuBar;
	VistaTablero vistaTablero;
	Canvas canvasCentral;
	VBox contenedorCentral;
	
	public VistaAvance vistaAvance;
	public VistaCarcel vistaCarcel;
	public VistaCasillero vistaCasillero;
	public VistaCompania vistaCompania;
	public VistaImpuestoAlLujo vistaImpuestoAlLujo;
	public VistaJugador jugador1;
	public VistaJugador jugador2;
	public VistaJugador jugador3;
	public VistaPolicia vistaPolicia;
	public VistaQuini6 vistaQuini6;
	public VistaRetroceso vistaRetroceso;
	public VistaSalida vistaSalida;
	public VistaTerreno vistaTerreno;
	
	Label dineroDisponible;
	GridPane datosYBotones;
	Stage stage;
	

	public ContenedorPrincipal(Stage stage) {
		this.setMenu(stage);
		this.setCentro();
		this.setConsola();
		// this.setBotonera(robot);
		//this.setPanelInformativo(null);
	}

	// TODO armar botonera (Si va)
	// private void setBotonera() {
	//
	Button botonMover = new Button();
	// botonMover.setText("Mover");
	// BotonMoverHandler moveButtonHandler = new BotonMoverHandler(vistaRobot,
	// robot);
	// botonMover.setOnAction(moveButtonHandler);
	//
	// Button botonDireccion = new Button();
	// botonDireccion.setText("Cambiar direccion");
	// BotonDireccionHandler directionButtonHandler = new
	// BotonDireccionHandler(robot);
	// botonDireccion.setOnAction(directionButtonHandler);
	//
	VBox contenedorVertical = new VBox(botonMover);
	// contenedorVertical.setSpacing(10);
	// contenedorVertical.setPadding(new Insets(15));
	//
	// this.setLeft(contenedorVertical);
	//
	// }

	private void setMenu(Stage stage) {
		this.menuBar = new BarraDeMenu(stage);
		this.setTop(menuBar);
	}

	private void setCentro() {

		canvasCentral = new Canvas(850, 600);

		// TODO mover
		AlgoPoly algoPoly = new AlgoPoly();
		vistaTablero = new VistaTablero(algoPoly.getTablero(), canvasCentral);
		vistaTablero.dibujar();

		contenedorCentral = new VBox(canvasCentral);
		contenedorCentral.setAlignment(Pos.CENTER_LEFT);
		contenedorCentral.setSpacing(600);
		contenedorCentral.setPadding(new Insets(40));
//		Image imagen = new Image("file:src/vista/imagenes/Monopoly_pack_logo.png");
//		BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
//		BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
//		BackgroundSize.DEFAULT);
//		contenedorCentral.setBackground(new Background(imagenDeFondo));

		this.setCenter(contenedorCentral);
	}
	
	private void setPanelInformativo(AlgoPoly algoPoly) {
		// Para poner la info de cada jugador
		this.datosYBotones = new GridPane();
        this.datosYBotones.setVgap(55);
        this.datosYBotones.setHgap(49);
        this.dineroDisponible = new Label("");
        
        Button tirarDados = new Button();
        tirarDados.setText("Tirar Dados");
        BotonTirarDadosHandler tirarDadosHandler = new BotonTirarDadosHandler(algoPoly);
        tirarDados.setOnAction(tirarDadosHandler);
        
        this.datosYBotones.add(tirarDados,1,11);
        this.setRight(datosYBotones);
		
	}

	public void colocarJugadores() {
		jugador1.dibujarInicial();
		jugador2.dibujarInicial();
		jugador3.dibujarInicial();
		
	}
	

	private void setConsola() {

		// TODO cambiar por el modelo de Consola... Va la consola???
		Label etiqueta = new Label();
		etiqueta.setText("Consola...");
		etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
		etiqueta.setTextFill(Color.WHITE);

		VBox contenedorConsola = new VBox(etiqueta);
		contenedorConsola.setSpacing(10);
		contenedorConsola.setPadding(new Insets(15));
		contenedorConsola.setStyle("-fx-background-color: black;");

		this.setBottom(contenedorConsola);
	}
	
	public void terminarJuego(String ganador){
    	Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("ALGOPOLY");
	    alert.setHeaderText("TERMINA EL JUEGO");
	    alert.setContentText("El ganador es " + ganador);
	    alert.show();
	    OpcionSalirEventHandler reiniciar = new OpcionSalirEventHandler();
	    reiniciar.handle(null);
    }

	public BarraDeMenu getBarraDeMenu() {
		return menuBar;
	}

}
