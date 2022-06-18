/*
 * Classe que controla as acoes de aluno como: registro, remocao, listagem e etc.
 */
package pControllers;

import java.util.*;

import javax.swing.JOptionPane;

import pClasses.Aluno;
import pDAO.AlunoDAO;

public class AlunoController{

	Scanner sc = new Scanner(System.in); 
	AlunoDAO ad = new AlunoDAO();

	public void menu() {
		//imprime o menu com as ações de aluno
		String inputValue = JOptionPane.showInputDialog(""
				+ "O que deseja fazer?\n"
				+ "1 - Listar alunos\n"
				+ "2 - Alterar alunos\n"
				+ "3 - Cadastrar aluno\n"
				+ "4 - Excluir aluno\n");
		if(inputValue == null) {
			return;
		}else if(inputValue.isEmpty()) {
			menu();
			return;
		}
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
			JOptionPane.showMessageDialog(null, "Insira uma opcao valida","Erro", JOptionPane.ERROR_MESSAGE);
			menu();
		}
	}
	
	/*funcao do tipo void que aceita os valores inseridos pelo usuario, define os valores dentro de uma instância de
	 *Aluno a e chama um metodo de AlunoDAO que insere este aluno no banco de dados
	 */
	public void cadastrarAluno() {
		Aluno a = new Aluno();
		a.setNomeCom(JOptionPane.showInputDialog("Digite o nome do aluno"));
		String cpf = JOptionPane.showInputDialog("Digite o CPF do aluno");
		a.setCpf(cpf);
		a.setEndereco(JOptionPane.showInputDialog("Digite o endereço do aluno:"));
		a.setEmail(JOptionPane.showInputDialog("Digite o email do aluno:"));
		a.setNumCel(Long.valueOf(JOptionPane.showInputDialog("Digite o numero de celular do aluno")));

		if(ad.inserir(a)) {;
			System.out.println("Aluno cadastrado com sucesso.");
		}else {
			System.out.println("Não foi possível cadastrar o aluno.");
		}


	}
	
	//método que imprime lista os alunos na tela
	public void listarAluno() {
		String sAlunos = "";
		ArrayList<Aluno> aAlunos = new ArrayList<>();
		aAlunos = (ArrayList<Aluno>) ad.listar();
		for(Aluno a : aAlunos) {
			sAlunos += a.toStringAll() + "\n";
		}
		JOptionPane.showMessageDialog(null, sAlunos, "Lista de alunos", JOptionPane.PLAIN_MESSAGE);
	}
	
	//metodo responsável por alterar aluno, usando os valores já estabelecidos como referência para o usuário
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
		
		String inputValue = JOptionPane.showInputDialog(null, listagem + "Digite a matricula do aluno que deseja alterar: ");
		if(inputValue == null) {
			menu();
			return;
		}else if(inputValue.isEmpty()) {
			alterarAluno();
		}
		id = Integer.parseInt(inputValue);
		if(!ad.alunoExists(id)) {
			JOptionPane.showMessageDialog(null, "Insira uma matrícula valida","Erro", JOptionPane.ERROR_MESSAGE);
			alterarAluno();
		}else {
			Aluno alu = ad.getAlunoWithIndex(id);

			a.setNomeCom(JOptionPane.showInputDialog("Digite o nome: ", alu.getNomeCom()));
			a.setCpf(JOptionPane.showInputDialog("Digite o CPF: ", alu.getCpf()));
			a.setEndereco(JOptionPane.showInputDialog("Digite o endereco: ", alu.getEndereco()));
			a.setEmail(JOptionPane.showInputDialog("Digite o email: ", alu.getEmail()));
			a.setNumCel(Long.parseLong(JOptionPane.showInputDialog("Digite o celular: ", alu.getNumCel())));

			ad.alteraAluno(a, id);
		}
	}
	
	/*metodo do tipo void que lista as opcoes de aluno que o usuário pode excluir, e aceita o id do aluno a 
	 *ser excluido e chama o metodo de AlunoDAO para excluir aluno de banco de dados 
	 * */
	
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
		String inputValue = JOptionPane.showInputDialog(null, listagem + "Digite a matricula do aluno que deseja excluir: ");
		if(inputValue == null) {
			menu();
			return;
		}else if(inputValue.isEmpty()) {
			removerAluno();
		}
		id = Integer.parseInt(inputValue);
		if(!ad.alunoExists(id)) {
			JOptionPane.showMessageDialog(null, "Insira uma matrícula valida","Erro", JOptionPane.ERROR_MESSAGE);
			removerAluno();
		}else {
			id = Integer.parseInt(inputValue);
			if(ad.remover(id)) {
				JOptionPane.showMessageDialog(null, "Aluno de matrícula "+id+" removido com sucesso","Sucesso", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Não foi possivel remover o aluno de matricula "+id+".","Erro", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
}
