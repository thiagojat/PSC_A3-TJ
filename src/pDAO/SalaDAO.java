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
import pClasses.Sala;

public class SalaDAO {

	Connection conn = Conector.getConnection();
	
	/*Metodo do tipo booleano que insere valores de uma instancia do tipo Sala no banco de dados. Caso esta inserção for sucedida,
	 *o metodo retorna true, caso contrario, retorna false.*/
	public boolean inserir(Sala sala) {
		String sql ="INSERT INTO sala(nome,lugar,capacidade)VALUES(?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,sala.getNomeSala());
			stmt.setString(2,sala.getLugarSala());
			stmt.setString(3,""+sala.getCapacidadeMax());

			stmt.execute();
			System.out.println("estoremo fml");
			return true;
		}catch(SQLException ex){
			System.out.println(ex);
			return false;
		}
	}

	/*Metodo do tipo lista que retorna uma lista de todas as salas registradas no banco de dados*/
	public List<Sala>listar(){
		String sql  = "SELECT * FROM sala";
		List<Sala> salas = new ArrayList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()){
				Sala s =new Sala();
				s.setCodSala(resultado.getInt("cod_sala"));
				s.setNomeSala(resultado.getString("nome"));
				s.setLugarSala(resultado.getString("lugar"));
				s.setCapacidadeMax(resultado.getInt("capacidade"));
				salas.add(s);
			}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		return salas;
	}
	
	/*Metodo do tipo Sala que retorna uma instancia do tipo Sala apartir de um cod_sala especifico*/
	public Sala getSalaWithIndex(int cod_sala) {
		String sql = "SELECT * FROM sala WHERE cod_sala=?";
		Sala s = new Sala();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,cod_sala);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()){
				s.setCodSala(resultado.getInt("cod_sala"));
				s.setNomeSala(resultado.getString("nome"));
				s.setLugarSala(resultado.getString("lugar"));
				s.setCapacidadeMax(resultado.getInt("capacidade"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return s;
	}
	
	/*Metodo do tipo void que altera os valores de sala de cod_sala = id, usando os valores de uma instancia do tipo Sala como
	 *referencia*/
	public void alteraSala(Sala sala, int id) {
        String sql = "UPDATE sala SET nome=?, lugar=?, capacidade=? WHERE cod_sala=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, sala.getNomeSala());
            stmt.setString(2, sala.getLugarSala());
            stmt.setString(3, ""+sala.getCapacidadeMax());
            stmt.setString(4, "" + id);
            stmt.execute();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
	
	/*Metodo do tipo booleano que remove  no banco de dados. Caso esta inserção for sucedida,
	 *o metodo retorna true, caso contrario, retorna false.*/
	public boolean remover(Integer id){
		String sql="DELETE FROM sala WHERE cod_sala=?";
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
