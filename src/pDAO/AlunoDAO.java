
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
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
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
	}
	
	/*metodo do tipo List que retorna uma lista de todos os alunos cadastrados no sistema.*/
	public List<Aluno>listar(){
		String sql  = "SELECT * FROM aluno";
		List<Aluno> alunos = new ArrayList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
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
		return alunos;
	}
	
	public boolean alunoExists(int matricula) {
		String sql = "SELECT * FROM aluno WHERE matricula=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,matricula);
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
	
	/*metodo do tipo Aluno que retorna uma instancia de um tipo Aluno de matricula especifica.*/
	public Aluno getAlunoWithIndex(int matricula) {
		String sql = "SELECT * FROM aluno WHERE matricula=?";
		Aluno a = new Aluno();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,matricula);
			ResultSet resultado = stmt.executeQuery();
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
		return a;
	}
	
	/*metodo do tipo void que altera os dados de um aluno de matricula especifica, usando os valores de uma instancia do tipo Aluno*/
	public void alteraAluno(Aluno aluno, int id) {
		String sql = "UPDATE aluno SET nome=?, cpf=?, endereco=?, email=?, celular=? WHERE matricula=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
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
	}

	/*metodo do tipo booleano que remove um aluno de matricula especifica dos regitros de banco de dados*/
	public boolean remover(Integer id){
		String sql="DELETE FROM aluno WHERE matricula=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,id);
			stmt.execute();
			System.out.println("excluido");
			return true;
		}catch(SQLException ex){
			System.out.println(ex);
			return false;  
		}  
	}



}
