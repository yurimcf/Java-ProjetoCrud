package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.Aluno;
import Model.AlunoDao;

public class AlunoDelete extends JFrame implements ActionListener {
	private JButton btnCancelar, btnDelete, btnPesq;
	private JTextField campId;
	private JLabel campNome, campRa, campRg;
	private JLabel nome, ra, rg, id, empty;

	public AlunoDelete() {
		// ID
		id = criarEtiqueta("ID para atualizar:");
		campId = new JTextField();
		getContentPane().add(campId);
		btnPesq = criarBotao("Pesq. ID ", 'P');

		// nome
		nome = criarEtiqueta("Nome: ");
		campNome = EtiquetaInfo("");
		getContentPane().add(campNome);
		empty = new JLabel();
		getContentPane().add(empty);

		// ra
		ra = criarEtiqueta("RA do Aluno: ");
		campRa = EtiquetaInfo("");
		getContentPane().add(campRa);
		empty = new JLabel();
		getContentPane().add(empty);

		// rg
		rg = criarEtiqueta("RG: ");
		campRg = EtiquetaInfo("");
		getContentPane().add(campRg);
		empty = new JLabel();
		getContentPane().add(empty);

		// botoes
		btnDelete = criarBotao("Deletar", 'D');
		btnCancelar = criarBotao("Cancelar", 'C');

		// parâmetros da tela
		setTitle("Deletar Aluno");
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

	// metodo para criar Label de Info
	private JLabel EtiquetaInfo(String texto) {
		JLabel etiqueta = new JLabel(texto);
		etiqueta.setFont(new Font("Times New Roman", Font.BOLD, 24));
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
	private void limparCampos() {
		campId.setText(null);
		campNome.setText("");
		campRa.setText("");
		campRg.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AlunoDao dao = new AlunoDao();
		
		if (e.getSource() == btnPesq) {
			int idpesq = Integer.parseInt(campId.getText());
			for (Aluno a : dao.getAluno()) {
				if (a.getId() == idpesq) {
					campNome.setText(a.getNome());
					campRa.setText(a.getRa());
					campRg.setText(a.getRg());
					break;
				} 
			}
		}

		if (e.getSource() == btnDelete) {
			int idDel = Integer.parseInt(campId.getText());
			for (Aluno a : dao.getAluno()) {
				if (a.getId() == idDel) {
					dao.deleteID(idDel);
					break;
				}
			}
			limparCampos();
		}

		if (e.getSource() == btnCancelar) {
			MenuAppTela a = new MenuAppTela();
			setVisible(false);
			a.setVisible(true);
		}
	}

	public static void main(String[] args) {
		new AlunoDelete();
	}

}
