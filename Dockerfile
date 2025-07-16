# Use an official OpenJDK image
FROM openjdk:21

# Set the working directory inside the container
WORKDIR /app

# Copy source code into the container
COPY src/Go.java .

# Compile the Java file
RUN javac Go.java

# Run the application
CMD ["java", "Go"]