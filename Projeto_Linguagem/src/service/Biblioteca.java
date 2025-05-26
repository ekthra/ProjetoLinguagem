package service;

import java.util.ArrayList;
import java.util.List;
import model.Livro;


public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();
    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }
    public List<Livro> listarLivros() {
        return livros;
    }
    public void atualizarLivro(String tituloAntigo, String novoTitulo, String novoAutor, String novaCategoria, int novaQuantidade) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(tituloAntigo)) {
                livro.setTitulo(novoTitulo);
                livro.setAutor(novoAutor);
                livro.setCategoria(novaCategoria);
                livro.setQuantidadeDisponivel(novaQuantidade);
                System.out.println("Livro atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Livro não foi encontrado.");
    }
    public void deletarLivro(String titulo) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                livros.remove(i);
                System.out.println("Deletado com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }
    public Livro buscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }
    public boolean emprestarLivro(String titulo) {
        Livro livro = buscarLivro(titulo);
        if (livro != null) {
            return livro.Emprestar();
        }
        return false;
    }
    public boolean devolverLivro(String titulo) {
        Livro livro = buscarLivro(titulo);
        if (livro != null) {
            return livro.Devolver();
        }
        return false;
    }
}




