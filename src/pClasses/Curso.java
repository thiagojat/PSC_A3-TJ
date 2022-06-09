package pClasses;

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
		//Main.cursos.add(this);
		this.setProfessor(professor);
		this.setSala(sala);
		this.setCodigoCurso(codigoCurso);
		this.nomeCurso = nomeCurso;
		this.cargaHor = cargaHor;
		this.descCurso = descCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public ArrayList<Aluno> getAlunosMat() {
		return alunosMat;
	}

	public void setAlunosMat(ArrayList<Aluno> alunosMat) {
		this.alunosMat = alunosMat;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunosMat;
	}
}
