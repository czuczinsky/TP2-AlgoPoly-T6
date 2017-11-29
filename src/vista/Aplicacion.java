package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.AlgoPoly;


public class Aplicacion extends Application  {

	public static void main(String[] args) {
        launch(args);
	}

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("AlgoPoly");

        AlgoPoly algoPoly = new AlgoPoly();  // Crea el modelo

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(algoPoly, stage);
        Scene escenaJuego = new Scene(contenedorPrincipal, 1160, 670);
        stage.setScene(escenaJuego);

        stage.show();

    }

}
