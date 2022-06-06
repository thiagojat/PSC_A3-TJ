package main_package;

import java.util.ArrayList;

public class Curso {
	private String nomeCurso;
	private String codigoCurso;
	private int cargaHor;
	private String descCurso;
	private Professor professor;
	private Sala sala;
	
	public ArrayList<Aluno> alunosMat = new ArrayList<>();
	
	public Curso(Professor professor, Sala sala, String nomeCurso, int cargaHor, String descCurso) {
		this.setProfessor(professor);
		this.setSala(sala);
		this.setCodigoCurso();
		this.nomeCurso = nomeCurso;
		this.cargaHor = cargaHor;
		this.descCurso = descCurso;
	}
	
	public boolean matricularAluno(Aluno aluno) {
		if(this.getSala().getCapacidadeMax()<=alunosMat.size()) {
			System.out.println("Nao foi possivel adicionar o aluno, a sala nao comporta mais alunos.");
			return false;
		}else {
			alunosMat.add(aluno);
			System.out.println("Aluno matriculado!");
			return true;
		}
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	private void setCodigoCurso() {
		this.codigoCurso = "" + (Main.cursos.size() + 1);
	}

	public int getCargaHor() {
		return cargaHor;
	}

	public void setCargaHor(int cargaHor) {
		this.cargaHor = cargaHor;
	}

	public String getDescCurso() {
		return descCurso;
	}

	public void setDescCurso(String descCurso) {
		this.descCurso = descCurso;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
