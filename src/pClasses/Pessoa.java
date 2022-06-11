package pClasses;

public abstract class Pessoa {
	private String nomeCom;
	private String cpf;
	private String endereco;
	private String email;
	private long numCel;
	
	public long getNumCel() {
		return numCel;
	}

	public Pessoa(String nomeCom, String cpf, String endereco, String email, long numCel) {
		super();
		this.nomeCom = nomeCom;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.numCel = numCel;
	}

	public Pessoa() {
	}

	public String getNomeCom() {
		return nomeCom;
	}

	public void setNomeCom(String nomeCom) {
		this.nomeCom = nomeCom;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setNumCel(long numCel) {
		this.numCel = numCel;
	}
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
