package main_package;

public abstract class Pessoa {
	private String nomeCom;
	private String cpf;
	private String endereco;
	private String email;
	private String numCel;
	
	public Pessoa(String nomeCom, String cpf, String endereco, String email, String numCel) {
		this.nomeCom = nomeCom;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.numCel = numCel;
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

	public String getNumCel() {
		return numCel;
	}

	public void setNumCel(String numCel) {
		this.numCel = numCel;
	}
	
	
}
