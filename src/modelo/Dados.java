package modelo;

public class Dados {
	private static Dados dados = null;
	private int dado1;
	private int dado2;
	protected Dados() {
	}

	public static Dados getDados() {
		if (dados == null) {
			dados = new Dados();
			dados.tirar();
		}
		return dados;
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

	// Metodo para los test - cargo los dados
	public void setNumeros(int dado1, int dado2) {
		this.dado1 = dado1;
		this.dado2 = dado2;
	}
}

