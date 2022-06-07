package main_package;

public class Professor extends Pessoa{
	private String codFuncionario;

	public Professor(String fullName, String cpf, String address, String email, String phoneNumber) {
		super(fullName, cpf, address, email, phoneNumber);
		setCodFuncionario();
		Main.professores.add(this);
	}
	
	public String getCodFuncionario() {
		return codFuncionario;
	}
	
	private void setCodFuncionario() {
		this.codFuncionario = "" + (Main.professores.size());
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

