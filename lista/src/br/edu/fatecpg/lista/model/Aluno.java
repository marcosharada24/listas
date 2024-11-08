package br.edu.fatecpg.lista.model;

public class Aluno {

    private String nome;
    private String telefone;

    public Aluno(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Sobrescrevendo o toString() para exibir apenas o nome do aluno
    @Override
    public String toString() {
        return this.nome;  // Aqui, vamos exibir apenas o nome
    }
}
