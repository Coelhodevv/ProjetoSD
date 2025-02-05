# 🚀 Arquitetura de Microserviços com Eureka, API Gateway, Comunicação Assíncrona, Keycloak e Docker

Estamos desenvolvendo uma arquitetura de **microserviços** utilizando **Eureka** **comunicação assíncrona**, **mensageria**, **Docker**, para localização de serviços, **API Gateway** 
para gerenciamentos das requisições para instâncias e **Keycloak** para **segurança**.



## 🔍 Service Discovery com Eureka

Com a necessidade de escalar os microserviços dinamicamente, adotamos o **Eureka Server** para permitir a **descoberta automática** de serviços. Isso traz os seguintes benefícios:

- **Registro dinâmico** de cada microserviço conforme ele sobe.
- **Descoberta de serviços** sem a necessidade de endereços fixos.
- **Load balancing** dinâmico, garantindo resiliência e alta disponibilidade.

O **Eureka Client** permite que os serviços se **registrem automaticamente**, promovendo uma configuração simplificada sem a necessidade de configurar manualmente IPs ou portas.

## 🌐 API Gateway – Centralizando o Acesso

Para evitar a complexidade de múltiplas APIs expostas diretamente, usamos um **API Gateway**, que oferece:

- 🔀 **Centralização** no acesso a todos os microserviços.
- 🔄 **Roteamento automático** das chamadas para os serviços corretos.

O **API Gateway** proporciona uma camada unificada para os clientes, garantindo que eles não precisem se preocupar com os detalhes de qual serviço está rodando em qual porta.

## ⚖️ Load Balancer e Escalabilidade

A escalabilidade é essencial em sistemas distribuídos. Para isso, utilizamos um **Load Balancer** que:

- **Distribui a carga de trabalho** entre várias instâncias de cada microserviço.
- Garante **alta disponibilidade**, evitando que a falha de uma instância impacte o sistema.
- Permite a **escalabilidade dinâmica**, com a adição de novas instâncias conforme a demanda.

Isso assegura que o sistema continue performático e disponível, mesmo com o aumento do tráfego ou da carga de trabalho.

## 📩 Mensageria e Comunicação Assíncrona

Inicialmente, adotamos uma comunicação **síncrona**, onde os microserviços se comunicavam diretamente entre si com o Eureka. Agora, estamos implementando um **sistema de mensageria** com 
**RabbitMQ** para comunicação **assíncrona**, aumentando a **resiliência** e a **escalabilidade** do sistema.

### 🔄 Fluxo da Comunicação Assíncrona

1. Um **cliente**  solicita um **cartão de crédito**.
2. O **serviço de avaliação de crédito** processa os dados e envia uma mensagem para a **fila**.
3. O **serviço de cartões** escuta essa fila e, ao receber a mensagem, cadastra o cartão e salva no banco de dados.

✅ **Benefício**: Isso evita dependências diretas entre os serviços, permitindo que funcionem de forma **independente e escalável**.

## 🔒 Segurança com Keycloak

Para garantir a **segurança** e controle de acesso, implementamos o **Keycloak**, que oferece:

- **Autenticação Centralizada**: Gerencia todas as credenciais dos usuários.
- **Autorização**: Controle detalhado de acesso com base em **roles** e permissões.
- **Integração com o API Gateway**: O **API Gateway** comunica-se com o Keycloak para garantir que apenas usuários autenticados e autorizados tenham acesso aos serviços.

O **Keycloak** simplifica a implementação de **Single Sign-On (SSO)** e **autenticação federada**, proporcionando uma experiência de login unificada em toda a plataforma.

## 🏗️ Tecnologias Utilizadas

- **Microserviços**: Arquitetura distribuída para escalabilidade e independência de serviços.
- **RabbitMQ**: Sistema de mensageria para comunicação assíncrona entre serviços.
- **Docker**: Contêineres para garantir portabilidade e facilidade de deployment.
- **Eureka**: Ferramenta de **Service Discovery** para registro e descoberta automática de serviços.
- **API Gateway**: Roteamento centralizado e segurança das APIs.
- **Keycloak**: Autenticação e autorização centralizadas para garantir segurança.
- **Load Balancer**: Balanceamento de carga para garantir alta disponibilidade e escalabilidade.

## 🎯 Benefícios da Arquitetura

- **Resiliência**: Evita pontos únicos de falha com o uso de mensageria, discovery dinâmico e balanceamento de carga.
- **Escalabilidade**: Capacidade de aumentar a infraestrutura de forma dinâmica com o uso de microserviços e load balancing.
- **Segurança**: Autenticação e autorização centralizadas com o Keycloak, garantindo controle de acesso robusto.
- **Facilidade de Manutenção**: A separação em microserviços permite que alterações em um serviço não impactem outros, facilitando atualizações e manutenção.


