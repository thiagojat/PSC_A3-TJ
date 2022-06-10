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
	//nomeCom, cpf, endereco, email, numCel

	public boolean inserir(Aluno aluno) {
		String sql ="INSERT INTO aluno(nome,cpf,endereco,email,celular)VALUES(?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,aluno.getNomeCom());
			stmt.setString(2,""+aluno.getCpf());
			stmt.setString(3,aluno.getEndereco());
			stmt.setString(4,aluno.getEmail());
			stmt.setString(5,""+aluno.getNumCel());

			stmt.execute();
			System.out.println("estoremo fml");
			return true;
		}catch(SQLException ex){
			System.out.println(ex);
			return false;
		}
	}

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
				a.setCpf(resultado.getLong("cpf"));
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
