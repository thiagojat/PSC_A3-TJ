package main_package;

import java.util.ArrayList;

public class Main {
	public static ArrayList<Curso> cursos = new ArrayList<>();
	public static ArrayList<Sala> salas = new ArrayList<>();
	public static ArrayList<Professor> professores = new ArrayList<>();
	public static ArrayList<Aluno> alunos= new ArrayList<>();
	
	public static void main(String[] args) {
		
		//CADASTRAMENTO 
		Aluno a1 = new Aluno("Thiago Jose", "05289383042", "Rua Dos Bobos Nº2", "techerajathiago@gmail.com", "51996092362");
		Professor p1 = new Professor("Leonardo Amaral", "165484165", "Rua Dos Bobos Nº0", "email@dominio.com", "51996925954");
		Sala s1 = new Sala("101", "Predio 2", 50);
		Curso c1 = new Curso(p1, s1, "Programacao e Solucoes Computacionais", 60, "Programacao");
		
		//MATRICULA
		c1.matricularAluno(a1);
		
		//RELATORIO
		System.out.println("\n-----------R E L A T O R I O-----------\n\n");
		for (Curso c : cursos) {
			System.out.println(c.toString());
		}
		System.out.println("----F I M---D O---R E L A T O R I O----\n");
		System.out.println(""
				+ "Neste sistema estão cadastrados\n"
				+ cursos.size()+" cursos;\n"
				+ salas.size() +" salas;\n"
				+ professores.size()+" professores;\n"
				+ alunos.size()+ " alunos");
	}
}
