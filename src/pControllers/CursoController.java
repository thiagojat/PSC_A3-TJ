package pControllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import pClasses.*;
import pDAO.CursoDAO;

public class CursoController {
	CursoDAO cd = new CursoDAO();

	public void menu() {
		String inputValue = JOptionPane.showInputDialog(""
				+ "O que deseja fazer?\n"
				+ "1 - Listar cursos\n"
				+ "2 - Alterar curso\n"
				+ "3 - Ativar curso\n"
				+ "4 - Desativar curso\n"
				+ "5 - Cadastrar curso\n");
		int op = Integer.valueOf(inputValue);
		switch(op) {
		case 1:
			listarMenu();
			break;
		case 2:
			alterarCurso();
			break;
		case 3:
			ativarCurso();
			break;
		case 4:
			desativarCurso();
			break;
		case 5:
			cadastrarCurso();
		default:
			JOptionPane.showMessageDialog(null, "Insira uma opcao valida","Erro", JOptionPane.ERROR_MESSAGE);
			menu();
		}
	}

	public void cadastrarCurso() {
		Curso c = new Curso();

		c.setNomeCurso(JOptionPane.showInputDialog("Digite o nome do curso"));
		c.setCargaHor(Integer.valueOf(JOptionPane.showInputDialog("Digite a carga horaria do curso")));
		c.setDescCurso(JOptionPane.showInputDialog("Digite uma descrição para o curso"));
		c.setAtivo(true);
		
		cd.inserir(c);
	}
	
	public void listarMenu() {
		String inputValue = JOptionPane.showInputDialog(""
				+ "O que deseja fazer?\n"
				+ "1 - Listar todos os cursos\n"
				+ "2 - Listar cursos ativos\n"
				+ "3 - Listar cursos inativos\n");
		int op = Integer.valueOf(inputValue);
		switch(op) {
		case 1:
			listarCurso();
			break;
		case 2:
			listarCurso(true);
			break;
		case 3:
			listarCurso(false);
		default:
			JOptionPane.showMessageDialog(null, "Insira uma opcao valida","Erro", JOptionPane.ERROR_MESSAGE);
			listarMenu();
		}
	}

	public void listarCurso(){
		String sCursos = listagemCurso();
		JOptionPane.showMessageDialog(null, sCursos, "Lista de cursos", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void listarCurso(Boolean bool){
		String sCursos = listagemCurso(bool);
		JOptionPane.showMessageDialog(null, sCursos, "Lista de cursos", JOptionPane.PLAIN_MESSAGE);
	}
	
	
	public void alterarCurso() {

        Curso c = new Curso();
        int id;
        ArrayList<Curso> alunos = (ArrayList<Curso>)cd.listar();
        String listagem = "";
        for (Curso cc : alunos) {
            listagem += ""
					+ "Curso\n"
					+ "Codigo do curso: " + cc.getCodigoCurso()+";\n"
					+ "Nome do curso: "+cc.getNomeCurso()+"\n";
        }
        id = Integer.parseInt(JOptionPane.showInputDialog(null, listagem + "Digite o codigo do curso que deseja alterar: "));

        c.setNomeCurso(JOptionPane.showInputDialog("Digite o nome: ", alunos.get(id-1).getNomeCurso()));
        c.setCargaHor(Integer.valueOf(JOptionPane.showInputDialog("Digite a carga horaria: ", alunos.get(id-1).getCargaHor())));
        c.setDescCurso(JOptionPane.showInputDialog("Digite a desclição do curso: ", alunos.get(id-1).getDescCurso()));

        cd.alteraCurso(c, id);
    }
	
	public void ativarCurso() {

        Curso c = new Curso();
        int id;
        String listagem = listagemCurso(false);
        id = Integer.parseInt(JOptionPane.showInputDialog(null, listagem + "Digite o codigo do curso que deseja ativar: "));

        c.setAtivo(true);

        cd.setAtivo(c, id);
    }
	
	public void desativarCurso() {

        Curso c = new Curso();
        int id;
        String listagem = listagemCurso(false);
        id = Integer.parseInt(JOptionPane.showInputDialog(null, listagem + "Digite o codigo do curso que deseja desativar: "));

        c.setAtivo(false);

        cd.setAtivo(c, id);
    }
	
	private String listagemCurso() {
		String sCursos = "";
		ArrayList<Curso> aCursos = new ArrayList<>();
		aCursos = (ArrayList<Curso>) cd.listar();
		for(Curso c : aCursos) {
			sCursos += c.toString() + "\n";
		}
		return sCursos;
	}
	
	private String listagemCurso(Boolean bool) {
		String sCursos = "";
		ArrayList<Curso> aCursos = new ArrayList<>();
		aCursos = (ArrayList<Curso>) cd.listar();
		for(Curso c : aCursos) {
			if(c.isAtivo() == bool) {
				sCursos += ""
						+ "Curso\n"
						+ "Ativo: " + c.isAtivo()+";\n"
						+ "Codigo do curso: " + c.getCodigoCurso()+";\n"
						+ "Nome do curso: "+c.getNomeCurso()+"\n";
			}
		}
		return sCursos;
	}
	
	//	private boolean alunoJaMatriculado(Curso curso, Aluno aluno) {
	//		for (int i = 0; i < curso.getAlunos().size(); i++) {
	//			if(aluno.getMatricula() == curso.getAlunos().get(i).getMatricula()) {
	//				return true;
	//			}
	//		}
	//		return false;
	//		
	//	}
	//	
	//	public boolean matricularAluno(Curso curso, Aluno aluno) {
	//		if(curso.getSala().getCapacidadeMax()<=curso.getAlunos().size()) {
	//			System.out.println("Nao foi possivel adicionar o aluno, c sala nao comporta mais alunos.");
	//			return false;
	//		}else {
	//			if(!alunoJaMatriculado(curso, aluno)) {
	//				curso.getAlunos().add(aluno);
	//				System.out.println("O aluno "+ aluno.getNomeCom()+" matriculado no curso "+ curso.getNomeCurso()+"!");
	//				return true;
	//			}else {
	//				System.out.println("O aluno "+ aluno.getNomeCom()+" ja esta matriculado no curso "+ curso.getNomeCurso()+"!");
	//				return true;
	//			}
	//		}
	//	}



}
