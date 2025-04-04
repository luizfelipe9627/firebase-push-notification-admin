FROM openjdk:21-jdk-slim AS builder

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=builder /app/target/firebase-push-notification-admin-0.0.1-SNAPSHOT.jar firebase-push-notification-admin.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "firebase-push-notification-admin.jar"]
