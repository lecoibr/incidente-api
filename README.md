# Incidente API

## Contém:
- Docker e Docker-compose
- Java 21
- Swagger (OpenApi)
- Junit e Mockito (Testes Unitários)
- JPA/Hibernate
- Spring Boot
- Maven
- Banco de Dados H2
- Lombok

## Como compilar e subir a aplicação:
```bash
mvn clean install
docker-compose up --build
```
ou
```bash
mvn clean install
mvn spring-boot:run
```

## Acessando a aplicação no browser:
- http://localhost:8080/swagger-ui.html
