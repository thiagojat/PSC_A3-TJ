package pClasses;


public class Sala {
	private String nomeSala;
	private String lugarSala;
	private int capacidadeMax;
	private int codSala;


	public Sala(String nomeSala, String lugarSala, int capacidadeMax) {
		//Main.salas.add(this);
		this.nomeSala = nomeSala;
		this.lugarSala = lugarSala;
		this.capacidadeMax = capacidadeMax;
	}
	public Sala() {

	}
	public String getNomeSala() {
		return nomeSala;
	}
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	public String getLugarSala() {
		return lugarSala;
	}
	public void setLugarSala(String lugarSala) {
		this.lugarSala = lugarSala;
	}
	public int getCapacidadeMax() {
		return capacidadeMax;
	}
	public void setCapacidadeMax(int capacidadeMax) {
		this.capacidadeMax = capacidadeMax;
	}
	public int getCodSala() {
		return codSala;
	}
	public void setCodSala(int codSala) {
		this.codSala = codSala;
	}
	@Override
	public String toString() {
		return "Sala\n"
				+ "Codigo: " + getCodSala()+";\n"
				+ "Nome da sala: " + getNomeSala() + ";\n"
				+ "Lugar da Sala: " + getLugarSala() + ";\n"
				+ "Capacidade: " + getCapacidadeMax() + ";\n";
	}


}
