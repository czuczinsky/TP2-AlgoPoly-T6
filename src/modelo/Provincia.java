package modelo;

public class Provincia {
	private final int maximoTerrenos = 10;
	private Terreno[] terrenos;
	private int cantidadTerrenos;
	
	public Provincia( ) {
		cantidadTerrenos = 0;
		terrenos = new Terreno[maximoTerrenos];
	}

	public void agregarTerreno(Terreno terreno) {
		terrenos[cantidadTerrenos] = terreno;
		cantidadTerrenos++;
	}
}
