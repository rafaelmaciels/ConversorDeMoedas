# Challenge - Conversor de Moedas em Java

Este é um projeto simples em Java que consome a API da ExchangeRate-API para converter valores entre diferentes moedas.

## Pré-requisitos

- Java Development Kit (JDK) 17 ou superior.
- Apache Maven.

## 🚀 Configuração

### 1. Obtenha sua Chave de API

- Acesse o site [https://www.exchangerate-api.com/](https://www.exchangerate-api.com/).
- Crie uma conta gratuita para obter sua chave de API (API Key).

### 2. Insira a Chave no Código

- Abra o arquivo `src/main/java/com/conversor/api/ApiClient.java`.
- Encontre a linha: `private static final String API_KEY = "SUA_CHAVE_AQUI";`
- Substitua `"SUA_CHAVE_AQUI"` pela chave que você obteve.

## ▶️ Como Executar

1. Abra um terminal ou prompt de comando na pasta raiz do projeto (onde o arquivo `pom.xml` está localizado).
2. Compile o projeto com o Maven:
   ```bash
   mvn compile
   ```
3. Execute a aplicação:
   ```bash
   mvn exec:java
   ```

O menu do conversor de moedas aparecerá no seu console. Siga as instruções para realizar as conversões.
