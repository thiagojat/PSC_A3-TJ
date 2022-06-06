package main_package;

import java.util.ArrayList;

public class Main {
	public static ArrayList<Curso> cursos = new ArrayList<>();
	public static ArrayList<Sala> salas = new ArrayList<>();
	public static ArrayList<Professor> professores = new ArrayList<>();
	public static ArrayList<Aluno> alunos= new ArrayList<>();
	
	public static void main(String[] args) {
		Aluno a1 = new Aluno("Thiago Jose", "05289383042", "Rua Dos Bobos Nº2", "techerajathiago@gmai.com", "51996092362");
		Professor p1 = new Professor("Leonardo Amaral", "165484165", "Rua Dos Bobos Nº0", "email@dominio.com", "51996925954");
		Sala s1 = new Sala("101", "Predio 2", 0);
		Curso c1 = new Curso(p1, s1, "Programação e Soluções Computacionais", 60, "Programação");
		c1.matricularAluno(a1);
	}
}
