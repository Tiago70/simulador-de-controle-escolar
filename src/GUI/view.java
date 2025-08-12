package GUI;

import classes.*;

import controlador.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

public class view extends JFrame {
	private static final long serialVersionUID = 1L;

	// Todas as variáveis globais abaixo
	Logica controlador = new Logica();
	JPanel paineis = new JPanel(new CardLayout());
	CardLayout grupoPaineis = (CardLayout) paineis.getLayout();

	// Botões menu inicial
	JButton btnAluno = new JButton("Aluno");
	JButton btnProfessor = new JButton("Professor");
	JButton btnCurso = new JButton("Curso");
	JButton btnGerarRelatorio = new JButton("Gerar Relatório");
	JButton btnSair = new JButton("Sair");

	// Componentes da Tela de Controle Geral
	JLabel tituloTelaControle = new JLabel();
	JButton btnCadastrar = new JButton("Cadastrar");
	JButton btnConsultar = new JButton("Consultar");
	JButton btnVincularNoCurso = new JButton("Vincular"); // Usado apenas na vinculação
	JButton btnSairDoControle = new JButton("Voltar");

	// Componentes Para Cadastro de Aluno, Professor e Curso
	JTextField entradaCadastroNome = new JTextField();
	JLabel msgCadastroIdade = new JLabel("Idade");
	JTextField entradaCadastroIdade = new JTextField();
	JLabel msgCadastroMatricula = new JLabel("Matrícula");
	JTextField entradaCadastroMatricula = new JTextField();
	JLabel msgCadastroEspecialidade = new JLabel("Especialidade");
	JTextField entradaCadastroEspecialidade = new JTextField();
	JLabel msgCadastroCargaHoraria = new JLabel("Carga Horária");
	JTextField entradaCadastroCargaHoraria = new JTextField();
	JButton btnConfirmarCadastro = new JButton("Cadastrar");
	JButton btnCancelarCadastro = new JButton("Cancelar");

	// Componentes Consultar e Excluir Aluno, Professor e Curso
	JPanel painelExibirInfo = new JPanel();
	JLabel msgEntradaConsulta = new JLabel();
	JTextField entradaConsultar = new JTextField();
	JButton btnConfirmarConsulta = new JButton("Consultar");
	JLabel consultaExibirNome = new JLabel();
	JLabel consultaExibirIdade = new JLabel();
	JLabel consultaExibirMatricula = new JLabel();
	JButton btnCancelarConsulta = new JButton("Cancelar");
	JButton btnEditar = new JButton("Editar");
	JButton btnExcluir = new JButton("Excluir");

	// Componentes da Tela Editar Aluno, Professor e Curso
	JLabel msgEditarIdade = new JLabel();
	JTextField entradaNovoNome = new JTextField();
	JTextField entradaNovaIdade = new JTextField();
	JButton btnSalvarEdicao = new JButton("Salvar");
	JButton btnCancelarEdicao = new JButton("Cancelar");

	// Componente Para Vinculação
	JLabel msgVincularNome = new JLabel("Nome do curso para vincular");
	JTextField entradaVincularCurso;
	JLabel msgVincularAouP = new JLabel(
			"<html>Coloque a Matricula para vincular um aluno <br>Nome para vincular um professor</html>");
	JTextField entradaVincularAouP;
	JButton btnVincularAluno = new JButton("Vincular Aluno");
	JButton btnVincularProfessor = new JButton("Vincular Professor");
	JButton btnSairVincular = new JButton("Cancelar");

	// Componentes Gerar Relatório
	JButton btnSairDoGerarRel = new JButton("Voltar");
	JButton btnGerarRelAluno = new JButton("Alunos");
	JButton btnGerarRelProfessor = new JButton("Professores");
	JScrollPane painelDeScroll = new JScrollPane();

	// Construtor da Interface
	public view() {
		// Cria a Janela
		setTitle("Controle Escolar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(678, 410);
		getContentPane().setLayout(new BorderLayout());
		setIconImage(Toolkit.getDefaultToolkit().getImage("GUI/gato.jpg"));
		setLocationRelativeTo(null);
		setResizable(false);

		///////////////// Tela Principal /////////////////
		JPanel telaPrincipal = new JPanel();
		telaPrincipal.setLayout(new BorderLayout());
		telaPrincipal.setLayout(null);

		JLabel msgBemVindo = new JLabel("Bem Vindo");
		msgBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		msgBemVindo.setBounds(273, 10, 117, 29);
		telaPrincipal.add(msgBemVindo);

		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setBounds(29, 48, 595, 293);
		telaPrincipal.add(painelPrincipal);
		painelPrincipal.setLayout(null);

		btnAluno.setForeground(new Color(43, 49, 51));
		btnAluno.setBounds(10, 10, 211, 35);
		painelPrincipal.add(btnAluno);

		btnProfessor.setForeground(new Color(43, 49, 51));
		btnProfessor.setBounds(10, 55, 211, 35);
		painelPrincipal.add(btnProfessor);

		btnCurso.setForeground(new Color(43, 49, 51));
		btnCurso.setBounds(10, 100, 211, 35);
		painelPrincipal.add(btnCurso);

		btnGerarRelatorio.setBounds(10, 145, 211, 35);
		painelPrincipal.add(btnGerarRelatorio);

		btnSair.setForeground(new Color(43, 49, 51));
		btnSair.setBounds(59, 220, 121, 35);
		painelPrincipal.add(btnSair);

		///////////////// Tela de Controle do Aluno e do Professor /////////////////
		JPanel painelDoControle = new JPanel();
		painelDoControle.setLayout(null);

		tituloTelaControle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tituloTelaControle.setBounds(220, 10, 300, 29);
		painelDoControle.add(tituloTelaControle);

		JPanel subPainelDoControle = new JPanel();
		subPainelDoControle.setBounds(29, 48, 595, 293);
		subPainelDoControle.setLayout(null);
		painelDoControle.add(subPainelDoControle);

		btnCadastrar.setForeground(new Color(43, 49, 51));
		btnCadastrar.setBounds(10, 10, 211, 35);
		subPainelDoControle.add(btnCadastrar);

		btnConsultar.setForeground(new Color(43, 49, 51));
		btnConsultar.setBounds(10, 55, 211, 35);
		subPainelDoControle.add(btnConsultar);

		btnVincularNoCurso.setForeground(new Color(43, 49, 51));
		btnVincularNoCurso.setBounds(10, 100, 211, 35);
		btnVincularNoCurso.setVisible(false);
		subPainelDoControle.add(btnVincularNoCurso);

		btnSairDoControle.setBounds(59, 220, 121, 35);
		btnSairDoControle.setForeground(new Color(43, 49, 51));
		subPainelDoControle.add(btnSairDoControle);

		///////////////// Tela Para Cadastrar o aluno /////////////////
		JPanel painelCadastrar = new JPanel();
		painelCadastrar.setLayout(null);

		JLabel tituloCadastrar = new JLabel("Cadastro");
		tituloCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tituloCadastrar.setBounds(220, 10, 224, 29);
		painelCadastrar.add(tituloCadastrar);

		JLabel msgCadastro = new JLabel("Preencha todos os campos para realizar o cadastro");
		msgCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		msgCadastro.setBounds(41, 49, 451, 45);
		painelCadastrar.add(msgCadastro);

		JLabel msgCadastroNome = new JLabel("Nome");
		msgCadastroNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		msgCadastroNome.setBounds(41, 112, 81, 13);
		painelCadastrar.add(msgCadastroNome);

		entradaCadastroNome.setBounds(41, 129, 129, 26);
		entradaCadastroNome.setColumns(10);
		painelCadastrar.add(entradaCadastroNome);

		msgCadastroIdade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		msgCadastroIdade.setBounds(41, 169, 81, 13);
		msgCadastroIdade.setVisible(false);
		painelCadastrar.add(msgCadastroIdade);

		msgCadastroEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		msgCadastroEspecialidade.setBounds(41, 169, 129, 13);
		msgCadastroEspecialidade.setVisible(false);
		painelCadastrar.add(msgCadastroEspecialidade);

		entradaCadastroEspecialidade.setBounds(41, 186, 129, 26);
		entradaCadastroEspecialidade.setColumns(10);
		entradaCadastroEspecialidade.setVisible(false);
		painelCadastrar.add(entradaCadastroEspecialidade);

		msgCadastroCargaHoraria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		msgCadastroCargaHoraria.setBounds(41, 169, 129, 13);
		msgCadastroCargaHoraria.setVisible(false);
		painelCadastrar.add(msgCadastroCargaHoraria);

		entradaCadastroCargaHoraria.setBounds(41, 186, 129, 26);
		entradaCadastroCargaHoraria.setColumns(10);
		entradaCadastroCargaHoraria.setVisible(false);
		painelCadastrar.add(entradaCadastroCargaHoraria);

		entradaCadastroIdade.setBounds(41, 186, 129, 26);
		entradaCadastroIdade.setColumns(10);
		entradaCadastroIdade.setVisible(false);
		painelCadastrar.add(entradaCadastroIdade);

		msgCadastroMatricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		msgCadastroMatricula.setBounds(41, 229, 81, 13);
		msgCadastroMatricula.setVisible(false);
		painelCadastrar.add(msgCadastroMatricula);

		entradaCadastroMatricula.setBounds(41, 246, 129, 26);
		entradaCadastroMatricula.setColumns(10);
		entradaCadastroMatricula.setVisible(false);
		painelCadastrar.add(entradaCadastroMatricula);

		btnConfirmarCadastro.setBounds(359, 309, 99, 29);
		painelCadastrar.add(btnConfirmarCadastro);

		btnCancelarCadastro.setBounds(177, 309, 99, 29);
		painelCadastrar.add(btnCancelarCadastro);

		///////////////// Tela para consultar o aluno e professor /////////////////
		JPanel painelConsultar = new JPanel();
		painelConsultar.setLayout(null);

		JLabel msgConsultar = new JLabel("Consultar");
		msgConsultar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		msgConsultar.setBounds(220, 10, 224, 29);
		painelConsultar.add(msgConsultar);

		JLabel msgConsultarInfo = new JLabel("Informe um dos dados abaixo para realizar a consulta");
		msgConsultarInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		msgConsultarInfo.setBounds(41, 49, 451, 45);
		painelConsultar.add(msgConsultarInfo);

		msgEntradaConsulta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		msgEntradaConsulta.setBounds(41, 112, 123, 13);
		painelConsultar.add(msgEntradaConsulta);

		entradaConsultar.setBounds(41, 129, 129, 26);
		painelConsultar.add(entradaConsultar);
		entradaConsultar.setColumns(10);

		btnEditar.setBounds(281, 309, 99, 29);
		painelConsultar.add(btnEditar);

		btnCancelarConsulta.setBounds(41, 309, 99, 29);
		painelConsultar.add(btnCancelarConsulta);

		btnExcluir.setBounds(510, 309, 99, 29);
		painelConsultar.add(btnExcluir);

		btnConfirmarConsulta.setBounds(281, 127, 99, 29);
		painelConsultar.add(btnConfirmarConsulta);

		painelExibirInfo.setBounds(41, 165, 200, 131);
		painelConsultar.add(painelExibirInfo);
		painelExibirInfo.setLayout(null);

		consultaExibirMatricula.setBounds(4, 95, 125, 13);
		painelExibirInfo.add(consultaExibirMatricula);

		consultaExibirNome.setBounds(4, 23, 125, 13);
		painelExibirInfo.add(consultaExibirNome);

		consultaExibirIdade.setBounds(4, 59, 200, 13);
		painelExibirInfo.add(consultaExibirIdade);

		///////////////// Tela para editar /////////////////
		JPanel painelEditarPessoa = new JPanel();
		painelEditarPessoa.setLayout(null);

		JLabel msgEditar = new JLabel("Editar");
		msgEditar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		msgEditar.setBounds(220, 10, 71, 29);
		painelEditarPessoa.add(msgEditar);

		JLabel msgEditarSub = new JLabel("Caso não queira alterar um dos campos, deixe-o em branco");
		msgEditarSub.setFont(new Font("Tahoma", Font.PLAIN, 18));
		msgEditarSub.setBounds(41, 62, 500, 45);
		painelEditarPessoa.add(msgEditarSub);

		JLabel msgEditarNome = new JLabel("Novo nome");
		msgEditarNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		msgEditarNome.setBounds(41, 146, 123, 13);
		painelEditarPessoa.add(msgEditarNome);

		entradaNovoNome.setBounds(41, 163, 129, 26);
		painelEditarPessoa.add(entradaNovoNome);
		entradaNovoNome.setColumns(10);

		msgEditarIdade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		msgEditarIdade.setBounds(41, 214, 129, 26);
		painelEditarPessoa.add(msgEditarIdade);

		entradaNovaIdade.setBounds(41, 238, 129, 26);
		painelEditarPessoa.add(entradaNovaIdade);
		entradaNovaIdade.setColumns(10);

		btnSalvarEdicao.setBounds(331, 309, 99, 29);
		painelEditarPessoa.add(btnSalvarEdicao);

		btnCancelarEdicao.setBounds(41, 309, 99, 29);
		painelEditarPessoa.add(btnCancelarEdicao);

		///////////////// Tela de Vinculação /////////////////
		JPanel painelVincular = new JPanel();
		painelVincular.setLayout(null);

		JLabel msgVincular = new JLabel("Vincular ao curso");
		msgVincular.setFont(new Font("Tahoma", Font.PLAIN, 24));
		msgVincular.setBounds(220, 10, 224, 29);
		painelVincular.add(msgVincular);

		JPanel subPainelVincular = new JPanel();
		subPainelVincular.setBounds(29, 48, 595, 293);
		subPainelVincular.setLayout(null);
		painelVincular.add(subPainelVincular);

		msgVincularNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		msgVincularNome.setBounds(10, 10, 272, 19);
		subPainelVincular.add(msgVincularNome);

		btnSairVincular.setBounds(42, 227, 137, 35);
		btnSairVincular.setForeground(new Color(43, 49, 51));
		subPainelVincular.add(btnSairVincular);

		msgVincularAouP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		msgVincularAouP.setBounds(10, 102, 264, 35);
		subPainelVincular.add(msgVincularAouP);

		entradaVincularCurso = new JTextField();
		entradaVincularCurso.setBounds(10, 31, 129, 26);
		subPainelVincular.add(entradaVincularCurso);

		entradaVincularAouP = new JTextField();
		entradaVincularAouP.setBounds(10, 138, 129, 26);
		entradaVincularAouP.setColumns(10);
		subPainelVincular.add(entradaVincularAouP);

		btnVincularAluno.setBounds(229, 227, 137, 35);
		subPainelVincular.add(btnVincularAluno);

		btnVincularProfessor.setBounds(416, 227, 150, 35);
		subPainelVincular.add(btnVincularProfessor);

		///////////////// Tela para Gerar Relatório /////////////////
		JPanel painelGerarRelatorio = new JPanel();
		painelGerarRelatorio.setLayout(null);

		JLabel msgGerarRelatorio = new JLabel("Escola uma das opções para gerar o relatório");
		msgGerarRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		msgGerarRelatorio.setBounds(123, 0, 425, 42);
		painelGerarRelatorio.add(msgGerarRelatorio);

		btnSairDoGerarRel.setBounds(91, 63, 99, 29);
		painelGerarRelatorio.add(btnSairDoGerarRel);

		btnGerarRelAluno.setBounds(281, 63, 99, 29);
		painelGerarRelatorio.add(btnGerarRelAluno);

		btnGerarRelProfessor.setBounds(471, 63, 99, 29);
		painelGerarRelatorio.add(btnGerarRelProfessor);

		painelDeScroll.setBounds(10, 108, 644, 255);
		painelGerarRelatorio.add(painelDeScroll);

		///////////////// Adicionando as telas ao trocador /////////////////
		paineis.add(telaPrincipal, "Tela Principal");
		paineis.add(painelDoControle, "Tela de Controle");
		paineis.add(painelCadastrar, "Tela de Cadastro");
		paineis.add(painelConsultar, "Tela de Consultar");
		paineis.add(painelEditarPessoa, "Tela para Editar");
		paineis.add(painelVincular, "Tela para Vincular");
		paineis.add(painelGerarRelatorio, "Tela para Gerar Relatorio");

		getContentPane().add(paineis, BorderLayout.CENTER);

		///////////////// Eventos dos botões do menu principal /////////////////
		btnAluno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eventosAluno(); // Chama os eventos do aluno
			}
		});
		btnProfessor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eventosProfessor(); // Chama os eventos do professor
			}
		});
		btnCurso.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eventosCurso(); // Chama os eventos do curso
			}
		});
		btnGerarRelatorio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gerarRelatorio(); // Chama os eventos para Gerar o relatório
			}
		});
		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Fecha o programa
			}
		});
	}

	///////////////// Lógica dos botões relacionados ao aluno /////////////////
	private void eventosAluno() {
		// Prepara os componentes
		tituloTelaControle.setText("Controle de Alunos");
		grupoPaineis.show(paineis, "Tela de Controle");
		entradaCadastroIdade.setVisible(true);
		entradaCadastroMatricula.setVisible(true);
		msgCadastroIdade.setVisible(true);
		msgCadastroMatricula.setVisible(true);

		// Reseta as ações de alguns botões compartilhados para evitar bugs (essa função
		// está no final)
		resetarAcoes(btnCadastrar, btnConfirmarCadastro, btnConsultar, btnConfirmarConsulta, btnEditar, btnSalvarEdicao,
				btnExcluir, btnSairDoControle);

		// Eventos do Cadastro
		btnCadastrar.addActionListener(e -> grupoPaineis.show(paineis, "Tela de Cadastro"));
		btnConfirmarCadastro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Estudante alunoNovo = new Estudante();
				if (alunoNovo.cadastrar(entradaCadastroNome.getText(), entradaCadastroIdade.getText(),
						entradaCadastroMatricula.getText())) {
					controlador.adicionarEstudante(alunoNovo);
					entradaCadastroNome.setText("");
					entradaCadastroIdade.setText("");
					entradaCadastroMatricula.setText("");
					grupoPaineis.show(paineis, "Tela de Controle");
				}
			}
		});
		btnCancelarCadastro.addActionListener(e -> grupoPaineis.show(paineis, "Tela de Controle"));

		// Eventos da consulta
		btnConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				msgEntradaConsulta.setText("Nome ou Matricula");
				grupoPaineis.show(paineis, "Tela de Consultar");
				painelExibirInfo.setVisible(false);
				btnEditar.setEnabled(false);
				btnExcluir.setEnabled(false);
			}
		});
		btnConfirmarConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = controlador.consultarEstudante(entradaConsultar.getText(), entradaConsultar.getText());
				if (index >= 0) {
					Estudante consultado = new Estudante();
					consultado = controlador.Estudantes.get(index);
					consultaExibirNome.setText("Nome: " + consultado.getNome());
					consultaExibirIdade.setText("Idade: " + consultado.getIdade());
					consultaExibirMatricula.setText("Matricula: " + consultado.getMatricula());
					consultaExibirMatricula.setVisible(true);
					painelExibirInfo.setVisible(true);
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
				}
			}
		});
		btnCancelarConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				grupoPaineis.show(paineis, "Tela de Controle");
				consultaExibirMatricula.setVisible(false);
			}
		});

		// Eventos da edição
		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				grupoPaineis.show(paineis, "Tela para Editar");
				msgEditarIdade.setText("Nova idade");
			}
		});
		btnSalvarEdicao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = controlador.consultarEstudante(entradaConsultar.getText(), entradaConsultar.getText());
				if (controlador.editarEstudante(entradaNovoNome.getText(), entradaNovaIdade.getText(), index)) {
					grupoPaineis.show(paineis, "Tela de Consultar");
					entradaNovoNome.setText("");
					entradaNovaIdade.setText("");
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
				}
			}
		});
		btnCancelarEdicao.addActionListener(e -> grupoPaineis.show(paineis, "Tela de Consultar"));

		// Eventos da exclusão
		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controlador.removerEstudante(entradaConsultar.getText(), entradaConsultar.getText());
			}
		});

		// sai do painel de controle
		btnSairDoControle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				grupoPaineis.show(paineis, "Tela Principal");
				msgCadastroIdade.setVisible(false);
				msgCadastroMatricula.setVisible(false);
				entradaCadastroIdade.setVisible(false);
				entradaCadastroMatricula.setVisible(false);
			}
		});
	}

	//////////////// Lógica dos botões relacionados ao Professor /////////////////
	private void eventosProfessor() {
		tituloTelaControle.setText("Controle de Professores");
		grupoPaineis.show(paineis, "Tela de Controle");
		msgCadastroEspecialidade.setVisible(true);
		entradaCadastroEspecialidade.setVisible(true);
		resetarAcoes(btnCadastrar, btnConfirmarCadastro, btnConsultar, btnConfirmarConsulta, btnEditar, btnSalvarEdicao,
				btnExcluir, btnSairDoControle);

		// Eventos do cadastro
		btnCadastrar.addActionListener(e -> grupoPaineis.show(paineis, "Tela de Cadastro"));
		btnConfirmarCadastro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Professor professorNovo = new Professor();
				professorNovo.cadastrar(entradaCadastroNome.getText(), entradaCadastroEspecialidade.getText());
				controlador.adicionarProfessor(professorNovo);
				entradaCadastroNome.setText("");
				entradaCadastroEspecialidade.setText("");
				grupoPaineis.show(paineis, "Tela de Controle");
			}
		});
		btnCancelarCadastro.addActionListener(e -> grupoPaineis.show(paineis, "Tela de Controle"));

		// Eventos da consulta
		btnConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				msgEntradaConsulta.setText("Apenas o nome");
				grupoPaineis.show(paineis, "Tela de Consultar");
				painelExibirInfo.setVisible(false);
				btnEditar.setEnabled(false);
				btnExcluir.setEnabled(false);
			}
		});
		btnConfirmarConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = controlador.consultarProfessor(entradaConsultar.getText());
				if (index >= 0) {
					Professor consultado = new Professor();
					consultado = controlador.Professores.get(index);
					consultaExibirNome.setText("Nome: " + consultado.getNome());
					consultaExibirIdade.setText("Especialidade: " + consultado.getEspecialidade());
					painelExibirInfo.setVisible(true);
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
				}
			}
		});
		btnCancelarConsulta.addActionListener(e -> grupoPaineis.show(paineis, "Tela de Controle"));

		// Eventos para editar
		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				grupoPaineis.show(paineis, "Tela para Editar");
				msgEditarIdade.setText("Nova especialidade");
			}
		});

		btnSalvarEdicao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = controlador.consultarProfessor(entradaConsultar.getText());
				if (controlador.editarProfessor(entradaNovoNome.getText(), entradaNovaIdade.getText(), index)) {
					grupoPaineis.show(paineis, "Tela de Consultar");
					entradaNovoNome.setText("");
					entradaNovaIdade.setText("");
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
				}
			}
		});
		btnCancelarEdicao.addActionListener(e -> grupoPaineis.show(paineis, "Tela de Consultar"));

		// Eventos para excluir
		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controlador.removerProfessor(entradaConsultar.getText());
			}
		});

		// sair do painel de controle
		btnSairDoControle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				grupoPaineis.show(paineis, "Tela Principal");
				msgCadastroEspecialidade.setVisible(false);
				entradaCadastroEspecialidade.setVisible(false);
			}
		});
	}

	//////////////// Lógica dos botões relacionados ao curso /////////////////
	private void eventosCurso() {
		tituloTelaControle.setText("Controle dos Cursos");
		grupoPaineis.show(paineis, "Tela de Controle");
		btnVincularNoCurso.setVisible(true);
		msgCadastroCargaHoraria.setVisible(true);
		entradaCadastroCargaHoraria.setVisible(true);
		resetarAcoes(btnCadastrar, btnConfirmarCadastro, btnConsultar, btnConfirmarConsulta, btnEditar, btnSalvarEdicao,
				btnExcluir, btnSairDoControle, btnVincularAluno, btnVincularProfessor);

		// Eventos de cadastro
		btnCadastrar.addActionListener(e -> grupoPaineis.show(paineis, "Tela de Cadastro"));
		btnConfirmarCadastro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Curso cursoNovo = new Curso();
				cursoNovo.setNomeCurso(entradaCadastroNome.getText());
				cursoNovo.setCargaHoraria(entradaCadastroCargaHoraria.getText());
				controlador.adicionarCurso(cursoNovo);
				grupoPaineis.show(paineis, "Tela de Controle");
				entradaCadastroNome.setText("");
				entradaCadastroCargaHoraria.setText("");
			}
		});
		btnCancelarCadastro.addActionListener(e -> grupoPaineis.show(paineis, "Tela de Controle"));

		// Eventos de consulta
		btnConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				msgEntradaConsulta.setText("Apenas o nome");
				grupoPaineis.show(paineis, "Tela de Consultar");
				painelExibirInfo.setVisible(false);
				btnEditar.setEnabled(false);
				btnExcluir.setEnabled(false);
			}
		});
		btnConfirmarConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = controlador.consultarCurso(entradaConsultar.getText());
				if (index >= 0) {
					Curso consultado = new Curso();
					consultado = controlador.Cursos.get(index);
					consultaExibirNome.setText("Nome: " + consultado.getNomeCurso());
					consultaExibirIdade.setText("Carga Horaria: " + consultado.getCargaHoraria());
					painelExibirInfo.setVisible(true);
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
				}
			}
		});
		btnCancelarConsulta.addActionListener(e -> grupoPaineis.show(paineis, "Tela de Controle"));

		// Eventos para editar
		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				grupoPaineis.show(paineis, "Tela para Editar");
				msgEditarIdade.setText("Nova carga horaria");
			}
		});
		btnSalvarEdicao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = controlador.consultarCurso(entradaConsultar.getText());
				if (controlador.editarCurso(entradaNovoNome.getText(), entradaNovaIdade.getText(), index)) {
					grupoPaineis.show(paineis, "Tela de Consultar");
					entradaNovoNome.setText("");
					entradaNovaIdade.setText("");
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
				}
			}
		});
		btnCancelarEdicao.addActionListener(e -> grupoPaineis.show(paineis, "Tela de Consultar"));

		// Eventos para excluir
		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controlador.removerCurso(entradaConsultar.getText());
			}
		});

		// Eventos para vincular
		btnVincularNoCurso.addActionListener(e -> grupoPaineis.show(paineis, "Tela para Vincular"));
		btnVincularAluno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int indexCurso = controlador.consultarCurso(entradaVincularCurso.getText());
				if (indexCurso >= 0) {
					int indexEstudante = controlador.consultarEstudante(entradaVincularAouP.getText(),
							entradaVincularAouP.getText());
					if (indexEstudante >= 0) {
						controlador.vincularNoCurso(controlador.Estudantes.get(indexEstudante),
								entradaVincularCurso.getText());
						grupoPaineis.show(paineis, "Tela de Controle");
						entradaVincularCurso.setText("");
						entradaVincularAouP.setText("");
					}
				}
			}
		});
		btnVincularProfessor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int indexCurso = controlador.consultarCurso(entradaVincularCurso.getText());
				if (indexCurso >= 0) {
					int indexProfessor = controlador.consultarProfessor(entradaVincularAouP.getText());
					if (indexProfessor >= 0) {
						controlador.vincularNoCurso(controlador.Professores.get(indexProfessor),
								entradaVincularCurso.getText());
						grupoPaineis.show(paineis, "Tela de Controle");
						entradaVincularCurso.setText("");
						entradaVincularAouP.setText("");
					}
				}
			}
		});
		btnSairVincular.addActionListener(e -> grupoPaineis.show(paineis, "Tela de Controle"));

		// Sai do painel de controle
		btnSairDoControle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				grupoPaineis.show(paineis, "Tela Principal");
				btnVincularNoCurso.setVisible(false);
				msgCadastroCargaHoraria.setVisible(false);
				entradaCadastroCargaHoraria.setVisible(false);
			}
		});
	}

	//////////////// Lógica dos botões relacionados ao gerar relatório
	//////////////// /////////////////
	private void gerarRelatorio() {
		grupoPaineis.show(paineis, "Tela para Gerar Relatorio");
		resetarAcoes(btnGerarRelAluno, btnGerarRelProfessor);

		// Gera a tabela aluno
		btnGerarRelAluno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] colunas = { "Nome", "Idade", "Matricula", "Curso matriculado" };
				String[][] dados = new String[controlador.Estudantes.size()][4];
				Estudante Aluno = new Estudante();
				if (controlador.Estudantes.size() == 0)
					return;
				for (int i = 0; i < controlador.Estudantes.size(); i++) {
					Aluno = controlador.Estudantes.get(i);
					dados[i][0] = Aluno.getNome();
					dados[i][1] = Integer.toString(Aluno.getIdade());
					dados[i][2] = Aluno.getMatricula();
					dados[i][3] = controlador.getCursoMatriculado(Aluno);
				}
				DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
				JTable tabelaAluno = new JTable(modelo);
				painelDeScroll.setViewportView(tabelaAluno);
			}
		});

		// Gera a tabela professor
		btnGerarRelProfessor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] colunas = { "Nome", "Especialidade", "Curso vinculado" };
				String[][] dados = new String[controlador.Professores.size()][3];
				Professor professor = new Professor();
				if (controlador.Professores.size() == 0)
					return;
				for (int i = 0; i < controlador.Professores.size(); i++) {
					professor = controlador.Professores.get(i);
					dados[i][0] = professor.getNome();
					dados[i][1] = professor.getEspecialidade();
					dados[i][2] = controlador.getCursoVinculado(professor);
				}
				DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
				JTable tabelaAluno = new JTable(modelo);
				painelDeScroll.setViewportView(tabelaAluno);
			}
		});
		btnSairDoGerarRel.addActionListener(e -> grupoPaineis.show(paineis, "Tela Principal"));
	}

	//////////////// Reseta as funcoes dos botões recebidos /////////////////
	public void resetarAcoes(JButton... botoes) {
		for (JButton botao : botoes) {
			for (ActionListener al : botao.getActionListeners()) {
				botao.removeActionListener(al);
			}
		}
	}

}
