package modelo;

public class Dados {
	private int dado1;
	private int dado2;

	public Dados() {
		tirar();
	}

	public void tirar() {
		dado1 = 1 + (int)(Math.random() * 6);
		dado2 = 1 + (int)(Math.random() * 6);
	}

	public int getSuma() {
		return dado1 + dado2;
	}
	
	public int getDado1() {
		return dado1;
	}
	
	public int getDado2() {
		return dado2;
	}
}

