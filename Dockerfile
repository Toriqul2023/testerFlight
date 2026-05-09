# Build stage
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src src

# Build the project
RUN mvn clean package -DskipTests

# Package stage
FROM eclipse-temurin:17-jdk
WORKDIR /app
# Use the executable jar we configured in pom.xml
COPY --from=build /app/target/*-jar-with-dependencies.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]
