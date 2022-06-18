
/*
 * Classe responsavel por comunicar o codigo com o sistema de banco de dados: inserindo, resgatando,
 * listando, editando e removendo dados.
 * 
 * */
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
	
	/*metodo que insere a matricula de um aluno matriculado e seu curso no banco de dados, retornando true 
	 *se a inserção for sucedida e retornado false se for falha.
	 */
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
	
	/*metodo que recebe do banco de dados todos os alunos matriculados em um curso c, retornando uma lista de todos eles.*/
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
	
	public boolean alunoExistsInCurso(Aluno a, Curso c) {
		String sql = "SELECT * FROM alunocurso WHERE r_matricula=? AND r_cod_curso=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,a.getMatricula());
			stmt.setInt(2,c.getCodigoCurso());
			
			ResultSet resultado = stmt.executeQuery();
			if(resultado.next()) {
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException e) {
			System.out.println(e);
			return false;
		}
	}
	
	/*metodo que retorna a contagem de quantos alunos existem inscritos em um curso específico, usando uma instancia do tipo curso*/
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
	
	/*metodo que retorna a contagem de quantos alunos existem inscritos em um curso específico, usando o cod_curso do curso desejado*/
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
