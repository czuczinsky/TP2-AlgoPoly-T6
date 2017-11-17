package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import modelo.Robot;
//import vista.eventos.AplicacionOnKeyPressEventHandler;


public class Aplicacion extends Application  {

	public static void main(String[] args) {
        launch(args);
	}

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("AlgoPoly");

//        Robot robot = crearModelo();

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);

 //       AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
 //       escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);


        // add handler to this:
        // stage.setOnCloseRequest()

        stage.setScene(escenaJuego);
//        stage.setFullScreen(true);

        stage.show();

    }

}
