package pDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BD.Conector;
import pClasses.Aluno;
import pClasses.Curso;

public class Aluno_CursoDAO {
	Connection conn = Conector.getConnection();
	ProfessorDAO pd = new ProfessorDAO();
	AlunoDAO ad = new AlunoDAO();

	public boolean matricularAluno(Aluno a, Curso c) {
		String sql = "INSERT INTO alunocurso (r_matricula, r_cod_curso) VALUES (?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, a.getMatricula());
			stmt.setInt(2, c.getCodigoCurso());
			
			stmt.execute();
			return true;
		}catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public ArrayList<Aluno> listarAlunosEmCurso(Curso c) {
		ArrayList<Aluno> alunos = new ArrayList<>();
		String sql = "SELECT aluno.matricula FROM aluno, alunocurso WHERE aluno.matricula=r_matricula AND r_cod_curso=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,c.getCodigoCurso());
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()){
				int id = resultado.getInt("matricula");
				Aluno a = ad.getAlunoWithIndex(id);
				alunos.add(a);
			}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		return alunos;
	}

	public int getCount(Curso c) {
		int count;
		String sql = "SELECT COUNT(alunocurso.cod_curso) FROM alunocurso, curso WHERE alunocurso.cod_curso=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, c.getCodigoCurso());
			ResultSet resultado = stmt.executeQuery();
			count = resultado.getInt("COUNT(alunocurso.r_cod_curso)");
			return count;
		}catch (SQLException e) {
			System.out.println(e);
			return 0;
		}
	}
	public int getCount(int c) {
		int count =0;
		String sql = "SELECT COUNT(r_cod_curso) AS count FROM alunocurso WHERE r_cod_curso=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, c);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				count = resultado.getInt("count");
			}
			return count;
		}catch (SQLException e) {
			System.out.println(e);
			return 1000000;
		}
	}
}
