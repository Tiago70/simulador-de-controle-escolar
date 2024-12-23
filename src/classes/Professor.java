package classes;

import javax.swing.JOptionPane;

public class Professor extends Pessoa{
    String especialidade;

    public Professor(String nome, int idade, String especialidade){
        super(nome, idade);
        this.especialidade = especialidade;
    }
    
    public Professor() {
    	
    }

    public String getEspecialidade(){
        return especialidade;
    }
    
    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }

    public void editarNome(String nome){
        setNome(nome);
    }
    
    public void editarIdade(int idade){
        setIdade(idade);
    }

    public void editarEspecialidade(String matricula){
        setEspecialidade(matricula);
    }
    
    public boolean cadastrar(String nome, String especialidade){
    	if (nome.isEmpty() || especialidade.isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        setNome(nome); 
        setEspecialidade(especialidade);
        return true;
    }
    
 // O seguinte método não foi utilizado, mas mantemos mesmo assim
    @Override
    void exibirDados() {
        System.out.println("Nome: " + getNome() + " especialidade " + getEspecialidade());
    }
    
}
