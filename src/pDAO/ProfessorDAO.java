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
	//nomeCom, cpf, endereco, email, numCel

	public boolean inserir(Professor Professor) {
		String sql ="INSERT INTO professor(nome,cpf,endereco,email,celular)VALUES(?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,Professor.getNomeCom());
			stmt.setString(2,""+Professor.getCpf());
			stmt.setString(3,Professor.getEndereco());
			stmt.setString(4,Professor.getEmail());
			stmt.setString(5,""+Professor.getNumCel());

			stmt.execute();
			System.out.println("estoremo fml");
			return true;
		}catch(SQLException ex){
			System.out.println(ex);
			return false;
		}
	}

	public List<Professor>listar(){
		String sql  = "SELECT * FROM professor";
		List<Professor> professores = new ArrayList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()){
				Professor p =new Professor();
				p.setCodFuncionario(resultado.getInt("cod_func"));
				p.setNomeCom(resultado.getString("nome"));
				p.setCpf(resultado.getLong("cpf"));
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
	
	public void alteraProfessor(Professor professor, int id) {
        String sql = "UPDATE professor SET nome=?, cpf=?, endereco=?, email=?, celular=? WHERE cod_func=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
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

}
