package teste;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Cadastro extends JFrame {
    private JTextField campoNome;
    private JTextField campoSemestre;
    private JTextField campoMatricula;
    private JComboBox<String> caixaTurma;
    private JButton botaoCadastrar;
    private JButton botaoVisualizar;
    private JLabel labelMensagem;
    private ArrayList<Turma> turmas;

    public Cadastro() {
        super("Cadastro de Alunos");
        setLayout(new FlowLayout());

        campoNome = new JTextField(10);
        campoSemestre = new JTextField(10);
        campoMatricula = new JTextField(10);
        caixaTurma = new JComboBox<String>();
        botaoCadastrar = new JButton("Cadastrar");
        botaoVisualizar = new JButton("Visualizar");
        labelMensagem = new JLabel("");

        add(new JLabel("Nome:"));
        add(campoNome);
        add(new JLabel("Semestre:"));
        add(campoSemestre);
        add(new JLabel("Matrícula:"));
        add(campoMatricula);
        add(new JLabel("Turma:"));
        add(caixaTurma);
        add(botaoCadastrar);
        add(botaoVisualizar);
        add(labelMensagem);

        turmas = new ArrayList<Turma>();
        turmas.add(new Turma("A"));
        turmas.add(new Turma("B"));
        turmas.add(new Turma("C"));

        for (Turma t : turmas) {
            caixaTurma.addItem(t.getNome());
        }

        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarAluno();
            }
        });

        botaoVisualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                visualizarTurma();
            }
        });

        setSize(400, 300);
        setVisible(true);
    }


    public void cadastrarAluno() {
        try {
            String nome = campoNome.getText();
            int semestre = Integer.parseInt(campoSemestre.getText());
            String matricula = campoMatricula.getText();

            Aluno a = new Aluno(nome, semestre, matricula);

            int indice = caixaTurma.getSelectedIndex();

            boolean adicionado = turmas.get(indice).adicionarAluno(a);
            if (adicionado) {
                labelMensagem.setText("Aluno cadastrado com sucesso!");
            } else {
                labelMensagem.setText("Turma cheia!");
            }
            campoNome.setText("");
            campoSemestre.setText("");
            campoMatricula.setText("");
        } catch (NumberFormatException e) {
            labelMensagem.setText("Semestre inválido!");
        }
    }

    public void visualizarTurma() {
        int indice = caixaTurma.getSelectedIndex();

        Turma t = turmas.get(indice);

        ArrayList<Aluno> lista = t.getLista();

        String dados = "";
        for (Aluno a : lista) {
            dados += a + "\n";
        }

        JOptionPane.showMessageDialog(this, dados, "Alunos da turma " + t.getNome(), JOptionPane.INFORMATION_MESSAGE);
    }
}