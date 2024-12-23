package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.*;

public class Logica {
	// Listas onde armazenam todos os dados 
	public ArrayList<Estudante> Estudantes = new ArrayList<>();
	public ArrayList<Professor> Professores = new ArrayList<>();
	public ArrayList<Curso> Cursos = new ArrayList<>();
	
	//////////////// Lógica da manipulação dos dados dos Alunos ////////////////
	public void adicionarEstudante(Estudante AlunoNovo) {
		Estudantes.add(AlunoNovo);
	}

	public int consultarEstudante(String nome, String matricula) {
		if (Estudantes.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há alunos cadastrados");
			return -1;
		}
		for (int i = 0; i < Estudantes.size(); i++) {
			Estudante verificador = new Estudante();
			verificador = Estudantes.get(i);
			if (verificador.getNome().equals(nome) || verificador.getMatricula().equals(matricula)) {
				return i;
			}
		}
		JOptionPane.showMessageDialog(null, "Não foi encontrado um aluno com este nome ou matricula");
		return -1;
	}

	public boolean editarEstudante(String nome, String idade, int index) {
		Estudante verificador = new Estudante();
		verificador = Estudantes.get(index);
		
		int idadeInteiro = verificador.getIdade();
		
		if (!nome.isEmpty() || !idade.isEmpty()) {
			if (!idade.isEmpty()) idadeInteiro = Integer.parseInt(idade);
			if (nome.isEmpty()) nome = verificador.getNome();
			if (idadeInteiro < 0 ) {
				JOptionPane.showMessageDialog(null, "Não é permitido idade menor que 0");
				return false;
			}
			
			verificador.setNome(nome);
			verificador.setIdade(idadeInteiro);
			Estudantes.set(index, verificador);
			
			JOptionPane.showMessageDialog(null, "Estudante alterado com sucesso");
			return true;
		}

		JOptionPane.showMessageDialog(null, "Preencha pelo menos um dos campos");
		return false;
	}

	public boolean removerEstudante(String nome, String matricula) {
		int existe = consultarEstudante(nome, matricula);
		if (existe >= 0) {
			Estudantes.remove(existe);
			JOptionPane.showMessageDialog(null, "Estudante removido com secesso");
			return true;
		}
		return false;
	}
	public String getCursoMatriculado(Estudante aluno) {
		String nome = null;
		List<String> nomesLista = new ArrayList<>();
		for (int i = 0; i < Cursos.size(); i++) {
			Curso curso = Cursos.get(i);
			nome = curso.consultarCursoMatriculado(aluno);
			if (nome != null) {
				nomesLista.add(nome);
			}
		}
		nome = "";
		for (int i = 0; i < nomesLista.size(); i++) {
			if (i == 0) {
				nome = nome + nomesLista.get(i);
				continue;
			} 
			nome = nome + ", " + nomesLista.get(i);
		}
		if(nome == "") return "Não matriculado";
		return nome;
	}
	
	//////////////// Lógica da manipulação dos dados dos professores ////////////////
	public void adicionarProfessor(Professor professorNovo) {
		Professores.add(professorNovo);
	}
	
	public int consultarProfessor(String nome) {
		if (Professores.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há Professores cadastrados");
			return -1;
		}
		for (int i = 0; i < Professores.size(); i++) {
			Professor verificador = new Professor();
			verificador = Professores.get(i);
			if (verificador.getNome().equals(nome)) {
				return i;
			}
		}
		JOptionPane.showMessageDialog(null, "Não foi encontrado um professor com este nome");
		return -1;
	}
	
	public boolean editarProfessor(String nome, String especialidade, int index) {
		Professor verificador = new Professor();
		verificador = Professores.get(index);
		
		if (!nome.isEmpty() || !especialidade.isEmpty()) {
			if (especialidade.isEmpty()) especialidade = verificador.getEspecialidade();
			if (nome.isEmpty()) nome = verificador.getNome();
			
			verificador.setNome(nome);
			verificador.setEspecialidade(especialidade);
			Professores.set(index, verificador);
			
			JOptionPane.showMessageDialog(null, "Professor alterado com sucesso");
			return true;
		}

		JOptionPane.showMessageDialog(null, "Preencha pelo menos um dos campos");
		return false;
	}
	
	public boolean removerProfessor(String nome) {
		int existe = consultarProfessor(nome);
		if (existe >= 0) {
			Professores.remove(existe);
			JOptionPane.showMessageDialog(null, "Professor removido com secesso");
			return true;
		}
		return false;
	}
	
	public String getCursoVinculado(Professor professor) {
		for (int i = 0; i < Cursos.size(); i++) {
			Curso curso = Cursos.get(i);
			Professor verificador = curso.getProfessorVinculado();
			if (verificador != null && verificador.getNome() == professor.getNome()) {				
				return curso.getNomeCurso();
			}
		}
		return "Não vinculado";
	}
	
	//////////////// Lógica da manipulação dos dados dos Cursos ////////////////
	public void adicionarCurso(Curso CursoNovo) {
		Cursos.add(CursoNovo);
	}
	
	public int consultarCurso(String nome) {
		if (Cursos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há cursos cadastrados");
			return -1;
		}
		for (int i = 0; i < Cursos.size(); i++) {
			Curso verificador = new Curso();
			verificador = Cursos.get(i);
			if (verificador.getNomeCurso().equals(nome)) {
				return i;
			}
		}
		JOptionPane.showMessageDialog(null, "Não foi encontrado um curso com este nome");
		return -1;
	}
	public boolean editarCurso(String nome, String cargaHoraria, int index) {
		Curso verificador = new Curso();
		verificador = Cursos.get(index);
		
		if (!nome.isEmpty() || !cargaHoraria.isEmpty()) {
			if (cargaHoraria.isEmpty()) cargaHoraria = verificador.getCargaHoraria();
			if (nome.isEmpty()) nome = verificador.getNomeCurso();
			verificador.setNomeCurso(nome);
			verificador.setCargaHoraria(cargaHoraria);
			Cursos.set(index, verificador);
			
			JOptionPane.showMessageDialog(null, "Curso alterado com sucesso");
			return true;
		}

		JOptionPane.showMessageDialog(null, "Preencha pelo menos um dos campos");
		return false;
	}
	
	public boolean removerCurso(String nome) {
		int existe = consultarCurso(nome);
		if (existe >= 0) {
			Cursos.remove(existe);
			JOptionPane.showMessageDialog(null, "Curso removido com secesso");
			return true;
		}
		return false;
	}
	
	public void vincularNoCurso(Estudante AlunoNovo, String nomeDoCurso) {
		Curso aux = new Curso();
		if (Cursos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há cursos cadastrados");
			return;
		}
		for(int i = 0; i < Cursos.size(); i++) {
			aux = Cursos.get(i);
			if (aux.getNomeCurso().equals(nomeDoCurso)) {
				aux.vincularAluno(AlunoNovo);
				Cursos.set(i, aux);
				JOptionPane.showMessageDialog(null, "Aluno vinculado com sucesso");
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "Não foi econtrado um curso com este nome");
	}
	public void vincularNoCurso(Professor ProfessorNovo, String nomeDoCurso) {
		Curso aux = new Curso();
		if (Cursos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há cursos cadastrados");
			return;
		}
		for(int i = 0; i < Cursos.size(); i++) {
			aux = Cursos.get(i);
			if (aux.getNomeCurso().equals(nomeDoCurso)) {
				aux.setProfessorVinculado(ProfessorNovo);
				Cursos.set(i, aux);
				JOptionPane.showMessageDialog(null, "Professor vinculado com sucesso");
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "Não foi econtrado um curso com este nome");
	}
	
}
