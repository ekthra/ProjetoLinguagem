package controller;

import model.Professor;
import service.ProfessorService;

import java.util.List;
import java.util.Scanner;

public class ProfessorController {
    private ProfessorService professorService = new ProfessorService();

    public void cadastrarProfessor(Professor professor) {
        professorService.cadastrarProfessor(professor);
    }

    public void cadastrarProfessor(Scanner sc) {
        Professor p = new Professor();
        System.out.println("\n=== CADASTRO DE PROFESSOR ===");
        System.out.print("Digite o nome do professor: ");
        p.setNome(sc.nextLine());
        System.out.print("Digite a especialização do professor: ");
        p.setArea(sc.nextLine());
        System.out.print("Digite a formação do professor: ");
        p.setFormacao(sc.nextLine());
        System.out.print("Digite o limite de empréstimos (recomendado: 4): ");
        p.setLimiteEmprestimos(sc.nextInt());
        sc.nextLine();
        p.setLivrosEmprestados(0);
        professorService.cadastrarProfessor(p);
        System.out.println("Professor cadastrado com sucesso!");
    }

    public List<Professor> listarProfessores() {
        return professorService.listarProfessores();
    }
    public void atualizarProfessor(String nomeAntigo, String novoNome, String novaArea, String novaFormacao, int novoLimite) {
        professorService.atualizarProfessor(nomeAntigo, novoNome, novaArea, novaFormacao, novoLimite);
    }
    public void deletarProfessor(String nome) {
        professorService.deletarProfessor(nome);
    }

    public Professor buscarProfessor(String nome) {
        return professorService.buscarProfessor(nome);
    }

    public boolean incrementarLivrosEmprestados(String nome) {
        return professorService.incrementarLivrosEmprestados(nome);
    }

    public boolean decrementarLivrosEmprestados(String nome) {
        return professorService.decrementarLivrosEmprestados(nome);
    }
}
