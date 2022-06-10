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
	// nomeSala, local, capacidade

	public boolean inserir(Sala sala) {
		String sql ="INSERT INTO sala(nome,local,capacidade)VALUES(?,?,?)";
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
				s.setLugarSala(resultado.getString("local"));
				s.setCapacidadeMax(resultado.getInt("capacidade"));
				salas.add(s);
			}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		return salas;
	}
	
	public void alteraSala(Sala sala, int id) {
        String sql = "UPDATE sala SET nome=?, local=?, capacidade=? WHERE cod_sala=?";
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
	
	public boolean remover(Integer id){
		String sql="DELETE FROM aluno WHERE cod_sala=?";
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
