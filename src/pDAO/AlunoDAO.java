
/*
 * Classe responsavel por comunicar o codigo com o sistema de banco de dados: inserindo, resgatando,
 * listando, editando e removendo dados.
 * 
 * */
package pDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BD.*;
import pClasses.Aluno;

public class AlunoDAO {
	Connection conn = Conector.getConnection();
	
	/*metodo do tipo booleano que insere os valores de uma instancia do tipo Aluno no banco de dado, retornando true se esta inserção
	 *for sucedida e false se for fracassada*/
	public boolean inserir(Aluno aluno) {
		String sql ="INSERT INTO aluno(nome,cpf,endereco,email,celular)VALUES(?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,aluno.getNomeCom());
			stmt.setString(2,aluno.getCpf());
			stmt.setString(3,aluno.getEndereco());
			stmt.setString(4,aluno.getEmail());
			stmt.setString(5,""+aluno.getNumCel());

			stmt.execute();
			return true;
		}catch(SQLException ex){
			System.out.println(ex);
			return false;
		}
		finally {Conector.CloseConnection(conn, stmt);}
		
	}
	
	/*metodo do tipo List que retorna uma lista de todos os alunos cadastrados no sistema.*/
	public List<Aluno>listar(){
		String sql  = "SELECT * FROM aluno";
		List<Aluno> alunos = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet resultado = null;
		try {
			stmt = conn.prepareStatement(sql);
			resultado = stmt.executeQuery();
			while(resultado.next()){
				Aluno a =new Aluno();
				a.setMatricula(resultado.getString("matricula"));
				a.setNomeCom(resultado.getString("nome"));
				a.setCpf(resultado.getString("cpf"));
				a.setEndereco(resultado.getString("endereco"));
				a.setEmail(resultado.getString("email"));
				a.setNumCel(resultado.getLong("celular"));
				alunos.add(a);
			}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		finally {Conector.CloseConnection(conn, stmt, resultado);}
		return alunos;
	}
	
	public boolean alunoExists(int matricula) {
		String sql = "SELECT * FROM aluno WHERE matricula=?";
		PreparedStatement stmt = null;
		ResultSet resultado = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,matricula);
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
	
	/*metodo do tipo Aluno que retorna uma instancia de um tipo Aluno de matricula especifica.*/
	public Aluno getAlunoWithIndex(int matricula) {
		String sql = "SELECT * FROM aluno WHERE matricula=?";
		Aluno a = new Aluno();
		PreparedStatement stmt = null;
		ResultSet resultado = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,matricula);
			resultado = stmt.executeQuery();
			while(resultado.next()){
				a.setMatricula(resultado.getString("matricula"));
				a.setNomeCom(resultado.getString("nome"));
				a.setCpf(resultado.getString("cpf"));
				a.setEndereco(resultado.getString("endereco"));
				a.setEmail(resultado.getString("email"));
				a.setNumCel(resultado.getLong("celular"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		finally {Conector.CloseConnection(conn, stmt, resultado);}
		return a;
	}
	
	/*metodo do tipo void que altera os dados de um aluno de matricula especifica, usando os valores de uma instancia do tipo Aluno*/
	public void alteraAluno(Aluno aluno, int id) {
		String sql = "UPDATE aluno SET nome=?, cpf=?, endereco=?, email=?, celular=? WHERE matricula=?";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, aluno.getNomeCom());
			stmt.setString(2, "" + aluno.getCpf());
			stmt.setString(3, aluno.getEndereco());
			stmt.setString(4, aluno.getEmail());
			stmt.setString(5, aluno.getNumCel() + "");
			stmt.setString(6, "" + id);
			stmt.execute();
		}catch(SQLException ex){
			System.out.println(ex);
		}
		finally {Conector.CloseConnection(conn, stmt);}
	}

	/*metodo do tipo booleano que remove um aluno de matricula especifica dos regitros de banco de dados*/
	public boolean remover(Integer id){
		String sql="DELETE FROM aluno WHERE matricula=?";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,id);
			stmt.execute();
			System.out.println("excluido");
			return true;
		}catch(SQLException ex){
			System.out.println(ex);
			return false;  
		}  
		finally {Conector.CloseConnection(conn, stmt);}
	}



}
