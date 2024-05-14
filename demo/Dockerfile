# Start with a base image containing Java runtime (adoptopenjdk/openjdk11:latest)
FROM adoptopenjdk/openjdk11:latest

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Variable to hold the jar file
ARG JAR_FILE=build/libs/*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]