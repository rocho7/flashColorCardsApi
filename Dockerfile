FROM amazoncorretto:21-alpine-jdk

COPY target/1-flashcard-0.0.4-SNAPSHOT.jar /api-v1.jar

ENTRYPOINT ["java", "-jar", "/api-v1.jar"]