package main_package;

public class Student extends Person{
	private String regNumber;

	public Student(String fullName, String cpf, String address, String email, String phoneNumber, String regNumber) {
		super(fullName, cpf, address, email, phoneNumber);
		this.regNumber = regNumber;
	}

}
