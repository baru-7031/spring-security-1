FROM openjdk:17
ADD target/security-service.jar security-service.jar
COPY . /src/data
ENTRYPOINT["java","-jar","security-service.jar"]