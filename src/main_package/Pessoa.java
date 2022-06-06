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
	
	
}
