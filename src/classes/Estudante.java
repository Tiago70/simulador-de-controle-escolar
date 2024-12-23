package classes;

import javax.swing.JOptionPane;

public class Estudante extends Pessoa{
    private String matricula;

    public Estudante(String nome, int idade, String matricula){
        super(nome, idade);
        this.matricula = matricula;
    }
    
    public Estudante(){
    	
    }
    
    public String getMatricula(){
        return matricula;
    }
    
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public void editarNome(String nome){
        setNome(nome);
    }
    
    public void editarIdade(int idade){
        setIdade(idade);
    }

    public void editarMatricula(String matricula){
        setMatricula(matricula);
    }

    public boolean cadastrar(String nome, String idade, String matricula){
    	int idadeInteiro = -1;
    	if (!idade.isEmpty()) {
    		idadeInteiro = Integer.parseInt(idade);
    	}
    	if (nome.isEmpty() || idadeInteiro < 0 || matricula.isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        setNome(nome); 
        setIdade(idadeInteiro);
        this.matricula = matricula;
        return true;
    }
    
    // O seguinte método não foi utilizado, mas mantemos mesmo assim
    @Override
    void exibirDados() {
        System.out.println("Nome: " + getNome() + " Idade " + getIdade() + " matrícula " + getMatricula());
    }
    
}

