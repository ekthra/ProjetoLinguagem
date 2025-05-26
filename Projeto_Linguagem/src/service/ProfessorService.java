package service;

import java.util.ArrayList;
import java.util.List;
import model.Professor;

public class ProfessorService {
    private List<Professor> professores = new ArrayList<>();
    public void cadastrarProfessor(Professor professor) {
        professores.add(professor);
    }
    public List<Professor> listarProfessores() {
        return professores;
    }
    public void atualizarProfessor(String nomeAntigo, String novoNome, String novaArea, String novaFormacao, int novoLimite) {
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(nomeAntigo)) {
                professor.setNome(novoNome);
                professor.setArea(novaArea);
                professor.setFormacao(novaFormacao);
                professor.setLimiteEmprestimos(novoLimite);
                System.out.println("Professor atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Professor não foi encontrado.");
    }
    public void deletarProfessor(String nome) {
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getNome().equalsIgnoreCase(nome)) {
                professores.remove(i);
                System.out.println("Deletado com sucesso!");
                return;
            }
        }
        System.out.println("Professor não encontrado.");
    }

    public Professor buscarProfessor(String nome) {
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(nome)) {
                return professor;
            }
        }
        return null;
    }

    public boolean incrementarLivrosEmprestados(String nome) {
        Professor professor = buscarProfessor(nome);
        if (professor != null) {
            professor.setLivrosEmprestados(professor.getLivrosEmprestados() + 1);
            return true;
        }
        return false;
    }

    public boolean decrementarLivrosEmprestados(String nome) {
        Professor professor = buscarProfessor(nome);
        if (professor != null && professor.getLivrosEmprestados() > 0) {
            professor.setLivrosEmprestados(professor.getLivrosEmprestados() - 1);
            return true;
        }
        return false;
    }
}
