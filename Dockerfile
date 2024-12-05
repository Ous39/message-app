# Stage 1: Build the application using Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Set the working directory inside the build container
WORKDIR /app

# Copy the Maven configuration file
COPY pom.xml .

# Download dependencies to optimize builds
RUN mvn dependency:go-offline -B

# Copy the application source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:17-jdk-slim

# Set the working directory inside the final container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
