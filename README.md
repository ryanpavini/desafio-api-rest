# API de Controle Financeiro Pessoal

API RESTful desenvolvida em Java 17 com Spring Boot 3 para gerenciamento de lançamentos financeiros (receitas e despesas). Este projeto foi criado como parte de um desafio da [Digital Innovation One](https://dio.me/).

## ✨ Funcionalidades

-   Registrar novas transações (receitas ou despesas).
-   Listar todas as transações registradas.
-   Buscar uma transação específica por ID.
-   Calcular e exibir um balanço financeiro completo (total de receitas, total de despesas e saldo final).

## 🚀 Tecnologias Utilizadas

-   **Java 17**
-   **Spring Boot 3**
-   **Spring Data JPA**
-   **H2 Database** (para desenvolvimento)
-   **Lombok**
-   **OpenAPI (Swagger)** para documentação da API.
-   **Maven**

## 🛠 Endpoints da API

| Verbo  | Endpoint          | Descrição                                 | Corpo da Requisição (Exemplo)                                                                    |
|--------|-------------------|-------------------------------------------|--------------------------------------------------------------------------------------------------|
| `GET`  | `/lancamentos`    | Lista todos os lançamentos financeiros.   | -                                                                                                |
| `GET`  | `/lancamentos/{id}`| Busca um lançamento pelo seu ID.         | -                                                                                                |
| `GET`  | `/lancamentos/balanco` | Retorna o balanço financeiro atual.       | -                                                                                                |
| `POST` | `/lancamentos`    | Cria um novo lançamento.                  | `{"descricao": "Salário", "valor": 5000.00, "tipo": "RECEITA", "data": "2025-08-05"}` |

### Exemplo de corpo para despesa:
`{"descricao": "Aluguel", "valor": 1500.00, "tipo": "DESPESA", "data": "2025-08-10"}`

## ⚙️ Como Executar Localmente

1.  Clone o repositório.
2.  Navegue até a pasta do projeto via terminal.
3.  Execute o comando: `mvn spring-boot:run`
4.  A API estará rodando em `http://localhost:8080`.
