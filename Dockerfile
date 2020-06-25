FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/AISMovie-*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]