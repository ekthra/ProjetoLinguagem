package controller;
import model.Aluno;
import service.AlunoService;


import java.util.List;
import java.util.Scanner;

public class AlunoController {
    private AlunoService alunoService = new AlunoService();

    public void cadastrarAluno(Aluno aluno) {
        alunoService.cadastrarAluno(aluno);
    }

    public void cadastrarAluno(Scanner sc) {
        Aluno a = new Aluno();
        System.out.println("\n=== CADASTRO DE ALUNO ===");
        System.out.print("Digite o nome do aluno: ");
        a.setNome(sc.nextLine());
        System.out.print("Digite a matrícula do aluno: ");
        a.setMatricula(sc.nextLine());
        System.out.print("Digite o curso do aluno: ");
        a.setCurso(sc.nextLine());
        System.out.print("Digite o limite de empréstimos (recomendado: 2): ");
        a.setLimiteEmprestimos(sc.nextInt());
        sc.nextLine();
        a.setLivrosEmprestados(0);
        alunoService.cadastrarAluno(a);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public List<Aluno> listarAlunos() {
        return alunoService.listarAluno();
    }
    public void atualizarAluno(String nomeAntigo, String novoNome, String novaMatricula, String novoCurso, int novoLimite) {
        alunoService.atualizarAluno(nomeAntigo, novoNome, novaMatricula, novoCurso, novoLimite);
    }
    public void deletarAluno(String nome) {
        alunoService.deletarAluno(nome);
    }

    public Aluno buscarAluno(String nome) {
        return alunoService.buscarAluno(nome);
    }

    public boolean incrementarLivrosEmprestados(String nome) {
        return alunoService.incrementarLivrosEmprestados(nome);
    }

    public boolean decrementarLivrosEmprestados(String nome) {
        return alunoService.decrementarLivrosEmprestados(nome);
    }
}

