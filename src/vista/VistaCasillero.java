package vista;

import java.lang.reflect.Method;
import javafx.scene.layout.StackPane;
import modelo.AlgoPoly;
import modelo.Casillero;

public class VistaCasillero {
	private Dibujable dibujable;

	public VistaCasillero(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, Casillero casillero, StackPane pane, double x, double y, double ancho,
			double alto) {

		@SuppressWarnings("rawtypes")
		Class[] param = new Class[8];
		param[0] = AlgoPoly.class;
		param[1] = ContenedorPrincipal.class;
		param[2] = Casillero.class;
		param[3] = StackPane.class;
		param[4] = double.class;
		param[5] = double.class;
		param[6] = double.class;
		param[7] = double.class;

		String nombreClase = "vista.Vista" + casillero.getClass().getSimpleName();

		// TODO Bloque por si cambia modelo. Eliminar al fijar modelo
		boolean esta = false;
		if (nombreClase.equals("vista.VistaCarcel"))
			esta = true;
		if (nombreClase.equals("vista.VistaAvance"))
			esta = true;
		if (nombreClase.equals("vista.VistaCompania"))
			esta = true;
		if (nombreClase.equals("vista.VistaTerreno"))
			esta = true;
		if (nombreClase.equals("vista.VistaSalida"))
			esta = true;
		if (nombreClase.equals("vista.VistaRetroceso"))
			esta = true;
		if (nombreClase.equals("vista.VistaPolicia"))
			esta = true;
		if (nombreClase.equals("vista.VistaQuini6"))
			esta = true;
		if (nombreClase.equals("vista.VistaImpuestoAlLujo"))
			esta = true;

		if (!esta)
			nombreClase = "vista.VistaSalida";
		// -----------------------------------------------------------------

		try {
			Class<?> clase = Class.forName(nombreClase);
			Method metodo = clase.getDeclaredMethod("Instancia", param);
			dibujable = (Dibujable) metodo.invoke(null, algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dibujar() {
		dibujable.dibujar();
	}
}
