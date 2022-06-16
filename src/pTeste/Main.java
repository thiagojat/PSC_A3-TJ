package pTeste;

import javax.swing.JOptionPane;
import pControllers.*;

public class Main {

	public static void main(String[] args) {
		AlunoController ac = new AlunoController();
		ProfessorController pc = new ProfessorController();
		CursoController cc = new CursoController();
		SalaController sc = new SalaController();

		int op = 0;
		//loop que imprime o menu principal
		do {
			String inputValue = JOptionPane.showInputDialog(""
					+ "O que deseja fazer?\n"
					+ "1 - Acessar alunos\n"
					+ "2 - Acessar professores\n"
					+ "3 - Acessar cursos\n"
					+ "4 - Acessar salas\n");
			op = Integer.valueOf(inputValue);
			//switch que controla e direciona aos sub-menus
			switch(op) {
			case 1:
				ac.menu();
				break;
			case 2:
				pc.menu();
				break;
			case 3:
				cc.menu();
				break;
			case 4:
				sc.menu();
				break;	
			default:
				JOptionPane.showMessageDialog(null, "Insira uma opcao valida","Erro", JOptionPane.ERROR_MESSAGE);
			}
		}while(op != 0);
		//sc.close();



	}
}
