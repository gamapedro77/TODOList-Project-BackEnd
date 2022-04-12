package Model;

import java.time.LocalDate;

public class Tarefa {

        String nome;

        String descricao;
        String dataDeTermino;
        int prioridade;
        String categoria;
        String status;

    public Tarefa(String nome, String descricao, String dataDeTermino,  int prioridade, String categoria, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeTermino = dataDeTermino;
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;

    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataDeTermino() {
        return dataDeTermino;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getStatus() {
        return status;
    }






}
