/*
 * Classe que coontrola a relação entre aluno e curso.
 * */

package pControllers;

import javax.swing.JOptionPane;
import pClasses.*;
import pDAO.Aluno_CursoDAO;

public class Aluno_CursoController {
	Aluno_CursoDAO acd = new Aluno_CursoDAO();
	CursoController cc = new CursoController();
	
	/*
	 * método do tipo void que consulta os alunos matriculados em um curso, compara com a capacidade da sala em que o curso é alocado
	 * e se for menor, chama o método para inserir a matricula do aluno no banco de dados. 
	 */
	public void matricularAluno(Aluno a, Curso c) {
		int capacidade = c.getSala().getCapacidadeMax();
		int count = acd.getCount(c);
		
		if(count++<=capacidade) {
			acd.matricularAluno(a, c);
		}else {
			JOptionPane.showMessageDialog(null, "o imite de aludos desta sala foi excedida","Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/*método do tipo String que usa uma lista recuperada de Aluno_CursoDAO e constrói uma string com todos os nome de alunos
	 *listados em curso c
	 */
	public String listarAlunosEmCurso(Curso c) {
		String listagem = "";
		for(Aluno a : acd.listarAlunosEmCurso(c)) {
			listagem+= "\n     -" +a.getNomeCom()+",";
		}
		return listagem;
	}
}
