package main_package;

public class Professor extends Person{
	public String employeeCode;

	public Professor(String fullName, String cpf, String address, String email, String phoneNumber,
			String employeeCode) {
		super(fullName, cpf, address, email, phoneNumber);
		this.employeeCode = employeeCode;
	}
	
	
}
