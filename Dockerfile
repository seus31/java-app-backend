FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . .

ENTRYPOINT ["java", "-jar", "build/libs/java-app-backend-0.0.1-SNAPSHOT.jar"]
