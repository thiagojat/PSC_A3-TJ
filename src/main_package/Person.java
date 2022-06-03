package main_package;

public abstract class Person {
	private String fullName;
	private String cpf;
	private String address;
	private String email;
	private String phoneNumber;
	
	public Person(String fullName, String cpf, String address, String email, String phoneNumber) {
		this.fullName = fullName;
		this.cpf = cpf;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	
}
