package pClasses;

public class Aluno extends Pessoa{
	private String matricula;
	
	public Aluno(String nomeCom, String cpf, String endereco, String email, long numCel, String matricula) {
		super(nomeCom, cpf, endereco, email, numCel);
		this.matricula = matricula;
	}

	public Aluno() {
		
	}

	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String toStringAll() {
		return ""
				+ "Aluno\n"
				+ "Matricula: " + getMatricula() + ";\n"
				+ "Nome: " + getNomeCom() + ";\n"
				+ "CPF: " + getCpf()+";\n"
				+ "Endereco: " + getEndereco() + ";\n"
				+ "Email: " + getEmail() + ";\n"
				+ "Celular: " + getNumCel()+";\n";
				
	}
	@Override
	public String toString() {
		return "Nome: " + getNomeCom() + "(Matricula: " + getMatricula() + ")\n";
	}

	

	
}
