# Build stage
FROM maven:3.8.3-openjdk-17 AS build
COPY . .
# এটি আপনার প্রোজেক্ট কম্পাইল করে jar ফাইল তৈরি করবে
RUN mvn clean package -DskipTests

# Package stage
FROM eclipse-temurin:17-jdk
# /target/*.jar ব্যবহার করলে নামের ঝামেলা থাকে না, এটি অটোমেটিক jar ফাইলটি খুঁজে নেবে
COPY --from=build /target/*.jar Flight_Demo-1.0-SNAPSHOT.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "Flight_Demo-1.0-SNAPSHOT.jar"]