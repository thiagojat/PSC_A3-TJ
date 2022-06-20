/*
 * Classe responsavel por controlar as acoes possiveis com sala: cadastro, remoçao, listagem e etc.
 * 
 * */

package pControllers;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import pClasses.Sala;
import pDAO.SalaDAO;

public class SalaController  implements ControllerInterface{

	Scanner sc = new Scanner(System.in); 
	SalaDAO sd = new SalaDAO();

	public void menu() {
		String inputValue = JOptionPane.showInputDialog(""
				+ "O que deseja fazer?\n"
				+ "1 - Listar salas\n"
				+ "2 - Alterar salas\n"
				+ "3 - Cadastrar sala\n"
				+ "4 - Remover sala\n");
		if(inputValue == null) {
			return;
		}else if(inputValue.isEmpty()) {
			menu();
			return;
		}
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
		case 4:
			removeSala();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Insira uma opcao valida","Erro", JOptionPane.ERROR_MESSAGE);
			menu();
		}
	}


	/*metodo do tipo void que cadastra um curso recebendo os valores desejados pelo usuario e insere no banco de dados*/
	public void cadastrarSala() {
		Sala s = new Sala();
		s.setNomeSala(JOptionPane.showInputDialog("Digite o nome da sala"));
		s.setLugarSala(JOptionPane.showInputDialog("Digite o local da sala"));
		s.setCapacidadeMax(Integer.valueOf(JOptionPane.showInputDialog("Digite s capacidade da sala")));

		sd.inserir(s);


	}

	/*metodo do tipo void que lista na tela todas as salas cadastradas*/
	public void listarSala() {
		String sSalas = "";
		ArrayList<Sala> aSalas = new ArrayList<>();
		aSalas = (ArrayList<Sala>) sd.listar();
		for(Sala s : aSalas) {
			sSalas += s.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, sSalas, "Lista de salas", JOptionPane.PLAIN_MESSAGE);
	}

	/*metodo void que altera a sala de acordo com os valores inseridos pelo usuario*/
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
		id = Integer.parseInt(JOptionPane.showInputDialog(null, listagem + "Digite o cdigo da sala que deseja alterar que deseja alterar: "));
		Sala sala = sd.getSalaWithIndex(id);
		s.setNomeSala(JOptionPane.showInputDialog("Digite o nome: ", sala.getNomeSala()));
		s.setLugarSala(JOptionPane.showInputDialog("Digite o local da sala: ", sala.getLugarSala()));
		s.setCapacidadeMax(Integer.valueOf(JOptionPane.showInputDialog("Digite o endereco: ", sala.getCapacidadeMax())));

		sd.alteraSala(s, id);
	}
	
	/*metodo do tipo void que imprime na tela uma lista de salas */
	private void removeSala() {
		int id;
		String listagem = "";
		ArrayList<Sala> salas = (ArrayList<Sala>)sd.listar();
		for(Sala s : salas) {
			listagem += "-"+s.toString() + " Cód: "+ s.getCodSala() +"\n";
		}
		id = Integer.parseInt(JOptionPane.showInputDialog(null, listagem + "Digite o código da sala que deseja excluir: "));
		
		if(sd.remover(id)) {
			JOptionPane.showMessageDialog(null, "Sala removida com sucesso", "Removida", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog (null, "Não foi possivel remover a sala. Verifique se\nesta sala não está associada a um curso.", "Falha", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
