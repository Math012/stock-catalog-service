FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY build/libs/catalog-service-0.0.1-SNAPSHOT.jar /app/catalog-service.jar

EXPOSE 8081

CMD ["java", "-jar", "/app/catalog-service.jar"]