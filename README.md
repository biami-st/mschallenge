# Desafio Microsserviços⚙️

Desenvolvimento de uma aplicação baseada em microsserviços utilizando Spring Cloud.

## Serviços

#### 💻 Microsserviço 1 : Catálogo de Produtos

* Acessível por "/produtos".
* Permite cadastrar, listar e consultar produtos.
* Persistência via H2 Database.
     
#### 💻 Microsserviço 2 : Simulador de Pedido

* Acessível por "/pedidos".
* Permite simular pedidos com base em uma lista de produtos.
* Sem persistência de dados.

## Arquitetura

* Utilizar Spring Cloud Gateway como API Gateway.
* Usar Spring Cloud Eureka como Service Discovery.
