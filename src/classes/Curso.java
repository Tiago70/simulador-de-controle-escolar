package classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Curso {
	private String nomeCurso;
	private String cargaHoraria;
	private Professor professorVinculado;
	private ArrayList<Estudante> AlunosMatricuados = new ArrayList<>();	
	
	public Curso() {
		
	}
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public String getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public Professor getProfessorVinculado() {
		return professorVinculado;
	}
	public void setProfessorVinculado(Professor professorVinculado) {
		this.professorVinculado = professorVinculado;
	}
	
	public void vincularAluno(Estudante AlunoNovoNoCurso) {
		AlunosMatricuados.add(AlunoNovoNoCurso);
	}
	
	public boolean cadastro(String nome, String cargaHoraria) {
    	if (nome.isEmpty()|| cargaHoraria.isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        setNomeCurso(nome); 
        setCargaHoraria(cargaHoraria);
        return true;
	}
	
	public String consultarCursoMatriculado(Estudante aluno) {
		for (int i = 0; i < AlunosMatricuados.size(); i++) {
			Estudante matricularos = AlunosMatricuados.get(i);
			if (aluno.getMatricula().equals(matricularos.getMatricula())) {
				return nomeCurso;
			}
		}
		return null;
	}
}
