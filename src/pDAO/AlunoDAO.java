package pDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
