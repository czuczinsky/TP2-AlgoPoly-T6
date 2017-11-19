package modelo;

public class AlgoPoly {
	Tablero tablero;
	Dados dados;

	public AlgoPoly() {
		this.tablero = new Tablero();
		this.armarTablero();
	}

	public void armarTablero() {

		tablero.agregarCasillero(new Salida());
		tablero.agregarCasillero(new Quini6());
		Grupo bsas = new Grupo();
		tablero.agregarCasillero(new Terreno("Bs.As. SUR", bsas, 20000, 2000, 3000, 3500, 5000, 5000, 8000));
		Grupo edesurAysa = new Grupo();
		tablero.agregarCasillero(new Compania("EDESUR", 35000, edesurAysa, 500, 1000));
		tablero.agregarCasillero(new Terreno("Bs.As. NORTE", bsas, 25000, 2500, 3500, 4000, 6000, 5500, 9000));
		Carcel carcel = new Carcel();
		tablero.agregarCasillero(carcel);
		Grupo cordoba = new Grupo();
		tablero.agregarCasillero(new Terreno("CORDOBA SUR", cordoba, 18000, 1000, 1500, 2500, 3000, 2000, 3000));
		tablero.agregarCasillero(new Avance(tablero));
		Grupo subteTren = new Grupo();
		tablero.agregarCasillero(new Compania("SUBTE", 40000, subteTren, 600, 1100));
		tablero.agregarCasillero(new Terreno("CORDOBA NORTE", cordoba, 20000, 1300, 1800, 2900, 3500, 2200, 3500));
		tablero.agregarCasillero(new ImpuestoAlLujo());
		tablero.agregarCasillero(new Terreno("SANTA FE", new Grupo(), 15000, 1500, 3500, 0, 0, 4000, 0));
		tablero.agregarCasillero(new Compania("AYSA", 30000, edesurAysa, 300, 500));
		Grupo salta = new Grupo();
		tablero.agregarCasillero(new Terreno("SALTA NORTE", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500));
		tablero.agregarCasillero(new Terreno("SALTA SUR", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500));
		tablero.agregarCasillero(new Policia(carcel));
		tablero.agregarCasillero(new Compania("TREN", 38000, subteTren, 450, 800));
		tablero.agregarCasillero(new Terreno("NEUQUEN", new Grupo(), 17000, 1800, 3800, 0, 0, 4800, 0));
		tablero.agregarCasillero(new Retroceso(tablero));
		tablero.agregarCasillero(new Terreno("TUCUMAN", new Grupo(), 25000, 2500, 4500, 0, 0, 7000, 0));

	}

	public Tablero getTablero() {
		return tablero;
	}
}
