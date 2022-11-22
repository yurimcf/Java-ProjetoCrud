package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class MenuAppTela extends JFrame implements ActionListener {
	JLabel home;
	JMenuBar barraMenu;
	JMenu cadastro, atualizar, exclusao, leitura, encerrar;
	JMenuItem professor, aluno, attAluno, rgf, ra, rg, professorL, alunoL, sair;

	public MenuAppTela() {

		// componentes da home
		home = criarHome("Bem Vindo ao Sistema");

		// barra de menu
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);

		// elementedo da barra de menu
		cadastro = new JMenu("Cadastro");
		cadastro.setMnemonic('C');
		atualizar = new JMenu("Alteracao");
		atualizar.setMnemonic('T');
		exclusao = new JMenu("Exclusao");
		exclusao.setMnemonic('X');
		leitura = new JMenu("Leitura");
		leitura.setMnemonic('L');
		encerrar = new JMenu("Encerrar");
		encerrar.setMnemonic('N');

		barraMenu.add(cadastro);
		barraMenu.add(atualizar);
		barraMenu.add(exclusao);
		barraMenu.add(leitura);
		barraMenu.add(encerrar);

		// criar itens dos elementos do menu
		professor = criarItem("Professor", 'P', cadastro);
		aluno = criarItem("Aluno", 'A', cadastro);

		attAluno = criarItem("Atualizar Aluno", 'T', atualizar);

		rgf = criarItem("Por RGF", 'F', exclusao);
		ra = criarItem("Por RA", 'A', exclusao);
		rg = criarItem("Por RG", 'G', exclusao);

		professorL = criarItem("Leitura Professor", 'I', leitura);
		alunoL = criarItem("Leitura Aluno", 'L', leitura);

		sair = criarItem("Sair", 'S', encerrar);

		setTitle("Projeto CRUD PI -2");
		setSize(550, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// cria os itens do menu
	private JMenuItem criarItem(String texto, char c, JMenu menu) {
		JMenuItem item = new JMenuItem(texto);
		item.setMnemonic(c);
		item.addActionListener(this);
		menu.add(item);
		return item;
	}

	// metedo pra implementrar a home
	private JLabel criarHome(String texto) {
		JLabel textoH = new JLabel(texto);
		textoH.setVerticalAlignment(SwingConstants.CENTER);
		textoH.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textoH.setForeground(Color.BLACK);
		textoH.setHorizontalAlignment(SwingConstants.CENTER);
		add(textoH);
		return textoH;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == professor) {
			ProfessorCadastro a = new ProfessorCadastro();
			a.setVisible(true);
			setVisible(false);
		}

		if (e.getSource() == aluno) {
			AlunoCadastro a = new AlunoCadastro();
			a.setVisible(true);
			setVisible(false);
		}

		if (e.getSource() == attAluno) {
			AlunoUpdateDelete a = new AlunoUpdateDelete();
			a.setVisible(true);
			setVisible(false);
		}
		if (e.getSource() == rgf) {
			AlunoCadastro a = new AlunoCadastro();
			a.setVisible(true);
			setVisible(false);
		}
		if (e.getSource() == ra) {
			AlunoCadastro a = new AlunoCadastro();
			a.setVisible(true);
			setVisible(false);
		}
		if (e.getSource() == rg) {
			AlunoCadastro a = new AlunoCadastro();
			a.setVisible(true);
			setVisible(false);
		}
		if (e.getSource() == professorL) {
			AlunoCadastro a = new AlunoCadastro();
			a.setVisible(true);
			setVisible(false);
		}
		if (e.getSource() == alunoL) {
			ListarAlunos a = new ListarAlunos();
			a.setVisible(true);
			setVisible(false);
		}

		if (e.getSource() == sair) {
			int sair = JOptionPane.showConfirmDialog(null, "Certeza que deseja Sair");
			if (sair == 0) {
				System.exit(0);
			}
		}
	}
}
