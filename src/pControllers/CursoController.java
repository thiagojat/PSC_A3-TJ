package pControllers;

import pClasses.*;

public class CursoController {
	
	private boolean alunoJaMatriculado(Curso curso, Aluno aluno) {
		for (int i = 0; i < curso.getAlunos().size(); i++) {
			if(aluno.getMatricula() == curso.getAlunos().get(i).getMatricula()) {
				return true;
			}
		}
		return false;
		
	}
	
	public boolean matricularAluno(Curso curso, Aluno aluno) {
		if(curso.getSala().getCapacidadeMax()<=curso.getAlunos().size()) {
			System.out.println("Nao foi possivel adicionar o aluno, a sala nao comporta mais alunos.");
			return false;
		}else {
			if(!alunoJaMatriculado(curso, aluno)) {
				curso.getAlunos().add(aluno);
				System.out.println("O aluno "+ aluno.getNomeCom()+" matriculado no curso "+ curso.getNomeCurso()+"!");
				return true;
			}else {
				System.out.println("O aluno "+ aluno.getNomeCom()+" ja esta matriculado no curso "+ curso.getNomeCurso()+"!");
				return true;
			}
		}
	}

	
}
