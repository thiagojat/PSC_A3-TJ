package pControllers;


public class SalaController {
	private String nomeSala;
	private String lugarSala;
	private int capacidadeMax;
	

	public SalaController(String nomeSala, String lugarSala, int capacidadeMax) {
		//Main.salas.add(this);
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
