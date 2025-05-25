package model;

public final class Aluno extends Pessoa {
    private double media;
    private String matricula;
    private String curso;

    public Aluno(double media, String matricula) {
        this.media = media;
        this.matricula = matricula;
    }
    public Aluno() {
    }
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public Aluno(double media, String matricula, int livrosEmprestados, int limiteEmprestimos) {
        this.media = media;
        this.matricula = matricula;

    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "media=" + media +
                ", matricula='" + matricula + '\'' +
                ", curso='" + curso + '\'' +
                ", nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", livrosEmprestados=" + getLivrosEmprestados() +
                ", limiteEmprestimos=" + getLimiteEmprestimos() +
                '}';
    }


}
