package modelo;

public class AlgoPoly {
	Tablero tablero;
	Dados dados;

	public AlgoPoly() {
		this.tablero = new Tablero();
		this.armarTablero();
	}

	public void armarTablero() {
		Grupo bsas = new Grupo();
		Grupo edesurAysa = new Grupo();
		Grupo cordoba = new Grupo();
		Grupo subteTren = new Grupo();
		Grupo salta = new Grupo();
		Agrupable bsAsSur=new Terreno("Bs.As. SUR", bsas, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Agrupable edesur=new Compania("EDESUR", 35000, edesurAysa, 500, 1000);
		Agrupable bsAsNorte=new Terreno("Bs.As. NORTE", bsas, 25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Agrupable cordobaSur=new Terreno("CORDOBA SUR", cordoba, 18000, 1000, 1500, 2500, 3000, 2000, 3000);
		Agrupable subte=new Compania("SUBTE", 40000, subteTren, 600, 1100);
		Agrupable cordobaNorte=new Terreno("CORDOBA NORTE", cordoba, 20000, 1300, 1800, 2900, 3500, 2200, 3500);
		Agrupable santaFe=new Terreno("SANTA FE", new Grupo(), 15000, 1500, 3500, 0, 0, 4000, 0);
		Agrupable aysa=new Compania("AYSA", 30000, edesurAysa, 300, 500);
		Agrupable saltaNorte=new Terreno("SALTA NORTE", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Agrupable saltaSur=new Terreno("SALTA SUR", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Agrupable tren=new Compania("TREN", 38000, subteTren, 450, 800);
		Agrupable neuquen=new Terreno("NEUQUEN", new Grupo(), 17000, 1800, 3800, 0, 0, 4800, 0);
		Agrupable tucuman=new Terreno("TUCUMAN", new Grupo(), 25000, 2500, 4500, 0, 0, 7000, 0);

		tablero.agregarCasillero(new Salida());
		tablero.agregarCasillero(new Quini6());
		tablero.agregarCasillero(bsAsSur);
		tablero.agregarCasillero(edesur);
		tablero.agregarCasillero(bsAsNorte);
		Carcel carcel=new Carcel();
		tablero.agregarCasillero(carcel);
		tablero.agregarCasillero(cordobaSur);
		tablero.agregarCasillero(new Avance(tablero));
		tablero.agregarCasillero(subte);
		tablero.agregarCasillero(cordobaNorte);
		tablero.agregarCasillero(new ImpuestoAlLujo());
		tablero.agregarCasillero(santaFe);
		tablero.agregarCasillero(aysa);
		tablero.agregarCasillero(saltaNorte);
		tablero.agregarCasillero(saltaSur);
		tablero.agregarCasillero(new Policia(carcel));
		tablero.agregarCasillero(tren);
		tablero.agregarCasillero(neuquen);
		tablero.agregarCasillero(new Retroceso(tablero));
		tablero.agregarCasillero(tucuman);

	}

	public Tablero getTablero() {
		return tablero;
	}
}
