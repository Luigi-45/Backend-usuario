FROM openjdk:21-jdk-slim

COPY target/Usuario.jar /app/Usuario.jar

EXPOSE 8086

WORKDIR /app

ENTRYPOINT ["java", "-jar", "Usuario.jar"]