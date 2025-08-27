package PoolDeThreads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class invokeAny {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tarefas = Arrays.asList(
                () -> { Thread.sleep(3000); return "📧 Tarefa 1"; }, // Demora 3
                () -> { Thread.sleep(1000); return "📊 Tarefa 2"; }, // Demora 1 segundo
                () -> { Thread.sleep(2000); return "💾 Tarefa 3"; } // Demora 2
        );

        // Retorna o resultado da primeira tarefa que terminar
        String resultado = executor.invokeAny(tarefas);

        System.out.println("Primeira tarefa finalizada: " + resultado); //Nesse caso é para retornar apenas a tarefa 2

        executor.shutdown();
    }
}
