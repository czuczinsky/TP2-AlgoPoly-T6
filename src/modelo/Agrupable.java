package modelo;

public interface Agrupable {
	public Jugador getPropietario();
	public boolean estaCompleto();
	void ocupar(Jugador jugador, Dados dados);
}
