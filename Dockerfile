FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} raspberry-2019.12.1.jar
ENTRYPOINT ["java","-jar","/raspberry-2019.12.1.jar"]