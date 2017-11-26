package eventos;

import modelo.AlgoPoly;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent> {

	public BotonTirarDadosHandler(AlgoPoly algoPoly) {
	        algoPoly.getDados().tirar();
	    }
	
	 @Override
	    public void handle(ActionEvent actionEvent) {
	       // comportamiento al tirar dados
	    }
	
	
}
