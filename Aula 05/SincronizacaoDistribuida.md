## Relógios Físicos
- Baseados no tempo real do hardware (UTC).
- Problema: desvios de clock (clock drift) → cada máquina pode medir o tempo em ritmos diferentes.
- Solução: protocolos como NTP (Network Time Protocol) para sincronizar com uma referência confiável.
- Uso: registro de logs, coordenação de eventos em tempo real.
- Exemplo bancário: sincronizar horários de transações entre diferentes agências.

---

## Relógios Lógicos
- Não medem tempo real, apenas ordenam eventos.
- Garantem a ordem causal entre processos.
- Relógio de Lamport: fornece uma ordem parcial dos eventos.
- Uso: consistência de mensagens, evitar problemas em sistemas distribuídos.
- Exemplo bancário: garantir que uma transferência seja debitada antes de ser creditada em outra conta.

---

## Exclusão Mútua
- Garante que apenas um processo por vez acesse a região crítica.
- Regras:
  - Mutual Exclusion → apenas um no recurso.
  - Progress → se livre, alguém deve entrar.
  - Bounded Waiting → nenhum processo espera indefinidamente.
- Implementações:
  - Centralizada (coordenador único).
  - Distribuída (Ricart-Agrawala, token ring).
- Exemplo bancário: dois caixas eletrônicos não podem atualizar o saldo da mesma conta simultaneamente.

---

## Algoritmos de Eleição
- Definem qual processo será o coordenador/líder em caso de falha.
- Exemplos:
  - Bully → maior ID vence.
  - Ring → maior ID sobrevive após circular no anel.
- Uso: coordenação e tolerância a falhas.
- Exemplo bancário: escolher o servidor principal responsável por autorizar transações caso o atual falhe.

---

## Sincronismo e Acesso à Seção Crítica
- Garante acesso seguro de múltiplos processos a recursos críticos.
- Ferramentas em linguagens:
  - Java → `synchronized`
  - C#/Python → `lock`
- Relações:
  - Relógios → ajudam na ordenação de eventos.
  - Exclusão mútua → controla quem acessa o recurso.
  - Eleição → define quem coordena o acesso.
- Exemplo bancário: garantir que apenas uma operação de saque seja processada por vez para a mesma conta.

---

# Resumo com o Exemplo do Banheiro

- Relógios Físicos: todos os relógios de parede da casa precisam estar sincronizados para saber quem chegou primeiro.
- Relógios Lógicos: mesmo sem olhar a hora, sabemos que a pessoa entrou antes de outra porque havia uma ordem de chegada.
- Exclusão Mútua: apenas uma pessoa pode usar o banheiro de cada vez.
- Eleição: se houver várias pessoas esperando, elas podem combinar uma regra para decidir quem entra primeiro (por exemplo, o mais velho ou quem chegou antes).
- Sincronismo: a fila garante que cada pessoa terá acesso ao banheiro sem que duas entrem ao mesmo tempo.
