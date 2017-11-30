package vista;

import java.lang.reflect.Method;

import javafx.scene.layout.GridPane;
import modelo.AlgoPoly;
import modelo.Casillero;

public class VistaCasillero {
	private Dibujable dibujable;

	public VistaCasillero(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, Casillero casillero,
			GridPane pane, int x, int y, double ancho, double alto) {

		@SuppressWarnings("rawtypes")
		Class[] param = new Class[8];
		param[0] = AlgoPoly.class;
		param[1] = ContenedorPrincipal.class;
		param[2] = Casillero.class;
		param[3] = GridPane.class;
		param[4] = int.class;
		param[5] = int.class;
		param[6] = double.class;
		param[7] = double.class;

		String nombreClase = "vista.Vista" + casillero.getClass().getSimpleName();

		try {
			Class<?> clase = Class.forName(nombreClase);
			Method metodo = clase.getDeclaredMethod("Instancia", param);
			dibujable = (Dibujable) metodo.invoke(null, algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho,
					alto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dibujar() {
		dibujable.dibujar();
	}
}
