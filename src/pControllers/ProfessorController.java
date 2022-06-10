package pControllers;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import pClasses.Professor;
import pDAO.ProfessorDAO;

public class ProfessorController{
	
	ArrayList<Professor> professores = new ArrayList<>(); 

	Scanner sc = new Scanner(System.in); 
	ProfessorDAO pd = new ProfessorDAO();

	public void menu() {
		String inputValue = JOptionPane.showInputDialog(""
				+ "O que deseja fazer?\n"
				+ "1 - Listar professores\n"
				+ "2 - Alterar professores\n"
				+ "3 - Cpdastrar professor\n");
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
		default:
			menu();
			JOptionPane.showMessageDialog(null, "Insira uma opcao valida","Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	
	public void cadastrarProfessor() {
		
		Professor p = new Professor();
		p.setNomeCom(JOptionPane.showInputDialog("Digite o nome do professor"));
		p.setCpf(Long.valueOf(JOptionPane.showInputDialog("Digite o CPF do professor")));
		p.setEndereco(JOptionPane.showInputDialog("Digite o endereço do professor:"));
		p.setEmail(JOptionPane.showInputDialog("Digite o email do professor:"));
		p.setNumCel(Long.valueOf(JOptionPane.showInputDialog("Digite o numero de celular do professor")));
		
		pd.inserir(p);
		
		
	}

	public void listarProfessor() {
		String sProfessores = "";
		ArrayList<Professor> aProfessores = new ArrayList<>();
		aProfessores = (ArrayList<Professor>) pd.listar();
		for(Professor p : aProfessores) {
			sProfessores += p.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, sProfessores, "Lista de professores", JOptionPane.PLAIN_MESSAGE);
	}
	
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
        id = Integer.valueOf(JOptionPane.showInputDialog(null, listagem + "Digite o codigo do funcionario que deseja alterar: "));

        p.setNomeCom(JOptionPane.showInputDialog("Digite o nome: ", professores.get(id-1).getNomeCom()));
        p.setCpf(Long.parseLong(JOptionPane.showInputDialog("Digite o CPF: ", professores.get(id-1).getCpf())));
        p.setEndereco(JOptionPane.showInputDialog("Digite o endereco: ", professores.get(id-1).getEndereco()));
        p.setEmail(JOptionPane.showInputDialog("Digite o email: ", professores.get(id-1).getEmail()));
        p.setNumCel(Long.parseLong(JOptionPane.showInputDialog("Digite o celular: ", professores.get(id-1).getNumCel())));

        pd.alteraProfessor(p, id);
    }
}

