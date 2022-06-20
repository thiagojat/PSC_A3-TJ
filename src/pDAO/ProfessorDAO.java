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
import pClasses.Professor;

public class ProfessorDAO {
	Connection conn = Conector.getConnection();

	/*Metodo booleano que insere os dados no banco de dados de um professor a partir de uma instancia do tipo Professor.
	 *Se esta insercao for sucedida, retorna true, se não, retorna false.*/
	public boolean inserir(Professor professor) {
		String sql ="INSERT INTO professor(nome,cpf,endereco,email,celular)VALUES(?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,professor.getNomeCom());
			stmt.setString(2,professor.getCpf());
			stmt.setString(3,professor.getEndereco());
			stmt.setString(4,professor.getEmail());
			stmt.setString(5,""+professor.getNumCel());

			stmt.execute();
			return true;
		}catch(SQLException ex){
			System.out.println(ex);
			return false;
		}
	}
	
	public boolean professorExists(int cod_func) {
		String sql = "SELECT * FROM professor WHERE cod_func=?";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,cod_func);
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
	
	/*Metodo do tipo List que retorna do banco de dados uma lista com todos os professores registrados no banco de dados.*/
	public List<Professor>listar(){
		String sql  = "SELECT * FROM professor";
		List<Professor> professores = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet resultado = null;
		try {
			stmt = conn.prepareStatement(sql);
			resultado = stmt.executeQuery();
			while(resultado.next()){
				Professor p =new Professor();
				p.setCodFuncionario(resultado.getString("cod_func"));
				p.setNomeCom(resultado.getString("nome"));
				p.setCpf(resultado.getString("cpf"));
				p.setEndereco(resultado.getString("endereco"));
				p.setEmail(resultado.getString("email"));
				p.setNumCel(resultado.getLong("celular"));
				professores.add(p);
			}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		return professores;
	}
	
	/*Metodo do tipo Professor que retorna uma instancia do tipo Professor a partir de um cod_func especifico.*/
	public Professor getProfessorWithIndex(int codFuncionario) {
		String sql = "SELECT * FROM professor WHERE cod_func=?";
		Professor p = new Professor();
		PreparedStatement stmt = null;
		ResultSet resultado = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,codFuncionario);
			resultado = stmt.executeQuery();
			while(resultado.next()){
				p.setCodFuncionario(resultado.getString("cod_func"));
				p.setNomeCom(resultado.getString("nome"));
				p.setCpf(resultado.getString("cpf"));
				p.setEndereco(resultado.getString("endereco"));
				p.setEmail(resultado.getString("email"));
				p.setNumCel(resultado.getLong("celular"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return p;
	}
	
	/*Metodo od tipo void que altera os valores de um professor de codi_func especifico a partir dos valores de uma instancia
	 *do tipo Professor.*/
	public void alteraProfessor(Professor professor, int id) {
        String sql = "UPDATE professor SET nome=?, cpf=?, endereco=?, email=?, celular=? WHERE cod_func=?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, professor.getNomeCom());
            stmt.setString(2, "" + professor.getCpf());
            stmt.setString(3, professor.getEndereco());
            stmt.setString(4, professor.getEmail());
            stmt.setString(5, professor.getNumCel() + "");
            stmt.setString(6, "" + id);
            stmt.execute();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
	
	/*Metodo do tipo booleano que remove os registros de um professor especifico a partir de um cod_func especifico(id)*/
	public boolean remover(Integer id){
		String sql="DELETE FROM professor WHERE cod_func=?";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,id);
			stmt.execute();
			return true;
		}catch(SQLException ex){
			System.out.println(ex);
			return false;  
		}  
	}
}
