package View.ProfessorTelas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.BEAN.ValidaRG;
import Model.DAO.ProfessorDao;
import Model.entity.Aluno;
import Model.entity.Professor;
import View.MenuAppTela;

public class ProfessorUpdate extends JFrame implements ActionListener {
	private JButton btnAtt, btnCancelar, btnPesq;
	private JTextField campNome, campRgf, campRg, campId;
	private JLabel nome, rgf, rg, id, empty;

	public ProfessorUpdate() {
		// ID
		id = criarEtiqueta("ID para atualizar.:");
		campId = new JTextField(null);
		getContentPane().add(campId);
		btnPesq = criarBotao("Pesq. ID ", 'P');

		// nome
		nome = criarEtiqueta("Nome.: ");
		campNome = new JTextField();
		getContentPane().add(campNome);
		empty = new JLabel();
		getContentPane().add(empty);

		// ra
		rgf = criarEtiqueta("RA do Aluno.: ");
		campRgf = new JTextField();
		getContentPane().add(campRgf);
		empty = new JLabel();
		getContentPane().add(empty);

		// rg
		rg = criarEtiqueta("RG: ");
		campRg = new JTextField();
		getContentPane().add(campRg);
		empty = new JLabel();
		getContentPane().add(empty);

		// botoes
		btnAtt = criarBotao("Atualizar All", 'A');
		btnCancelar = criarBotao("Cancelar", 'C');

		setTitle("Atualizar Professor");
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
		campRgf.setText("");
		campRg.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ProfessorDao dao = new ProfessorDao();
		if (e.getSource() == btnPesq) {
			int id = Integer.parseInt(campId.getText());
			for (Professor p : dao.getProfessor()) {
				if (p.getId() == id) {
					campNome.setText(p.getNome());
					campRgf.setText(p.getRgf());
					campRg.setText(p.getRg());
					break;
				}
			}
		}
		
		if (e.getSource() == btnAtt) {
			Professor novo = new Professor(campNome.getText(), campRgf.getText(), campRg.getText());
			if (ValidaRG.isRG(novo.getRg()) == true) {
				Professor attProf = new Professor();
				attProf.setId(Integer.parseInt(campId.getText()));
				attProf.setNome(campNome.getText());
				attProf.setRgf(campRgf.getText());
				attProf.setRg(campRg.getText());
				dao.updateRegistro(attProf);
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

	public static void main(String[] args) {
		new ProfessorUpdate();
	}

}
