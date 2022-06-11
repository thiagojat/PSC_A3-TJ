package pClasses;


public class Professor extends Pessoa{
	private String codFuncionario;

	public Professor(String nomeCom, String cpf, String endereco, String email, long numCel, String codFuncionario) {
		super(nomeCom, cpf, endereco, email, numCel);
		this.codFuncionario = codFuncionario;
	}
	public Professor() {
	}

	public String getCodFuncionario() {
		return codFuncionario;
	}
	
	public void setCodFuncionario(String codFuncionario) {
		this.codFuncionario = codFuncionario;
	}
	
	@Override
	public String toString() {
		return getNomeCom() + " (Cód.;" + getCodFuncionario() + ")";
	}
	public String toStringAll() {
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

