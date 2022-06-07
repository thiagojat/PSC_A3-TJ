package main_package;

public class Aluno extends Pessoa{
	private String matricula;

	public Aluno(String nomeCom, String cpf, String endereco, String email, String numCel) {
		super(nomeCom, cpf, endereco, email, numCel);
		this.setMatricula();
		Main.alunos.add(this);
	}

	public String getMatricula() {
		return matricula;
	}

	private void setMatricula() {
		
		this.matricula = ""+ (Main.alunos.size());
	}

	@Override
	public String toString() {
		return ""
				+ "Aluno\n"
				+ "Matricula: " + getMatricula() + ";\n"
				+ "Nome: " + getNomeCom() + ";\n"
				+ "CPF: " + getCpf()+";\n"
				+ "Endereco: " + getEndereco() + ";\n"
				+ "Email: " + getEmail() + ";\n"
				+ "Celular: " + getNumCel()+";\n";
	}

	

	
}
