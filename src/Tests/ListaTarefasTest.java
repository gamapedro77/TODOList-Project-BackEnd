package Tests;
import Model.ListaTarefas;
import Model.Tarefa;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ListaTarefasTest {
    ListaTarefas listaTarefas = new ListaTarefas();
    @Test
    public void testNovaTarefa() {
        Tarefa novaTarefa = new Tarefa("atividade", "descricao sample", "2022-12-24", 5, "teste", "Pendente");

        listaTarefas.novaTarefa(novaTarefa);

        assertEquals("atividade", listaTarefas.getTarefa("atividade").getNome());
    }


}
