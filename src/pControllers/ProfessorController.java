/*
 * Classe responsavel por controlar as acoes possiveis com professor: cadastro, remoçao, listagem e etc.
 * 
 * */
package pControllers;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import pClasses.Professor;
import pDAO.ProfessorDAO;

public class ProfessorController{

	ProfessorDAO pd = new ProfessorDAO();

	public void menu() {
		String inputValue = JOptionPane.showInputDialog(""
				+ "O que deseja fazer?\n"
				+ "1 - Listar professores\n"
				+ "2 - Alterar professores\n"
				+ "3 - Cadastrar professor\n"
				+ "4 - Remover professor\n");
		if(inputValue == null) {
			return;
		}else if(inputValue.isEmpty()) {
			menu();
			return;
		}
		int op = Integer.valueOf(inputValue);
		switch(op) {
		case 1:
			listarProfessor();
			break;
		case 2:
			alterarProfessor();
			break;
		case 3:
			cadastrarProfessor();
			break;
		case 4:
			removerProfessor();
		default:
			JOptionPane.showMessageDialog(null, "Insira uma opcao valida","Erro", JOptionPane.ERROR_MESSAGE);
			menu();
		}
	}

	/*metodo do tipo void que cadastra um professor recebendo os valores desejados pelo usuario e insere no banco de dados*/
	public void cadastrarProfessor() {

		Professor p = new Professor();
		p.setNomeCom(JOptionPane.showInputDialog("Digite o nome do professor"));
		p.setCpf(JOptionPane.showInputDialog("Digite o CPF do professor"));
		p.setEndereco(JOptionPane.showInputDialog("Digite o endereço do professor:"));
		p.setEmail(JOptionPane.showInputDialog("Digite o email do professor:"));
		p.setNumCel(Long.valueOf(JOptionPane.showInputDialog("Digite o numero de celular do professor")));

		pd.inserir(p);
	}

	/*metodo do tipo void que lista todos os professores na tela*/
	public void listarProfessor() {
		String sProfessores = "";
		ArrayList<Professor> aProfessores = new ArrayList<>();
		aProfessores = (ArrayList<Professor>) pd.listar();
		for(Professor p : aProfessores) {
			sProfessores += p.toStringAll() + "\n";
		}
		JOptionPane.showMessageDialog(null, sProfessores, "Lista de professores", JOptionPane.PLAIN_MESSAGE);
	}

	/*metodo void que altera o professor de acordo com os valores inseridos pelo usuario*/
	public void alterarProfessor() {
		Professor p = new Professor();
		int id;
		ArrayList<Professor> professores = (ArrayList<Professor>)pd.listar();
		String listagem = "";
		for (Professor pp : professores) {
			listagem += ""
					+ "Aluno\n"
					+ "Matricula: " + pp.getCodFuncionario()+";\n"
					+ "Nome: "+pp.getNomeCom()+";\n\n";
		}
		String inputValue = JOptionPane.showInputDialog(null, listagem + "Digite o codigo do funcionario que deseja alterar: ");
		if(inputValue == null) {
			menu();
			return;
		}else if(inputValue.isEmpty()) {
			alterarProfessor();
		}
		id = Integer.valueOf(inputValue);

		if(!pd.professorExists(id)) {
			JOptionPane.showMessageDialog(null, "Insira um codigo de funcionario valido","Erro", JOptionPane.ERROR_MESSAGE);
			alterarProfessor();
		}else {
			p.setNomeCom(JOptionPane.showInputDialog("Digite o nome: ", pd.getProfessorWithIndex(id).getNomeCom()));
			p.setCpf(JOptionPane.showInputDialog("Digite o CPF: ", pd.getProfessorWithIndex(id).getCpf()));
			p.setEndereco(JOptionPane.showInputDialog("Digite o endereco: ", pd.getProfessorWithIndex(id).getEndereco()));
			p.setEmail(JOptionPane.showInputDialog("Digite o email: ", pd.getProfessorWithIndex(id).getEmail()));
			p.setNumCel(Long.parseLong(JOptionPane.showInputDialog("Digite o celular: ", pd.getProfessorWithIndex(id).getNumCel())));

			pd.alteraProfessor(p, id);
		}
	}

	/*metodo void que remove professor*/
	private void removerProfessor() {
		int id;
		String listagem = "";
		ArrayList<Professor> professores = (ArrayList<Professor>)pd.listar();
		for(Professor p : professores) {
			listagem += "-"+p.toString()+"\n";
		}
		String inputValue = JOptionPane.showInputDialog(null, listagem + "Digite o código de funcionário do professor que deseja excluir: ");
		if(inputValue == null) {
			menu();
			return;
		}else if(inputValue.isEmpty()) {
			removerProfessor();
		}
		id = Integer.parseInt(inputValue);
		if(!pd.professorExists(id)) {
			JOptionPane.showMessageDialog(null, "Insira uma matrícula valida","Erro", JOptionPane.ERROR_MESSAGE);
			removerProfessor();
		}else {
			id = Integer.parseInt(inputValue);

			if(pd.remover(id)) {
				JOptionPane.showMessageDialog(null, "Professor removido com sucesso", "Removido", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog (null, "Não foi possivel remover professor. Verifique\nse professor não está associado a um curso.", "Falha", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}

