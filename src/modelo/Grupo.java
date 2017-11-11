package modelo;

import java.util.ArrayList;

public class Grupo {
	private ArrayList<Agrupable> elementos = new ArrayList<Agrupable>();

	public void agregar(Agrupable agrupable) {
		elementos.add(agrupable);
	}

	public boolean esMultiple() {
		return (elementos.size() > 1);
	}

	public boolean mismoPropietario() {
		boolean resultado = true;
		for (Agrupable agrupable : elementos)
			if (agrupable.getPropietario() != elementos.get(0).getPropietario()) {
				resultado = false;
			}
		return resultado;
	}

}
