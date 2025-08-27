package PoolDeThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExemploSimplesPool {
    public static void main(String[] args) {

        //Criando um pool com 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(1);

        // Isso indica que terá apenas 3 threads ativas ao mesmo tempo para executar as seguintes tarefas:

        // Tarefa 1: Simula o envio de e-mail
        Runnable tarefaEmail = () -> {
            System.out.println("\n\uD83D\uDCE7 Enviando email... " + Thread.currentThread().getName());
            try{
                Thread.sleep(2000); // Envie o e-mail e até ele chegar demorará uns 2 segundos de descanso
            } catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("\n✅ E-mail enviado! " + Thread.currentThread().getName());
        };

        //Tarefa 2:
        Runnable tarefaRelatorio = () -> {
            System.out.println("\n\uD83D\uDCCA Processando relatório... " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("\n✅ Relatório enviado! " + Thread.currentThread().getName());
        };

        //Tarefa 3:
        Runnable tarefaBackup = () -> {
            System.out.println("\n\uD83D\uDCBE Fazendo backup... ");

            try{
                Thread.sleep(10000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("\n✅ Backup concluido! " + Thread.currentThread().getName());
        };

        // Enviando as tarefas para o pool de 3 threads de uma vez.
        executor.submit(tarefaEmail);
        executor.submit(tarefaRelatorio);
        executor.submit(tarefaBackup);
        executor.submit(tarefaRelatorio);
        executor.submit(tarefaEmail);

        //Finaliza o executor (não aceita novas tarefas)
        executor.shutdown();

    }

}
