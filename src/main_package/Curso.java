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
		Main.cursos.add(this);
		this.setProfessor(professor);
		this.setSala(sala);
		this.setCodigoCurso();
		this.nomeCurso = nomeCurso;
		this.cargaHor = cargaHor;
		this.descCurso = descCurso;
	}
	private boolean alunoJaMatriculado(Aluno aluno) {
		for (int i = 0; i < alunosMat.size(); i++) {
			if(aluno.getMatricula() == alunosMat.get(i).getMatricula()) {
				return true;
			}
		}
		return false;
		
	}
	
	public boolean matricularAluno(Aluno aluno) {
		if(this.getSala().getCapacidadeMax()<=alunosMat.size()) {
			System.out.println("Nao foi possivel adicionar o aluno, a sala nao comporta mais alunos.");
			return false;
		}else {
			if(!alunoJaMatriculado(aluno)) {
				alunosMat.add(aluno);
				System.out.println("O aluno "+ aluno.getNomeCom()+" matriculado no curso "+ this.getNomeCurso()+"!");
				return true;
			}else {
				System.out.println("O aluno "+ aluno.getNomeCom()+" ja esta matriculado no curso "+ this.getNomeCurso()+"!");
				return true;
			}
		}
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	private void setCodigoCurso() {
		this.codigoCurso = "" + (Main.cursos.size());
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
	
	private String nomeAlunos() {
		if(alunosMat.size()>0) {
			String lista = "";
			for (int i = 0; i < alunosMat.size(); i++) {
				lista += "\t" + alunosMat.get(i).getNomeCom()+ ";\n";
			}
			return "Ha " + alunosMat.size() + " aluno(s) neste curso.\n" + lista;
		}else return "Nao ha alunos matriculados neste curso.";
	}

	@Override
	public String toString() {
		return "Curso -" + getNomeCurso()+"-\n"
				+ "Codigo: "+ getCodigoCurso() + ";\n"
				+ "Carga Hor.: " + getCargaHor() + ";\n"
				+ "Descrcao: "+ getDescCurso() + ";\n"
				+ "Sala: " + getSala().getNomeSala() + ";\n"
				+ "Professor: " + getProfessor().getNomeCom() + ";\n"
				+ nomeAlunos() + "\n";
	}
	
}
