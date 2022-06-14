package pControllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import pClasses.*;
import pDAO.*;
import pDAO.SalaDAO;

public class CursoController {
	AlunoDAO ad = new AlunoDAO();
	CursoDAO cd = new CursoDAO();
	Aluno_CursoDAO acd = new Aluno_CursoDAO();
	ProfessorDAO pd = new ProfessorDAO();
	SalaDAO sd = new SalaDAO();

	public void menu() {
		String inputValue = JOptionPane.showInputDialog(""
				+ "O que deseja fazer?\n"
				+ "1 - Listar cursos\n"
				+ "2 - Alterar curso\n"
				+ "3 - Ativar curso\n"
				+ "4 - Desativar curso\n"
				+ "5 - Cadastrar curso\n"
				+ "6 - Matricular aluno em um curso\n");
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
			break;
		case 6:
			matricularAluno();
		default:
			JOptionPane.showMessageDialog(null, "Insira uma opcao valida","Erro", JOptionPane.ERROR_MESSAGE);
			menu();
		}
	}
	
	public void matricularAluno() {
		
		Aluno[] alunos = new Aluno[ad.listar().size()];
		int count = 0;
		for(Aluno c : ad.listar()) {
			alunos[count] = c;
			count++;
		}
		Object aluno = JOptionPane.showInputDialog(null,"Escolha um Aluno", "Aluno", JOptionPane.INFORMATION_MESSAGE, null, alunos,alunos[0]);
		Curso[] cursos = new Curso[ad.listar().size()];
		count = 0;
		for(Curso c : cd.listar()) {
			cursos[count] = c;
			count++;
		}
		Object curso = JOptionPane.showInputDialog(null,"Escolha um Curso", "Curso", JOptionPane.INFORMATION_MESSAGE, null, cursos,cursos[0]);
		
		acd.matricularAluno((Aluno)aluno, (Curso)curso);	
		
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
			listarCursosAtivos();
			break;
		case 3:
			listarCursosInativos();
		default:
			JOptionPane.showMessageDialog(null, "Insira uma opcao valida","Erro", JOptionPane.ERROR_MESSAGE);
			listarMenu();
		}
	}

	public void cadastrarCurso() {
		Curso c = new Curso();

		c.setNomeCurso(JOptionPane.showInputDialog("Digite o nome do curso"));
		Professor[] profs = new Professor[pd.listar().size()];
		int count = 0;
		for(Professor p : pd.listar()) {
			profs[count] = p;
			count++;
		}
		Object prof = JOptionPane.showInputDialog(null,"Escolha um professor", "Professor", JOptionPane.INFORMATION_MESSAGE, null, profs,profs[0]);
		c.setProfessor((Professor)prof);
		c.setCargaHor(Integer.valueOf(JOptionPane.showInputDialog("Digite a carga horaria do curso")));
		c.setDescCurso(JOptionPane.showInputDialog("Digite uma descrição para o curso"));
		Sala[] salas = new Sala[sd.listar().size()];
		count = 0;
		for(Sala s : sd.listar()) {
			salas[count] = s;
			count++;
		}
		Object sala = JOptionPane.showInputDialog(null,"Escolha um professor", "Professor", JOptionPane.INFORMATION_MESSAGE, null, salas,salas[0]);
		c.setSala((Sala)sala);
		c.setAtivo(true);
		
		cd.inserir(c);
	}

	public void listarCurso(){
		String sCursos = listagemCurso();
		JOptionPane.showMessageDialog(null, sCursos, "Lista de cursos", JOptionPane.PLAIN_MESSAGE);
	}
	public void listarCursosAtivos(){
		String sCursos = listagemCursosAtivos();
		JOptionPane.showMessageDialog(null, sCursos, "Lista de cursos", JOptionPane.PLAIN_MESSAGE);
	}
	public void listarCursosInativos(){
		String sCursos = listagemCursosInativos();
		JOptionPane.showMessageDialog(null, sCursos, "Lista de cursos", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void alterarCurso() {

        Curso c = new Curso();
        int id;
        ArrayList<Curso> cursos = (ArrayList<Curso>)cd.listar();
        String listagem = "";
        for (Curso cc : cursos) {
            listagem += ""
					+ "Curso\n"
					+ "Codigo do curso: " + cc.getCodigoCurso()+";\n"
					+ "Nome do curso: "+cc.getNomeCurso()+"\n";
        }
        id = Integer.parseInt(JOptionPane.showInputDialog(null, listagem + "Digite o codigo do curso que deseja alterar: "));

        c.setNomeCurso(JOptionPane.showInputDialog("Digite o nome: ", cd.getCursoWithId(id).getNomeCurso()));
        Professor[] profs = new Professor[pd.listar().size()];
		int count = 0;
		for(Professor p : pd.listar()) {
			profs[count] = p;
			count++;
		}
		Object prof = JOptionPane.showInputDialog(null,"Escolha um professor", "Professor", JOptionPane.INFORMATION_MESSAGE, null, profs,profs[0]);
		c.setProfessor((Professor)prof);
		c.setCargaHor(Integer.valueOf(JOptionPane.showInputDialog("Digite a carga horaria: ", cd.getCursoWithId(id).getCargaHor())));
		c.setDescCurso(JOptionPane.showInputDialog("Digite a descrição do curso: ", cd.getCursoWithId(id).getDescCurso()));
		Sala[] salas = new Sala[sd.listar().size()];
		count = 0;
		for(Sala s : sd.listar()) {
			salas[count] = s;
			count++;
		}
		Object sala = JOptionPane.showInputDialog(null,"Escolha um professor", "Professor", JOptionPane.INFORMATION_MESSAGE, null, salas,salas[0]);
		c.setSala((Sala)sala);
        

        cd.alteraCurso(c, id);
    }
	
	public void ativarCurso() {

        Curso c = new Curso();
        int id;
        String listagem = listagemCursosAtivos();
        id = Integer.parseInt(JOptionPane.showInputDialog(null, listagem + "Digite o codigo do curso que deseja ativar: "));

        c.setAtivo(true);

        cd.setStatus(c, id);
    }
	
	public void desativarCurso() {

        Curso c = new Curso();
        int id;
        String listagem = listagemCursosInativos();
        id = Integer.parseInt(JOptionPane.showInputDialog(null, listagem + "Digite o codigo do curso que deseja desativar: "));

        c.setAtivo(false);

        cd.setStatus(c, id);
    }
	
	private String listagemCurso() {
		String sCursos = "";
		ArrayList<Curso> aCursos = new ArrayList<>();
		aCursos = (ArrayList<Curso>) cd.listar();
		for(Curso c : aCursos) {
			sCursos += c.toStringAll() + "\n";
		}
		return sCursos;
	}
	
	private String listagemCursosAtivos() {
		String sCursos = "";
		ArrayList<Curso> aCursos = new ArrayList<>();
		aCursos = (ArrayList<Curso>) cd.listarAtivos();
		for(Curso c : aCursos) {
				sCursos += ""
						+ "Curso\n"
						+ "Ativo: " + c.isAtivo()+";\n"
						+ "Codigo do curso: " + c.getCodigoCurso()+";\n"
						+ "Nome do curso: "+c.getNomeCurso()+"\n";
		}
		return sCursos;
	}
	private String listagemCursosInativos() {
		String sCursos = "";
		ArrayList<Curso> aCursos = new ArrayList<>();
		aCursos = (ArrayList<Curso>) cd.listarInativos();
		for(Curso c : aCursos) {
				sCursos += ""
						+ "Curso\n"
						+ "Ativo: " + c.isAtivo()+";\n"
						+ "Codigo do curso: " + c.getCodigoCurso()+";\n"
						+ "Nome do curso: "+c.getNomeCurso()+"\n";
		}
		return sCursos;
	}

}
