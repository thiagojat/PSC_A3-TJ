package pControllers;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import pClasses.Sala;
import pDAO.SalaDAO;

public class SalaController {
	ArrayList<Sala> salas = new ArrayList<>(); 

	Scanner sc = new Scanner(System.in); 
	SalaDAO sd = new SalaDAO();

	public void menu() {
		String inputValue = JOptionPane.showInputDialog(""
				+ "O que deseja fazer?\n"
				+ "1 - Listar salas\n"
				+ "2 - Alterar salas\n"
				+ "3 - Cadastrar aluno\n");
		int op = Integer.valueOf(inputValue);
		switch(op) {
		case 1:
			listarSala();
			break;
		case 2:
			alterarSala();
			break;
		case 3:
			cadastrarSala();
			break;
		default:
			menu();
			JOptionPane.showMessageDialog(null, "Insira uma opcao valida","Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void cadastrarSala() {

		Sala s = new Sala();
		s.setNomeSala(JOptionPane.showInputDialog("Digite o nome da sala"));
		s.setLugarSala(JOptionPane.showInputDialog("Digite o local da sala"));
		s.setCapacidadeMax(Integer.valueOf(JOptionPane.showInputDialog("Digite s capacidade da sala")));

		sd.inserir(s);


	}

	public void listarSala() {
		String sSalas = "";
		ArrayList<Sala> aSalas = new ArrayList<>();
		aSalas = (ArrayList<Sala>) sd.listar();
		for(Sala s : aSalas) {
			sSalas += s.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, sSalas, "Lista de salas", JOptionPane.PLAIN_MESSAGE);
	}

	public void alterarSala() {

		Sala s = new Sala();
		int id;
		ArrayList<Sala> salas = (ArrayList<Sala>)sd.listar();
		String listagem = "";
		for (Sala ss : salas) {
			listagem += ""
					+ "Sala\n"
					+ "Codigo: " + ss.getCodSala()+";\n"
					+ "Nome: "+ss.getNomeSala()+";\n\n";
		}
		id = Integer.parseInt(JOptionPane.showInputDialog(null, listagem + "Digite a matricula do aluno que deseja alterar: "));

		s.setNomeSala(JOptionPane.showInputDialog("Digite o nome: ", salas.get(id-1).getNomeSala()));
		s.setLugarSala(JOptionPane.showInputDialog("Digite o local da sala: ", salas.get(id-1).getLugarSala()));
		s.setCapacidadeMax(Integer.valueOf(JOptionPane.showInputDialog("Digite o endereco: ", salas.get(id-1).getCapacidadeMax())));

		sd.alteraSala(s, id);
	}
}
