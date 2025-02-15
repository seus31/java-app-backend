FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . .

ENV JAVA_OPTS="-Dspring.devtools.restart.enabled=true"

ENTRYPOINT ["java", "-jar", "build/libs/java-app-backend-0.0.1-SNAPSHOT.jar"]
