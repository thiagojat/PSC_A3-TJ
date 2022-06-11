package pControllers;

import java.util.*;

import javax.swing.JOptionPane;

import pAdcionais.FuncoesAdicionais;
import pClasses.Aluno;
import pDAO.AlunoDAO;

public class AlunoController {

	ArrayList<Aluno> alunos = new ArrayList<>(); 

	Scanner sc = new Scanner(System.in); 
	AlunoDAO ad = new AlunoDAO();
	FuncoesAdicionais fa = new FuncoesAdicionais();

	public void menu() {
		String inputValue = JOptionPane.showInputDialog(""
				+ "O que deseja fazer?\n"
				+ "1 - Listar alunos\n"
				+ "2 - Alterar alunos\n"
				+ "3 - Cadastrar aluno\n"
				+ "4 - Excluir aluno\n");
		int op = Integer.valueOf(inputValue);
		switch(op) {
		case 1:
			listarAluno();
			break;
		case 2:
			alterarAluno();
			break;
		case 3:
			cadastrarAluno();
			break;
		case 4:
			removerAluno();
			break;
		default:
			menu();
			JOptionPane.showMessageDialog(null, "Insira uma opcao valida","Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void cadastrarAluno() {

		Aluno a = new Aluno();
		a.setNomeCom(JOptionPane.showInputDialog("Digite o nome do aluno"));
		String cpf = JOptionPane.showInputDialog("Digite o CPF do aluno");
		if(fa.verificaCPF(cpf)) {
			a.setCpf(cpf);
		}else {
			while(!fa.verificaCPF(cpf)) {
				cpf = JOptionPane.showInputDialog("Digite o CPF do aluno");
			}
		}
		a.setEndereco(JOptionPane.showInputDialog("Digite o endereço do aluno:"));
		a.setEmail(JOptionPane.showInputDialog("Digite o email do aluno:"));
		a.setNumCel(Long.valueOf(JOptionPane.showInputDialog("Digite o numero de celular do aluno")));

		ad.inserir(a);


	}

	public void listarAluno() {
		String sAlunos = "";
		ArrayList<Aluno> aAlunos = new ArrayList<>();
		aAlunos = (ArrayList<Aluno>) ad.listar();
		for(Aluno a : aAlunos) {
			sAlunos += a.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, sAlunos, "Lista de alunos", JOptionPane.PLAIN_MESSAGE);
	}

	public void alterarAluno() {

		Aluno a = new Aluno();
		int id;
		ArrayList<Aluno> alunos = (ArrayList<Aluno>)ad.listar();
		String listagem = "";
		for (Aluno aa : alunos) {
			listagem += ""
					+ "Aluno\n"
					+ "Matricula: " + aa.getMatricula()+";\n"
					+ "Nome: "+aa.getNomeCom()+";\n\n";
		}
		id = Integer.parseInt(JOptionPane.showInputDialog(null, listagem + "Digite a matricula do aluno que deseja alterar: "));

		a.setNomeCom(JOptionPane.showInputDialog("Digite o nome: ", ad.getAlunoWithIndex(id).getNomeCom()));
		a.setCpf(JOptionPane.showInputDialog("Digite o CPF: ", ad.getAlunoWithIndex(id).getCpf()));
		a.setEndereco(JOptionPane.showInputDialog("Digite o endereco: ", ad.getAlunoWithIndex(id).getEndereco()));
		a.setEmail(JOptionPane.showInputDialog("Digite o email: ", ad.getAlunoWithIndex(id).getEmail()));
		a.setNumCel(Long.parseLong(JOptionPane.showInputDialog("Digite o celular: ", ad.getAlunoWithIndex(id).getNumCel())));

		ad.alteraAluno(a, id);
	}
	
	public void removerAluno() {
		int id;
		ArrayList<Aluno> alunos = (ArrayList<Aluno>)ad.listar();
		String listagem = "";
		for (Aluno aa : alunos) {
			listagem += ""
					+ "Aluno\n"
					+ "Matricula: " + aa.getMatricula()+";\n"
					+ "Nome: "+aa.getNomeCom()+";\n\n";
		}
		id = Integer.parseInt(JOptionPane.showInputDialog(null, listagem + "Digite a matricula do aluno que deseja excluir: "));
		ad.remover(id);
	}
}
