package main_package;

public class Professor extends Pessoa{
	private String codFuncionario;

	public Professor(String fullName, String cpf, String address, String email, String phoneNumber) {
		super(fullName, cpf, address, email, phoneNumber);
		setCodFuncionario();
	}
	
	public String getCodFuncionario() {
		return codFuncionario;
	}
	
	private void setCodFuncionario() {
		this.codFuncionario = "" + (Main.professores.size() + 1);
	}
	
}

