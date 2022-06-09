package pControllers;

import java.util.*;

import pClasses.Aluno;
import pDAO.AlunoDAO;

public class AlunoController {
	
	ArrayList<Aluno> alunos = new ArrayList<>(); 

	Scanner sc = new Scanner(System.in); 
	AlunoDAO ad = new AlunoDAO();
	
	public void cadastrarAluno() {
		
		Aluno a = new Aluno();
		System.out.println("Digite o nome do aluno");
		a.setNomeCom(sc.nextLine());
		System.out.println("Digite o CPF do aluno");
		a.setCpf(sc.nextLong());
		sc.nextLine();
		System.out.println("Digite o endereço do aluno:");
		a.setEndereco(sc.nextLine());
		System.out.println("Digite o email do aluno:");
		a.setEmail(sc.nextLine());
		System.out.println("Digite o número de celular do aluno:");
		a.setNumCel(sc.nextLong());
		sc.nextLine();
		
		ad.inserir(a);
		
		
	}
}
