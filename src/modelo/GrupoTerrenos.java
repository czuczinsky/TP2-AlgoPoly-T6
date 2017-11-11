package modelo;

import java.util.ArrayList;

public class GrupoTerrenos {
	private ArrayList<Terreno> terrenos = new ArrayList<Terreno>();

	public void agregarTerreno(Terreno terreno) {
		terrenos.add(terreno);
	}

	public boolean esMultiple() {
		return (terrenos.size() > 1);
	}

	public boolean terrenosMismoPropietario() {
		boolean resultado = true;
		for (Terreno terreno : terrenos)
			if (terreno.getPropietario() != terrenos.get(0).getPropietario()) {
				resultado = false;
			}
		return resultado;
	}

}
