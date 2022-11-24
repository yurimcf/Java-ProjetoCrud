package View;

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

import Controller.ValidaRG;
import Model.Aluno;
import Model.AlunoDao;

public class AlunoCadastro extends JFrame implements ActionListener {
	JButton btnAdd, btnCancelar;
	JTextField campNome, campRa, campRg;
	JLabel nome, ra, rg;

	public AlunoCadastro() {
		// nome
		nome = criarEtiqueta("Nome: ");
		campNome = new JTextField();
		getContentPane().add(campNome);

		// ra
		ra = criarEtiqueta("RA do Aluno: ");
		campRa = new JTextField();
		getContentPane().add(campRa);

		// rg
		rg = criarEtiqueta("RG");
		campRg = new JTextField();
		getContentPane().add(campRg);

		// botoes
		btnAdd = criarBotao("Adicionar", 'A');
		btnCancelar = criarBotao("Cancelar", 'C');

		setTitle("Inserir Novo Aluno");
		setSize(550, 300);
		GridLayout gl = new GridLayout(4, 2, 3, 30); // linha, coluna, espessuraH - espessuraV
		getContentPane().setBackground(new Color(200, 200, 200));
		getContentPane().setLayout(gl);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	
	private void limparCampos() {
		campNome.setText("");
		campRa.setText("");
		campRg.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			Aluno novo = new Aluno(campNome.getText(), campRa.getText(), campRg.getText());
			String rg = novo.getRg();
			if (ValidaRG.isRG(rg) == true) {
				System.out.printf("%s\n", ValidaRG.imprimeRG(rg));
				if(AlunoDao.inserir(novo)) {
					limparCampos();
					
				}
			} else {
				JOptionPane.showMessageDialog(null, "Rg inválido");
			}
		}
		if (e.getSource() == btnCancelar) {
			MenuAppTela a = new MenuAppTela();
			JOptionPane.showMessageDialog(null, "Registro Cancelado");
			setVisible(false);
			a.setVisible(true);

		}

	}

}
