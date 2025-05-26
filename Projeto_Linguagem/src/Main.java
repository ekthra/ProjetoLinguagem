import controller.AlunoController;
import controller.ProfessorController;
import controller.BibliotecaController;
import java.util.Scanner;
import java.util.List;
import model.Aluno;
import model.Professor;
import model.Livro;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProfessorController professorController = new ProfessorController();
        AlunoController alunoController = new AlunoController();
        BibliotecaController bibliotecaController = new BibliotecaController();
        int opcao;

        do {
            System.out.println("\n=== BIBLIOTECA UNIVERSITÁRIA ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Emprestar Livro");
            System.out.println("6 - Devolver Livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    menuCadastro(sc, professorController, alunoController, bibliotecaController);
                    break;
                case 2:
                    menuListar(sc, professorController, alunoController, bibliotecaController);
                    break;
                case 3:
                    menuAtualizar(sc, professorController, alunoController, bibliotecaController);
                    break;
                case 4:
                    menuExcluir(sc, professorController, alunoController, bibliotecaController);
                    break;
                case 5:
                    menuEmprestarLivro(sc, professorController, alunoController, bibliotecaController);
                    break;
                case 6:
                    menuDevolverLivro(sc, professorController, alunoController, bibliotecaController);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }

    private static void menuCadastro(Scanner sc, ProfessorController professorController,
                                     AlunoController alunoController, BibliotecaController bibliotecaController) {
        System.out.println("\n=== MENU DE CADASTRO ===");
        System.out.println("1 - Cadastrar Professor");
        System.out.println("2 - Cadastrar Aluno");
        System.out.println("3 - Cadastrar Livro");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine(); // Limpar o buffer

        switch (opcao) {
            case 1:
                professorController.cadastrarProfessor(sc);
                break;
            case 2:
                alunoController.cadastrarAluno(sc);
                break;
            case 3:
                bibliotecaController.cadastrarLivro(sc);
                break;
            case 0:
                return;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void menuListar(Scanner sc, ProfessorController professorController,
                                   AlunoController alunoController, BibliotecaController bibliotecaController) {
        System.out.println("\n=== MENU DE LISTAGEM ===");
        System.out.println("1 - Listar Professores");
        System.out.println("2 - Listar Alunos");
        System.out.println("3 - Listar Livros");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                listarProfessores(professorController);
                break;
            case 2:
                listarAlunos(alunoController);
                break;
            case 3:
                listarLivros(bibliotecaController);
                break;
            case 0:
                return;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void menuAtualizar(Scanner sc, ProfessorController professorController,
                                      AlunoController alunoController, BibliotecaController bibliotecaController) {
        System.out.println("\n=== MENU DE ATUALIZAÇÃO ===");
        System.out.println("1 - Atualizar Professor");
        System.out.println("2 - Atualizar Aluno");
        System.out.println("3 - Atualizar Livro");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                atualizarProfessor(sc, professorController);
                break;
            case 2:
                atualizarAluno(sc, alunoController);
                break;
            case 3:
                atualizarLivro(sc, bibliotecaController);
                break;
            case 0:
                return;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void menuExcluir(Scanner sc, ProfessorController professorController,
                                    AlunoController alunoController, BibliotecaController bibliotecaController) {
        System.out.println("\n=== MENU DE EXCLUSÃO ===");
        System.out.println("1 - Excluir Professor");
        System.out.println("2 - Excluir Aluno");
        System.out.println("3 - Excluir Livro");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o nome do professor a ser excluído: ");
                String nomeProfessor = sc.nextLine();
                professorController.deletarProfessor(nomeProfessor);
                break;
            case 2:
                System.out.print("Digite o nome do aluno a ser excluído: ");
                String nomeAluno = sc.nextLine();
                alunoController.deletarAluno(nomeAluno);
                break;
            case 3:
                System.out.print("Digite o título do livro a ser excluído: ");
                String tituloLivro = sc.nextLine();
                bibliotecaController.deletarLivro(tituloLivro);
                break;
            case 0:
                return;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void menuEmprestarLivro(Scanner sc, ProfessorController professorController,
                                           AlunoController alunoController, BibliotecaController bibliotecaController) {
        System.out.println("\n=== MENU DE EMPRÉSTIMO DE LIVROS ===");
        System.out.println("1 - Emprestar para Professor");
        System.out.println("2 - Emprestar para Aluno");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                emprestarLivroProfessor(sc, professorController, bibliotecaController);
                break;
            case 2:
                emprestarLivroAluno(sc, alunoController, bibliotecaController);
                break;
            case 0:
                return;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void emprestarLivroProfessor(Scanner sc, ProfessorController professorController,
                                                BibliotecaController bibliotecaController) {
        System.out.println("\n=== EMPRÉSTIMO PARA PROFESSOR ===");
        System.out.print("Digite o nome do professor: ");
        String nomeProfessor = sc.nextLine();

        Professor professor = professorController.buscarProfessor(nomeProfessor);
        if (professor == null) {
            System.out.println("Professor não encontrado!");
            return;
        }

        if (professor.getLivrosEmprestados() >= professor.getLimiteEmprestimos()) {
            System.out.println("Professor atingiu o limite de empréstimos!");
            return;
        }

        System.out.print("Digite o título do livro: ");
        String tituloLivro = sc.nextLine();

        Livro livro = bibliotecaController.buscarLivro(tituloLivro);
        if (livro == null) {
            System.out.println("Livro não encontrado!");
            return;
        }

        if (livro.getQuantidadeDisponivel() <= 0) {
            System.out.println("Livro não disponível para empréstimo!");
            return;
        }

        if (bibliotecaController.emprestarLivro(tituloLivro) &&
                professorController.incrementarLivrosEmprestados(nomeProfessor)) {
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Erro ao realizar o empréstimo!");
        }
    }

    private static void emprestarLivroAluno(Scanner sc, AlunoController alunoController,
                                            BibliotecaController bibliotecaController) {
        System.out.println("\n=== EMPRÉSTIMO PARA ALUNO ===");
        System.out.print("Digite o nome do aluno: ");
        String nomeAluno = sc.nextLine();

        Aluno aluno = alunoController.buscarAluno(nomeAluno);
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }

        if (aluno.getLivrosEmprestados() >= aluno.getLimiteEmprestimos()) {
            System.out.println("Aluno atingiu o limite de empréstimos!");
            return;
        }

        System.out.print("Digite o título do livro: ");
        String tituloLivro = sc.nextLine();

        Livro livro = bibliotecaController.buscarLivro(tituloLivro);
        if (livro == null) {
            System.out.println("Livro não encontrado!");
            return;
        }

        if (livro.getQuantidadeDisponivel() <= 0) {
            System.out.println("Livro não disponível para empréstimo!");
            return;
        }

        if (bibliotecaController.emprestarLivro(tituloLivro) &&
                alunoController.incrementarLivrosEmprestados(nomeAluno)) {
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Erro ao realizar o empréstimo!");
        }
    }

    private static void listarProfessores(ProfessorController controller) {
        System.out.println("\n=== LISTA DE PROFESSORES ===");
        List<Professor> professores = controller.listarProfessores();
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            for (Professor professor : professores) {
                System.out.println("Nome: " + professor.getNome());
                System.out.println("Especialização: " + professor.getArea());
                System.out.println("Formação: " + professor.getFormacao());
                System.out.println("Limite de Empréstimos: " + professor.getLimiteEmprestimos());
                System.out.println("Livros Emprestados: " + professor.getLivrosEmprestados());
                System.out.println("Livros Disponíveis para Empréstimo: " +
                        (professor.getLimiteEmprestimos() - professor.getLivrosEmprestados()));
                System.out.println("------------------------");
            }
        }
    }

    private static void listarAlunos(AlunoController controller) {
        System.out.println("\n=== LISTA DE ALUNOS ===");
        List<Aluno> alunos = controller.listarAlunos();
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Matrícula: " + aluno.getMatricula());
                System.out.println("Curso: " + aluno.getCurso());
                System.out.println("Limite de Empréstimos: " + aluno.getLimiteEmprestimos());
                System.out.println("Livros Emprestados: " + aluno.getLivrosEmprestados());
                System.out.println("Livros Disponíveis para Empréstimo: " +
                        (aluno.getLimiteEmprestimos() - aluno.getLivrosEmprestados()));
                System.out.println("------------------------");
            }
        }
    }

    private static void listarLivros(BibliotecaController controller) {
        System.out.println("\n=== LISTA DE LIVROS ===");
        List<Livro> livros = controller.listarLivros();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (Livro livro : livros) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Categoria: " + livro.getCategoria());
                System.out.println("Quantidade Disponível: " + livro.getQuantidadeDisponivel());
                System.out.println("Status: " + (livro.isEmprestado() ? "Emprestado" : "Disponível"));
                System.out.println("------------------------");
            }
        }
    }

    private static void atualizarProfessor(Scanner sc, ProfessorController controller) {
        System.out.println("\n=== ATUALIZAR PROFESSOR ===");
        System.out.print("Digite o nome do professor que deseja atualizar: ");
        String nomeAntigo = sc.nextLine();
        System.out.print("Digite o novo nome: ");
        String novoNome = sc.nextLine();
        System.out.print("Digite a nova especialização: ");
        String novaArea = sc.nextLine();
        System.out.print("Digite a nova formação: ");
        String novaFormacao = sc.nextLine();
        System.out.print("Digite o novo limite de empréstimos: ");
        int novoLimite = sc.nextInt();
        sc.nextLine();

        controller.atualizarProfessor(nomeAntigo, novoNome, novaArea, novaFormacao, novoLimite);
        System.out.println("Professor atualizado com sucesso!");
    }

    private static void atualizarAluno(Scanner sc, AlunoController controller) {
        System.out.println("\n=== ATUALIZAR ALUNO ===");
        System.out.print("Digite o nome do aluno que deseja atualizar: ");
        String nomeAntigo = sc.nextLine();
        System.out.print("Digite o novo nome: ");
        String novoNome = sc.nextLine();
        System.out.print("Digite a nova matrícula: ");
        String novaMatricula = sc.nextLine();
        System.out.print("Digite o novo curso: ");
        String novoCurso = sc.nextLine();
        System.out.print("Digite o novo limite de empréstimos: ");
        int novoLimite = sc.nextInt();
        sc.nextLine();

        controller.atualizarAluno(nomeAntigo, novoNome, novaMatricula, novoCurso, novoLimite);
        System.out.println("Aluno atualizado com sucesso!");
    }

    private static void atualizarLivro(Scanner sc, BibliotecaController controller) {
        System.out.println("\n=== ATUALIZAR LIVRO ===");
        System.out.print("Digite o título do livro que deseja atualizar: ");
        String tituloAntigo = sc.nextLine();
        System.out.print("Digite o novo título: ");
        String novoTitulo = sc.nextLine();
        System.out.print("Digite o novo autor: ");
        String novoAutor = sc.nextLine();
        System.out.print("Digite a nova categoria: ");
        String novaCategoria = sc.nextLine();
        System.out.print("Digite a nova quantidade disponível: ");
        int novaQuantidade = sc.nextInt();
        sc.nextLine();

        controller.atualizarLivro(tituloAntigo, novoTitulo, novoAutor, novaCategoria, novaQuantidade);
        System.out.println("Livro atualizado com sucesso!");
    }

    private static void menuDevolverLivro(Scanner sc, ProfessorController professorController,
                                          AlunoController alunoController, BibliotecaController bibliotecaController) {
        System.out.println("\n=== MENU DE DEVOLUÇÃO DE LIVROS ===");
        System.out.println("1 - Devolver Livro de Professor");
        System.out.println("2 - Devolver Livro de Aluno");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                devolverLivroProfessor(sc, professorController, bibliotecaController);
                break;
            case 2:
                devolverLivroAluno(sc, alunoController, bibliotecaController);
                break;
            case 0:
                return;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void devolverLivroProfessor(Scanner sc, ProfessorController professorController,
                                               BibliotecaController bibliotecaController) {
        System.out.println("\n=== DEVOLUÇÃO DE LIVRO POR PROFESSOR ===");
        System.out.print("Digite o nome do professor: ");
        String nomeProfessor = sc.nextLine();

        Professor professor = professorController.buscarProfessor(nomeProfessor);
        if (professor == null) {
            System.out.println("Professor não encontrado!");
            return;
        }

        if (professor.getLivrosEmprestados() <= 0) {
            System.out.println("Professor não possui livros emprestados!");
            return;
        }

        System.out.print("Digite o título do livro: ");
        String tituloLivro = sc.nextLine();

        Livro livro = bibliotecaController.buscarLivro(tituloLivro);
        if (livro == null) {
            System.out.println("Livro não encontrado!");
            return;
        }

        if (bibliotecaController.devolverLivro(tituloLivro) &&
                professorController.decrementarLivrosEmprestados(nomeProfessor)) {
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Erro ao realizar a devolução!");
        }
    }

    private static void devolverLivroAluno(Scanner sc, AlunoController alunoController,
                                           BibliotecaController bibliotecaController) {
        System.out.println("\n=== DEVOLUÇÃO DE LIVRO POR ALUNO ===");
        System.out.print("Digite o nome do aluno: ");
        String nomeAluno = sc.nextLine();

        Aluno aluno = alunoController.buscarAluno(nomeAluno);
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }

        if (aluno.getLivrosEmprestados() <= 0) {
            System.out.println("Aluno não possui livros emprestados!");
            return;
        }

        System.out.print("Digite o título do livro: ");
        String tituloLivro = sc.nextLine();

        Livro livro = bibliotecaController.buscarLivro(tituloLivro);
        if (livro == null) {
            System.out.println("Livro não encontrado!");
            return;
        }

        if (bibliotecaController.devolverLivro(tituloLivro) &&
                alunoController.decrementarLivrosEmprestados(nomeAluno)) {
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Erro ao realizar a devolução!");
        }
    }
}