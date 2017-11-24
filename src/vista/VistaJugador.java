package vista;
import modelo.Jugador;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaJugador extends ImageView{
	GridPane grid;
    private Jugador jugador;
    Image imagen;
    Image figuraJugador;
    String rutaFiguraJugador;
    String rutaFicha;
    
    
    public VistaJugador(Jugador jugador, GridPane grid,String ruta,String rutaFicha) {
        this.jugador = jugador;
    	this.grid = grid;
    	this.rutaFiguraJugador=ruta;
    	this.rutaFicha=rutaFicha;
    	
    }
    
    public void dibujarInicial(){
    	
    	this.figuraJugador = new Image(this.rutaFiguraJugador);
    	this.imagen = new Image(this.rutaFicha);
    
    }

}
