package PoolDeThreads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class invokeAll {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        List<Callable<String>> tarefas = Arrays.asList(
                () -> { Thread.sleep(1000); return "Tarefa 1 concluída " + Thread.currentThread().getName(); },
                () -> { Thread.sleep(1000); return "Tarefa 2 concluída " + Thread.currentThread().getName(); },
                () -> "Tarefa 3 concluída imediatamente " + Thread.currentThread().getName()
        );

        List<Future<String>> resultados = executor.invokeAll(tarefas);

        for (Future<String> futuro : resultados) {
            System.out.println(futuro.get());
            //join() -> usado com Thread direta, espera uma thread terminar.
            //Future.get() -> usado com ExecutorService, espera a tarefa terminar (seja Runnable ou Callable).
        }

        executor.shutdown();
    }

}
