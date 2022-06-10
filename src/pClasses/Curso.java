package pClasses;

import java.util.ArrayList;


public class Curso {
	private String nomeCurso;
	private int codigoCurso;
	private boolean ativo;
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

	public Curso() {
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public int getCodigoCurso() {
		return codigoCurso;
	}


	public void setCodigoCurso(int codigoCurso) {
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

	public void setAlunosMat(ArrayList<Aluno> alunosMat) {
		this.alunosMat = alunosMat;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunosMat;
	}
	public boolean isAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	@Override
	public String toString() {
		return "Curso\n"
				+ "Nome: " + getNomeCurso() + ";\n"
				+ "Codigo: " + getCodigoCurso() + ";\n"
				+ "Ativo: " + isAtivo() + ";\n"
				+ "Professor: " + getProfessor() + ";\n"
				+ "Sala: " + getSala() + ";\n"
				+ "Carga Horaria: " + getCargaHor() + ";\n"
				+ "Descrição: " + getDescCurso() + ";\n"
				+ "Alunos" + getAlunos()+";\n";
	}


}
