import Model.ListaTarefas;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // No momento novas tarefas serão registradas através do terminal enquanto não há um front end

        ListaTarefas listaDeTarefas = new ListaTarefas();

        listaDeTarefas.carregarArquivo("TodoList.csv");

        boolean endApp = true;
        System.out.println("COMANDOS: C - Criar nova tarefa, R - Recuperar lista de tarefas, D - Deletar uma tarefa, Quit - Encerrar aplicação");
        while(endApp) {
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();

            switch(userInput) {
                case "C":
                    listaDeTarefas.novaTarefa();
                    break;
                case "R":
                    listaDeTarefas.imprimeLista();
                    break;
                case "D":
                    listaDeTarefas.deletarTarefa();
                    break;
                case "Quit":
                    endApp = false;
                    listaDeTarefas.escreverTarefas();
                    break;
                default:
                    System.out.println("Comando não reconhecido... encerrando aplicação");
                    break;
            }
        }


    }
}
