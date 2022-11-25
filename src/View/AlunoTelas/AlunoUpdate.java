package View.AlunoTelas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.BEAN.ValidaRG;
import Model.DAO.AlunoDao;
import Model.entity.Aluno;
import View.MenuAppTela;

public class AlunoUpdate extends JFrame implements ActionListener {
	private JButton btnAtt, btnCancelar, btnPesq;
	private JTextField campNome, campRa, campRg, campId;
	private JLabel nome, ra, rg, id, empty;

	public AlunoUpdate() {
		// ID
		id = criarEtiqueta("ID para atualizar:");
		campId = new JTextField();
		getContentPane().add(campId);
		btnPesq = criarBotao("Pesq. ID ", 'P');

		// nome
		nome = criarEtiqueta("Nome: ");
		campNome = new JTextField();
		getContentPane().add(campNome);
		empty = new JLabel();
		getContentPane().add(empty);

		// ra
		ra = criarEtiqueta("RA do Aluno: ");
		campRa = new JTextField();
		getContentPane().add(campRa);
		empty = new JLabel();
		getContentPane().add(empty);

		// rg
		rg = criarEtiqueta("RG: ");
		campRg = new JTextField();
		getContentPane().add(campRg);
		empty = new JLabel();
		getContentPane().add(empty);

		// botoes
		btnAtt = criarBotao("Atualizar", 'A');
		btnCancelar = criarBotao("Cancelar", 'C');

		setTitle("Atualizar Aluno");
		setSize(550, 300);
		GridLayout gl = new GridLayout(5, 3, 3, 30); // linha, coluna, espessuraH - espessuraV
		getContentPane().setBackground(new Color(200, 200, 200));
		getContentPane().setLayout(gl);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// metodo para criarLabel
	private JLabel criarEtiqueta(String texto) {
		JLabel etiqueta = new JLabel(texto);
		etiqueta.setFont(new Font("Times New Roman", Font.BOLD, 18));
		etiqueta.setForeground(Color.BLACK);
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		add(etiqueta);
		return etiqueta;
	}

	// metodo para criarbotao
	private JButton criarBotao(String texto, char c) {
		JButton botao = new JButton(texto);
		botao.setMnemonic(c);
		botao.addActionListener(this);
		add(botao);
		return botao;
	}

	// limpa os Campos
	public void limparCampos() {
		campId.setText("");
		campNome.setText("");
		campRa.setText("");
		campRg.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AlunoDao dao = new AlunoDao();
		if (e.getSource() == btnPesq) {
			int id = Integer.parseInt(campId.getText());
			for (Aluno a : dao.getAluno()) {
				if (a.getId() == id) {
					campNome.setText(a.getNome());
					campRa.setText(a.getRa());
					campRg.setText(a.getRg());
					break;
				}
			}
		}

		if (e.getSource() == btnAtt) {
			Aluno novo = new Aluno(campNome.getText(), campRa.getText(), campRg.getText());
			if (ValidaRG.isRG(novo.getRg()) == true) {
				Aluno attAluno = new Aluno();
				attAluno.setId(Integer.parseInt(campId.getText()));
				attAluno.setNome(campNome.getText());
				attAluno.setRa(campRa.getText());
				attAluno.setRg(campRg.getText());
				dao.updateRegistro(attAluno);
			} else {
				JOptionPane.showMessageDialog(null, "Rg inválido");
			}
			limparCampos();
		}

		if (e.getSource() == btnCancelar) {
			MenuAppTela a = new MenuAppTela();
			setVisible(false);
			a.setVisible(true);
		}
	}
}
