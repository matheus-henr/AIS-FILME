# AIS FILMES API

**Informações importantes**

*Configurações necessária de ambiente*

 - JDK 8 (Java)
 - Maven
 - IDE de preferencia configurada com o [Lombok](https://projectlombok.org/)

*Para rodar a API*

 - 'mvn test' para rodar apenas os testes.
 - 'mvn spring-boot:run' para rodar a aplicação.

*Swagger da API* [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
> Caso esteja rodando a aplicação local na porta 8080

**Docker**
>Necessário ter o docker já configurado. caso não tenha, [clique aqui](https://www.hostinger.com.br/tutoriais/install-docker-ubuntu).

 - mvn package
 - docker build -t matheus/aisfilme .
 - docker run -p 8080:8080  matheus/aisfilme
