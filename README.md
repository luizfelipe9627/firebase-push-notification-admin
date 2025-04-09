# Firebase Push Notification Admin

Este projeto é uma **Prova de Conceito (POC)** para gerenciar notificações e inscrições de tópicos utilizando o **Firebase Admin SDK** com **Spring Boot**. Ele inclui a funcionalidade de enviar notificações para tópicos, inscrever e desinscrever dispositivos de tópicos, e até mesmo "deletar" tópicos removendo todos os tokens associados a eles.

## Objetivo da POC

O objetivo desta POC é demonstrar como integrar o Firebase Admin SDK com uma aplicação backend em Spring Boot para realizar operações como:

- Enviar notificações push para dispositivos inscritos em tópicos.
- Inscrever dispositivos (tokens) em tópicos.
- Desinscrever dispositivos de tópicos.
- "Deletar" tópicos removendo todos os tokens associados a eles.

## Pré-requisitos para Executar

Antes de executar este projeto, certifique-se de ter os seguintes pré-requisitos instalados:

- **Java 21**: Este projeto foi desenvolvido utilizando o Java.
- **Maven**: Para compilar e executar o projeto.
- **Firebase Project**: Você precisa de no mínimo um token de serviço para o Firebase Admin SDK.

### Configuração do Firebase

1. Crie um projeto no Firebase.
2. Gere uma chave privada para o Firebase Admin SDK através do console do Firebase (Configurações do Projeto > Contas de Serviço > Gerar Nova Chave Privada).
3. Baixe o arquivo JSON contendo as credenciais e renomeie-o para `firebase-credentials.json`.
4. Coloque o arquivo `firebase-credentials.json` na pasta `src/main/resources` do seu projeto.

### Dependências do Maven

Este projeto usa as seguintes dependências do Maven:

- **Spring Boot Starter Web**: Para criar uma aplicação web com Spring Boot.
- **Spring Boot DevTools**: Para facilitar o desenvolvimento.
- **Spring Boot Starter Validation**: Para validação de dados.
- **Lombok**: Para reduzir a verbosidade do código.
- **Firebase Admin SDK**: Para interagir com o Firebase.
- **Docker**: Para rodar o projeto em um contêiner.
- **Docker Compose**: Para orquestrar os contêineres.

## Como rodar em um contêiner Docker
O projeto também pode ser executado em um contêiner Docker. Para isso, rode o seguinte comando:

```bash
docker compose up
```

# Passo a Passo para Testar a API com cURL

Este documento fornece um passo a passo para testar as funcionalidades da sua API utilizando comandos `cURL`.

## 1. Enviar Notificação para um Tópico

Para enviar uma notificação para um tópico, você precisa enviar uma requisição POST para o endpoint `/topics/send` com o seguinte corpo:

### Exemplo de cURL:

```bash
curl -X POST \
  http://localhost:8080/message/send \
  -H 'Content-Type: application/json' \
  -d '{
    "topic": "notificacaoTeste",
    "notification": {
      "title": "Título da Notificação",
      "body": "Corpo da Notificação",
      "image": "http://example.com/image.jpg"
    }
  }'
```

## 2. Inscrever um Dispositivo em um Tópico

Para inscrever um dispositivo em um tópico, você precisa enviar uma requisição POST para o endpoint `/topics/subscribe` com o seguinte corpo:

### Exemplo de cURL:

```bash
curl -X POST \
  http://localhost:8080/topic/subscribe \
  -H 'Content-Type: application/json' \
  -d '{
    "topic": "notificacaoTeste"
    "tokens": ["token_1", "token_2"],
  }'
```

## 3. Desinscrever um Dispositivo de um Tópico

Para desinscrever um dispositivo de um tópico, você precisa enviar uma requisição POST para o endpoint `/topics/unsubscribe` com o seguinte corpo:

### Exemplo de cURL:

```bash
curl -X POST \
  http://localhost:8080/topic/unsubscribe \
  -H 'Content-Type: application/json' \
  -d '{
    "topic": "notificacaoTeste"
    "tokens": ["token_1", "token_2"],
  }'
```

## Como Testar

1. Certifique-se de que o seu aplicativo Spring Boot está em execução. Você pode fazer isso com o comando:

    ```bash
    mvn spring-boot:run
    ```

2. Use os exemplos de `cURL` para testar as funcionalidades descritas.

3. Verifique os logs do servidor para acompanhar os detalhes da requisição e resposta.

## Licença

Este projeto é de código aberto e está sob a licença MIT.

---

🔥 **Desenvolvido com Java e Spring Boot** 🚀
