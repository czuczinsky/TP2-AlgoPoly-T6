package vista;

import eventos.BotonMoverHandler;
import eventos.BotonPasarTurnoHandler;
import eventos.BotonPerderHandler;
import eventos.BotonTirarDadosHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.AlgoPoly;
import modelo.Jugador;

public class ContenedorPrincipal extends BorderPane {

	private AlgoPoly algoPoly;
	VistaTablero vistaTablero;
	Canvas canvas;
	GridPane paneIzquierdo;
	Label dineroDisponible;
	VBox datosYBotones;
	Stage stage;
	Label turno;

	public ContenedorPrincipal(AlgoPoly algoPoly, Stage stage) {

		this.algoPoly = algoPoly;

		this.setIzquierda();
		this.setPanelInformativo();
	}

	private void setIzquierda() {
		paneIzquierdo = new GridPane();
		vistaTablero = new VistaTablero(algoPoly, this, paneIzquierdo);
		vistaTablero.dibujar();

		paneIzquierdo.setAlignment(Pos.CENTER);
		this.setBorder(algoPoly, paneIzquierdo);
		this.setLeft(paneIzquierdo);
	}

	private void setPanelInformativo() {

		this.datosYBotones = new VBox();
		datosYBotones.setSpacing(20);

		Image fondo = new Image("file:src/vista/imagenes/fondo.png");
		BackgroundImage imagenDeFondo = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(1, 1, true, true, false, false));
		this.setBackground(new Background(imagenDeFondo));
		this.setBorder(algoPoly, datosYBotones);

		Text titulo = new Text("TURNO:");
		titulo.setFill(Color.BLACK);
		titulo.setFont(Font.font("Arial", FontWeight.BOLD, 30));
		this.datosYBotones.getChildren().add(titulo);
		VBox.setMargin(titulo, new Insets(10));

		this.mostrarJugadorActual(algoPoly.getJugadorActual().getNombre());

		for (Jugador jugador : algoPoly.getJugadores()) {
			Text txtJugador = new Text("Disponible : $ " + String.valueOf(jugador.getDinero()));
			txtJugador.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			setearColor(txtJugador, jugador);
			datosYBotones.getChildren().add(txtJugador);
			VBox.setMargin(txtJugador, new Insets(15));
		}

		this.mostrarDados(algoPoly.getDados().getDado1());
		this.mostrarDados(algoPoly.getDados().getDado2());

		if (this.algoPoly.hayGanador()) {
			mostrarAlert("Gano jugador: " + algoPoly.getJugadores().get(0).getNombre());
	        System.exit(0);  // Sale de la aplicacion
		}
		
		this.ponerBotones();

		this.datosYBotones.setAlignment(Pos.CENTER);
		this.setCenter(datosYBotones);
	}

	private void mostrarAlert(String mensaje) {
		Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
		dialogoAlerta.setTitle("");
		dialogoAlerta.setHeaderText(null);
		dialogoAlerta.setContentText(mensaje);
		dialogoAlerta.initStyle(StageStyle.UTILITY);
		dialogoAlerta.showAndWait();
	}
	
	private void ponerBotones() {
		
		if (algoPoly.debeVenderPropiedades()) {
			this.mostrarAlert("Debe vender Propiedades.");
		}
		
		if (algoPoly.puedeTirarDados()) {
			Button btnTirarDados = new Button();
			btnTirarDados.setText("Tirar Dados");
			BotonTirarDadosHandler tirarDadosHandler = new BotonTirarDadosHandler(this.algoPoly, this);
			btnTirarDados.setOnAction(tirarDadosHandler);
			VBox.setMargin(btnTirarDados, new Insets(15));
			this.datosYBotones.getChildren().add(btnTirarDados);
		}

		if (algoPoly.puedeMover()) {
			Button btnMover = new Button();
			btnMover.setText("Mover Ficha");
			BotonMoverHandler moverHandler = new BotonMoverHandler(this.algoPoly, this);
			btnMover.setOnAction(moverHandler);
			VBox.setMargin(btnMover, new Insets(15));
			this.datosYBotones.getChildren().add(btnMover);
		}

		if (algoPoly.debePasarTurno()) {
			Button btnPasar = new Button();
			btnPasar.setText("Pasar Turno");
			this.mostrarAlert("Pierde turno por estar preso");
			BotonPasarTurnoHandler pasarHandler = new BotonPasarTurnoHandler(this.algoPoly, this);
			btnPasar.setOnAction(pasarHandler);
			VBox.setMargin(btnPasar, new Insets(15));
			this.datosYBotones.getChildren().add(btnPasar);
		}
		
		if (algoPoly.vaAPerder()) {
			Button btnPerder = new Button();
			btnPerder.setText("Perder");
			BotonPerderHandler perderHandler = new BotonPerderHandler(this.algoPoly, this);
			btnPerder.setOnAction(perderHandler);
			VBox.setMargin(btnPerder, new Insets(15));
			this.datosYBotones.getChildren().add(btnPerder);
		}
	}
	
	private void mostrarJugadorActual(String nombre) {
		Image image = new Image("file:src/vista/imagenes/ficharoja.png");
		if (nombre == "Verde")
			image = new Image("file:src/vista/imagenes/fichaverde.png");
		if (nombre == "Azul")
			image = new Image("file:src/vista/imagenes/fichaazul.png");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		imageView.setFitWidth(50);
		imageView.setFitHeight(50);
		imageView.setPreserveRatio(true);
		imageView.setSmooth(true);
		datosYBotones.getChildren().add(imageView);
	}

	private void mostrarDados(double valor) {
		Image image = new Image("file:src/vista/imagenes/dado1.png");
		if (valor == 2)
			image = new Image("file:src/vista/imagenes/dado2.png");
		if (valor == 3)
			image = new Image("file:src/vista/imagenes/dado3.png");
		if (valor == 4)
			image = new Image("file:src/vista/imagenes/dado4.png");
		if (valor == 5)
			image = new Image("file:src/vista/imagenes/dado5.png");
		if (valor == 6)
			image = new Image("file:src/vista/imagenes/dado6.png");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		imageView.setFitWidth(50);
		imageView.setFitHeight(50);
		imageView.setPreserveRatio(true);
		imageView.setSmooth(true);
		datosYBotones.getChildren().add(imageView);
	}

	private void setearColor(Text txt, Jugador jugador) {
		if (jugador.getNombre().equals("Rojo"))
			txt.setFill(Color.RED);
		if (jugador.getNombre().equals("Verde"))
			txt.setFill(Color.GREEN);
		if (jugador.getNombre().equals("Azul"))
			txt.setFill(Color.BLUE);
	}

	private void setBorder(AlgoPoly algoPoly, Pane pane) {
		String color = "BLACK";
		Jugador jugadorActual = algoPoly.getJugadorActual();
		if (jugadorActual.getNombre().equals("Rojo"))
			color = "RED";
		if (jugadorActual.getNombre().equals("Verde"))
			color = "GREEN";
		if (jugadorActual.getNombre().equals("Azul"))
			color = "BLUE";
		pane.setStyle("-fx-padding: 2;" + "-fx-border-style: solid inside;" + "-fx-border-width: 7;"
				+ "-fx-border-insets: 2;" + "-fx-border-radius: 10;" + "-fx-border-color: " + color + ";");
	}

	public void refrescar() {
		this.setIzquierda();
		this.setPanelInformativo();
	}
}
