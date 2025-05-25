package model;

public final class Professor extends Pessoa {
    private String area;
    private String formacao;
    public Professor(String area, String formacao) {
        this.area = area;
        this.formacao = formacao;
    }

    public Professor() {
    }
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public interface Emprestavel {
        public boolean Emprestar();
        public boolean Devolver();
    }
}
