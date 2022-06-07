package main_package;

public class Sala {
	private String nomeSala;
	private String lugarSala;
	private int capacidadeMax;
	

	public Sala(String nomeSala, String lugarSala, int capacidadeMax) {
		Main.salas.add(this);
		this.nomeSala = nomeSala;
		this.lugarSala = lugarSala;
		this.capacidadeMax = capacidadeMax;
	}
	
	public int getCapacidadeMax() {
		return capacidadeMax;
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public String getLugarSala() {
		return lugarSala;
	}
}
