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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Jugador;

public class ContenedorPrincipal extends BorderPane {

	BarraDeMenu menuBar;
	VistaTablero vistaTablero;
	Canvas canvas;
	StackPane paneCentral;

	public VistaAvance vistaAvance; // van aca estas vistas o solo dentro de vistaTablero?
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
	// GridPane datosYBotones;
	VBox datosYBotones;
	Stage stage;

	public ContenedorPrincipal(AlgoPoly algoPoly, Stage stage) {

		// TODO sacar es para probar el color de borde en funcion del jugador actual. Es
		// random depende de valor dados
		for (int i = 0; i < 5000; i++) {
			algoPoly.getDados().tirar();
			algoPoly.getTurno().siguienteJugador(algoPoly.getDados());
		}
		/////////////////////////////////////////////

		this.setCentro(algoPoly);
		this.setConsola();
		this.setPanelInformativo(algoPoly);
	}

	private void setCentro(AlgoPoly algoPoly) {
		paneCentral = new StackPane();
		vistaTablero = new VistaTablero(algoPoly, paneCentral);
		vistaTablero.dibujar();

		paneCentral.setAlignment(Pos.TOP_LEFT);
		this.setBorder(algoPoly, paneCentral);
		this.setCenter(paneCentral);
	}

	private void setBorder(AlgoPoly algoPoly, Pane pane) {
		String color = "BLACK";
		Jugador jugadorActual = algoPoly.getTurno().getJugadorActual();

		if (jugadorActual.getNombre().equals("Rojo"))
			color = "RED";
		if (jugadorActual.getNombre().equals("Verde"))
			color = "GREEN";
		if (jugadorActual.getNombre().equals("Azul"))
			color = "BLUE";
		pane.setStyle("-fx-padding: 2;" + "-fx-border-style: solid inside;" + "-fx-border-width: 7;"
				+ "-fx-border-insets: 2;" + "-fx-border-radius: 10;" + "-fx-border-color: " + color + ";");
	}

	private void setPanelInformativo(AlgoPoly algoPoly) {
		// Para poner la info de cada jugador
		/*
		 * this.datosYBotones = new GridPane(); this.datosYBotones.setVgap(5);
		 * this.datosYBotones.setHgap(5); this.dineroDisponible = new Label("");
		 * 
		 * Button tirarDados = new Button(); tirarDados.setText("Tirar Dados");
		 * BotonTirarDadosHandler tirarDadosHandler = new
		 * BotonTirarDadosHandler(algoPoly); tirarDados.setOnAction(tirarDadosHandler);
		 * 
		 * Button b2 = new Button(); b2.setText("2");
		 * 
		 * this.datosYBotones.add(tirarDados,1,8); this.datosYBotones.add(b2,10,10);
		 * //datosYBotones.setAlignment(Pos.BOTTOM_CENTER);
		 * 
		 * Text jugador1 = new Text("JUGADOR ROJO:");
		 * jugador1.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		 * datosYBotones.add(jugador1, 0,1); Text jugador2 = new Text("JUGADOR VERDE:");
		 * jugador2.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		 * datosYBotones.add(jugador2, 1,2); Text jugador3 = new Text("JUGADOR AZUL:");
		 * jugador3.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		 * datosYBotones.add(jugador3, 2,3);
		 */
		this.datosYBotones = new VBox();
		// datosYBotones.setPadding(new Insets(60));
		datosYBotones.setSpacing(80);

		this.setBorder(algoPoly, datosYBotones);

		Text jugador1 = new Text("JUGADOR ROJO:");
		jugador1.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		Text jugador2 = new Text("JUGADOR VERDE:");
		jugador2.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		Text jugador3 = new Text("JUGADOR AZUL:");
		jugador3.setFont(Font.font("Arial", FontWeight.BOLD, 15));

		VBox.setMargin(jugador1, new Insets(20));
		VBox.setMargin(jugador2, new Insets(20));
		VBox.setMargin(jugador3, new Insets(20));
		datosYBotones.getChildren().addAll(jugador1, jugador2, jugador3);

		Button tirarDados = new Button();
		tirarDados.setText("Tirar Dados");
		BotonTirarDadosHandler tirarDadosHandler = new BotonTirarDadosHandler(algoPoly);
		tirarDados.setOnAction(tirarDadosHandler);

		VBox.setMargin(tirarDados, new Insets(20));
		this.datosYBotones.getChildren().add(tirarDados);

		this.datosYBotones.setAlignment(Pos.CENTER);

		this.setRight(datosYBotones);

	}

	public void colocarJugadores() {
		// los jugadores se deberian pedir al modelo
		// algo asi
		// algoPoly.getJugadores()

		// y recorrer el arrayList de jugadores con un for
		// (si se eliminan jugadores van a ser menos de 3)

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

	public void terminarJuego(String ganador) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("ALGOPOLY");
		alert.setHeaderText("TERMINA EL JUEGO");
		alert.setContentText("El ganador es " + ganador);
		alert.show();
		OpcionSalirEventHandler reiniciar = new OpcionSalirEventHandler();
		reiniciar.handle(null);
	}
}
