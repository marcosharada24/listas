package br.edu.fatecpg.lista.view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import br.edu.fatecpg.lista.model.Aluno;

public class Jframe2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txt_nome;
    private JTextField txt_telefone;
    private JButton btn_atualizar;
    private JButton btn_excluir;

    public Jframe2(ArrayList<Aluno> ListaAlunos) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        if (ListaAlunos == null || ListaAlunos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum aluno cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JComboBox<Aluno> comboBox = new JComboBox<>(ListaAlunos.toArray(new Aluno[0]));
        comboBox.setBounds(10, 30, 400, 30);
        contentPane.add(comboBox);

        JLabel lbl_nome = new JLabel("Nome:");
        lbl_nome.setBounds(10, 80, 400, 30);
        contentPane.add(lbl_nome);

        JLabel lbl_telefone = new JLabel("Telefone:");
        lbl_telefone.setBounds(10, 120, 400, 30);
        contentPane.add(lbl_telefone);

        txt_nome = new JTextField();
        txt_nome.setBounds(10, 160, 200, 30);
        contentPane.add(txt_nome);
        txt_nome.setColumns(10);

        txt_telefone = new JTextField();
        txt_telefone.setBounds(10, 200, 200, 30);
        contentPane.add(txt_telefone);
        txt_telefone.setColumns(10);

        btn_atualizar = new JButton("Atualizar");
        btn_atualizar.setBounds(220, 160, 200, 30);
        contentPane.add(btn_atualizar);
        btn_atualizar.setEnabled(false);

        btn_excluir = new JButton("Excluir");
        btn_excluir.setBounds(220, 200, 200, 30);
        contentPane.add(btn_excluir);
        btn_excluir.setEnabled(false);

        comboBox.addActionListener(e -> {
            Aluno alunoSelecionado = (Aluno) comboBox.getSelectedItem();
            if (alunoSelecionado != null) {
                txt_nome.setText(alunoSelecionado.getNome());
                txt_telefone.setText(alunoSelecionado.getTelefone());

                lbl_nome.setText("Nome: " + alunoSelecionado.getNome());
                lbl_telefone.setText("Telefone: " + alunoSelecionado.getTelefone());

                btn_atualizar.setEnabled(true);
                btn_excluir.setEnabled(true);
            }
        });

        btn_atualizar.addActionListener(e -> {
            Aluno alunoSelecionado = (Aluno) comboBox.getSelectedItem();
            if (alunoSelecionado != null) {
                boolean nomeAlterado = !txt_nome.getText().equals(alunoSelecionado.getNome());
                boolean telefoneAlterado = !txt_telefone.getText().equals(alunoSelecionado.getTelefone());

                if (nomeAlterado || telefoneAlterado) {
                    alunoSelecionado.setNome(txt_nome.getText());
                    alunoSelecionado.setTelefone(txt_telefone.getText());
                    JOptionPane.showMessageDialog(this, "Aluno atualizado com sucesso!");

                    comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(ListaAlunos.toArray(new Aluno[0])));

                    txt_nome.setText("");
                    txt_telefone.setText("");

                    btn_atualizar.setEnabled(false);
                    btn_excluir.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhuma alteração detectada!", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        btn_excluir.addActionListener(e -> {
            Aluno alunoSelecionado = (Aluno) comboBox.getSelectedItem();
            if (alunoSelecionado != null) {
                int confirmacao = JOptionPane.showConfirmDialog(this,
                        "Tem certeza que deseja excluir o aluno " + alunoSelecionado.getNome() + "?",
                        "Confirmação de exclusão", JOptionPane.YES_NO_OPTION);

                if (confirmacao == JOptionPane.YES_OPTION) {
                    ListaAlunos.remove(alunoSelecionado);

                    comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(ListaAlunos.toArray(new Aluno[0])));

                    txt_nome.setText("");
                    txt_telefone.setText("");

                    JOptionPane.showMessageDialog(this, "Aluno excluído com sucesso!");

                    btn_atualizar.setEnabled(false);
                    btn_excluir.setEnabled(false);
                }
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ArrayList<Aluno> alunos = new ArrayList<>();
                    Jframe2 frame = new Jframe2(alunos);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


