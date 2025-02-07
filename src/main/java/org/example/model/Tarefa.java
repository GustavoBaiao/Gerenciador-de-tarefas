package org.example.model;

import org.example.enums.Prioridade;
import org.example.enums.Status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class Tarefa {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate dataDeVencimento;
    private Status statusDeConclusao;
    private Prioridade prioridade;

    public Tarefa() {
    }

    public Tarefa(Long id,String titulo, String descricao, LocalDate dataDeVencimento, Status statusDeConclusao, Prioridade prioridade) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataDeVencimento = dataDeVencimento;
        this.statusDeConclusao = statusDeConclusao;
        this.prioridade = prioridade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }


    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public Status getStatusDeConclusao() {
        return statusDeConclusao;
    }

    public void setStatusDeConclusao(Status statusDeConclusao) {
        this.statusDeConclusao = statusDeConclusao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dataFormatada = dataDeVencimento.format(formatter);
        return "Tarefa{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataDeVencimento=" + dataFormatada +
                ", statusDeConclusao=" + statusDeConclusao +
                ", prioridade=" + prioridade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(id, tarefa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
