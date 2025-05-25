package model;

public abstract class Pessoa {
    private String nome, cpf, email;
    private int livrosEmprestados;
    private int limiteEmprestimos;

    public Pessoa(String nome, String cpf, String email, int livrosEmprestados, int limiteEmprestimos) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.livrosEmprestados = livrosEmprestados;
        this.limiteEmprestimos = limiteEmprestimos;
    }
    public Pessoa() {
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(int livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }

    public int getLimiteEmprestimos() {
        return limiteEmprestimos;
    }

    public void setLimiteEmprestimos(int limiteEmprestimos) {
        this.limiteEmprestimos = limiteEmprestimos;
    }


    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nCPF: " + cpf +
                "\nEmail: " + email +
                "\nLivros Emprestados: " + livrosEmprestados +
                "\nLimite de Empréstimos: " + limiteEmprestimos;
    }
}
