package pClasses;


public class Professor extends Pessoa{
	private String codFuncionario;

	public Professor(String nomeCom, long cpf, String endereco, String email, long numCel, String codFuncionario) {
		super(nomeCom, cpf, endereco, email, numCel);
		this.codFuncionario = codFuncionario;
	}

	public String getCodFuncionario() {
		return codFuncionario;
	}
	
	public void setCodFuncionario() {
		//this.codFuncionario = "" + (Main.professores.size());
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

