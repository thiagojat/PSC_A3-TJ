package pTeste;

import javax.swing.JOptionPane;
import pControllers.*;

public class Main {

	public static void main(String[] args) {
		AlunoController ac = new AlunoController();
		ProfessorController pc = new ProfessorController();
		CursoController cc = new CursoController();
		SalaController sc = new SalaController();

		int close = 0;
		int op = 0;
		//loop que imprime o menu principal
		do {

			String inputValue = menuMain();
			if(inputValue.equals("terminate")) System.exit(0);
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

		}while(close != 1);

	}
	public static String menuMain() {
		int close = 0;
		String inputValue = JOptionPane.showInputDialog(""
				+ "O que deseja fazer?\n"
				+ "1 - Acessar alunos\n"
				+ "2 - Acessar professores\n"
				+ "3 - Acessar cursos\n"
				+ "4 - Acessar salas\n");
		if(inputValue == null) {
			close = JOptionPane.showConfirmDialog(null,"Deseja encerrar o programa?", 
					"Encerrar programa", JOptionPane.YES_NO_OPTION);
			if(close == JOptionPane.YES_OPTION) {
				return "terminate";
			}else if(close == JOptionPane.NO_OPTION){
				return menuMain();
			}
		}else if(inputValue.isBlank()) {
			return menuMain();
		}else {
			return inputValue;
		}
		return "nada";
	}
}
