package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class AlunoDao {
	private final static String INSERT = "INSERT INTO aluno (nome, ra, rg) VALUES (?,?,?)";
	private final String DELETE = "DELETE FROM aluno WHERE id=?";
	private final String UPDATE = "UPDATE `aluno` SET `nome` = ?, `ra` = ?, `rg` = ? WHERE (`id` = ?);";
	private final String SELECTALL = "SELECT * FROM aluno";
	private final static String SELECTID = "SELECT * FROM ALUNO WHERE id?";

	public static void inserir(Aluno aluno) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopi", "root", "@yuri5140");
			pstm = conn.prepareStatement(INSERT);

			pstm.setString(1, aluno.getNome());
			pstm.setString(2, aluno.getRa());
			pstm.setString(3, aluno.getRg());

			pstm.executeUpdate();
			pstm.close();
			conn.close();
			JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha ao tentar REGISTRAR Aluno " + "ERRO: " + e.getMessage());
		}

	}

	public void deleteID(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopi", "root", "@yuri5140");
			pstm = conn.prepareStatement(DELETE);
			pstm.setInt(1, id);

			pstm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Aluno deletado com exito");
			pstm.close();
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha ao tentar DELETAR Aluno " + "ERRO: " + e.getMessage());
		}
	}

	public void updateRegistro(Aluno aluno) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopi", "root", "@yuri5140");
			pstm = conn.prepareStatement(UPDATE);
			pstm.setInt(4, aluno.getId());
			pstm.setString(1, aluno.getNome());
			pstm.setString(2, aluno.getRa());
			pstm.setString(3, aluno.getRg());

			pstm.executeUpdate();
			pstm.close();
			conn.close();
			JOptionPane.showMessageDialog(null, "Aluno Atualizado com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha ao tentar ATUALIZAR o Aluno " + "ERRO: " + e.getMessage());
		}
	}

	public List<Aluno> getAluno() {
		Connection conn;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<Aluno> alunoLista = new ArrayList<Aluno>();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopi", "root", "@yuri5140");
			pstm = conn.prepareStatement(SELECTALL);
			rs = pstm.executeQuery();
			System.out.println("Conexão feita");

			while (rs.next()) {
				Aluno aluno = new Aluno();

				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setRa(rs.getString("ra"));
				aluno.setRg(rs.getString("rg"));
				alunoLista.add(aluno);
			}
			pstm.close();
			conn.close();
			rs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar Alunos" + e.getMessage());
			// e.printStackTrace();
		}
		return alunoLista;
	}

	public static Aluno getContatoId(int id) {
		Connection conn;
		PreparedStatement pstm;
		ResultSet rs;
		Aluno aluno = new Aluno();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopi", "root", "@yuri5140");
			pstm = conn.prepareStatement(SELECTID);
			rs = pstm.executeQuery();

			pstm.setInt(1, id);
			while (rs.next()) {
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setRa(rs.getString("ra"));
				aluno.setRg(rs.getString("rg"));
			}

			pstm.close();
			conn.close();
			rs.close();
			JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar Alunos" + e.getMessage());
		}

		return aluno;
	}
}
