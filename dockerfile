# ====== Stage 1: Build the app ======
FROM maven:3.9-eclipse-temurin-11 AS build

WORKDIR /app

# Copy pom.xml and download dependencies first (cache layer)
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Now copy source code and build
COPY src ./src
RUN mvn -B clean package -DskipTests

# ====== Stage 2: Run the app ======
FROM eclipse-temurin:11-jre

WORKDIR /app

# Copy the jar from the build stage
# adjust name if your version changes
COPY --from=build /app/target/developer-horoscope-0.0.1-SNAPSHOT.jar app.jar

# Set prod profile by default inside container
ENV SPRING_PROFILES_ACTIVE=prod

# If your prod profile uses port 8081, expose that
EXPOSE 8081

# Start the Spring Boot app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]