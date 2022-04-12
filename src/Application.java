import Model.ListaTarefas;
import Model.Tarefa;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // No momento novas tarefas serão registradas através do terminal enquanto não há um front end

        ListaTarefas listaDeTarefas = new ListaTarefas();

        listaDeTarefas.carregarArquivo("TodoList.csv");

        boolean endApp = true;
        System.out.println("COMANDOS: ");
        System.out.println(" C - Criar nova tarefa, R - Recuperar lista de tarefas, D - Deletar uma tarefa");
        System.out.println("RP - Recuperar tarefas por prioridade");
        System.out.println("RC - Recuperar tarefas por categoria");
        System.out.println("Quit - Encerrar aplicação");
        while(endApp) {
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();

            switch(userInput) {
                case "C":
                    System.out.println("Insira o nome da tarefa: ");
                    String nome = input.nextLine();
                    System.out.println("Insira a descricao da tarefa: ");
                    String descricao = input.nextLine();
                    System.out.println("Insira um numero de 1 à 5 para a prioridade da tarefa: ");
                    int prioridade = Integer.parseInt(input.nextLine());
                    System.out.println("Insira a categoria da tarefa: ");
                    String categoria = input.nextLine();
                    System.out.println("Insira o status da tarefa: ");
                    String status = input.nextLine();
                    System.out.println("Insira a data limite da tarefa: ");
                    String data = input.nextLine();

                    Tarefa novaTarefa = new Tarefa(nome,
                            descricao,
                            data,
                            prioridade,
                            categoria,
                            status);

                    listaDeTarefas.novaTarefa(novaTarefa);
                    break;
                case "R":
                    listaDeTarefas.imprimeLista();
                    break;
                case "D":
                    listaDeTarefas.deletarTarefa();
                    break;
                case "RP":
                    listaDeTarefas.recuperarListaPorPrioridade();
                    break;
                case "RC":
                    listaDeTarefas.recuperarListaPorCategoria();
                    break;
                case "Quit":
                    endApp = false;
                    listaDeTarefas.escreverTarefas();
                    break;
                default:
                    System.out.println("Comando não reconhecido...");
                    break;
            }
        }


    }
}
