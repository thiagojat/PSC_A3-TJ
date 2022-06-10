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

	public boolean inserir(Curso curso) {
		String sql ="INSERT INTO curso(nome,carga_horaria, desc_curso, ativo)VALUES(?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,curso.getNomeCurso());
			stmt.setString(2,""+curso.getCargaHor());
			stmt.setString(3,""+curso.getDescCurso());
			stmt.setString(4,""+curso.isAtivo());

			stmt.execute();
			System.out.println("estoremo fml");
			return true;
		}catch(SQLException ex){
			System.out.println(ex);
			return false;
		}
	}

	public List<Curso>listar(){
		String sql  = "SELECT * FROM curso";
		List<Curso> cursos = new ArrayList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()){
				Curso c =new Curso();
				c.setCodigoCurso(resultado.getInt("cod_curso"));
				c.setNomeCurso(resultado.getString("nome"));
				c.setCargaHor(resultado.getInt("carga_horaria"));
				c.setDescCurso(resultado.getString("desc_curso"));
				c.setAtivo(resultado.getBoolean("ativo"));
				
				cursos.add(c);
			}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		return cursos;
	}
	public void alteraCurso(Curso curso, int id) {
        String sql = "UPDATE curso SET nome=?, carga_horaria=?, desc_curso=?, ativo=? WHERE cod_curso=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNomeCurso());
            stmt.setString(2, "" + curso.getCargaHor());
            stmt.setString(3, curso.getDescCurso());
            stmt.setBoolean(4, curso.isAtivo());
            stmt.setString(5, "" + id);
            stmt.execute();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
	public void setAtivo(Curso curso, int id) {
        String sql = "UPDATE curso SET ativo=? WHERE cod_curso=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setBoolean(1,curso.isAtivo());
            stmt.setString(2, "" + id);
            stmt.execute();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
	
	public boolean remover(Integer id){
		String sql="DELETE FROM aluno WHERE cod_curso=?";
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
