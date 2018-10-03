FROM openjdk:8-jdk-alpine
COPY ./target/api-1.0-SNAPSHOT.jar /tmp
WORKDIR /tmp
EXPOSE 8080
CMD ["java", "-jar", "api-1.0-SNAPSHOT.jar"]
