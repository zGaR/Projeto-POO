package teste;

class Aluno {
    private String nome;
    private int semestre;
    private String matricula;

    public Aluno(String nome, int semestre, String matricula) {
        this.nome = nome;
        this.semestre = semestre;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String toString() {
        return "Nome: " + nome + ", Semestre: " + semestre + ", Matrícula: " + matricula;
    }
}