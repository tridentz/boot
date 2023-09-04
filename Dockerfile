FROM openjdk:11
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "/app.jar"]