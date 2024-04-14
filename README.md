# Projeto Locadora de Carros com Spring Boot e H2

Este é um exemplo básico de um aplicativo CRUD (Create, Read, Update, Delete) usando Spring Boot para cadastrar carros em um banco de dados H2 em memória.

## Pré-requisitos

- JDK 17 ou superior instalado
- Maven 3.x ou superior instalado

## Configuração do Projeto

1. Clone este repositório em sua máquina local:

    ```
    git clone https://github.com/alexjosesilva/localdoraIBM.git
    ```

2. Navegue até o diretório do projeto:

    ```
    cd localdoraIBM
    ```
3. Se atentar paro application.
    ```
    # Configuração do contexto da aplicação
      server.servlet.context-path=/app
    ```

4. Execute o projeto usando Maven:

    ```
    mvn spring-boot:run
    ```

O aplicativo será iniciado em `http://localhost:8080/app/carros`.

## Acesso ao Console do H2

O console do H2 está disponível em `http://localhost:8080/app/h2-console`. Use as seguintes configurações para se conectar ao banco de dados H2:

- JDBC URL: `jdbc:h2:mem:testdb`
- Usuário: `sa`
- Senha: `password`

## Endpoints da API

- **Listar Carros**: `GET /app/carros`
- **Buscar Carro por ID**: `GET /app/carros/{id}`
- **Cadastrar Carro**: `POST /app/carros`
- **Atualizar Carro**: `PUT /app/carros/{id}`
- **Deletar Carro**: `DELETE /app/carros/{id}`

## Contribuição

Sinta-se à vontade para contribuir com melhorias, correções de bugs ou novos recursos! Basta criar uma issue ou enviar uma solicitação de pull.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).
