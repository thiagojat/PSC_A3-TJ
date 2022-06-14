package pControllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import pClasses.*;
import pDAO.Aluno_CursoDAO;

public class Aluno_CursoController {
	Aluno_CursoDAO acd = new Aluno_CursoDAO();
	CursoController cc = new CursoController();
	
	public void matricularAluno(Aluno a, Curso c) {
		int capacidade = c.getSala().getCapacidadeMax();
		int count = acd.getCount(c);
		
		if(count++<=capacidade) {
			acd.matricularAluno(a, c);
		}else {
			JOptionPane.showMessageDialog(null, "o imite de aludos desta sala foi excedida","Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public String listarAlunosEmCurso(Curso c) {
		String listagem = "";
		for(Aluno a : acd.listarAlunosEmCurso(c)) {
			listagem+= "\n     -" +a.getNomeCom()+",";
		}
		return listagem;
	}
}
