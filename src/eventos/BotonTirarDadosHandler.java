package eventos;

import modelo.AlgoPoly;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent> {

	private final AlgoPoly juego;

	public BotonTirarDadosHandler(AlgoPoly algoPoly) {
	        this.juego = algoPoly;
	    
	    }
	
	 @Override
	    public void handle(ActionEvent actionEvent) {
	       // comportamiento al tirar dados
	    }
	
	
}
