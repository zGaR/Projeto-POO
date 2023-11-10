package teste;

import java.util.ArrayList;

class Turma {
    private ArrayList<Aluno> lista;
    private String nome;

    public Turma(String nome) {
        this.nome = nome;
        lista = new ArrayList<Aluno>();
    }

    public boolean adicionarAluno(Aluno a) {
        if (lista.size() < 30) {
            lista.add(a);
            return true;
        } else {
            return false;
        }
    }
    public void removerAluno(Aluno a) {
        if (lista.contains(a)) {
            lista.remove(a);
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    public ArrayList<Aluno> getLista() {
        return lista;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return "Turma: " + nome + ", Alunos: " + lista;
    }
}