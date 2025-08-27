# Pool de Threads em Java

Um **pool de threads** é um conjunto de threads pré-existentes e gerenciadas, prontas para executar tarefas.  
Ao invés de criar uma nova thread para cada tarefa, você envia as tarefas para o pool, que distribui entre as threads disponíveis.  

---

## Conceitos

| Conceito           | Exemplo da vida real                           |
|-------------------|-----------------------------------------------|
| **Thread**         | Um motoboy que faz uma entrega de cada vez   |
| **Pool de threads**| Equipe fixa de motoboys que pega tarefas da fila e executa |
| **Tarefa (Runnable)** | Uma entrega, como enviar e-mail ou gerar relatório |

### Como funciona:

- Você tem um **pool fixo de threads** (ex: 3 threads).  
- Chegam várias tarefas (ex: 5 tarefas).  
- As threads disponíveis pegam as tarefas imediatamente.  
- As tarefas excedentes ficam **na fila**, esperando a próxima thread disponível.  
- Quando uma thread termina, ela **reaproveita-se** para pegar a próxima tarefa.

---

## Exemplo simples em Java (está nos arquivos -> Classe: RunnableThreads)

```java
package Threads.AprendizadoThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableThreads {
    public static void main(String[] args) {

        // Criando um pool com 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Tarefa 1: Simula o envio de e-mail
        Runnable tarefaEmail = () -> {
            System.out.println("\n📧 Enviando email... " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n✅ E-mail enviado! " + Thread.currentThread().getName());
        };

        // Tarefa 2: Processando relatório
        Runnable tarefaRelatorio = () -> {
            System.out.println("\n📊 Processando relatório... " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n✅ Relatório enviado! " + Thread.currentThread().getName());
        };

        // Tarefa 3: Fazendo backup
        Runnable tarefaBackup = () -> {
            System.out.println("\n💾 Fazendo backup... " + Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n✅ Backup concluído! " + Thread.currentThread().getName());
        };

        // Enviando as tarefas para o pool
        executor.submit(tarefaEmail);
        executor.submit(tarefaRelatorio);
        executor.submit(tarefaBackup);
        executor.submit(tarefaRelatorio);
        executor.submit(tarefaEmail);

        // Finaliza o executor (não aceita novas tarefas)
        executor.shutdown();
    }
}
