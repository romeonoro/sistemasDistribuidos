## Relógios Físicos
- Baseados no tempo real (UTC).
- Problema: cada relógio da casa pode marcar horários diferentes.
- Solução: sincronizar todos os relógios (ex.: ajustar pelo horário oficial).
- Uso: coordenação de eventos em tempo real.
- Exemplo do banheiro: os relógios ajudam a decidir quem realmente chegou primeiro para usar o banheiro.

---

## Relógios Lógicos
- Não medem tempo real, apenas ordenam eventos.
- Garantem ordem causal entre processos.
- Relógio de Lamport: fornece uma ordem parcial dos eventos.
- Uso: consistência na execução de eventos.
- Exemplo do banheiro: mesmo sem relógio, sabemos que quem entrou primeiro no corredor chegou antes na fila do banheiro.

---

## Exclusão Mútua
- Garante que apenas um processo por vez acesse a região crítica.
- Regras:
  - Mutual Exclusion → apenas uma pessoa no banheiro por vez.
  - Progress → se o banheiro está livre, alguém da fila deve entrar.
  - Bounded Waiting → ninguém fica esperando para sempre.
- Implementações:
  - Centralizada: uma pessoa da casa (coordenador) controla quem entra.
  - Distribuída: todos combinam regras (quem pede primeiro, quem tem prioridade).
- Exemplo do banheiro: impedir que duas pessoas entrem ao mesmo tempo.

---

## Algoritmos de Eleição
- Usados para decidir quem será o coordenador/líder.
- Exemplos:
  - Bully → a pessoa de maior autoridade decide quem entra.
  - Ring → cada pessoa sugere uma ordem, até restar uma decisão final.
- Uso: coordenação e tolerância a falhas.
- Exemplo do banheiro: se não há ninguém organizando a fila, os próprios moradores decidem entre si quem entra primeiro.

---

## Sincronismo e Acesso à Seção Crítica
- Garante que vários processos acessem recursos de forma organizada.
- Ferramentas em linguagens:
  - Java → `synchronized`
  - C#/Python → `lock`
- Relações:
  - Relógios → ajudam a saber a ordem de chegada.
  - Exclusão mútua → só uma pessoa no banheiro.
  - Eleição → decidir quem coordena a fila.
- Exemplo do banheiro: a fila na porta garante que cada pessoa use o banheiro na sua vez.

---

# Resumo com o Exemplo do Banheiro
- Relógios Físicos: quem chegou primeiro pode ser decidido pelo horário do relógio.
- Relógios Lógicos: mesmo sem relógio, sabemos a ordem de chegada na fila.
- Exclusão Mútua: apenas uma pessoa no banheiro por vez.
- Eleição: se não houver fila organizada, os moradores decidem regras de prioridade.
- Sincronismo: a fila garante que ninguém entre ao mesmo tempo.
