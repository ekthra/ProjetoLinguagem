package model;

import model.interfaces.Emprestavel;

public class Livro implements Emprestavel {
    private String titulo;
    private String autor;
    private String categoria;
    private int quantidadeDisponivel;
    private boolean emprestado;

    public Livro(String titulo, String autor, String categoria, int quantidadeDisponivel, boolean emprestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.emprestado = emprestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    @Override
    public boolean Emprestar() {
        if (quantidadeDisponivel > 0) {
            quantidadeDisponivel--;
            emprestado = true;
            return true;
        } else {
            System.out.println("Não há livros disponíveis.");
            return false;
        }
    }

    @Override
    public boolean Devolver() {
        if (emprestado) {
            quantidadeDisponivel++;
            if (quantidadeDisponivel > 0) {
                emprestado = false;
            }
            return true;
        } else {
            System.out.println("O livro não está emprestado ou já foi devolvido.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", categoria='" + categoria + '\'' +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                ", emprestado=" + emprestado +
                '}';
    }

}
