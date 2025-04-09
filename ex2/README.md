# Tarefa 1 Sprint 2: Strategy, Adapter e Observer

Este projeto demonstra a implementação de três padrões de projeto em um contexto de cálculo de fretes:

- **Strategy** – para escolher dinamicamente a modalidade de entrega.  
- **Adapter** – para integrar uma transportadora externa (API não padronizada).  
- **Observer** – para notificar observadores (ex. via e-mail e SMS) quando a entrega é concluída.
---

## 👀 Visão Geral

O projeto foi construído usando Spring Boot, demonstrando o uso de cada padrão de projeto solicitado.

Ele expõe, por exemplo, um endpoint `/api/entregas` que permite calcular o frete de acordo com uma modalidade específica, além de concluir a entrega e notificar quaisquer observadores (e-mail, SMS, etc.).


## 📡 Exemplos de Uso (Requests HTTP)

### Cálculo do Frete (POST)

**Requisição:**

```http
POST /api/entregas
Content-Type: application/json

{
  "peso": 10.0,
  "transportadora": "economica"
}
```

**Resposta:**

```
Frete calculado: 15.0
```

---

## 🧠 Detalhes dos Padrões Implementados

### Strategy

Cada modalidade de entrega possui sua própria lógica para cálculo de frete.

**Interface:**

```java
public interface EntregaStrategy {
    double calcularFrete(double peso);
}
```

**Implementações concretas:**

- `EntregaExpressaStrategy`
- `EntregaEconomicaStrategy`
- `TransportadoraTerceirizadaStrategy`

Permite adicionar novas modalidades sem modificar as existentes.

---

### Adapter

Integra APIs externas com formato diferente do utilizado internamente.

- **API externa:** `TransportadoraExternaAPI`  
- **Adapter:** `TransportadoraExternaAdapter`

Esse padrão converte o modelo da API externa para o formato esperado pelo sistema, facilitando a reutilização e manutenção.

---

### Observer

Permite notificar múltiplos observadores quando a entrega é concluída.

**Interface:**

```java
public interface EntregaObserver {
    void notificar(String mensagem);
}
```

**Implementações:**

- `EmailObserver`
- `SmsObserver`

O evento de “conclusão de entrega” dispara notificações a todos os observadores registrados, sem alterar a lógica principal.

