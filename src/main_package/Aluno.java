package main_package;

public class Aluno extends Pessoa{
	private String matricula;

	public Aluno(String nomeCom, String cpf, String endereco, String email, String numCel) {
		super(nomeCom, cpf, endereco, email, numCel);
		this.setMatricula();
	}

	public String getMatricula() {
		return matricula;
	}

	private void setMatricula() {
		this.matricula = ""+ (Main.alunos.size() + 1);
	}

	
}
