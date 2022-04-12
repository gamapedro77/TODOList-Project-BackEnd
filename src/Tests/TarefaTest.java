package Tests;
import Model.Tarefa;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TarefaTest {
    private static Tarefa tarefa;

    @Before
    public void testPrepararObjetoTarefa() {
        tarefa = new Tarefa("nome", "descricao", "2022-03-03",5,"teste","Pendente");
    }

    @Test
    public void testTarefaGetNome() {
        assertSame("nome", tarefa.getNome());
        System.out.println("nome da tarefa é retornado corretamente");
    }

    @Test
    public void testTarefaGetDescricao() {
        assertSame("descricao", tarefa.getDescricao());
        System.out.println("descricao da tarefa é retornado corretamente");
    }

    @Test
    public void testTarefaGetData() {
        assertSame("2022-03-03", tarefa.getDataDeTermino());
        System.out.println("data da tarefa é retornado corretamente");
    }

    @Test
    public void testTarefaGetPrioridade() {
        assertSame(5, tarefa.getPrioridade());
        System.out.println("prioridade da tarefa é retornado corretamente");
    }

    @Test
    public void testTarefaGetCategoria() {
        assertSame("teste", tarefa.getCategoria());
        System.out.println("categoria da tarefa é retornado corretamente");
    }

    @Test
    public void testTarefaGetStatus() {
        assertSame("Pendente", tarefa.getStatus());
        System.out.println("status da tarefa é retornado corretamente");
    }
}
