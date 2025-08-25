# Sistemas Distribuídos e Paralelos

## Sistemas Distribuídos

Sistemas distribuídos são compostos por máquinas **heterogêneas** (com diferentes arquiteturas de hardware, sistemas operacionais e linguagens de programação), **fracamente acopladas** (Grid Computing) e distribuídas geograficamente. A comunicação ocorre por meio de **protocolos do modelo TCP/IP** (endereço de rede, porta lógica, máscara de rede, protocolos de transporte).

### Características:
- **Arquiteturas:**
  - Cliente-Servidor
  - Ponto-a-Ponto
- **Tolerância a falhas**
- **Escalabilidade**
- **Segurança**
- **Manutenção/atualização**
- **Compartilhamento de recursos:** processador, memória, impressoras etc.
- **Grid Computacional**

### Comunicação:
- Comunicação entre sistemas se dá por **troca de mensagens**:
  - Strings → Mensagens simples
  - Objetos → Requer **serialização**
- A base da comunicação é via **SOCKETS**, que são **bloqueantes**.
- A solução para manter desempenho é o uso de **THREADS** para processamento paralelo/concomitante.

### Programação Distribuída:
- Fortemente dependente de sistemas operacionais:
  - Gestão de processamento
  - Gestão de comunicação
  - Gestão de serviços
- **Throughput** é uma métrica de desempenho importante.
- Controle de **sincronismo** é essencial:
  - **Relógio lógico ou físico**
  - **Exclusão mútua** por:
    - Monitores
    - Semáforos
    - Filas

---

## Thread

Uma **thread** é um subprocesso (ou miniprocesso) pertencente a um processo, criado em tempo de programação/execução com o objetivo de realizar **processamento paralelo/concomitante**.

### Estados de uma Thread:
- Em execução
- Finalizado/pronto
- Espera/aguardando
- Parado
- Dormindo
- Cancelado

### Tipos de Thread em Java:
- **Com compartilhamento de memória** → Interface `Runnable`
- **Sem compartilhamento de memória** → Classe `Thread`

### Considerações:
- Com **compartilhamento de memória**, o processamento é bloqueante. O programador deve garantir o **sincronismo**.
- Threads podem ser:
  - **Simples** (sem dependência de dados)
  - **Com memória compartilhada** (uso de dados compartilhados)

---

## Sistemas Paralelos

Sistemas paralelos são **homogêneos**, ou seja, utilizam hardware, sistemas operacionais e linguagens de programação **iguais** em todas as máquinas. São **fortemente acoplados** (Cluster), geralmente **localizados fisicamente no mesmo ambiente**, e fazem uso de comunicação de alta velocidade, como **fibra ótica**.

### Características:
- **Arquitetura:**
  - Ponto-a-Ponto
- **Cluster Computacional**
- **Compartilhamento de recursos** (processador, memória, etc.)
- **Tolerância a falhas**
- **Escalabilidade**
- **Segurança**
- **Manutenção/atualização**
- **Sistema de nobreak robusto**
- **Sistema de backup confiável**

### Programação Paralela:
- Foca na divisão de processos e tarefas entre múltiplas unidades de processamento.
- Cada **processo** demanda recursos como:
  - Processador
  - Barramento
  - RAM + Cache
  - Periféricos
