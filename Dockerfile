FROM adoptopenjdk:11-jdk-hotspot AS builder
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]