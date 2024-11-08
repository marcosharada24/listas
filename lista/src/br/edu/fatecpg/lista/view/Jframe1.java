package br.edu.fatecpg.lista.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import br.edu.fatecpg.lista.model.Aluno;

public class Jframe1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txt_nome;
    private JTextField txt_telefone;
    private ArrayList<Aluno> ListaAlunos = new ArrayList<>(); 

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Jframe1 frame = new Jframe1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Jframe1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txt_nome = new JTextField();
        txt_nome.setToolTipText("Nome do aluno");
        txt_nome.setBounds(10, 30, 200, 30);
        contentPane.add(txt_nome);
        txt_nome.setColumns(10);

        txt_telefone = new JTextField();
        txt_telefone.setToolTipText("Telefone do aluno");
        txt_telefone.setBounds(10, 80, 200, 30);
        contentPane.add(txt_telefone);
        txt_telefone.setColumns(10);

        JButton btn_cadastrar = new JButton("Cadastrar");
        btn_cadastrar.setBounds(10, 130, 200, 30);
        contentPane.add(btn_cadastrar);

        btn_cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txt_nome.getText();
                String telefone = txt_telefone.getText();

                if (nome.isEmpty() || telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(btn_cadastrar, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    ListaAlunos.add(new Aluno(nome, telefone));
                    JOptionPane.showMessageDialog(btn_cadastrar, "Cadastro realizado com sucesso!");
                    txt_nome.setText("");
                    txt_telefone.setText("");

                    System.out.println("Aluno adicionado: " + nome + ", " + telefone);
                    System.out.println("Tamanho da lista de alunos: " + ListaAlunos.size());
                }
            }
        });

        JButton btn_lista = new JButton("Listar");
        btn_lista.setBounds(10, 180, 200, 30);
        contentPane.add(btn_lista);

        btn_lista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!ListaAlunos.isEmpty()) {
                    System.out.println("Abrindo Jframe2...");
                    Jframe2 frame2 = new Jframe2(ListaAlunos);
                    frame2.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(btn_lista, "Nenhum aluno cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

