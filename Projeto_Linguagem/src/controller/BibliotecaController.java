package controller;

import java.util.List;
import java.util.Scanner;
import model.Livro;
import service.Biblioteca;

public class BibliotecaController {
    private Biblioteca biblioteca = new Biblioteca();

    public void cadastrarLivro(Livro livro) {
        biblioteca.cadastrarLivro(livro);
    }

    public void cadastrarLivro(Scanner sc) {
        System.out.println("\n=== CADASTRO DE LIVRO ===");
        System.out.print("Digite o título do livro: ");
        String titulo = sc.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = sc.nextLine();
        System.out.print("Digite a categoria do livro: ");
        String categoria = sc.nextLine();
        System.out.print("Digite a quantidade disponível: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        Livro livro = new Livro(titulo, autor, categoria, quantidade, false);
        biblioteca.cadastrarLivro(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public List<Livro> listarLivros() {
        return biblioteca.listarLivros();
    }
    public void atualizarLivro(String tituloAntigo, String novoTitulo, String novoAutor, String novaCategoria, int novaQuantidade) {
        biblioteca.atualizarLivro(tituloAntigo, novoTitulo, novoAutor, novaCategoria, novaQuantidade);
    }
    public void deletarLivro(String titulo) {
        biblioteca.deletarLivro(titulo);
    }
    public Livro buscarLivro(String titulo) {
        return biblioteca.buscarLivro(titulo);
    }
    public boolean emprestarLivro(String titulo) {
        return biblioteca.emprestarLivro(titulo);
    }
    public boolean devolverLivro(String titulo) {
        return biblioteca.devolverLivro(titulo);
    }
}
