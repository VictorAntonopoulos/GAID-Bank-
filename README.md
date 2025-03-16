# 💰 Bem-vindo ao GAID Bank!

## 1. Introdução
O **GAID Bank** é uma API desenvolvida em **Spring Boot** e **Java 17**, projetada para gerenciamento bancário. Aqui você aprenderá como **rodar** o projeto, **acessar** a documentação e **testar** cada funcionalidade.

---

## 2. Como Rodar o Projeto

### 2.1 Requisitos
Antes de iniciar, certifique-se de ter instalado:
✅ **Java 17+** → [Download](https://adoptium.net/)
✅ **Maven** → [Download](https://maven.apache.org/download.cgi)
✅ **Postman ou Swagger UI** para testar a API

### 2.2 Baixar e Executar o Projeto
1. **Clone o repositório**
   ```sh
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. **Acesse a pasta do projeto**
   ```sh
   cd seu-repositorio
   ```
3. **Baixe as dependências e compile**
   ```sh
   mvn clean install
   ```
4. **Inicie a aplicação**
   ```sh
   mvn spring-boot:run
   ```
5. **Acesse a documentação Swagger**
   👉 [`http://localhost:8080/swagger-ui/index.html`](http://localhost:8080/swagger-ui/index.html)

---

## 3. Testando a API

### 3.1 Endpoint Principal (Info do Projeto)
🔹 **`GET /`** → Retorna informações do projeto.

📌 **Resposta Esperada:**
```json
{
  "project": "GAID Bank API",
  "author": "Victor Martins Antonopoulos"
}
```

### 3.2 Criar uma Nova Conta
🔹 **`POST /account`** → Cria uma conta bancária.

📌 **Corpo da Requisição:**
```json
{
  "accountNumber": "123456",
  "agency": "0001",
  "holderName": "Victor",
  "holderCpf": "12345678900",
  "balance": 200.0,
  "openingDate": "2025-03-12",
  "accountType": "CORRENTE"
}
```

### 3.3 Buscar Todas as Contas
🔹 **`GET /account`** → Retorna todas as contas cadastradas.

### 3.4 Buscar Conta por ID
🔹 **`GET /account/id/{accountId}`** → Retorna uma conta pelo ID.

### 3.5 Buscar Conta por CPF
🔹 **`GET /account/cpf/{cpf}`** → Retorna uma conta pelo CPF.

### 3.6 Fazer um Depósito
🔹 **`PUT /account/deposit`** → Adiciona saldo na conta.

📌 **Corpo da Requisição:**
```json
{
  "accountId": 1,
  "amount": 50.0
}
```

### 3.7 Fazer um Saque
🔹 **`PUT /account/withdraw`** → Retira saldo da conta.

📌 **Corpo da Requisição:**
```json
{
  "accountId": 1,
  "amount": 30.0
}
```

### 3.8 Fazer uma Transferência PIX
🔹 **`PUT /account/pix`** → Transfere saldo entre contas.

📌 **Corpo da Requisição:**
```json
{
  "accountId": 1,
  "pixAccountId": 2,
  "amount": 20.0
}
```

---

## 4. Extras e Dicas

### 4.1 Consultar o Banco de Dados (H2)
Caso esteja usando H2, acesse:
👉 [`http://localhost:8080/h2-console`](http://localhost:8080/h2-console)
📌 **JDBC URL:** `jdbc:h2:mem:bankdb`
📌 **Usuário:** `sa`
📌 **Senha:** *(deixe em branco)*

### 4.2 Possíveis Erros
❌ **Conta não encontrada:** Verifique se o `accountId` existe.
❌ **Saldo insuficiente:** O saldo da conta de origem é menor que o valor da transação.

---

## 5. Conclusão
Agora você sabe **rodar, acessar e testar** a API do GAID Bank! 🚀

Se precisar de mais funcionalidades, basta atualizar o projeto! 😊

