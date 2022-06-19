/*
 * Classe responsavel por comunicar o codigo com o sistema de banco de dados: inserindo, resgatando,
 * listando, editando e removendo dados.
 * 
 */

package pDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BD.Conector;
import pClasses.Curso;

public class CursoDAO {
	Connection conn = Conector.getConnection();
	ProfessorDAO pd = new ProfessorDAO();
	SalaDAO sd = new SalaDAO();
	
	/*metodo do tipo boleano que insere os valores de uma instancia de tipo Curso no sistema de banco de dados, 
	 *retornando true se esta insercao for sucedida e false se essa operacao for cancelada*/
	public boolean inserir(Curso curso) {
		String sql ="INSERT INTO curso(nome,carga_horaria, desc_curso, status, cod_func_curso, cod_sala_curso)VALUES(?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,curso.getNomeCurso());
			stmt.setString(2,""+curso.getCargaHor());
			stmt.setString(3,""+curso.getDescCurso());
			stmt.setBoolean(4, curso.isAtivo());
			stmt.setString(5, curso.getProfessor().getCodFuncionario());
			stmt.setString(6, ""+curso.getSala().getCodSala());

			stmt.execute();
			return true;
		}catch(SQLException ex){
			System.out.println(ex);
			return false;
		}
		finally {Conector.CloseConnection(conn, stmt);}
	}

	public boolean cursoExists(int cod_curso) {
		String sql = "SELECT * FROM aluno WHERE cod_curso=?";
		PreparedStatement stmt = null;
		ResultSet resultado = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,cod_curso);
			resultado = stmt.executeQuery();
			if(resultado.next()) {
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException e) {
			System.out.println(e);
			return false;
		}
		finally {Conector.CloseConnection(conn, stmt, resultado);}
	}
	
	/*Metodo do tipo lista que retorna uma lista de todos os cursos registrados no sistema de banco de dados*/
	public List<Curso>listar(){
		String sql  = "SELECT * FROM curso";
		List<Curso> cursos = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet resultado = null;
		try {
			stmt = conn.prepareStatement(sql);
			resultado = stmt.executeQuery();
			while(resultado.next()){
				Curso c =new Curso();
				c.setCodigoCurso(resultado.getInt("cod_curso"));
				c.setNomeCurso(resultado.getString("nome"));
				c.setCargaHor(resultado.getInt("carga_horaria"));
				c.setDescCurso(resultado.getString("desc_curso"));
				c.setAtivo(resultado.getBoolean("status"));
				c.setProfessor(pd.getProfessorWithIndex(resultado.getInt("cod_func_curso")));
				c.setSala(sd.getSalaWithIndex(resultado.getInt("cod_sala_curso")));
				
				cursos.add(c);
			}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		finally {Conector.CloseConnection(conn, stmt, resultado);}
		return cursos;
	}
	
	/*Metodo do tipo lista que retorna uma lista de todos os cursos ativos registrados no sistema de banco de dados*/
	public List<Curso>listarAtivos(){
		String sql  = "SELECT * FROM curso WHERE status=true";
		List<Curso> cursos = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet resultado = null;
		try {
			stmt = conn.prepareStatement(sql);
			resultado = stmt.executeQuery();
			while(resultado.next()){
				Curso c =new Curso();
				c.setCodigoCurso(resultado.getInt("cod_curso"));
				c.setNomeCurso(resultado.getString("nome"));
				c.setCargaHor(resultado.getInt("carga_horaria"));
				c.setDescCurso(resultado.getString("desc_curso"));
				c.setAtivo(resultado.getBoolean("status"));
				c.setProfessor(pd.getProfessorWithIndex(resultado.getInt("cod_func_curso")));
				
				cursos.add(c);
			}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		finally {Conector.CloseConnection(conn, stmt, resultado);}
		return cursos;
	}
	
	/*Metodo do tipo lista que retorna uma lista de todos os cursos inativos registrados no sistema de banco de dados*/
	public List<Curso>listarInativos(){
		String sql  = "SELECT * FROM curso WHERE status=false";
		List<Curso> cursos = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet resultado = null;
		try {
			stmt = conn.prepareStatement(sql);
			resultado = stmt.executeQuery();
			while(resultado.next()){
				Curso c =new Curso();
				c.setCodigoCurso(resultado.getInt("cod_curso"));
				c.setNomeCurso(resultado.getString("nome"));
				c.setCargaHor(resultado.getInt("carga_horaria"));
				c.setDescCurso(resultado.getString("desc_curso"));
				c.setAtivo(resultado.getBoolean("status"));
				c.setProfessor(pd.getProfessorWithIndex(resultado.getInt("cod_func_curso")));
				
				cursos.add(c);
			}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		finally {Conector.CloseConnection(conn, stmt, resultado);}
		return cursos;
	}
	
	/*Metodo do tipo Curso que retorna uma instancia do tipo Curso apartir de um cod_curso especifico*/
	public Curso getCursoWithId(int cod_curso){
		String sql  = "SELECT * FROM curso WHERE cod_curso=?";
		Curso c = new Curso();
		PreparedStatement stmt = null;
		ResultSet resultado = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cod_curso);
			resultado = stmt.executeQuery();
			while(resultado.next()){
				c.setCodigoCurso(resultado.getInt("cod_curso"));
				c.setNomeCurso(resultado.getString("nome"));
				c.setCargaHor(resultado.getInt("carga_horaria"));
				c.setDescCurso(resultado.getString("desc_curso"));
				c.setAtivo(resultado.getBoolean("status"));
				c.setProfessor(pd.getProfessorWithIndex(resultado.getInt("cod_func_curso")));
			}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		finally {Conector.CloseConnection(conn, stmt, resultado);}
		return c;
	}
	
	/*Metodo do tipo void que altera os dados de um Curso que o cod_curso seja igual ao id, usando valores de uma instancia
	 *do tipo curso para inserir novos valores.*/
	public void alteraCurso(Curso curso, int id) {
        String sql = "UPDATE curso SET nome=?, carga_horaria=?, desc_curso=?, status=? WHERE cod_curso=?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNomeCurso());
            stmt.setString(2, "" + curso.getCargaHor());
            stmt.setString(3, curso.getDescCurso());
            stmt.setBoolean(4, curso.isAtivo());
            stmt.setString(5, "" + id);
            stmt.execute();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        finally {Conector.CloseConnection(conn, stmt);}
    }
	
	/*Metodo do tipo void que altera o status de um curso apartir de seu cod_curso.*/
	public void setStatus(Curso curso, int id) {
        String sql = "UPDATE curso SET status=? WHERE cod_curso=?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setBoolean(1,curso.isAtivo());
            stmt.setString(2, "" + id);
            stmt.execute();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        finally {Conector.CloseConnection(conn, stmt);}
    }

}
