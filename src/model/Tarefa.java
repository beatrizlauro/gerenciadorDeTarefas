package model;

import java.time.LocalDate;

public class Tarefa {
    
    private int id;
    private String nomeTarefa;
    private String descricao;
    private boolean concluida;
    private LocalDate dataCriacao;

    public Tarefa(int id, String nomeTarefa, String descricao, boolean concluida, LocalDate dataCriacao) {
        this.id = id;
        this.nomeTarefa = nomeTarefa;
        this.descricao = descricao;
        this.concluida = concluida;
        this.dataCriacao = dataCriacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
    
    // Método para retornar "Concluída" ou "Pendente"
    public String getStatus() {
        return concluida ? "Concluída" : "Pendente";
    }
    
    @Override
    public String toString() {
        return "Tarefa: "          + this.nomeTarefa + "\n" +
               "Descrição: "       + this.descricao  + "\n" +
               "Concluído: "       + getStatus()     + "\n" +
               "Data de Criação: " + this.dataCriacao;
    }

    public String getisConcluida() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
