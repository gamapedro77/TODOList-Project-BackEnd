package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaTarefas {
    private final List<Tarefa> lista;

    public ListaTarefas() {
        this.lista = new ArrayList<>();
    }

    public void carregarArquivo(String filePath) {
        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");
                String nome = line[0].trim();
                String descricao = line[1].trim();
                String dataDeTermino = line[2].trim();
                int prioridade =  Integer.parseInt(line[3].trim());
                String categoria = line[4].trim();
                String status = line[5].trim();
                Tarefa tarefa = new Tarefa(nome, descricao, dataDeTermino, prioridade, categoria, status);
                this.lista.add(tarefa);
            }
            this.ordenarPorPrioridade();
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum arquivo de lista foi encontrado... Iniciando lista vazia.");
        }

    }

    public void novaTarefa(Tarefa novaTarefa) {

        this.lista.add(novaTarefa);
        this.ordenarPorPrioridade();
        System.out.println("Tarefa criada com sucesso");
    }

    public void imprimeLista() {
        for(Tarefa tarefa : lista) {
            System.out.println(tarefa.getNome() + ", " +
                    tarefa.getDescricao() + ", " +
                    tarefa.getDataDeTermino() + ", " +
                    tarefa.getPrioridade() + ", " +
                    tarefa.getCategoria() + ", " +
                    tarefa.getStatus());
        }
    }

    public void ordenarPorPrioridade() {
        lista.sort((t1, t2) -> {
            return Integer.compare(t1.getPrioridade(), t2.getPrioridade());
        });
    }

    public void deletarTarefa() {
        Scanner input = new Scanner(System.in);

        System.out.println("Insira o nome da tarefa a ser deletada: ");

        String nomeDeletar = input.nextLine();
        Tarefa tarefaDeletar = getTarefa(nomeDeletar);
        if(tarefaDeletar == null) {
            System.out.println("Tarefa não encontrada");
        }
        else {
            this.lista.remove(tarefaDeletar);
            System.out.println("Tarefa removida com sucesso");
        }


    }

    public void escreverTarefas() {
        try {
            File todoList = new File("TodoList.csv");
            todoList.delete();
            FileWriter fw = new FileWriter("TodoList.csv", false);
            for(Tarefa tarefa : this.lista) {
                String newLine = tarefa.getNome() + ", " +
                        tarefa.getDescricao() + ", " +
                        tarefa.getDataDeTermino() + ", " +
                        tarefa.getPrioridade() + ", " +
                        tarefa.getCategoria() + ", " +
                        tarefa.getStatus() + System.lineSeparator();
                fw.append(newLine);
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Tarefa getTarefa(String nome) {

        for(Tarefa tarefa : this.lista) {
            if(tarefa.getNome().equals(nome)) {
                return tarefa;
            }
        }

        return null;
    }

    public void recuperarListaPorCategoria() {
        Scanner input = new Scanner(System.in);

        System.out.println("Insira a categoria: ");
        String categoria = input.nextLine();
        for(Tarefa tarefa : lista) {
            if (tarefa.getCategoria().equals(categoria)) {
                System.out.println(tarefa.getNome() + ", " +
                        tarefa.getDescricao() + ", " +
                        tarefa.getDataDeTermino() + ", " +
                        tarefa.getPrioridade() + ", " +
                        tarefa.getCategoria() + ", " +
                        tarefa.getStatus());
            }
        }
    }

    public void recuperarListaPorPrioridade() {
        Scanner input = new Scanner(System.in);

        System.out.println("Insira o valor da prioridade: ");
        int prioridade = Integer.parseInt(input.nextLine());
        for (Tarefa tarefa : lista) {
            if(tarefa.getPrioridade() >= prioridade) {
                System.out.println(tarefa.getNome() + ", " +
                        tarefa.getDescricao() + ", " +
                        tarefa.getDataDeTermino() + ", " +
                        tarefa.getPrioridade() + ", " +
                        tarefa.getCategoria() + ", " +
                        tarefa.getStatus());
            }
        }
    }


}
