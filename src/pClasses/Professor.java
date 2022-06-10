package pClasses;


public class Professor extends Pessoa{
	private int codFuncionario;

	public Professor(String nomeCom, long cpf, String endereco, String email, long numCel, int codFuncionario) {
		super(nomeCom, cpf, endereco, email, numCel);
		this.codFuncionario = codFuncionario;
	}
	public Professor() {
	}

	public int getCodFuncionario() {
		return codFuncionario;
	}
	
	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
	}
	
	@Override
	public String toString() {
		return ""
				+ "Professor\n"
				+ "Codigo de funcionário: " + getCodFuncionario() + ";\n"
				+ "Nome: " + getNomeCom() + ";\n"
				+ "CPF: " + getCpf()+";\n"
				+ "Endereco: " + getEndereco() + ";\n"
				+ "Email: " + getEmail() + ";\n"
				+ "Celular: " + getNumCel()+";\n";
	}
	
}

