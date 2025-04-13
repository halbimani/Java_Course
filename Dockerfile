FROM openjdk:17-jdk-slim
MAINTAINER abc@email.com
WORKDIR /app
EXPOSE 8086
COPY /target/employee-service.jar /app/employee-service.jar
ENTRYPOINT ["java","-jar","employee-service.jar"]