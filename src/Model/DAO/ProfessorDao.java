package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.entity.Professor;

public class ProfessorDao {
	private final static String INSERT = "INSERT INTO professor (nome, rgf, rg) VALUES (?,?,?);";
	private final String DELETE = "DELETE FROM professor WHERE id=?;";
	private final String UPDATE = "UPDATE `professor` SET `nome` = ?,`rgf` = ?, `rg` = ? WHERE (`id` = ?);";
	private final String SELECTALL = "SELECT * FROM professor;";
	private final static String SELECTID = "SELECT * FROM professor WHERE id=?;";
	
	public static boolean inserir(Professor professor) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectarMySQL.getConexao();
			pstm = conn.prepareStatement(INSERT);

			pstm.setString(1, professor.getNome());
			pstm.setString(2, professor.getRgf());
			pstm.setString(3, professor.getRg());

			pstm.executeUpdate();
			//pstm.close();
			ConnectarMySQL.closeConexao(conn, pstm);
			JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso.");
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha ao tentar REGISTRAR novo professor " + "ERRO: " + e.getMessage());
		}
		return false;

	}
	
	public void deleteID(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectarMySQL.getConexao();
			pstm = conn.prepareStatement(DELETE);
			pstm.setInt(1, id);

			pstm.executeUpdate();
			//pstm.close();
			ConnectarMySQL.closeConexao(conn, pstm);
			JOptionPane.showMessageDialog(null, "Professor deletado com exito");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha ao tentar DELETAR professor " + "ERRO: " + e.getMessage());
		}
	}
	
	public void updateRegistro(Professor professor) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectarMySQL.getConexao();
			pstm = conn.prepareStatement(UPDATE);
			pstm.setString(1, professor.getNome());
			pstm.setString(2, professor.getRgf());
			pstm.setString(3, professor.getRg());
			pstm.setInt(4, professor.getId());

			pstm.executeUpdate();
			//pstm.close();
			ConnectarMySQL.closeConexao(conn, pstm);
			JOptionPane.showMessageDialog(null, "Aluno Atualizado com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha ao tentar ATUALIZAR o Aluno " + "ERRO: " + e.getMessage());
		}
	}
	
	public List<Professor> getProfessor() {
		Connection conn;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<Professor> professorLista = new ArrayList<Professor>();
		try {
			conn = ConnectarMySQL.getConexao();
			pstm = conn.prepareStatement(SELECTALL);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Professor professor = new Professor();

				professor.setId(rs.getInt("id"));
				professor.setNome(rs.getString("nome"));
				professor.setRgf(rs.getString("rgf"));
				professor.setRg(rs.getString("rg"));
				professorLista.add(professor);
			}
			//pstm.close();
			ConnectarMySQL.closeConexao(conn, pstm, rs);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar Alunos" + e.getMessage());
		}
		return professorLista;
	}
	
	public static Professor getProfessorId(int id) {
		Connection conn;
		PreparedStatement pstm;
		ResultSet rs;
		Professor professor= new Professor();
		try {
			conn = ConnectarMySQL.getConexao();
			pstm = conn.prepareStatement(SELECTID);
			rs = pstm.executeQuery();

			pstm.setInt(1, id);
			while (rs.next()) {
				professor.setId(rs.getInt("id"));
				professor.setNome(rs.getString("nome"));
				professor.setRgf(rs.getString("ra"));
				professor.setRg(rs.getString("rg"));
			}

			pstm.close();
			ConnectarMySQL.closeConexao();
			JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar Alunos" + e.getMessage());
		}
		return professor;
	}
}
